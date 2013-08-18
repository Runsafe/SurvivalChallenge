package no.runsafe.survivalchallenge;

import no.runsafe.framework.RunsafeConfigurablePlugin;
import no.runsafe.survivalchallenge.database.ObjectiveRepository;
import no.runsafe.survivalchallenge.objectives.CraftWorkbench;
import no.runsafe.survivalchallenge.objectives.Diamonds;
import no.runsafe.survivalchallenge.objectives.Emeralds;
import no.runsafe.survivalchallenge.objectives.VillagerTrade;

public class Plugin extends RunsafeConfigurablePlugin
{
	@Override
	protected void PluginSetup()
	{
		// Core
		addComponent(ObjectiveRepository.class);
		addComponent(ObjectiveHandler.class);

		// Objectives
		addComponent(CraftWorkbench.class);
		addComponent(Diamonds.class);
		addComponent(Emeralds.class);
		addComponent(VillagerTrade.class);
	}
}
