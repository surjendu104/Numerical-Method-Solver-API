package com.surja.Coco.Math.payload;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AlgebraicFunctionsDto {
    String equation;
    double lowerLimit;
    double upperLimit;
    int numberOfIteration;
    double functionValue;
    double calculatedRoot;
    double[][] table;
}
