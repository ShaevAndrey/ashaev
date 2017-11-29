package ru.job4j.array;

/**
 * Class Connect  Объединяет два отсортированных массива втретий, сохраняя сортирвку.
 * @author Shaev Andrey.
 * @version 1.01.
 * @since 29.11.17.
 */

public class Connect {

    public int[] connect(int[] mass1, int[] mass2) {
        int[] result = new int[mass1.length + mass2.length];
        int mass1Count = mass1.length;
        int mass2Count = mass2.length;
        int resultCount = result.length;
        /*
        сравниваем элементы и больший заносим в новый массив. проверяем с конца массивы
        до тех пор, пока один из массивов не кончится.
        */
        while (mass1Count != 0 && mass2Count != 0) {
            if (mass1[mass1Count - 1] > mass2[mass2Count - 1]) {
                result[resultCount - 1] = mass1[mass1Count - 1];
                mass1Count--;
            } else {
                result[resultCount - 1] = mass2[mass2Count - 1];
                mass2Count--;
            }
            resultCount--;
        }
        /* дописываем оставшийся массив в конечный. */
        while (resultCount != 0) {
            if (mass1Count == 0) {
                result[resultCount - 1] = mass2[mass2Count - 1];
                mass2Count--;
            } else {
                result[resultCount - 1] = mass1[mass1Count - 1];
                mass2Count--;
            }
            resultCount--;
        }

        return result;
    }
}
