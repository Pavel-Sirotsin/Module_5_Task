package by.epam.jonline.treasure.controller;

import by.epam.jonline.treasure.controller.impl.ControllerImpl;

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
