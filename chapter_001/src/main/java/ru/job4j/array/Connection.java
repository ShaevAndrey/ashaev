package ru.job4j.array;

public class Connection {

    public int[] connection(int[] mass1, int[] mass2) {
        int[] result = new int[mass1.length + mass2.length];
        int mass1Length = 0;
        int  mass1Index = 0;
        int mass2Length = 0;
        int  mass2Index = 0;
        for (int i = 0; i < result.length; i++) {
            if (mass1[mass1Index] <= mass2[mass2Index] && mass1Length < mass1.length) {
                result[i] = mass1[mass1Index];
                mass1Length++;
                if (mass1Length != mass1.length) {
                    mass1Index++;
                }
            } else if (mass2Length < mass2.length) {
                result[i] = mass2[mass2Index];
                mass2Length++;
                if (mass2Length != mass2.length) {
                    mass2Index++;
                }
            }
        }
        return result;
    }
}
