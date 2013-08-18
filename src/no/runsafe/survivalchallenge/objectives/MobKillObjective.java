package no.runsafe.survivalchallenge.objectives;

import no.runsafe.framework.api.event.entity.IEntityDeathEvent;
import no.runsafe.framework.api.minecraft.RunsafeEntityType;
import no.runsafe.framework.minecraft.RunsafeServer;
import no.runsafe.framework.minecraft.entity.RunsafeEntity;
import no.runsafe.framework.minecraft.entity.RunsafeProjectile;
import no.runsafe.framework.minecraft.event.entity.RunsafeEntityDamageByEntityEvent;
import no.runsafe.framework.minecraft.event.entity.RunsafeEntityDeathEvent;
import no.runsafe.framework.minecraft.player.RunsafePlayer;
import no.runsafe.survivalchallenge.BaseObjective;
import no.runsafe.survivalchallenge.ObjectiveHandler;

public abstract class MobKillObjective extends BaseObjective implements IEntityDeathEvent
{
	public MobKillObjective(ObjectiveHandler handler)
	{
		super(handler);
	}

	@Override
	public void OnEntityDeath(RunsafeEntityDeathEvent event)
	{
		RunsafeEntity entity = event.getEntity();
		if (entityType != null && entity.getEntityType() == entityType && handler.entityInEligibleWorld(entity))
		{
			RunsafeServer.Instance.broadcastMessage(entity.getLastDamageCause().getClass().getName());
			if (entity.getLastDamageCause() instanceof RunsafeEntityDamageByEntityEvent)
			{
				RunsafeEntityDamageByEntityEvent damageEvent = (RunsafeEntityDamageByEntityEvent) entity.getLastDamageCause();
				RunsafeEntity attacker = damageEvent.getDamageActor();

				if (attacker instanceof RunsafePlayer)
				{
					award((RunsafePlayer) attacker);
				}
				else if (attacker instanceof RunsafeProjectile)
				{
					RunsafeProjectile projectile = (RunsafeProjectile) attacker;
					if (projectile.getShooterPlayer() != null)
						award(projectile.getShooterPlayer());
				}
			}
		}
	}

	@Override
	public String getObjectiveTitle()
	{
		return "Headhunting: " + entityType.getName();
	}

	protected RunsafeEntityType entityType;
}
