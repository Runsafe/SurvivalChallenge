package no.runsafe.survivalchallenge.objectives;

import no.runsafe.framework.api.event.entity.IEntityDamageByEntityEvent;
import no.runsafe.framework.minecraft.entity.LivingEntity;
import no.runsafe.framework.minecraft.entity.ProjectileEntity;
import no.runsafe.framework.minecraft.entity.RunsafeEntity;
import no.runsafe.framework.minecraft.entity.RunsafeProjectile;
import no.runsafe.framework.minecraft.event.entity.RunsafeEntityDamageByEntityEvent;
import no.runsafe.survivalchallenge.BaseObjective;
import no.runsafe.survivalchallenge.Objective;
import no.runsafe.survivalchallenge.ObjectiveHandler;

public class SnowballSquid extends BaseObjective implements IEntityDamageByEntityEvent
{
	public SnowballSquid(ObjectiveHandler handler)
	{
		super(handler);
	}

	@Override
	public String getObjectiveTitle()
	{
		return "Have At Thee, Sea Fiend!";
	}

	@Override
	public Objective getObjective()
	{
		return Objective.SNOWBALL_AT_SQUID;
	}

	@Override
	public void OnEntityDamageByEntity(RunsafeEntityDamageByEntityEvent event)
	{
		RunsafeEntity entity = event.getEntity();
		if (entity.getEntityType() == LivingEntity.Squid && handler.entityInEligibleWorld(entity))
		{
			RunsafeEntity attacker = event.getDamageActor();
			if (attacker instanceof RunsafeProjectile)
			{
				RunsafeProjectile projectile = (RunsafeProjectile) attacker;
				if (projectile.getEntityType() == ProjectileEntity.Snowball && projectile.getShooterPlayer() != null)
					award(projectile.getShooterPlayer());
			}
		}
	}
}
