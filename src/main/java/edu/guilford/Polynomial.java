package edu.guilford;

import java.util.Random;
import java.util.ArrayList;

public class Polynomial implements Comparable<Polynomial> {
    private ArrayList coefficients = new ArrayList<Float>();
    private int degree = -1;

    public Polynomial() {
        this.degree = 10;
        for (int i = 0; i < 10; i++) {
            coefficients.add(0.0f);
        }
    }

    public Polynomial(double[] coefficients) {
        this.degree = coefficients.length-1;
        for (int i = 0; i <= this.degree; i++) {
            this.coefficients.add((float) (coefficients[i]));
        }
    }

    public Polynomial(int degree) {
        this.degree = degree;
        Random rand = new Random();

        for (int i = 0; i <= degree; i++) {
            coefficients.add(rand.nextFloat(-15,15));
        }
    }

    // getters and setters
    public ArrayList getCoefficients() {
        return this.coefficients;
    }
    public int getDegree() {
        return this.degree;
    }
    public float getCoefficient(int index) {
        return (float) this.coefficients.get(index);
    }

    public void setCoefficient(int k, float value) {
        if (k <= degree) {
            this.coefficients.set(k, value);
        }
        else {
            for (int i = this.coefficients.size(); i < k; i++) {
                this.coefficients.add(0.0f);
            }
            this.coefficients.add(value);
        }
    }
    public void setCoefficients(ArrayList coefficients) {
        this.coefficients = coefficients;
        this.degree = coefficients.size()-1;
    }

    public float evaluate(float x) {
        float result = 0.0f;
        for (int i = this.degree; i >= 0; i--) {
            result += this.getCoefficient(this.degree-i) * Math.pow(x, i);
        }
        return result;
    }

    public void clear() {
        this.coefficients.clear();
        this.degree = 0;
    }

    public Polynomial add(Polynomial p) {
        Polynomial greaterPolynomial;
        Polynomial lesserPolynomial;
        if (this.degree > p.getDegree()) {
            greaterPolynomial = this;
            lesserPolynomial = p;
        }
        else {
            greaterPolynomial = p;
            lesserPolynomial = this;
        }

        int degreeDifference = greaterPolynomial.getDegree() - lesserPolynomial.getDegree();
        int newDegree = Math.max(this.degree, p.getDegree());

        Polynomial result = new Polynomial(newDegree);

        for (int i = 0; i < degreeDifference; i++) {
            result.setCoefficient(i, greaterPolynomial.getCoefficient(i));
        }
        for (int i = degreeDifference; i <= newDegree; i++) {
            result.setCoefficient(i, greaterPolynomial.getCoefficient(i) + lesserPolynomial.getCoefficient(i-degreeDifference));
        }
        return result;
    }

    public Polynomial subtract(Polynomial p) {
        // convert p to a negative polynomial
        Polynomial negativeP = new Polynomial(p.getDegree());
        for (int i = 0; i <= p.getDegree(); i++) {
            negativeP.setCoefficient(i, -1 * p.getCoefficient(i));
        }
        return this.add(negativeP);
    }

    // toString method
    public String toString() {
        if (this.degree == 0) {
            return 0.0f + "";
        }
        String result = "";
        for (int i = this.degree; i >= 0; i--) {
            result += this.getCoefficient(this.degree-i) + "x^" + (i);
            if (i > 0) {
                result += " + ";
            }
        }
        return result;
    }

    public int compareTo(Polynomial p) {
        if (this.degree > p.getDegree()) {
            return 1;
        }
        else if (this.degree < p.getDegree()) {
            return -1;
        }
        else {
            if (this.evaluate(1.0f) > p.evaluate(1.0f)) {
                return 1;
            }
            else if (this.evaluate(1.0f) < p.evaluate(1.0f)) {
                return -1;
            }
            else {
                if (this.evaluate(-1.0f) > p.evaluate(-1.0f)) {
                    return 1;
                }
                else if (this.evaluate(-1.0f) < p.evaluate(-1.0f)) {
                    return -1;
                }
                else {
                    return 0;
                }
            }
        }
    }

}
