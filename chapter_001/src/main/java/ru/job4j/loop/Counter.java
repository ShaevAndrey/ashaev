package ru.job4j.loop;

/**
 * Class Counter 4.1. подсчёт чётных чисел в диапозоне
 * @author Shaev Andrey
 * @version 1.01
 * @since 18.11.17
*/
public class Counter {
public int add(int start, int finish) {
	int count = 0;
	for (int i = start; i <= finish; i++) {
		 if (i % 2 == 0) {
			 count = count + i;
		 }
	}	
	return count;
}
}