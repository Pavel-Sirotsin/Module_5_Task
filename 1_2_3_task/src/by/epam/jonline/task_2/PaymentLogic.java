package by.epam.jonline.task_2;

import java.util.Iterator;
import java.util.ListIterator;

public class PaymentLogic {

	public String totalAmount(Payment receipt) {
		double amount = 0;
		for (Payment.Product product : receipt.getProducts()) {
			amount += product.getPrice() * product.getQuantity();
		}
		return String.format("Total amount: %.2f", amount);
	}

	public void addProduct(Payment receipt, Payment.Product product) {
		receipt.getProducts().add(product);
	}

	public void removeProduct(Payment receipt, int article, int quantity) {
		Iterator<Payment.Product> it = receipt.getProducts().iterator();
		while (it.hasNext()) {
			Payment.Product current = it.next();
			if (current.getArticleN() == article && quantity > 0) {
				it.remove();
				quantity--;
			}
		}
	}

	public void removeProduct(Payment receipt, int article) {
		Iterator<Payment.Product> it = receipt.getProducts().iterator();
		while (it.hasNext()) {
			Payment.Product current = it.next();
			if (current.getArticleN() == article)
				it.remove();
		}
	}

	public void replaceProduct(Payment receipt, int article, Payment.Product another) {
		ListIterator<Payment.Product> li = receipt.getProducts().listIterator();
		while (li.hasNext()) {
			Payment.Product current = li.next();
			if (current.getArticleN() == article)
				li.set(another);
		}
	}
}
