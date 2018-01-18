package ru.job4j.tracker;

public class ValidateInput extends ConsoleInput {
	
	public int ask(String quation, int range) {
		boolean invalid = true;
		int value = -1;
		do {
			try {
				value = super.ask(quation, range);
				invalid = false;
			} catch (NumberFormatException nfe) {
				System.out.println("Please enter validate data again");
			} catch (MenuOutException moe) {
				System.out.println("Please enter number from menu");
			}
		} while(invalid);
		return value;
	}

}
