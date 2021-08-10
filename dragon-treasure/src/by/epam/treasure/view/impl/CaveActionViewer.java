package by.epam.treasure.view.impl;

import java.util.List;

import by.epam.treasure.entity.DragonCave;
import by.epam.treasure.entity.Treasure;
import by.epam.treasure.view.ICaveViewer;

public class CaveActionViewer implements ICaveViewer {

	@Override
	public String addAndRemoveAnswer(boolean result) {
		return (result ? "Успешно!" : "Что-то пошло не так!");
	}

	@Override
	public String showAllInCaveAnswer(DragonCave cave) {
		return cave.toString();
	}

	@Override
	public String chooseByCostAnswer(List<Treasure> list) {
		if (list.size() != 0) {
			StringBuilder sb = new StringBuilder();

			for (Treasure t : list) {
				sb.append(String.format("ID: %-3d | Name: %-23s | Wieght: %-6d gr.(ct.) | Cost: %.2f $", t.getId(),
						t.getName(), t.getWieght(), t.getCost()));
				sb.append("\n");
			}

			return sb.toString();
		} else
			return "Таких драгоценностей нет!";
	}

	@Override
	public String showExpensivestAnswer(Treasure t) {
		return t.toString();
	}

}
