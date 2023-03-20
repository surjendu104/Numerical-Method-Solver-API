package com.surja.Coco.Math.service.implementation;

import com.surja.Coco.Math.service.EqualIntervalInterpolationService;
import org.springframework.stereotype.Service;

@Service
public class NewtonBackwardImplementation implements EqualIntervalInterpolationService {

    @Override
    public double interpolationResult(double[][] table, double u) {
        double ans = 0.0;
        int i = table.length-1;
        int j = 0;

        while (j<table[0].length) {
            ans += calculateU(u, j) * table[i][j] / factorial(j);
            i--;j++;
        }
        return ans;
    }

    @Override
    public double[][] init(double[] points, double[] values, double valuePoint) {
        int n = values.length;
        double[][] table = new double[2 * n - 1][n];
        int k = 0;
        for (int i = 0; i < 2 * n - 1; i += 2) {
            table[i][0] = values[k++];
        }
        for (int j = 1; j < n; j++) {
            for (int i = j; i < 2 * n - 1 - j; i++) {
                table[i][j] = table[i + 1][j - 1] - table[i - 1][j - 1];
            }
        }
        return table;
    }

    @Override
    public double calculateU(double u, int n) {
        if (n == 0)
            return 1;
        double finalValue = 1;
        for (int i = 0; i < n; i++) {
            finalValue *= (u + i);
        }
        return finalValue;
    }

    @Override
    public double findU(double[] points, double valuePoint) {
        return (valuePoint-points[points.length-1])/(points[1]-points[0]);
    }

    public static long factorial(long n) {
        if (n == 0 || n == 1)
            return 1;
        return n * factorial(n - 1);
    }
}
