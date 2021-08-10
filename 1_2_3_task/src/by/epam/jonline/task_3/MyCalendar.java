package by.epam.jonline.task_3;

import java.time.Month;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Locale;
import java.util.SortedSet;
import java.util.TreeSet;

public class MyCalendar {
	private SortedSet<Day> dates;

	{
		dates = new TreeSet<Day>(new Comparator<Day>() {

			@Override
			public int compare(Day o1, Day o2) {
				return o1.date.compareTo(o2.date);
			}

		});
	}

	public static class Day { // inner class starts:
		private Calendar date;
		private Locale locale;
		private DayType type;

		{
			locale = new Locale("ru", "BY");
			date = Calendar.getInstance();
		}

		public Day() {
			super();
		}

		public Day(int year, int month, int dayOfMonth) {
			super();
			month = Month.of(month).ordinal();
			this.date.set(year, month, dayOfMonth);
		}

		public Day(int year, int month, int dayOfMonth, DayType type) {
			super();
			month = Month.of(month).ordinal();
			this.date.set(year, month, dayOfMonth);
			this.type = type;
		}

		public Calendar getDate() {
			return date;
		}

		public void setDate(int year, int month, int dayOfMonth) {
			month = Month.of(month).ordinal();
			this.date.set(year, month, dayOfMonth);
		}

		public Locale getLocale() {
			return locale;
		}

		public void setLocale(Locale locale) {
			this.locale = locale;
		}

		public DayType getType() {
			return type;
		}

		public void setType(DayType type) {
			this.type = type;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((date == null) ? 0 : date.hashCode());
			result = prime * result + ((locale == null) ? 0 : locale.hashCode());
			result = prime * result + ((type == null) ? 0 : type.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Day other = (Day) obj;
			if (date == null) {
				if (other.date != null)
					return false;
			} else if (!date.equals(other.date))
				return false;
			if (locale == null) {
				if (other.locale != null)
					return false;
			} else if (!locale.equals(other.locale))
				return false;
			if (type != other.type)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return String.format("Day | %tF | %-12s | %s", date.getTime(),
					date.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG_FORMAT, locale), type.getEvent());
		}

	} // : inner class ends.

	public MyCalendar() {
		super();
	}

	public MyCalendar(SortedSet<Day> dates) {
		super();
		this.dates = dates;
	}

	public void setDates(SortedSet<Day> date) {
		this.dates = date;
	}

	public SortedSet<Day> getDates() {
		return dates;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dates == null) ? 0 : dates.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyCalendar other = (MyCalendar) obj;
		if (dates == null) {
			if (other.dates != null)
				return false;
		} else if (!dates.equals(other.dates))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("MyCalendar:\n");
		for (Day day : dates) {
			sb.append(day);
			sb.append("\n");
		}
		return sb.toString();
	}

}
