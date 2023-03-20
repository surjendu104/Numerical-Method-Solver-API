package com.surja.Coco.Math.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class InterpolationDto {
    private double[] points;
    private double[] values;
    private double valuePoint;
    private double[][] table;
    private double interpolationResult;
}
