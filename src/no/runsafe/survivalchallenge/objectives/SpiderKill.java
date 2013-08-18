package no.runsafe.survivalchallenge.objectives;

import no.runsafe.survivalchallenge.Objective;
import no.runsafe.survivalchallenge.ObjectiveHandler;

public class SpiderKill extends MobKillObjective
{
	public SpiderKill(ObjectiveHandler handler)
	{
		super(handler);
	}

	@Override
	public Objective getObjective()
	{
		return Objective.SPIDER_KILL;
	}
}
