package by.epam.jonline.task_1;

/*Задача 1.
Создать объект класса Текстовый файл, используя классы Файл, Директория. Методы: создать, переименовать,
вывести на консоль содержимое, дополнить, удалить.*/

public class Main {

	public static void main(String[] args) {
		FileLogic logic = new FileLogic();
		Directory directory = new Directory("My Books");

		String text = "Once in this wonderful world in a small vilage called \"Booland\",was born a little boy named \"JakSoon\" son of SoonJaka."
				+ " Since childhood, he dreamed of sailing around the world.";

		TextFile file1 = logic.createTextFile("Sailor's Story", "txt", text);
		System.out.println(file1);
		System.out.println();
		
		TextFile file2 = new TextFile("Bank robbery", "txt", "1st of julay :)");

		logic.rename(file1, "JakSoon's Childhood");
		
		logic.addTxtContent(file1, "When he grew up he built his first boat from bamboo trie.");
		System.out.println(file1);
		System.out.println();
		
		logic.addTxtContent(file2, "Bang! Bang! I'll shoot you down!");
		System.out.println(file2);
		System.out.println();
		
		logic.addToDirectory(file1, directory);
		logic.addToDirectory(file2, directory);
		
		System.out.println(directory);
		System.out.println();
		
		logic.delFromDirectory(file1, directory);
		logic.delFromDirectory(file2, directory);
		
		System.out.println(directory);
		System.out.println();
		
	}

}
