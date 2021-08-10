package by.epam.treasure.service.util;

public class Validator {
	public static boolean isValid(Object o) {
		if (o == null)
			return false;
		else
			return true;
	}
	
	public static boolean isValid(int val) {
		if (val < 0)
			return false;
		else
			return true;
	}

}
