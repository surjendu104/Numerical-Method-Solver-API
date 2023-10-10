package com.surja.Coco.Math.service;

public interface AlgebraicAndTranscendentalEquationService {
    public double[] calculateRootInBisectionMethod(String equation,double a,double b,double n, double[][] table);
    public double[] calculateRootInNewtonRaphsonMethod(String equation,double a,double n, double[][] table);
    public double[] calculateRootInRegulaFalsiMethod(String equation,double a,double b,double n, double[][] table);
}
