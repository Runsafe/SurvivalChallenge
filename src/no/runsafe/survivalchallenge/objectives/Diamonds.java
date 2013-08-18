package no.runsafe.survivalchallenge.objectives;

import no.runsafe.framework.api.event.player.IPlayerPickupItemEvent;
import no.runsafe.framework.minecraft.Item;
import no.runsafe.framework.minecraft.event.player.RunsafePlayerPickupItemEvent;
import no.runsafe.framework.minecraft.inventory.RunsafeInventory;
import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;
import no.runsafe.framework.minecraft.player.RunsafePlayer;
import no.runsafe.survivalchallenge.BaseObjective;
import no.runsafe.survivalchallenge.Objective;
import no.runsafe.survivalchallenge.ObjectiveHandler;

public class Diamonds extends BaseObjective implements IPlayerPickupItemEvent
{
	public Diamonds(ObjectiveHandler handler)
	{
		super(handler);
	}

	@Override
	public String getObjectiveTitle()
	{
		return "Girls Best Friend";
	}

	@Override
	public Objective getObjective()
	{
		return Objective.DIAMONDS;
	}

	@Override
	public void OnPlayerPickupItemEvent(RunsafePlayerPickupItemEvent event)
	{
		RunsafePlayer player = event.getPlayer();
		if (handler.entityInEligibleWorld(player))
		{
			RunsafeMeta item = event.getItem().getItemStack();
			RunsafeInventory inventory = player.getInventory();
			if (inventory == null)
				return;

			if (item.is(Item.Materials.Diamond) && item.getAmount() + inventory.getAmountOfItem(Item.Materials.Diamond) >= 30)
				this.award(player);
		}
	}
}
