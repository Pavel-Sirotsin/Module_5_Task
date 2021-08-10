package by.epam.treasure.controller.impl;

import by.epam.treasure.controller.Command;
import by.epam.treasure.controller.CommandProvider;
import by.epam.treasure.controller.IController;

public class ControllerImpl implements IController {
	
	private CommandProvider provider = new CommandProvider();

	@Override
	public String doAction(String operation) {
		// request form: 'number of operation'
		
		String responce;
		
		Command current = provider.getCommand(operation);
		responce = current.execute();
		
		return responce;
	}

}
