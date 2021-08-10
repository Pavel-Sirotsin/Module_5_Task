package by.epam.jonline.task_3;

/*Задача 3.
Создать класс Календарь с внутренним классом, с помощью объектов которого можно хранить информацию о
выходных и праздничных днях.
*/

public class Main {

	public static void main(String[] args) {
		MyCalendar calendar = new MyCalendar();
		Logic logic = new Logic(calendar);
		
		logic.addDay(2021, 1, 1, DayType.HOLIDAY);
		logic.addDay(2021, 1, 2, DayType.HOLIDAY);

		MyCalendar.Day day = logic.addDay(2021, 1, 23);
		logic.addDay(2021, 3, 27);
		logic.addDay(2021, 6, 26);
		logic.addDay(2021, 6, 27);

		System.out.println(calendar);
		logic.removeDay(2021, 3, 27);
		logic.removeDay(day);
		
		System.out.println(calendar);


	}

}
