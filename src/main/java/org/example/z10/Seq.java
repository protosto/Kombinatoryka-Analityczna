package org.example.z10;

import org.example.z9.Plot;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Seq {

    static String generateString (int n){

        String sequence = "";
        Random x = new Random();
        for(int i = 0; i < n; i++){

            if( x.nextInt(2) == 1) sequence+="a";
            else sequence += "b";

        }

        return sequence;
    }

    static boolean containsAAA(String text){
        for(int i = 0; i < text.length()-2; i++){
            if(text.startsWith("aaa", i)) return true;
        }
        return false;
    }

    static boolean containsABB(String text){
        for(int i = 0; i < text.length()-2; i++){
            if(text.startsWith("abb", i)) return true;
        }
        return false;
    }

    static int nrOfAAA(String text){

        int result = 0;
        for(int i = 0; i < text.length()-2; i++){
            if(text.startsWith("aa", i)) result++;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {

        int sampleSizes = 1000000;
        String text;
        int aaa, abb, nraaa;

        Map<Integer, Double> results = new HashMap<>();
        Map<Integer, Double> results1 = new HashMap<>();
        Map<Integer, Double> results2 = new HashMap<>();

        for(int i = 1; i <= 50; i++){

            aaa = 0;
            abb = 0;
            nraaa = 0;

            for(int j = 0; j < sampleSizes; j++){
                text = generateString(i);
                if(containsAAA(text)) aaa++;
                if(containsABB(text)) abb++;
                nraaa += nrOfAAA(text);
            }

            results.put(i, (double) aaa / sampleSizes);
            results1.put(i, (double) abb / sampleSizes);
            results2.put(i, (double) nraaa / sampleSizes);

        }

        Plot aaaabb = new Plot("Zad10.ab");
        aaaabb.add(results, "Probability of aaa");
        aaaabb.add(results1, "Probability of abb");
        Plot nrofaaa = new Plot("Zad10.c");
        nrofaaa.add(results2, "Number of aaa");

        aaaabb.makeAndSave();
        nrofaaa.makeAndSave();

    }

}
