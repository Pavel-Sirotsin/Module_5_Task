package by.epam.treasure.runner;

import by.epam.jonline.treasure.view.IMainViewer;
import by.epam.jonline.treasure.view.ViewerProvider;

/*Дракон и его сокровища. Создать программу, позволяющую обрабатывать сведения о 100 сокровищах в пещере
дракона. Реализовать возможность:
- просмотр сокровищ;
- выбор самого дорогого по стоимости сокровища;
- выбор сокровищ на заданную сумму.*/

public class Main {

	public static void main(String[] args) {
		ViewerProvider provider = ViewerProvider.getInstance();
		IMainViewer viewer = provider.getMainViewerImpl();

		String result = viewer.showMenu();
		System.out.println(result);

		result = viewer.chooseOperation();
		System.out.println(result);
		
        // additional functions:
		// input 4: добавляем сокровище
		// input 5: удаляем сокровище
	}

}
