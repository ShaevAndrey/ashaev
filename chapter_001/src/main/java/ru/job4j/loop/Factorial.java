package ru.job4j.loop;

/**
 * Class Counter 4.2. подсчёт факториала.
 * @author Shaev Andrey.
 * @version 1.01.
 * @since 18.11.17.
*/
public class Factorial {
public int calc(int n) {
	int count = 0;
	if (n == 0) {
		count = 1;
		} else {
			count = 1;
			for (int i = 1; i <= n; i++) {
			count = count * i;
			}
	    }	
	return count;
	}
}