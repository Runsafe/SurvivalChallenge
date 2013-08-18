package no.runsafe.survivalchallenge.objectives;

import no.runsafe.framework.api.event.entity.IEntityTameEvent;
import no.runsafe.framework.api.minecraft.IAnimalTamer;
import no.runsafe.framework.api.minecraft.RunsafeEntityType;
import no.runsafe.framework.minecraft.entity.LivingEntity;
import no.runsafe.framework.minecraft.entity.RunsafeEntity;
import no.runsafe.framework.minecraft.event.entity.RunsafeEntityTameEvent;
import no.runsafe.framework.minecraft.player.RunsafePlayer;
import no.runsafe.survivalchallenge.BaseObjective;
import no.runsafe.survivalchallenge.Objective;
import no.runsafe.survivalchallenge.ObjectiveHandler;

public class TameSomething extends BaseObjective implements IEntityTameEvent
{
	public TameSomething(ObjectiveHandler handler)
	{
		super(handler);
	}

	@Override
	public String getObjectiveTitle()
	{
		return "My New Best Friend";
	}

	@Override
	public Objective getObjective()
	{
		return Objective.TAME_SOMETHING;
	}

	@Override
	public void OnEntityTame(RunsafeEntityTameEvent event)
	{
		RunsafeEntity entity = event.getEntity();

		if (handler.entityInEligibleWorld(entity))
		{
			RunsafeEntityType type = entity.getEntityType();
			if (type == LivingEntity.Wolf || type == LivingEntity.Ocelot || type == LivingEntity.Horse)
			{
				IAnimalTamer tamer = event.getOwner();
				if (tamer instanceof RunsafePlayer)
					award((RunsafePlayer) tamer);
			}
		}
	}
}
