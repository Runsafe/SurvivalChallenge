package no.runsafe.survivalchallenge.objectives;

import no.runsafe.framework.api.event.inventory.ICraftItem;
import no.runsafe.framework.minecraft.Item;
import no.runsafe.framework.minecraft.event.inventory.RunsafeCraftItemEvent;
import no.runsafe.framework.minecraft.player.RunsafePlayer;
import no.runsafe.survivalchallenge.BaseObjective;
import no.runsafe.survivalchallenge.Objective;
import no.runsafe.survivalchallenge.ObjectiveHandler;

public class CraftWorkbench extends BaseObjective implements ICraftItem
{
	public CraftWorkbench(ObjectiveHandler handler)
	{
		super(handler);
		this.handler = handler;
	}

	@Override
	public String getObjectiveTitle()
	{
		return "Getting Started";
	}

	@Override
	public Objective getObjective()
	{
		return Objective.CRAFT_WORKBENCH;
	}

	@Override
	public void OnCraftItem(RunsafeCraftItemEvent event)
	{
		RunsafePlayer player = event.getWhoClicked();
		if (handler.playerInEligibleWorld(player) && event.getCurrentItem().is(Item.Decoration.Workbench))
			this.award(player);
	}

	private ObjectiveHandler handler;
}
