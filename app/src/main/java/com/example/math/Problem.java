package com.example.math;

public class Problem {
    private int result;

    public int getRandom(int min, int max) {
        return (int) (Math.random() * (max - min)) + min;
    }

    public int getResult() {
        return result;
    }

    public String getProblem() {
        int a = getRandom(-100, 100);
        int b = getRandom(-100, 100);
        String sign = getRandomSign();
        if (sign.equals("+")) result = a + b;
        if (sign.equals("-")) result = a - b;
        if (sign.equals("*")) result = a * b;
        if (sign.equals("/")) {
            if (a / b == 0 || a % b > 0) {
                a = LCM(a,b);
                result = a / b;
            }
        }
        return String.valueOf(a + " " + sign + " " + b);
    }

    public int getNoiseResult() {
        int c = getRandom(-10, 10);
        while (c == 0) {
            c = getRandom(-10, 10);
        }
        return result + c;

    }

    private String getRandomSign() {
        int sign = getRandom(1, 5);
        if (sign == 1) return "+";
        if (sign == 2) return "-";
        if (sign == 3) return "*";
        else return "/";
    }

    public String getScore(int a, int b) {
        return String.valueOf(a + "/" + b);
    }
    public int GCD(int a,int b){

            while (a != b) {
                if (a > b) {
                    a = a - b;
                } else {
                    b = b - a;
                }
            }
            return a;
    }
    public int LCM(int a,int b){
            return a*b / GCD(a, b);

    }
}
