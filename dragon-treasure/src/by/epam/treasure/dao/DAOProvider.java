package by.epam.treasure.dao;

import by.epam.treasure.dao.impl.CaveImpl;

public class DAOProvider {
	private final static DAOProvider instance = new DAOProvider();

	private DAOProvider() {

	}

	private ICaveDAO caveImpl = new CaveImpl();

	public static DAOProvider getInstance() {
		return instance;
	}

	public ICaveDAO getCaveImpl() {
		return caveImpl;
	}

}
