package org.example.z32;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class InverseFormalSeries {

    static double func1 (int n){
        return 1.0;
    }

    static double func2 (int n){
        return Math.pow(2, n);
    }

    static double func3 (int n){

        if(n < 2) return 1;

        int result = 1;

        while(n > 1){
           result *= n;
           n--;
        }

        return result;
    }

    static double func4 (int n){
        return 1.0/func3(n);
    }

    static List<Double> inverses(int n, Function<Integer, Double> function){

        List<Double> coefficients = new ArrayList<>();

        double x, y;
        coefficients.add(1.0/function.apply(0));

        for(int i = 1; i <= n; i++){
            y = 0;

            for( int k = 1; k <= i; k++){
                y += function.apply(k)*coefficients.get(i-k);
            }

            x = -1.0*coefficients.get(0)*y;
            coefficients.add(x);
        }

        return coefficients;
    }

    public static void main(String[] args) {

        List<Double> f1 = inverses(10, InverseFormalSeries::func1);
        List<Double> f2 = inverses(10, InverseFormalSeries::func2);
        List<Double> f3 = inverses(10, InverseFormalSeries::func3);
        List<Double> f4 = inverses(10, InverseFormalSeries::func4);

        System.out.println(f1);
        System.out.println(f2);
        System.out.println(f3);
        System.out.println(f4);

    }

}
