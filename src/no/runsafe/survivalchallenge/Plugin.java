package no.runsafe.survivalchallenge;

import no.runsafe.framework.RunsafePlugin;
import no.runsafe.survivalchallenge.database.ObjectiveRepository;
import no.runsafe.survivalchallenge.objectives.CraftWorkbench;

public class Plugin extends RunsafePlugin
{
	@Override
	protected void PluginSetup()
	{
		// Core
		this.addComponent(ObjectiveRepository.class);
		this.addComponent(ObjectiveHandler.class);

		// Objectives
		this.addComponent(CraftWorkbench.class);
	}
}
