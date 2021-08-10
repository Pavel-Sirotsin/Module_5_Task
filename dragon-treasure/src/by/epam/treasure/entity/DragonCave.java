package by.epam.treasure.entity;

import java.util.ArrayList;
import java.util.List;

public class DragonCave {

	private String name;
	private String place;
	private List<Treasure> list;
	{
		list = new ArrayList<Treasure>();
	}

	public DragonCave() {
		super();
	}

	public DragonCave(String name) {
		super();
		this.name = name;
	}

	public DragonCave(String name, String place) {
		super();
		this.name = name;
		this.place = place;
	}

	public DragonCave(String name, String place, List<Treasure> list) {
		super();
		this.name = name;
		this.place = place;
		this.list = list;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public List<Treasure> getList() {
		return list;
	}

	public void setList(List<Treasure> list) {
		this.list = list;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((place == null) ? 0 : place.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((list == null) ? 0 : list.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj && obj != null)
			return true;
		if (getClass() != obj.getClass())
			return false;
		DragonCave other = (DragonCave) obj;
		if (place == null && other.place != null)
			return false;
		if (!place.equals(other.place))
			return false;
		if (name == null && other.name != null)
			return false;
		if (!name.equals(other.name))
			return false;
		if (list == null && other.list != null)
			return false;
		if (!list.equals(other.list))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(String.format("DragonCave: %s | %s\n", name, place));
		for (Treasure t : list) {
			sb.append(t.toString());
			sb.append("\n");
		}
		return sb.toString();
	}

}
