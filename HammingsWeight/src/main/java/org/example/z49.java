package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class z49 {
    static int sumOfDivisors(int n) {
        int result = 0;
        int i = 1;
        for (; i * i <= n; i++) {
            if (n % i == 0) {
                result += n/i;
                result += i;
            }
        }
        if ((i - 1) * (i - 1) == n || i*i == n) {result -= i-1;}

        return result;
    }


    static List<Double> findPn(int n){
        List<Double> Pns = new ArrayList<>(n);
        double var;
        Pns.add(0, 1.0);

        for(int i = 1; i < n; i++){
            var = 0;
            for(int j = 1; j <= i; j++){
                var += sumOfDivisors(j)*Pns.get(i-j);
            }
            Pns.add(i,  var/i);
        }

        return Pns;
    }




    public static void main(String[] args) throws IOException {
        Map<Integer, Double> plot = new HashMap<>();

        List<Double> Pns = findPn(100);
        for( int i = 0; i < 100; i++){
            plot.put(i+1, Pns.get(i));
        }

        System.out.println(Pns);


        Plot divisors = new Plot("Zad49");
        divisors.addDouble(plot, "zad49-Plot");
        divisors.makeAndSave();


    }
}
