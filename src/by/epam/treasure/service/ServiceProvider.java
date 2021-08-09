package by.epam.treasure.service;

import by.epam.treasure.service.impl.CaveServiceImpl;

public class ServiceProvider {
	private final static ServiceProvider instance = new ServiceProvider();

	private ServiceProvider() {

	}

	public static ServiceProvider getInstance() {
		return instance;
	}

	private ICaveService serviceImpl = new CaveServiceImpl();

	public ICaveService getCaveServiceImpl() {
		return serviceImpl;
	}

}
