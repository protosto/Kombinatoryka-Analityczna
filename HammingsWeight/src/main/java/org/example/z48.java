package org.example;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class z48 {

    static int hammingWeight(int n){
        int result = 0;
        while(n > 1){
            result += n%2;
            n /= 2;
        }
        return result+n;
    }

    static Map<Integer, Integer> sumOfHammingsWeights(int n){
        Map<Integer, Integer> results = new HashMap<>();
        results.put(0, 0);
        for(int i = 1; i <= n; i++){
            results.put(i, hammingWeight(i)+results.get(i-1));
        }
        return results;
    }

    public static void main(String[] args) throws IOException {

        Map<Integer, Integer> plot = sumOfHammingsWeights(1024);
        Map<Integer, Double> plotB = new HashMap<>();

        plotB.put(0,0.0);
        for( int i = 1; i <= 20; i++){
            plotB.put(i, (hammingWeight(i)+plotB.get(i-1)));
        }

        for(int i = 0; i <= 20; i++){

        }


        Plot Hamming = new Plot("Zad48.a");
        Hamming.add(plot, "Hamming");
        Hamming.makeAndSave();

        Plot Hammingb = new Plot("Zad48.b");
        Hammingb.addDouble(plotB, "Hamming-asymp");
        Hamming.makeAndSave();
        Hammingb.makeAndSave();
    }
}