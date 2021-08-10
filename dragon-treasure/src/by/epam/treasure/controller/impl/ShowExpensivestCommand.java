package by.epam.treasure.controller.impl;

import by.epam.treasure.controller.Command;
import by.epam.treasure.entity.Treasure;
import by.epam.treasure.service.ICaveService;
import by.epam.treasure.service.ServiceException;
import by.epam.treasure.service.ServiceProvider;
import by.epam.treasure.view.ICaveViewer;
import by.epam.treasure.view.ViewerProvider;

public class ShowExpensivestCommand implements Command {

	@Override
	public String execute() {
		ServiceProvider serviceProvider = ServiceProvider.getInstance();
		ICaveService caveService = serviceProvider.getCaveServiceImpl();

		ViewerProvider viewerProvider = ViewerProvider.getInstance();
		ICaveViewer caveViewer = viewerProvider.getCaveActionViewer();

		try {

			Treasure t = caveService.showExpensivest();
			return caveViewer.showExpensivestAnswer(t);

		} catch (ServiceException e) {
			e.printStackTrace();
			return "Something need to fix up!";
		}
	}

}
