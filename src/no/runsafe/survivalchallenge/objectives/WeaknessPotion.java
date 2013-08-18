package no.runsafe.survivalchallenge.objectives;

import no.runsafe.framework.minecraft.Item;
import no.runsafe.survivalchallenge.Objective;
import no.runsafe.survivalchallenge.ObjectiveHandler;

public class WeaknessPotion extends CraftItemObjective
{
	public WeaknessPotion(ObjectiveHandler handler)
	{
		super(handler);
		item = Item.Brewing.Potion;
		data = 8200; // Weakness potion
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
}
