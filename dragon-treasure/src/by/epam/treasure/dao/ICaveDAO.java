package by.epam.treasure.dao;

import java.util.List;

import by.epam.treasure.entity.Treasure;

public interface ICaveDAO {
	boolean addTresure(Treasure t) throws DAOException;
	boolean removeTreasure(int id) throws DAOException;
	List<Treasure> createListFromFile() throws DAOException;
	

}
