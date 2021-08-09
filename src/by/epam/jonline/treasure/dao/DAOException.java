package by.epam.jonline.treasure.dao;

@SuppressWarnings("serial")
public class DAOException extends Exception{

	public DAOException() {
		super();
	}

	public DAOException(String message, Exception e) {
		super(message, e);
	}

	public DAOException(String message) {
		super(message);
	}

	public DAOException(Exception e) {
		super(e);
	}

}
