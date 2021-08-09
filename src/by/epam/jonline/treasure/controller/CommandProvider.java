package by.epam.jonline.treasure.controller;

import java.util.HashMap;
import java.util.Map;

import by.epam.jonline.treasure.controller.impl.AddTreasure;
import by.epam.jonline.treasure.controller.impl.ChooseByCostCommand;
import by.epam.jonline.treasure.controller.impl.RemoveTreasure;
import by.epam.jonline.treasure.controller.impl.ShowAllInCaveCommand;
import by.epam.jonline.treasure.controller.impl.ShowExpensivestCommand;

public class CommandProvider {
	
	private Map<String, Command> commands = new HashMap<>();
	
	public CommandProvider() {
		commands.put("1", new ShowAllInCaveCommand());
		commands.put("2", new ShowExpensivestCommand());
		commands.put("3", new ChooseByCostCommand());
		commands.put("4", new AddTreasure());
		commands.put("5", new RemoveTreasure());
	}

	public Command getCommand(String operation) {
		Command command = commands.get(operation);
		return command;
	}

}
