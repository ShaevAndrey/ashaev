package ru.job4j.tracker;

import java.util.*;

/**
 * Class ConsoleInput служит общения Tracker с пользователем.
 * @author Shaev Andrey.
 * @version 1.01.
 * @since 22.12.2012
*/

public class ConsoleInput implements Input {
	private Scanner scanner = new Scanner(System.in);
	
	public String ask(String quation) {
		System.out.println(quation);
		return scanner.nextLine();
	}
	
	public int ask(String quation, int range) {
		int key = Integer.valueOf(scanner.nextLine());
		boolean exist = false;
		if(key >= 0 && key < range) {
			exist = true;
		}
		if(exist) {
			return key;
		} else {
			throw new MenuOutException("OUT of range");
		}
	}
}