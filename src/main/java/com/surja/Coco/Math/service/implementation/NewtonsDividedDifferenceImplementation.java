package com.surja.Coco.Math.service.implementation;

import com.surja.Coco.Math.service.EqualIntervalInterpolationService;
import com.surja.Coco.Math.service.UnequalIntervalService;
import org.springframework.stereotype.Service;

@Service
public class NewtonsDividedDifferenceImplementation implements UnequalIntervalService {
    @Override
    public double interpolationResult(double[][] table,double valuePoint,double[] points) {
        double ans = 0.0;
        for(int i = 0;i<table[0].length;i++) {
            double temp = 1;
            for(int j = 0;j<i;j++)temp*=(valuePoint-points[j]);
            ans+=temp*table[i][i];
        }
        return ans;
    }

    @Override
    public double[][] init(double[] points, double[] values, double valuePoint) {
        int n = values.length;
        int k = 0;
        double[][] table = new double[2 * n - 1][n];
        double[] newPoints = new double[2*n-1];
        for (int i = 0;i<2*n-1;i+=2) {
            newPoints[i] = points[k++];
        }
        k = 0;
        for (int i = 0; i < 2 * n - 1; i += 2) {
            table[i][0] = values[k++];
        }
        for (int j = 1; j < n; j++) {
            int l = 0,r = 2*j;
            for (int i = j; i < 2 * n - 1 - j; i+=2) {
                table[i][j] = (table[i + 1][j - 1] - table[i - 1][j - 1])/(newPoints[r]-newPoints[l]);
                l+=2;r+=2;
            }
        }
        return table;
    }
}
