package ru.job4j.array;

import java.util.Arrays;
/**
 * Class ArrayDuplicate удаляет двойные элементы из массива.
 * @author Shaev Andrey.
 * @version 1.01.
 * @since 21.11.17.
*/
public class ArrayDuplicate {
	 public String[] remove(String[] array) {
		 String buffer;
		 int cut = array.length - 1;
		 for (int i = 0; i < cut; i++) {
		 	 	 int j = i + 1;
		 		 while (j < cut) {
					if (array[i].equals(array[j])) {
					buffer = array[cut]; 	//меняем элементы
					array[cut] = array[j];
					array[j] = buffer;
					cut = cut - 1;
					j--;				//ещё раз проверяем этот элемент
					}
				j++;
				}
		 	}
	 return Arrays.copyOf(array, cut + 1);
	 }
}