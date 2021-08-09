package by.epam.jonline.treasure.view.impl;

import java.util.Scanner;

import by.epam.jonline.treasure.controller.ControllerProvider;
import by.epam.jonline.treasure.controller.IController;
import by.epam.jonline.treasure.view.IMainViewer;

public class MainViewerImpl implements IMainViewer {
	private static final Scanner INPUT = new Scanner(System.in);

	@Override
	public int chooseSum() {
		int val;
		System.out.println("Введите допустимую сумму:\n");

		while (!INPUT.hasNextInt()) {
			System.out.println("Допустимы только цифры.");
			INPUT.next();
		}

		val = INPUT.nextInt();

		INPUT.close();
		return val;
	}

	@Override
	public String showMenu() {
		return String.format("Введите номер операции:\n1 - %s\n2 - %s\n3 - %s", "просмотр сокровищ",
				"выбор самого дорогого по стоимости сокровища", "выбор сокровищ на заданную сумму");
	}

	@Override
	public String chooseOperation() {
		ControllerProvider provider = ControllerProvider.getInstance();
		IController controller = provider.getController();

		String request;
		String responce;

		while (!INPUT.hasNext("[1-5]{1}")) {
			System.out.println("Допустимые значения: 1,2,3 либо 4,5");
			INPUT.next();
		}

		request = INPUT.next();
		if (request.equals("1") || request.equals("2")) {
			INPUT.close();
		}
		
		responce = controller.doAction(request);

		return responce;
	}

	@Override
	public String inputName() {
		System.out.println("Введите имя:");

		while (!INPUT.hasNextLine()) {
			System.out.println("Допустимы только буквы");
			INPUT.nextLine();
		}

		return INPUT.nextLine();
	}

	@Override
	public int inputWieght() {
		System.out.println("Введите вес:");

		while (!INPUT.hasNext("\\d{1,4}")) {
			System.out.println("Допустимы только четерёхзначные цифры");
			INPUT.next();
		}

		String val = INPUT.next();

		return Integer.parseInt(val);
	}

	@Override
	public double inputCost() {

		System.out.println("Введите стоимость:");

		while (!INPUT.hasNext("\\d*\\.?\\d*"))

		{
			System.out.println("Допустимы только цифры!");
			INPUT.next();
		}

		String val = INPUT.next();

		INPUT.close();
		return Double.parseDouble(val);
	}

	@Override
	public int chooseId() {
		int val;
		System.out.println("Введите ID номер сокровища:");

		while (!INPUT.hasNext("\\d+")) {
			System.out.println("Допустимы только цифры.");
			INPUT.next();
		}
		val = INPUT.nextInt();
		
		INPUT.close();
		return val;
	}

}
