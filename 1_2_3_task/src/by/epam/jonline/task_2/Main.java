package by.epam.jonline.task_2;

/*Задача 2.
Создать класс Payment с внутренним классом, с помощью объектов которого можно сформировать покупку из
нескольких товаров.*/

public class Main {

	public static void main(String[] args) {
		Payment shop = new Payment();
		PaymentLogic logic = new PaymentLogic();

		TestGenerator gen = new TestGenerator();

		gen.fillCart(shop);
		gen.makePayment(shop);

		System.out.print(shop);
		System.out.println(logic.totalAmount(shop) + "\n");

		Payment.Product hoody = new Payment.Product.Builder("Байка").articleN(2054).price(56.56).quantity(1).build();
		Payment.Product boxer = new Payment.Product.Builder("Шорты").articleN(100).price(10.56).quantity(2).build();

		logic.addProduct(shop, hoody);
		logic.addProduct(shop, hoody);

		System.out.print(shop);
		System.out.println(logic.totalAmount(shop) + "\n");
		
		logic.removeProduct(shop, 0);
		logic.removeProduct(shop, 2054, 1);

		System.out.print(shop);
		System.out.println(logic.totalAmount(shop) + "\n");
		
		logic.replaceProduct(shop, 2054, boxer);
		System.out.print(shop);
		System.out.println(logic.totalAmount(shop) + "\n");
		
	}

}
