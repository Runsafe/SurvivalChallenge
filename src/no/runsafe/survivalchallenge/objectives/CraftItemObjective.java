package no.runsafe.survivalchallenge.objectives;

import no.runsafe.framework.api.event.inventory.ICraftItem;
import no.runsafe.framework.minecraft.Item;
import no.runsafe.framework.minecraft.event.inventory.RunsafeCraftItemEvent;
import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;
import no.runsafe.framework.minecraft.player.RunsafePlayer;
import no.runsafe.survivalchallenge.BaseObjective;
import no.runsafe.survivalchallenge.ObjectiveHandler;

public abstract class CraftItemObjective extends BaseObjective implements ICraftItem
{
	public CraftItemObjective(ObjectiveHandler handler)
	{
		super(handler);
	}

	@Override
	public void OnCraftItem(RunsafeCraftItemEvent event)
	{
		RunsafePlayer player = event.getWhoClicked();
		if (handler.entityInEligibleWorld(player))
		{
			RunsafeMeta item = event.getCurrentItem();
			if ((item.is(this.item) && data == -1 || item.getDurability() == data))
				this.award(player);
		}
	}

	protected Item item;
	protected short data = -1;
}
