package com.surja.Coco.Math.payload;

import lombok.Data;

@Data
public class AlgebraicFunctionsDto {
    String equation;
    double lowerLimit;
    double upperLimit;
    int numberOfIteration;
    double functionValue;
    double calculatedRoot;
}
