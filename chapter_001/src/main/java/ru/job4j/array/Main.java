package ru.job4j.array;

import java.util.Arrays;

/**
 * Class Main проверяет наличие одной строки в другой.
 * @author Shaev Andrey.
 * @version 1.01.
 * @since 26.11.17.
*/
public class Main {
public static void main(String[] args) {
	String origin = "privet";
	String sub = "pr";
	boolean result = contains(origin, sub);
	System.out.println(result);
	}
static boolean contains(String origin, String sub) {
 	char[] stroka = origin.toCharArray();
	char[] test = sub.toCharArray();
	boolean result = false;
	int lstroka = stroka.length;
	int ltest = test.length;
		if (ltest <= lstroka) {
		for (int i = 0; i < (lstroka - ltest + 1); i++) {
			int count = 0;
			int j = 0;
			do {
				if (stroka[i + j] == test[j]) {
					j++;
					count++;
					} else {
						j--;
					}
				} while (j == count && j < ltest);
				if ((count) == ltest) {
					result = true;
					break; 
				}
			}
		}
	return result;
	}
}