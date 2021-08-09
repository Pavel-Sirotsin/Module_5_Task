package by.epam.jonline.treasure.controller.impl;

import by.epam.jonline.treasure.controller.Command;
import by.epam.jonline.treasure.view.ICaveViewer;
import by.epam.jonline.treasure.view.IMainViewer;
import by.epam.jonline.treasure.view.ViewerProvider;
import by.epam.treasure.entity.Treasure;
import by.epam.treasure.service.ICaveService;
import by.epam.treasure.service.ServiceException;
import by.epam.treasure.service.ServiceProvider;

public class AddTreasure implements Command {

	@Override
	public String execute() {
		ServiceProvider serviceProvider = ServiceProvider.getInstance();
		ICaveService caveService = serviceProvider.getCaveServiceImpl();

		ViewerProvider viewerProvider = ViewerProvider.getInstance();
		ICaveViewer caveViewer = viewerProvider.getCaveActionViewer();
		IMainViewer mainViewer = viewerProvider.getMainViewerImpl();

		int id = (int) (Math.random() * 10000);
		String name = mainViewer.inputName();
		int wieght = mainViewer.inputWieght();
		double cost = mainViewer.inputCost();

		try {
			Treasure t = caveService.createFromInputData(id, name, wieght, cost);
			boolean result = caveService.addTresure(t);

			return caveViewer.addAndRemoveAnswer(result);
		} catch (ServiceException e) {
			e.printStackTrace();
		}

		return "Проверьте введенные данные!";
	}

}
