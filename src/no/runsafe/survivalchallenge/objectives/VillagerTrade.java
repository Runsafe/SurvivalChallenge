package no.runsafe.survivalchallenge.objectives;

import no.runsafe.framework.api.event.inventory.IInventoryClick;
import no.runsafe.framework.minecraft.event.inventory.RunsafeInventoryClickEvent;
import no.runsafe.framework.minecraft.inventory.RunsafeInventoryType;
import no.runsafe.framework.minecraft.player.RunsafePlayer;
import no.runsafe.survivalchallenge.BaseObjective;
import no.runsafe.survivalchallenge.Objective;
import no.runsafe.survivalchallenge.ObjectiveHandler;

public class VillagerTrade extends BaseObjective implements IInventoryClick
{
	public VillagerTrade(ObjectiveHandler handler)
	{
		super(handler);
	}

	@Override
	public String getObjectiveTitle()
	{
		return "Making Friends In Higher Places";
	}

	@Override
	public Objective getObjective()
	{
		return Objective.VIlLAGER_TRADE;
	}

	@Override
	public void OnInventoryClickEvent(RunsafeInventoryClickEvent event)
	{
		RunsafePlayer player = event.getWhoClicked();
		if (handler.entityInEligibleWorld(player) && event.getInventory().getType() == RunsafeInventoryType.MERCHANT)
			this.award(player);
	}
}
