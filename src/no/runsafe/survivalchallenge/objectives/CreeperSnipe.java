package no.runsafe.survivalchallenge.objectives;

import no.runsafe.framework.api.event.entity.IEntityDamageByEntityEvent;
import no.runsafe.framework.minecraft.RunsafeLocation;
import no.runsafe.framework.minecraft.entity.RunsafeEntity;
import no.runsafe.framework.minecraft.entity.RunsafeProjectile;
import no.runsafe.framework.minecraft.event.entity.RunsafeEntityDamageByEntityEvent;
import no.runsafe.framework.minecraft.player.RunsafePlayer;
import no.runsafe.survivalchallenge.BaseObjective;
import no.runsafe.survivalchallenge.Objective;
import no.runsafe.survivalchallenge.ObjectiveHandler;

public class CreeperSnipe extends BaseObjective implements IEntityDamageByEntityEvent
{
	public CreeperSnipe(ObjectiveHandler handler)
	{
		super(handler);
	}

	@Override
	public String getObjectiveTitle()
	{
		return "He Just Got Sn--";
	}

	@Override
	public Objective getObjective()
	{
		return Objective.CREEPER_SNIPE;
	}

	@Override
	public void OnEntityDamageByEntity(RunsafeEntityDamageByEntityEvent event)
	{
		RunsafeEntity entity = event.getEntity();
		if (handler.entityInEligibleWorld(entity) && event.getDamageActor() instanceof RunsafeProjectile)
		{
			RunsafeProjectile projectile = (RunsafeProjectile) event.getDamageActor();
			RunsafePlayer shooter = projectile.getShooterPlayer();

			if (shooter != null)
			{
				RunsafeLocation playerLocation = shooter.getLocation();
				RunsafeLocation entityLocation = entity.getLocation();
				if (playerLocation != null && entityLocation != null && playerLocation.distance(entityLocation) >= 50)
					award(shooter);
			}
		}
	}
}
