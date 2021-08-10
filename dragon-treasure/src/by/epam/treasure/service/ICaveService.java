package by.epam.treasure.service;

import java.util.List;

import by.epam.treasure.entity.DragonCave;
import by.epam.treasure.entity.Treasure;

public interface ICaveService {
	Treasure createFromInputData(int id, String name, int wieght, double cost) throws ServiceException;
	boolean addTresure(Treasure t) throws ServiceException;
	boolean removeTreasure(int id) throws ServiceException;
	DragonCave getAllCave() throws ServiceException;
	List<Treasure> chooseByCost(int val) throws ServiceException;
	Treasure showExpensivest() throws ServiceException;

}
