package com.aiways.androidut.junit;

public class Caculator {
    public int add(int one, int another) {
        return one + another;
    }

    public int multiply(int one, int another) {
        // 为了简单起见，暂不考虑溢出等情况。
        return one * another;
    }

    public double divide(double divident, double dividor) {
        if (dividor == 0) throw new IllegalArgumentException("Dividor cannot be 0");
        return divident / dividor;
    }
}
