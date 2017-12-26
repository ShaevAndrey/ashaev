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
}