package com.surja.Coco.Math.service;

public interface SolutionOfODEService {
    double[][] eulersMethod(String equation,double valueOfX,double valueOfY,double height, int partitions,double valuePoint);
    double[][] eulersModifiedMethod(String equation,double valueOfX,double valueOfY,double height, int partitions,double valuePoint);
}
