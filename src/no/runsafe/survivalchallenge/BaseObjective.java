package no.runsafe.survivalchallenge;

import no.runsafe.framework.minecraft.player.RunsafePlayer;

public abstract class BaseObjective implements IObjective
{
	public BaseObjective(ObjectiveHandler handler)
	{
		this.handler = handler;
	}

	@Override
	public void award(RunsafePlayer player)
	{
		this.handler.awardPlayerObjective(player, this);
	}

	protected ObjectiveHandler handler;
}
