package no.runsafe.survivalchallenge;

import no.runsafe.framework.api.IOutput;

import java.util.List;

public class ObjectiveChecker
{
	public ObjectiveChecker(IObjective[] objectives, IOutput output)
	{
		ObjectiveChecker.objectives = objectives;
		ObjectiveChecker.output = output;
	}

	public static boolean hasCompletedAllObjectives(List<Integer> data)
	{
		if (ObjectiveChecker.objectives == null)
		{
			ObjectiveChecker.output.fine("ObjectiveChecker: No objectives loaded.");
			return false;
		}

		for (IObjective objective : ObjectiveChecker.objectives) // Check every objective.
		{
			if (!data.contains((Object) objective.getObjective().ordinal()))
			{
				ObjectiveChecker.output.fine("ObjectiveChecker: Objective not completed - %s", objective.getObjectiveTitle());
				return false;
			}
		}

		return true;
	}

	private static IObjective[] objectives;
	private static IOutput output;
}
