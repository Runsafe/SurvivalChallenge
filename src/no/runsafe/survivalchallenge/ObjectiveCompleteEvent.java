package no.runsafe.survivalchallenge;

import no.runsafe.framework.minecraft.event.player.RunsafeCustomEvent;
import no.runsafe.framework.minecraft.player.RunsafePlayer;

import java.util.List;

public class ObjectiveCompleteEvent extends RunsafeCustomEvent
{
	public ObjectiveCompleteEvent(RunsafePlayer player, List<Integer> progress)
	{
		super(player, "survivalChallenge.objectiveComplete");
		this.progress = progress;
	}

	@Override
	public Object getData()
	{
		return progress;
	}

	private List<Integer> progress;
}
