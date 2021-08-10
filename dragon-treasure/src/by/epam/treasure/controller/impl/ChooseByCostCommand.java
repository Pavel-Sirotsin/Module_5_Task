package by.epam.treasure.controller.impl;

import java.util.List;

import by.epam.treasure.controller.Command;
import by.epam.treasure.entity.Treasure;
import by.epam.treasure.service.ICaveService;
import by.epam.treasure.service.ServiceException;
import by.epam.treasure.service.ServiceProvider;
import by.epam.treasure.view.ICaveViewer;
import by.epam.treasure.view.IMainViewer;
import by.epam.treasure.view.ViewerProvider;

public class ChooseByCostCommand implements Command {

	@Override
	public String execute() {
		ServiceProvider serviceProvider = ServiceProvider.getInstance();
		ICaveService caveService = serviceProvider.getCaveServiceImpl();

		ViewerProvider viewerProvider = ViewerProvider.getInstance();
		ICaveViewer caveViewer = viewerProvider.getCaveActionViewer();
		IMainViewer mainViewer = viewerProvider.getMainViewerImpl();

		List<Treasure> list;
		int val;

		try {
			val = mainViewer.chooseSum();
			list = caveService.chooseByCost(val);
			
			return caveViewer.chooseByCostAnswer(list);
		} catch (ServiceException e) {
			e.printStackTrace();
		}

		return "Проверьте введенные данные!";
	}

}
