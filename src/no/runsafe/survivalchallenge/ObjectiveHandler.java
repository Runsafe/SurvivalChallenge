package no.runsafe.survivalchallenge;

import no.runsafe.framework.api.IConfiguration;
import no.runsafe.framework.api.IOutput;
import no.runsafe.framework.api.event.IServerReady;
import no.runsafe.framework.api.event.plugin.IConfigurationChanged;
import no.runsafe.framework.minecraft.RunsafeServer;
import no.runsafe.framework.minecraft.RunsafeWorld;
import no.runsafe.framework.minecraft.entity.RunsafeEntity;
import no.runsafe.framework.minecraft.player.RunsafePlayer;
import no.runsafe.survivalchallenge.database.ObjectiveRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ObjectiveHandler implements IConfigurationChanged, IServerReady
{
	public ObjectiveHandler(ObjectiveRepository database, ChallengeHandler handler, IOutput output)
	{
		this.database = database;
		this.handler = handler;
		this.output = output;
	}

	public void awardPlayerObjective(RunsafePlayer player, IObjective objective)
	{
		String playerName = player.getName();
		String objectiveName = objective.getObjectiveTitle();
		output.fine("%s: Just completed objective %s", playerName, objectiveName);

		if (handler.isFinished())
		{
			output.fine("%s: The event is already over, unable to complete objective.", playerName);
			player.sendColouredMessage("&cThe event has already finished!");
			handler.removePlayer(player);
			return;
		}

		Objective objectiveID = objective.getObjective();
		if (!playerHasCompletedObjective(player, objectiveID))
		{
			output.fine("%s: Player has not completed the objective, flagging completion.", playerName);
			this.database.flagObjectiveComplete(player, objectiveID); // Persist in the DB.

			if (!this.data.containsKey(playerName)) // If we don't already have a container for the player..
				this.data.put(playerName, new ArrayList<Integer>()); // .. make one.

			this.data.get(playerName).add(objectiveID.ordinal()); // Flag the objective as complete.
			player.sendColouredMessage("&eObjective complete: &f%s&e.", objective.getObjectiveTitle());

			new ObjectiveCompleteEvent(player, data.get(playerName)).Fire();
		}
		else
		{
			output.fine("%s: Player has already completed objective, not flagging.", playerName);
		}
	}

	public boolean entityInEligibleWorld(RunsafeEntity entity)
	{
		RunsafeWorld world = entity.getWorld();
		return world != null && world.getName().equalsIgnoreCase(challengeWorld);
	}

	public boolean playerHasCompletedObjective(RunsafePlayer player, Objective objective)
	{
		String playerName = player.getName();
		return data.containsKey(playerName) && data.get(playerName).contains(objective.ordinal());
	}

	@Override
	public void OnConfigurationChanged(IConfiguration configuration)
	{
		this.data = this.database.getStoredData(); // Load stored data from the database.
		this.challengeWorld = configuration.getConfigValueAsString("challengeLocation.world"); // Get the world for the event.
	}

	@Override
	public void OnServerReady()
	{
		// Fire a completion event for every player, this will shut the event if we're already done.
		for (Map.Entry<String, List<Integer>> node : data.entrySet())
			new ObjectiveCompleteEvent(RunsafeServer.Instance.getPlayerExact(node.getKey()), node.getValue()).Fire();
	}

	private HashMap<String, List<Integer>> data = new HashMap<String, List<Integer>>();
	private ObjectiveRepository database;
	private String challengeWorld;
	private ChallengeHandler handler;
	private IOutput output;
}
