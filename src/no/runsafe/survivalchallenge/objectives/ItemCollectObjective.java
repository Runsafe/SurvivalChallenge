package no.runsafe.survivalchallenge.objectives;

import no.runsafe.framework.api.event.player.IPlayerPickupItemEvent;
import no.runsafe.framework.minecraft.Item;
import no.runsafe.framework.minecraft.event.player.RunsafePlayerPickupItemEvent;
import no.runsafe.framework.minecraft.inventory.RunsafeInventory;
import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;
import no.runsafe.framework.minecraft.player.RunsafePlayer;
import no.runsafe.survivalchallenge.BaseObjective;
import no.runsafe.survivalchallenge.ObjectiveHandler;

public abstract class ItemCollectObjective extends BaseObjective implements IPlayerPickupItemEvent
{
	public ItemCollectObjective(ObjectiveHandler handler)
	{
		super(handler);
	}

	@Override
	public void OnPlayerPickupItemEvent(RunsafePlayerPickupItemEvent event)
	{
		RunsafePlayer player = event.getPlayer();
		if (itemType != null && itemAmount > 0 && handler.entityInEligibleWorld(player))
		{
			RunsafeMeta item = event.getItem().getItemStack();
			if (item.is(itemType))
			{
				RunsafeInventory inventory = player.getInventory();
				if (inventory != null && inventory.getAmountOfItem(itemType) + item.getAmount() >= itemAmount)
					this.award(player);
			}
		}
	}

	protected int itemAmount = 0;
	protected Item itemType;
}
