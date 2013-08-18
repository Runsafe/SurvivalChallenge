package no.runsafe.survivalchallenge;

import no.runsafe.framework.RunsafeConfigurablePlugin;
import no.runsafe.survivalchallenge.database.ObjectiveRepository;
import no.runsafe.survivalchallenge.objectives.*;

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
		addComponent(CaveSpiderKill.class);
		addComponent(CreeperKill.class);
		addComponent(SkeletonKill.class);
		addComponent(ZombieKill.class);
		addComponent(SilverfishKill.class);
		addComponent(SlimeKill.class);
		addComponent(EndermanKill.class);
		addComponent(SpiderKill.class);
	}
}
