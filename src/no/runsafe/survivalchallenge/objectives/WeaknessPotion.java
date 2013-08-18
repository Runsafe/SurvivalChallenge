package no.runsafe.survivalchallenge.objectives;

import no.runsafe.framework.api.event.inventory.IInventoryClick;
import no.runsafe.framework.minecraft.Item;
import no.runsafe.framework.minecraft.event.inventory.RunsafeInventoryClickEvent;
import no.runsafe.framework.minecraft.inventory.RunsafeInventoryType;
import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;
import no.runsafe.framework.minecraft.player.RunsafePlayer;
import no.runsafe.survivalchallenge.BaseObjective;
import no.runsafe.survivalchallenge.Objective;
import no.runsafe.survivalchallenge.ObjectiveHandler;

public class WeaknessPotion extends BaseObjective implements IInventoryClick
{
	public WeaknessPotion(ObjectiveHandler handler)
	{
		super(handler);
	}

	@Override
	public String getObjectiveTitle()
	{
		return "Tastes Like.. Cherry.";
	}

	@Override
	public Objective getObjective()
	{
		return Objective.WEAKNESS_POTION;
	}

	@Override
	public void OnInventoryClickEvent(RunsafeInventoryClickEvent event)
	{
		RunsafePlayer player = event.getWhoClicked();
		if (handler.entityInEligibleWorld(player) && event.getInventory().getType() == RunsafeInventoryType.BREWING)
		{
			RunsafeMeta item = event.getCurrentItem();
			if (item.is(Item.Brewing.Potion) && item.getDurability() == 8200)
				award(player);
		}
	}
}
