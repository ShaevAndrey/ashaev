package ru.job4j.loop;

/**
 * Class Counter 4.4. Построение пирамиды в псевдографике.
 * @author Shaev Andrey.
 * @version 1.01.
 * @since 18.11.17.
*/
public class Paint {
	public String piramid(int h) {
		StringBuilder field = new StringBuilder();
		for (int i = 1; i <= h; i++) {
				for (int j = 1; j <= (2 * h - 1); j++) {
						if ((h - i) < j && j < (h + i)) {
							field.append("^");
							} else {
								field.append(" ");
						    }
				}
				field.append(System.getProperty("line.separator"));
		}
	 return field.toString();		
	}
}