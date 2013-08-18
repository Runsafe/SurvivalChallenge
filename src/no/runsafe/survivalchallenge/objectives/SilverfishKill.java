package no.runsafe.survivalchallenge.objectives;

import no.runsafe.framework.minecraft.entity.LivingEntity;
import no.runsafe.survivalchallenge.Objective;
import no.runsafe.survivalchallenge.ObjectiveHandler;

public class SilverfishKill extends MobKillObjective
{
	public SilverfishKill(ObjectiveHandler handler)
	{
		super(handler);
		entityType = LivingEntity.Silverfish;
	}

	@Override
	public Objective getObjective()
	{
		return Objective.SILVERFISH_KILL;
	}
}
