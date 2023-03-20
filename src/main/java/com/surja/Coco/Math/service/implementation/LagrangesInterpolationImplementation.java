package com.surja.Coco.Math.service.implementation;

import org.springframework.stereotype.Service;

@Service
public class LagrangesInterpolationImplementation {
    public double interpolationResult(double[] points,double[] values,double valuePoint) {
        double ans = 0;
        int n = points.length;
        for(int i = 0;i<n;i++){
            double temp = 1;
            for(int j = 0;j<n;j++) {
                temp*=(j!=i)?(valuePoint-points[j])/(points[i]-points[j]):1;
            }
            ans+=temp*values[i];
        }
        return ans;
    }
}
