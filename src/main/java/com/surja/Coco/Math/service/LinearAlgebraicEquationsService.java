package com.surja.Coco.Math.service;

public interface LinearAlgebraicEquationsService {
    public double[] gaussEliminationMethod(double[][] inputMatrix);
    public double[] gaussJordanMethod(double[][] inputMatrix);
    public double[] gaussSeidalIterationMethod(double[][] inputMatrix,double allowedError,int maximumIteration);
    public double[] lUFactorizatonMrthod(double[][] inputMatrix);
}
