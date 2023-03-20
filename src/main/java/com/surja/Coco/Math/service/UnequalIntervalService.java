package com.surja.Coco.Math.service;

public interface UnequalIntervalService {
    double interpolationResult(double[][] table,double valuePoint,double[] points);
    double[][] init(double[] points, double[] values, double valuePoint);
}
