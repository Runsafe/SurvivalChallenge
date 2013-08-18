package no.runsafe.survivalchallenge.objectives;

import no.runsafe.framework.minecraft.entity.LivingEntity;
import no.runsafe.survivalchallenge.Objective;
import no.runsafe.survivalchallenge.ObjectiveHandler;

public class SkeletonKill extends MobKillObjective
{
	public SkeletonKill(ObjectiveHandler handler)
	{
		super(handler);
		entityType = LivingEntity.Skeleton;
	}

	@Override
	public Objective getObjective()
	{
		return Objective.SKELETON_KILL;
	}
}
