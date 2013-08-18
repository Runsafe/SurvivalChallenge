package no.runsafe.survivalchallenge.objectives;

import no.runsafe.framework.minecraft.entity.LivingEntity;
import no.runsafe.survivalchallenge.Objective;
import no.runsafe.survivalchallenge.ObjectiveHandler;

public class ZombieKill extends MobKillObjective
{
	public ZombieKill(ObjectiveHandler handler)
	{
		super(handler);
		entityType = LivingEntity.Zombie;
	}

	@Override
	public Objective getObjective()
	{
		return Objective.ZOMBIE_KILL;
	}
}
