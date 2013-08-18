package no.runsafe.survivalchallenge.objectives;

import no.runsafe.framework.minecraft.entity.LivingEntity;
import no.runsafe.survivalchallenge.Objective;
import no.runsafe.survivalchallenge.ObjectiveHandler;

public class CaveSpiderKill extends MobKillObjective
{
	public CaveSpiderKill(ObjectiveHandler handler)
	{
		super(handler);
		entityType = LivingEntity.CaveSpider;
	}

	@Override
	public Objective getObjective()
	{
		return Objective.CAVE_SPIDER_KILL;
	}
}
