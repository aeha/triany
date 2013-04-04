package aeha;

import aeha.dicti.Dicti;

public class DoMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Dicti dicti = new Dicti();
		dicti.set_entry(10, 1000);
		dicti.set_entry(5, 5000);
		dicti.set_entry(100, 10000);

		dicti.set_entry(5, 1);
		dicti.set_entry(10, 1);
		dicti.set_entry(100, 1);

		dicti.set_entry(1000000, 10000);
		dicti.set_entry(2, 10000);
		dicti.set_entry(11, 10000);

		dicti.set_entry(1, 100);
		dicti.set_entry(1, 1);


		int sum = dicti.find_entry(1);
		sum += dicti.find_entry(10);
		sum += dicti.find_entry(5);
		sum += dicti.find_entry(100);

		System.out.println( sum );

		dicti.print_entry();

	}

}
