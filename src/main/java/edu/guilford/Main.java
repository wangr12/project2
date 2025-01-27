package edu.guilford;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        double[] coeff1 = {1.0, 2.5, 3.3, 4.6}; 
        Polynomial p1 = new Polynomial(coeff1);
        double[] coeff2 = {4.1, 5.6, 6.8}; 
        Polynomial p2 = new Polynomial(coeff2);
        System.out.println("Testing getters and setters");

        // use getters and setters to test the Polynomial class
        System.out.println("Polynomial 1: " + p1.toString());
        System.out.println("Polynomial 1 degree: " + p1.getDegree());
        System.out.println("Polynomial 1 coefficients: " + p1.getCoefficients());
        System.out.println("Polynomial 1 coefficient 2: " + p1.getCoefficient(2));
        p1.setCoefficient(2, 3.0f);
        System.out.println("Polynomial 1 coefficient 2: " + p1.getCoefficient(2));
        p1.clear();
        System.out.println("Polynomial 1 after clearing: " + p1.toString());
        ArrayList<Float> newCoefficients = new ArrayList<Float>();
        newCoefficients.add(1.0f);
        newCoefficients.add(2.5f);
        newCoefficients.add(3.3f);
        newCoefficients.add(4.6f);
        p1.setCoefficients(newCoefficients);
        System.out.println("Polynomial 1 coefficients: " + p1.getCoefficients());

        System.out.println("Testing addition of polynomials");
        System.out.println("Polynomial 1: " + p1.toString());
        System.out.println("Polynomial 2: " + p2.toString());
        Polynomial p3 = p1.add(p2);
        System.out.println("Addition result: " + p3.toString());
        System.out.println("Comparison result: " + p1.compareTo(p2));

        System.out.println("Testing subtraction of polynomials");
        System.out.println("Polynomial 1: " + p1.toString());
        System.out.println("Polynomial 2: " + p2.toString());
        Polynomial p4 = p1.subtract(p2);
        System.out.println("Subtraction result: " + p4.toString());

        System.out.println("Testing evaluation of polynomials");
        System.out.println("Polynomial 1: " + p1.toString());
        System.out.println("Polynomial 1 evaluated at 2.0: " + p1.evaluate(2.0f));

        Polynomial[] polynomialArray = new Polynomial[5];
        for (int i = 0; i < 5; i++) {
            polynomialArray[i] = new Polynomial(5);
        }
        System.out.println("Unsorted polynomials: ");
        for (int i = 0; i < 5; i++) {
            System.out.println(polynomialArray[i].toString());
        }
        Arrays.sort(polynomialArray);
        System.out.println("Sorted polynomials: ");
        for (int i = 0; i < 5; i++) {
            System.out.println(polynomialArray[i].toString());
        }

    }
}