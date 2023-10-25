package org.example.z9;

import java.io.IOException;
import java.util.*;


public class FisherYates {
    static int[] fishYat(int n) {

        int[] tab = new int[n];

        for (int i = 0; i < n; i++) {
            tab[i] = i + 1;
        }

        Random x = new Random();

        for (int i = n - 1; i > 0; i--) {

            int j = x.nextInt(i + 1);

            int temp = tab[i];
            tab[i] = tab[j];
            tab[j] = temp;
        }
        return tab;
    }

    static boolean noFixedPoint(int[] tab) {

        for (int i = 0; i < tab.length; i++) {
            if (tab[i] == i + 1) return false;
        }
        return true;
    }

    static boolean oneFixedPoint(int[] tab) {

        int x = 0;
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] == i + 1) x++;
            if (x > 1) return false;
        }

        return x != 0;
    }

    static int nrOfCycles(int[] tab) {

        Set<Integer> visited = new HashSet<>();
        int cycles = 0;

        for (int i = 0; i < tab.length; i++) {
            visited.add(i);
        }


        while (!visited.isEmpty()) {
            int next = visited.iterator().next();
            int x = next;
            do {
                visited.remove(x);
                x = tab[x] - 1;
            } while (x != next);
            cycles++;
        }

        return cycles;
    }

    public static void main(String[] args) throws IOException {

        int maxN = 1000;
        int sampleSizes = 10000;
        int no, one, cycles;

        Map<Integer, Double> results = new HashMap<>();
        Map<Integer, Double> results1 = new HashMap<>();
        Map<Integer, Double> results2 = new HashMap<>();


        for (int n = 1; n <= maxN; n++) {
            no = 0;
            one = 0;
            cycles = 0;
            for (int i = 0; i < sampleSizes; i++) {

                int[] tab = fishYat(n);

                if (noFixedPoint(tab)) no++;
                if (oneFixedPoint(tab)) one++;
                cycles += nrOfCycles(tab);

            }

            results.put(n, (double) no / sampleSizes);
            results1.put(n, (double) one / sampleSizes);
            results2.put(n, (double) cycles / sampleSizes);

            if(n%(maxN/100) == 0) System.out.println((int)((float)n/maxN*100) + "%");
        }

        Plot nooneFixed = new Plot("Zad9.ab");
        nooneFixed.add(results, "No fixed");
        nooneFixed.add(results1, "One fixed");
        Plot cycle = new Plot("Zad9.c");
        cycle.add(results2, "Number of cycles");

        nooneFixed.makeAndSave();
        cycle.makeAndSave();

    }
}