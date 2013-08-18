package no.runsafe.survivalchallenge.database;

import no.runsafe.framework.api.database.IDatabase;
import no.runsafe.framework.api.database.IRow;
import no.runsafe.framework.api.database.ISet;
import no.runsafe.framework.api.database.Repository;
import no.runsafe.framework.minecraft.player.RunsafePlayer;
import no.runsafe.survivalchallenge.Objective;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ObjectiveRepository extends Repository
{
	public ObjectiveRepository(IDatabase database)
	{
		this.database = database;
	}

	@Override
	public String getTableName()
	{
		return "survival_challenge";
	}

	public HashMap<String, List<Integer>> getStoredData()
	{
		HashMap<String, List<Integer>> storedData = new HashMap<String, List<Integer>>();
		ISet data = this.database.Query("SELECT playerName, objectiveID FROM survival_challenge");
		for (IRow node : data)
		{
			String playerName = node.String("playerName");
			if (!storedData.containsKey(playerName))
				storedData.put(playerName, new ArrayList<Integer>());

			storedData.get(playerName).add(node.Integer("objectiveID"));
		}
		return storedData;
	}

	public void flagObjectiveComplete(RunsafePlayer player, Objective objective)
	{
		this.database.Execute(
				"INSERT INTO survival_challenge (playerName, objectiveID) VALUES(?, ?)",
				player.getName(),
				objective.ordinal()
		);
	}

	@Override
	public HashMap<Integer, List<String>> getSchemaUpdateQueries()
	{
		HashMap<Integer, List<String>> queries = new HashMap<Integer, List<String>>();
		ArrayList<String> sql = new ArrayList<String>();
		sql.add(
			"CREATE TABLE `survival_challenge` (" +
				"`playerName` VARCHAR(50) NOT NULL," +
				"`objectiveID` INT(10) NOT NULL," +
				"PRIMARY KEY (`playerName`, `objectiveID`)" +
				")"
		);
		queries.put(1, sql);
		return queries;
	}

	private IDatabase database;
}
