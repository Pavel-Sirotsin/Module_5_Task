package by.epam.treasure.service.impl;

import java.util.Iterator;
import java.util.List;

import by.epam.treasure.service.ServiceException;
import by.epam.treasure.service.util.Validator;
import by.epam.treasure.dao.DAOException;
import by.epam.treasure.dao.DAOProvider;
import by.epam.treasure.dao.ICaveDAO;
import by.epam.treasure.entity.DragonCave;
import by.epam.treasure.entity.Treasure;
import by.epam.treasure.service.ICaveService;

public class CaveServiceImpl implements ICaveService {
	private static final DragonCave CAVE = new DragonCave("Red - White Frankenstein", "Republic of Belarus");

	private DAOProvider provider = DAOProvider.getInstance();
	private ICaveDAO dao = provider.getCaveImpl();

	@Override
	public boolean addTresure(Treasure t) throws ServiceException {

		try {
			return dao.addTresure(t);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

	}

	@Override
	public boolean removeTreasure(int id) throws ServiceException {

		try {
			return dao.removeTreasure(id);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

	}

	@Override
	public DragonCave getAllCave() throws ServiceException {
		
		try {
			List<Treasure> list = dao.createListFromFile();
			CAVE.setList(list);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		
		return CAVE;
	}

	@Override
	public List<Treasure> chooseByCost(int val) throws ServiceException {
		if (!Validator.isValid(val)) {
			throw new ServiceException("Недопустимое значение!");  // проверка данных на слое сервисов.
		}

		try {
			List<Treasure> list = dao.createListFromFile();
			Iterator<Treasure> it = list.iterator();

			while (it.hasNext()) {
				Treasure temp = it.next();
				if (temp.getCost() > val)
					it.remove();
			}

			return list;
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

	}

	@Override
	public Treasure showExpensivest() throws ServiceException {
		double max = 0.0;
		Treasure expensivest = null;

		try {
			List<Treasure> list = dao.createListFromFile();

			for (Treasure t : list) {

				if (t.getCost() > max) {
					max = t.getCost();
					expensivest = t;
				}

			}

			return expensivest;

		} catch (DAOException e) {
			throw new ServiceException(e);
		}

	}

	@Override
	public Treasure createFromInputData(int id, String name, int wieght, double cost) throws ServiceException {
		Treasure t = new Treasure(id, name, wieght, cost);
		return t;
	}

}
