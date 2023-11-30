package org.example;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class z65 {

    static int factorial(int n){

        if(n < 2) return 1;

        int result = 2;
        for(int i = 3; i<= n; i++){
            result *= i;
        }
        return result;
    }

    static List<Double> an(int n){
        List<Double> ans = new ArrayList<>(n);

        ans.add(0, 1.0);

        for(int i = 1; i <= n; i++){
            ans.add(i, ans.get(i-1)*i*i+1);
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {

        Map<Integer, Double> plot = new HashMap<>();

        List<Double> ans = an(7);
        for( int i = 0; i < 7; i++){
            plot.put(i+1, ans.get(i+1)/(factorial(i+1)*factorial(i+1)));
            System.out.println(ans.get(i+1)/(factorial(i+1)*factorial(i+1)));
        }

        System.out.println(ans);


        Plot divisors = new Plot("Zad65");
        divisors.addDouble(plot, "zad65-Plot");
        divisors.makeAndSave();



    }

}
