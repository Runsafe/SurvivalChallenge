package no.runsafe.survivalchallenge.objectives;

import no.runsafe.framework.api.event.inventory.IInventoryClick;
import no.runsafe.framework.api.event.player.IPlayerPickupItemEvent;
import no.runsafe.framework.api.minecraft.IInventoryHolder;
import no.runsafe.framework.minecraft.Item;
import no.runsafe.framework.minecraft.event.inventory.RunsafeInventoryClickEvent;
import no.runsafe.framework.minecraft.event.player.RunsafePlayerPickupItemEvent;
import no.runsafe.framework.minecraft.inventory.RunsafeInventory;
import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;
import no.runsafe.framework.minecraft.player.RunsafePlayer;
import no.runsafe.survivalchallenge.BaseObjective;
import no.runsafe.survivalchallenge.ObjectiveHandler;

import java.util.HashMap;
import java.util.Map;

public abstract class ItemCollectObjective extends BaseObjective implements IPlayerPickupItemEvent, IInventoryClick
{
	public ItemCollectObjective(ObjectiveHandler handler)
	{
		super(handler);
	}

	@Override
	public void OnPlayerPickupItemEvent(RunsafePlayerPickupItemEvent event)
	{
		RunsafePlayer player = event.getPlayer();
		if (handler.entityInEligibleWorld(player))
		{
			RunsafeInventory inventory = player.getInventory();
			if (inventory == null)
				return;

			itemCheck(inventory, event.getItem().getItemStack(), player);
		}
	}

	@Override
	public void OnInventoryClickEvent(RunsafeInventoryClickEvent event)
	{
		RunsafeInventory inventory = event.getInventory();
		IInventoryHolder holder = inventory.getHolder();

		if (holder instanceof RunsafePlayer)
		{
			RunsafePlayer player = (RunsafePlayer) holder;
			if (handler.entityInEligibleWorld(player))
				itemCheck(inventory, event.getCursor(), player);
		}
	}

	private void itemCheck(RunsafeInventory inventory, RunsafeMeta item, RunsafePlayer player)
	{
		for (Map.Entry<Item, Integer> node : requiredItems.entrySet())
		{
			int amountOfItem = inventory.getAmountOfItem(node.getKey());
			if (item.is(node.getKey()))
				amountOfItem += item.getAmount();

			if (amountOfItem < node.getValue())
				return;
		}
		award(player);
	}

	protected HashMap<Item, Integer> requiredItems = new HashMap<Item, Integer>();
}
