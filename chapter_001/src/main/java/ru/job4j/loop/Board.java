package ru.job4j.loop;

/**
 * Class Counter 4.3. Построение шахматной доски в псевдографике.
 * @author Shaev Andrey.
 * @version 1.01.
 * @since 18.11.17.
*/
public class Board {
	public String paint(int wigth, int height) {
		StringBuilder field = new StringBuilder();
		for (int i = 1; i <= height; i++) {
				for (int j = 1; j <= wigth; j++) {
						if ((i + j) % 2 == 1) {
							field.append(" ");
						} else {
							field.append("x");
							}
				}
				field.append(System.getProperty("line.separator"));
		}
    return field.toString();		
	}
}