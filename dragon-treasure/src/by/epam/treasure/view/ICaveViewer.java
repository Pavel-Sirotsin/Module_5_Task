package by.epam.treasure.view;

import java.util.List;

import by.epam.treasure.entity.DragonCave;
import by.epam.treasure.entity.Treasure;

public interface ICaveViewer {
	String addAndRemoveAnswer(boolean result);
	String showAllInCaveAnswer(DragonCave cave);
	String chooseByCostAnswer(List<Treasure> list);
	String showExpensivestAnswer(Treasure t);
	

}
