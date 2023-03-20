package com.surja.Coco.Math.payload;

import lombok.Data;

@Data
public class IntegrationDto {
    String expression;
    double lowerBound;
    double upperBound;
    double partitionNumber;
    double result;
}
