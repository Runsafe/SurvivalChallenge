package no.runsafe.survivalchallenge.objectives;

import no.runsafe.framework.minecraft.entity.LivingEntity;
import no.runsafe.survivalchallenge.Objective;
import no.runsafe.survivalchallenge.ObjectiveHandler;

public class SlimeKill extends MobKillObjective
{
	public SlimeKill(ObjectiveHandler handler)
	{
		super(handler);
		entityType = LivingEntity.Slime;
	}

	@Override
	public Objective getObjective()
	{
		return Objective.SLIME_KILL;
	}
}
