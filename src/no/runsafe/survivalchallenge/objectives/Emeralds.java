package no.runsafe.survivalchallenge.objectives;

import no.runsafe.framework.minecraft.Item;
import no.runsafe.survivalchallenge.Objective;
import no.runsafe.survivalchallenge.ObjectiveHandler;

public class Emeralds extends ItemCollectObjective
{
	public Emeralds(ObjectiveHandler handler)
	{
		super(handler);
		itemType = Item.Materials.Emerald;
		itemAmount = 5;
	}

	@Override
	public String getObjectiveTitle()
	{
		return "Sparkling Jealously";
	}

	@Override
	public Objective getObjective()
	{
		return Objective.EMERALDS;
	}
}
