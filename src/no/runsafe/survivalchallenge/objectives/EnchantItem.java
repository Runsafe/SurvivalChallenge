package no.runsafe.survivalchallenge.objectives;

import no.runsafe.framework.api.event.enchantment.IEnchantItemEvent;
import no.runsafe.framework.minecraft.event.enchantment.RunsafeEnchantItemEvent;
import no.runsafe.framework.minecraft.player.RunsafePlayer;
import no.runsafe.survivalchallenge.BaseObjective;
import no.runsafe.survivalchallenge.Objective;
import no.runsafe.survivalchallenge.ObjectiveHandler;

public class EnchantItem extends BaseObjective implements IEnchantItemEvent
{
	public EnchantItem(ObjectiveHandler handler)
	{
		super(handler);
	}

	@Override
	public String getObjectiveTitle()
	{
		return "Enchantment? Enchantment!";
	}

	@Override
	public Objective getObjective()
	{
		return Objective.ENCHANT_ITEM;
	}

	@Override
	public void OnEnchantItemEvent(RunsafeEnchantItemEvent event)
	{
		RunsafePlayer player = event.getEnchanter();
		if (!event.isCancelled() && handler.entityInEligibleWorld(player))
			award(player);
	}
}
