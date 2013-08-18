package no.runsafe.survivalchallenge.objectives;

import no.runsafe.framework.minecraft.entity.LivingEntity;
import no.runsafe.survivalchallenge.Objective;
import no.runsafe.survivalchallenge.ObjectiveHandler;

public class SpiderKill extends MobKillObjective
{
	public SpiderKill(ObjectiveHandler handler)
	{
		super(handler);
		entityType = LivingEntity.Spider;
	}

	@Override
	public Objective getObjective()
	{
		return Objective.SPIDER_KILL;
	}
}
