package org.example.z66;

import static org.example.z9.FisherYates.fishYat;

public class z66 {

    public static float avgFixedPoints(int n, int tests){
        int[] results;
        int result = 0;

        for( int i = 0; i < tests; i++) {
            results = fishYat(n);
            result += howManyFixedPoints(results);
        }
        return (float)result/(float)tests;
    }

    public static int howManyFixedPoints( int[] tab ){
        int result = 0;
        for( int i = 1; i < tab.length; i++ ){
            if(tab[i] == i) result++;
        }

        return result;
    }

    public static void main(String[] args) {


        for( int i = 0; i < 1000; i ++ ){
            System.out.println(avgFixedPoints(i, 10000));
        }
    }
}
