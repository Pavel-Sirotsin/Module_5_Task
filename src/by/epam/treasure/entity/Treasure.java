package by.epam.treasure.entity;

public class Treasure {

	private int id;
	private String name;
	private int wieght;
	private double cost;

	public Treasure() {
		super();
	}

	public Treasure(int id, String name, int wieght, double cost) {
		super();
		this.id = id;
		this.name = name;
		this.wieght = wieght;
		this.cost = cost;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWieght() {
		return wieght;
	}

	public void setWieght(int wieght) {
		this.wieght = wieght;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(cost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + wieght;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Treasure other = (Treasure) obj;
		if (Double.doubleToLongBits(cost) != Double.doubleToLongBits(other.cost))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (wieght != other.wieght)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("Treasure - ID: %-5d | Name: %-23s | Wieght: %-4d gr.(ct.) | Cost: %.2f $", id, name, wieght,
				cost);
	}

}
