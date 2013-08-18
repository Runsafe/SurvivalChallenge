package no.runsafe.survivalchallenge;

import no.runsafe.framework.minecraft.player.RunsafePlayer;

public interface IObjective
{
	public void award(RunsafePlayer player);
	public String getObjectiveTitle();
	public Objective getObjective();
}
