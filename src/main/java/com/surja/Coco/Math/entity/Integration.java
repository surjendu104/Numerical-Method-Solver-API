package com.surja.Coco.Math.entity;

import lombok.Data;

@Data
public class Integration {
    String expression;
    double lowerBound;
    double upperBound;
    double partitionNumber;
}
