package ru.job4j.array;

/**
 * Class RotateArray переворот квадратного массива на 90 градусов вправо.
 * @author Shaev Andrey.
 * @version 1.01.
 * @since 21.11.17.
*/
public class RotateArray {
	public int[][] rotate(int[][] array) {
		 
	        int[][] rotateArray = new int[array.length][array.length];
	 
	        for (int i = 0; i < array.length; i++) {
	 
	            for (int j = 0; j < array.length; j++) {
	 
	                rotateArray[i][(array.length - 1) - j] = array[j][i];
	            }
	        }
	 
	        return rotateArray;
	    }
}