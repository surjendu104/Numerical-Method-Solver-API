package com.surja.Coco.Math.controller;

import com.surja.Coco.Math.entity.Interpolation;
import com.surja.Coco.Math.payload.InterpolationDto;
import com.surja.Coco.Math.service.implementation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/interpolation")
public class InterpolationController {
    @Autowired
    NewtonForwardImplementation newtonForwardImplementation;
    @Autowired
    NewtonBackwardImplementation newtonBackwardImplementation;
    @Autowired
    GaussForwardImplementation gaussForwardImplementation;
    @Autowired
    GaussBackwardImplementation gaussBackwardImplementation;
    @Autowired
    NewtonsDividedDifferenceImplementation newtonsDividedDifferenceImplementation;
    @Autowired
    LagrangesInterpolationImplementation lagrangesInterpolationImplementation;
    // Newton forward
    @PostMapping("/newtonForwardInterpolation")
    public ResponseEntity<InterpolationDto> newtonFrowardInterpolation(@RequestBody Interpolation interpolation) {
        double[] points = interpolation.getPoints();
        double[] values = interpolation.getValues();
        double valuePoint = interpolation.getValuePoint();
        InterpolationDto newInterpolation = new InterpolationDto();
        double[][] table = this.newtonForwardImplementation.init(points,values,valuePoint);
        double u = this.newtonForwardImplementation.findU(points,valuePoint);
        double resultPoint = this.newtonForwardImplementation.interpolationResult(table,u);

        newInterpolation.setPoints(points);
        newInterpolation.setValues(values);
        newInterpolation.setValuePoint(valuePoint);
        newInterpolation.setTable(table);
        newInterpolation.setInterpolationResult(resultPoint);

        return new ResponseEntity<InterpolationDto>(newInterpolation, HttpStatus.OK);
    }

    // Newton backward
    @PostMapping("/newtonBackwardInterpolation")
    public ResponseEntity<InterpolationDto> newtonBackwardInterpolation(@RequestBody Interpolation interpolation) {
        double[] points = interpolation.getPoints();
        double[] values = interpolation.getValues();
        double valuePoint = interpolation.getValuePoint();
        InterpolationDto newInterpolation = new InterpolationDto();
        double[][] table = this.newtonBackwardImplementation.init(points,values,valuePoint);
        double u = this.newtonBackwardImplementation.findU(points,valuePoint);
        double resultPoint = this.newtonBackwardImplementation.interpolationResult(table,u);

        newInterpolation.setPoints(points);
        newInterpolation.setValues(values);
        newInterpolation.setValuePoint(valuePoint);
        newInterpolation.setTable(table);
        newInterpolation.setInterpolationResult(resultPoint);

        return new ResponseEntity<InterpolationDto>(newInterpolation, HttpStatus.OK);
    }

    // Gauss forward
    @PostMapping("/gaussForwardInterpolation")
    public ResponseEntity<InterpolationDto> gaussForwardInterpolation(@RequestBody Interpolation interpolation) {
        double[] points = interpolation.getPoints();
        double[] values = interpolation.getValues();
        double valuePoint = interpolation.getValuePoint();
        InterpolationDto newInterpolation = new InterpolationDto();
        double[][] table = this.gaussForwardImplementation.init(points,values,valuePoint);
        double u = this.gaussForwardImplementation.findU(points,valuePoint);
        double resultPoint = this.gaussForwardImplementation.interpolationResult(table,u);

        newInterpolation.setPoints(points);
        newInterpolation.setValues(values);
        newInterpolation.setValuePoint(valuePoint);
        newInterpolation.setTable(table);
        newInterpolation.setInterpolationResult(resultPoint);

        return new ResponseEntity<InterpolationDto>(newInterpolation, HttpStatus.OK);
    }

    // Gauss backward
    @PostMapping("/gaussBackwardInterpolation")
    public ResponseEntity<InterpolationDto> gaussBackwardInterpolation(@RequestBody Interpolation interpolation) {
        double[] points = interpolation.getPoints();
        double[] values = interpolation.getValues();
        double valuePoint = interpolation.getValuePoint();
        InterpolationDto newInterpolation = new InterpolationDto();
        double[][] table = this.gaussBackwardImplementation.init(points,values,valuePoint);
        double u = this.gaussBackwardImplementation.findU(points,valuePoint);
        double resultPoint = this.gaussBackwardImplementation.interpolationResult(table,u);

        newInterpolation.setPoints(points);
        newInterpolation.setValues(values);
        newInterpolation.setValuePoint(valuePoint);
        newInterpolation.setTable(table);
        newInterpolation.setInterpolationResult(resultPoint);

        return new ResponseEntity<InterpolationDto>(newInterpolation, HttpStatus.OK);
    }

    // Stirling's interpolation
    /*
    * As stirling's interpolation is the average of gauss backward and forward interpolation
    * so we have just taken the average of those two
    * */
    @PostMapping("/stirlingInterpolation")
    public ResponseEntity<InterpolationDto> stirlingInterpolation(@RequestBody Interpolation interpolation) {
        double[] points = interpolation.getPoints();
        double[] values = interpolation.getValues();
        double valuePoint = interpolation.getValuePoint();
        InterpolationDto newInterpolation = new InterpolationDto();
        double[][] table = this.gaussBackwardImplementation.init(points,values,valuePoint);
        double u = this.gaussBackwardImplementation.findU(points,valuePoint);
        double resultPoint = (this.gaussBackwardImplementation.interpolationResult(table,u)+this.gaussForwardImplementation.interpolationResult(table,u))/2;

        newInterpolation.setPoints(points);
        newInterpolation.setValues(values);
        newInterpolation.setValuePoint(valuePoint);
        newInterpolation.setTable(table);
        newInterpolation.setInterpolationResult(resultPoint);

        return new ResponseEntity<InterpolationDto>(newInterpolation, HttpStatus.OK);
    }

    // Newton's divided difference interpolation method
    @PostMapping("/newtonsDividedDifference")
    public ResponseEntity<InterpolationDto> newtonsDividedDifference(@RequestBody Interpolation interpolation) {
        double[] points = interpolation.getPoints();
        double[] values = interpolation.getValues();
        double valuePoint = interpolation.getValuePoint();
        double[][] table = this.newtonsDividedDifferenceImplementation.init(points,values,valuePoint);
        double resultPoint = this.newtonsDividedDifferenceImplementation.interpolationResult(table,valuePoint,points);
        InterpolationDto newInterpolation = new InterpolationDto();

        newInterpolation.setPoints(points);
        newInterpolation.setValues(values);
        newInterpolation.setTable(table);
        newInterpolation.setValuePoint(valuePoint);
        newInterpolation.setInterpolationResult(resultPoint);

        return new ResponseEntity<InterpolationDto>(newInterpolation, HttpStatus.OK);
    }

    // Lagranges interpolation
    @PostMapping("/lagrangesInterpolation")
    public ResponseEntity<InterpolationDto> lagrangesInterpolation(@RequestBody Interpolation interpolation) {
        double[] points = interpolation.getPoints();
        double[] values = interpolation.getValues();
        double valuePoint = interpolation.getValuePoint();
        double resultPoint = this.lagrangesInterpolationImplementation.interpolationResult(points,values,valuePoint);
        InterpolationDto newInterpolation = new InterpolationDto();

        newInterpolation.setPoints(points);
        newInterpolation.setValues(values);
        newInterpolation.setValuePoint(valuePoint);
        newInterpolation.setInterpolationResult(resultPoint);

        return new ResponseEntity<InterpolationDto>(newInterpolation, HttpStatus.OK);
    }
}
