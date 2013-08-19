package no.runsafe.survivalchallenge;

import no.runsafe.framework.api.IOutput;
import no.runsafe.framework.api.event.player.IPlayerCustomEvent;
import no.runsafe.framework.minecraft.event.player.RunsafeCustomEvent;
import no.runsafe.framework.minecraft.player.RunsafePlayer;

import java.util.List;

public class ObjectiveChecker implements IPlayerCustomEvent
{
	public ObjectiveChecker(IObjective[] objectives, IOutput output, ChallengeHandler handler)
	{
		this.objectives = objectives;
		this.output = output;
		this.handler = handler;
	}

	@Override
	public void OnPlayerCustomEvent(RunsafeCustomEvent event)
	{
		if (event.getEvent().equals("survivalChallenge.objectiveComplete"))
		{
			RunsafePlayer player = event.getPlayer();
			List<Integer> progress = (List<Integer>) event.getData();

			output("Detected objective completion..", player);
			for (IObjective requiredObjective : objectives)
			{
				if (!progress.contains((Object) requiredObjective.getObjective().ordinal()))
				{
					output("Failed to meet required objective: " + requiredObjective.getObjectiveTitle(), player);
					return;
				}
			}
			output("No failed objectives, marking as the winner", player);
			handler.broadcastWinner(player);
		}
	}

	private void output(String message, RunsafePlayer player)
	{
		output.fine("ObjectiveChecker: [%s] %s", player.getName(), message);
	}

	private IOutput output;
	private IObjective[] objectives;
	private ChallengeHandler handler;
}
