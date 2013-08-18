package no.runsafe.survivalchallenge.objectives;

import no.runsafe.framework.minecraft.Item;
import no.runsafe.survivalchallenge.Objective;
import no.runsafe.survivalchallenge.ObjectiveHandler;

public class CraftWorkbench extends CraftItemObjective
{
	public CraftWorkbench(ObjectiveHandler handler)
	{
		super(handler);
		item = Item.Decoration.Workbench;
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
}
