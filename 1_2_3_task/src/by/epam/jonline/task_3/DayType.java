package by.epam.jonline.task_3;

public enum DayType {
	WEEKDAY("Рабочий день"), WEEKEND("Выходной день"), HOLIDAY("Праздник - оф. выходной");

	private String event;

	private DayType(String event) {
		this.event = event;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	@Override
	public String toString() {
		return String.format("%s", name(), event);
	}

}
