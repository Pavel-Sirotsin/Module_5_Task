package by.epam.jonline.task_2;

public class TestGenerator {

	public String goodsName(int i) {
		String[] store = { "Рубашка", "Часы", "Брюки", "Ботинки", "Джинсы", "Куртка" };
		return store[i];
	}

	public void fillCart(Payment receipt) {
		int randQ;
		double randP;

		for (int i = 0; i < 5; i++) {
			randQ = (int) (1 + Math.random() * 3);
			randP = Math.random() * 300;
			receipt.getProducts().add(new Payment.Product(goodsName(i), i, randQ, randP));
		}
	}

	public String storeName(int i) {
		String[] store = { "\"Zara\"", "\"Bershka\"", "\"Mohito\"", "\"Adidas\"", "\"Nike\"" };
		return store[i];
	}

	public void makePayment(Payment receipt) {
		int randID = (int) (Math.random() * 1000);
		int randN = (int) (Math.random() * 5);
		receipt.setId(randID);
		receipt.setStoreName(storeName(randN));

	}

}
