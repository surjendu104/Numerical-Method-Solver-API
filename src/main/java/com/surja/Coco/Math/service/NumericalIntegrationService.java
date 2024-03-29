package com.surja.Coco.Math.service;


public interface NumericalIntegrationService {
    double trapezoidalRule(double a, double b, double n, String expr, double[][] table);
    double simpsons_one_third_rule(double a,double b,double n,String expr, double[][] table);
    double simpsons_three_eight_rule(double a,double b,double n,String expr, double[][] table);
    double boolesRule(double a,double b,double n,String expr, double[][] table);
}
