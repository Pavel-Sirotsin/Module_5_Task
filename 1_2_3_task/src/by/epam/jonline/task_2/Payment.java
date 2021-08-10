package by.epam.jonline.task_2;

import java.util.*;

/*Задача 2.
Создать класс Payment с внутренним классом, с помощью объектов которого можно сформировать покупку из
нескольких товаров.*/

public class Payment {
	private int id;
	private String storeName;
	private List<Product> products;
	
	{
		products = new ArrayList<Product>();
	}

	public static class Product { // Nested classes starts:
		private String name;
		private int articleN;
		private int quantity;
		private double price;

		public static class Builder { //Joshua Bloch - effective java
			private String name;
			private int articleN;
			private int quantity;
			private double price;

			public Builder(String name) {
				this.name = name;
			}

			public Builder articleN(int val) {
				articleN = val;
				return this;
			}

			public Builder quantity(int val) {
				quantity = val;
				return this;
			}

			public Builder price(double val) {
				price = val;
				return this;
			}

			public Product build() {
				return new Product(this);
			}

		}

		private Product(Builder builder) {// Constructor for Builder pattern
			name = builder.name;
			articleN = builder.articleN;
			quantity = builder.quantity;
			price = builder.price;
		}

		public Product(String name, int articleN, int quantity, double price) {
			super();
			this.name = name;
			this.articleN = articleN;
			this.quantity = quantity;
			this.price = price;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getArticleN() {
			return articleN;
		}

		public void setArticleN(int articleN) {
			this.articleN = articleN;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + articleN;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			long temp;
			temp = Double.doubleToLongBits(price);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			result = prime * result + quantity;
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
			Product other = (Product) obj;
			if (articleN != other.articleN)
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
				return false;
			if (quantity != other.quantity)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return String.format("Product | ArticleN: %5d | Quantity: %d | Price: %7.2f BYN | Name: %s", articleN,
					quantity, price, name);
		}

	} // : nested classes ends.

	public Payment() {
		super();
	}

	public Payment(String storeName) {
		super();
		this.storeName = storeName;
	}

	public Payment(int id, String storeName, List<Product> products) {
		super();
		this.id = id;
		this.storeName = storeName;
		this.products = products;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((products == null) ? 0 : products.hashCode());
		result = prime * result + ((storeName == null) ? 0 : storeName.hashCode());
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
		Payment other = (Payment) obj;
		if (id != other.id)
			return false;
		if (products == null) {
			if (other.products != null)
				return false;
		} else if (!products.equals(other.products))
			return false;
		if (storeName == null) {
			if (other.storeName != null)
				return false;
		} else if (!storeName.equals(other.storeName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Payment");
		sb.append(" | ID: " + id);
		sb.append(" | Store: " + storeName + "\n");
		for (Product product : products) {
			sb.append(product + "\n");
		}
		return sb.toString();
	}

}
