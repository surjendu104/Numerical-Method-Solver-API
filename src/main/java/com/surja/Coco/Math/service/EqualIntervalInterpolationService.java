package com.surja.Coco.Math.service;

public interface EqualIntervalInterpolationService {
    double interpolationResult(double[][] table, double u);
    double[][] init(double[] points,double[] values,double valuePoint);
    double calculateU(double u,int n);
    double findU(double[] points,double valuePoint);
}
