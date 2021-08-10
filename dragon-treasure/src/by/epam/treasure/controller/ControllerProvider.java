package by.epam.treasure.controller;

import by.epam.treasure.controller.impl.ControllerImpl;

public class ControllerProvider {
	private static final ControllerProvider instance = new ControllerProvider();

	private ControllerProvider() {
	};

	private IController controller = new ControllerImpl();

	public static ControllerProvider getInstance() {
		return instance;
	}

	public IController getController() {
		return controller;
	}

}
