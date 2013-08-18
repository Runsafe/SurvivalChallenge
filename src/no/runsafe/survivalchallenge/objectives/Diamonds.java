package no.runsafe.survivalchallenge.objectives;

import no.runsafe.framework.minecraft.Item;
import no.runsafe.survivalchallenge.Objective;
import no.runsafe.survivalchallenge.ObjectiveHandler;

public class Diamonds extends ItemCollectObjective
{
	public Diamonds(ObjectiveHandler handler)
	{
		super(handler);
		requiredItems.put(Item.Materials.Diamond, 30);
	}

	@Override
	public String getObjectiveTitle()
	{
		return "Girls Best Friend";
	}

	@Override
	public Objective getObjective()
	{
		return Objective.DIAMONDS;
	}
}
