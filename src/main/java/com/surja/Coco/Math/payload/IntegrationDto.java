package com.surja.Coco.Math.payload;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class IntegrationDto {
    private String expression;
    private double lowerBound;
    private double upperBound;
    private double partitionNumber;
    private double result;
    private double[][] table;
}
