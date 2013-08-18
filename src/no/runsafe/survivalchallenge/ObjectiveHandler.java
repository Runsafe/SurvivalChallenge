package no.runsafe.survivalchallenge;

import no.runsafe.framework.api.IConfiguration;
import no.runsafe.framework.api.event.plugin.IConfigurationChanged;
import no.runsafe.framework.minecraft.RunsafeWorld;
import no.runsafe.framework.minecraft.player.RunsafePlayer;
import no.runsafe.survivalchallenge.database.ObjectiveRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ObjectiveHandler implements IConfigurationChanged
{
	public ObjectiveHandler(ObjectiveRepository database)
	{
		this.database = database;
	}

	public void awardPlayerObjective(RunsafePlayer player, IObjective objective)
	{
		Objective objectiveID = objective.getObjective();
		if (!playerHasCompletedObjective(player, objectiveID))
		{
			this.database.flagObjectiveComplete(player, objectiveID); // Persist in the DB.

			String playerName = player.getName();
			if (!this.data.containsKey(playerName)) // If we don't already have a container for the player..
				this.data.put(playerName, new ArrayList<Integer>()); // .. make one.

			this.data.get(playerName).add(objectiveID.ordinal()); // Flag the objective as complete.
			player.sendColouredMessage("&eObjective complete: &f%s&e.", objective.getObjectiveTitle());
		}
	}

	public boolean playerInEligibleWorld(RunsafePlayer player)
	{
		RunsafeWorld playerWorld = player.getWorld();
		return playerWorld != null && playerWorld.getName().equalsIgnoreCase(challengeWorld);
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
		this.challengeWorld = configuration.getConfigValueAsString("challengeWorld"); // Get the world for the event.
	}

	private HashMap<String, List<Integer>> data = new HashMap<String, List<Integer>>();
	private ObjectiveRepository database;
	private String challengeWorld;
}
