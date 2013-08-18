package no.runsafe.survivalchallenge.objectives;

import no.runsafe.framework.minecraft.entity.LivingEntity;
import no.runsafe.survivalchallenge.Objective;
import no.runsafe.survivalchallenge.ObjectiveHandler;

public class EndermanKill extends MobKillObjective
{
	public EndermanKill(ObjectiveHandler handler)
	{
		super(handler);
		entityType = LivingEntity.Enderman;
	}

	@Override
	public Objective getObjective()
	{
		return Objective.ENDERMAN_KILL;
	}
}
