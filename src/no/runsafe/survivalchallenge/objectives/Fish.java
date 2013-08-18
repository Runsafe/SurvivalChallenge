package no.runsafe.survivalchallenge.objectives;

import no.runsafe.framework.api.event.player.IPlayerFishEvent;
import no.runsafe.framework.minecraft.event.player.RunsafePlayerFishEvent;
import no.runsafe.survivalchallenge.BaseObjective;
import no.runsafe.survivalchallenge.Objective;
import no.runsafe.survivalchallenge.ObjectiveHandler;

public class Fish extends BaseObjective implements IPlayerFishEvent
{
	public Fish(ObjectiveHandler handler)
	{
		super(handler);
	}

	@Override
	public String getObjectiveTitle()
	{
		return "Dem Fishes Be Mine";
	}

	@Override
	public Objective getObjective()
	{
		return Objective.FISH;
	}

	@Override
	public void OnPlayerFish(RunsafePlayerFishEvent event)
	{
		if (event.getCaught() != null)
			award(event.getPlayer());
	}
}
