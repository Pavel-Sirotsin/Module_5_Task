package by.epam.jonline.treasure.controller.impl;

import by.epam.jonline.treasure.controller.Command;
import by.epam.jonline.treasure.view.ICaveViewer;
import by.epam.jonline.treasure.view.IMainViewer;
import by.epam.jonline.treasure.view.ViewerProvider;
import by.epam.treasure.service.ICaveService;
import by.epam.treasure.service.ServiceException;
import by.epam.treasure.service.ServiceProvider;

public class RemoveTreasure implements Command{

	@Override
	public String execute() {
		ServiceProvider serviceProvider = ServiceProvider.getInstance();
		ICaveService caveService = serviceProvider.getCaveServiceImpl();

		ViewerProvider viewerProvider = ViewerProvider.getInstance();
		ICaveViewer caveViewer = viewerProvider.getCaveActionViewer();
		IMainViewer mainViewer = viewerProvider.getMainViewerImpl();

		boolean result; 
		int id;
		
		try {
			id = mainViewer.chooseId();
			result = caveService.removeTreasure(id);

			return caveViewer.addAndRemoveAnswer(result);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		
		return "Проверьте введенные данные!";
	}

}
