package by.epam.treasure.dao.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.epam.treasure.dao.DAOException;
import by.epam.treasure.dao.ICaveDAO;
import by.epam.treasure.entity.Treasure;

public class CaveImpl implements ICaveDAO {

	private static final String RESOURCE = "src/by/epam/treasure/resources/treasure list";

	@Override
	public boolean addTresure(Treasure t) throws DAOException {
		try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(RESOURCE, true)))) {

			pw.println(t);
			return true;
		} catch (IOException e) {
			throw new DAOException(e);
		}

	}

	@Override
	public boolean removeTreasure(int id) throws DAOException {
		try (BufferedReader in = new BufferedReader(new FileReader(RESOURCE))) {

			StringBuilder sb = new StringBuilder();
			Pattern p = Pattern.compile("ID: " + id);
			Matcher m;
			String temp;

			while ((temp = in.readLine()) != null) {
				m = p.matcher(temp);

				if (!m.find()) {
					sb.append(temp);
					sb.append("\n");
				}
			}

			try (BufferedWriter out = new BufferedWriter(new FileWriter(RESOURCE))) {
				out.write(sb.toString());
			} catch (IOException e) {
				throw new DAOException(e);
			}

			return true;
		} catch (IOException e) {
			throw new DAOException(e);
		}

	}

	@Override
	public List<Treasure> createListFromFile() throws DAOException {
		List<Treasure> scroll = new ArrayList<Treasure>();

		String regex = ".+?(\\d+).+?: (.+)?\\|.+?: (\\d+).+?: (.+)? \\$";
		int id;
		String name;
		int wieght;
		double cost;

		Pattern p = Pattern.compile(regex);
		Matcher m;

		try (BufferedReader in = new BufferedReader(new FileReader(RESOURCE))) {
			String temp;
			while ((temp = in.readLine()) != null) {
				m = p.matcher(temp);

				if (m.matches()) {

					id = Integer.parseInt(m.group(1));
					name = m.group(2);
					wieght = Integer.parseInt(m.group(3));
					cost = Double.parseDouble(m.group(4));

					Treasure t = new Treasure(id, name, wieght, cost);
					scroll.add(t);
				}
			}
		} catch (IOException e) {
			throw new DAOException(e);
		}

		return scroll;

	}

}
