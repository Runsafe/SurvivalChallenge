package no.runsafe.survivalchallenge.objectives;

import no.runsafe.framework.minecraft.entity.LivingEntity;
import no.runsafe.survivalchallenge.Objective;
import no.runsafe.survivalchallenge.ObjectiveHandler;

public class CreeperKill extends MobKillObjective
{
	public CreeperKill(ObjectiveHandler handler)
	{
		super(handler);
		entityType = LivingEntity.Creeper;
	}

	@Override
	public Objective getObjective()
	{
		return Objective.CREEPER_KILL;
	}
}
