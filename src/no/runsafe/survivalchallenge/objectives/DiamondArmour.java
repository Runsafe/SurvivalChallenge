package no.runsafe.survivalchallenge.objectives;

import no.runsafe.framework.minecraft.Item;
import no.runsafe.survivalchallenge.Objective;
import no.runsafe.survivalchallenge.ObjectiveHandler;

public class DiamondArmour extends ItemCollectObjective
{
	public DiamondArmour(ObjectiveHandler handler)
	{
		super(handler);
		requiredItems.put(Item.Combat.Helmet.Diamond, 1);
		requiredItems.put(Item.Combat.Chestplate.Diamond, 1);
		requiredItems.put(Item.Combat.Leggings.Diamond, 1);
		requiredItems.put(Item.Combat.Boots.Diamond, 1);
	}

	@Override
	public String getObjectiveTitle()
	{
		return "Super-heated Garb";
	}

	@Override
	public Objective getObjective()
	{
		return Objective.DIAMOND_ARMOUR;
	}
}
