package by.epam.jonline.task_3;

import java.time.Month;
import java.util.Calendar;
import java.util.Iterator;

public class Logic {
	private MyCalendar calendar;

	public Logic() {
		super();
	}

	public Logic(MyCalendar calendar) {
		super();
		this.calendar = calendar;
	}

	public MyCalendar.Day addDay(int year, int month, int dayOfMonth) {
		MyCalendar.Day date = new MyCalendar.Day(year, month, dayOfMonth);

		boolean result = calendar.getDates().add(date);

		if (result) {
			int dayOfWeek = date.getDate().get(Calendar.DAY_OF_WEEK);

			if (dayOfWeek == 6 || dayOfWeek == 7)
				date.setType(DayType.WEEKEND);
			else
				date.setType(DayType.WEEKDAY);
		}
		return date;
	}

	public MyCalendar.Day addDay(int year, int month, int dayOfMonth, DayType type) {
		MyCalendar.Day date = new MyCalendar.Day(year, month, dayOfMonth);

		boolean result = calendar.getDates().add(date);

		if (result) {
			date.setType(type);
		}
		
		return date;

	}

	public void removeDay(MyCalendar.Day date) {
		Iterator<MyCalendar.Day> it = calendar.getDates().iterator();

		while (it.hasNext()) {
			MyCalendar.Day current = it.next();
			
			if (current.equals(date))
				it.remove();
		}
	}
	
	public void removeDay(int year, int month, int dayOfMonth) {
		month = Month.of(month).ordinal();
		Iterator<MyCalendar.Day> it = calendar.getDates().iterator();

		while (it.hasNext()) {
			MyCalendar.Day current = it.next();
			int anotherYear = current.getDate().get(Calendar.YEAR);
			int anotherMonth = current.getDate().get(Calendar.MONTH);
			int anotherDay = current.getDate().get(Calendar.DAY_OF_MONTH);
			
			if (anotherYear == year && anotherMonth == month && anotherDay == dayOfMonth)
				it.remove();
		}
	}

}
//