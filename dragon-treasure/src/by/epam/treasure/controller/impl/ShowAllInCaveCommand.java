package by.epam.treasure.controller.impl;

import by.epam.treasure.controller.Command;
import by.epam.treasure.entity.DragonCave;
import by.epam.treasure.service.ICaveService;
import by.epam.treasure.service.ServiceException;
import by.epam.treasure.service.ServiceProvider;
import by.epam.treasure.view.ICaveViewer;
import by.epam.treasure.view.ViewerProvider;

public class ShowAllInCaveCommand implements Command {

	@Override
	public String execute() {
		ServiceProvider serviceProvider = ServiceProvider.getInstance();
		ICaveService caveService = serviceProvider.getCaveServiceImpl();

		ViewerProvider viewerProvider = ViewerProvider.getInstance();
		ICaveViewer caveViewer = viewerProvider.getCaveActionViewer();

		try {

			DragonCave cave = caveService.getAllCave();
			return caveViewer.showAllInCaveAnswer(cave);

		} catch (ServiceException e) {
			e.printStackTrace();
			return e.getMessage();
		}

	}

}
