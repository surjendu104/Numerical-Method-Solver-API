package com.surja.Coco.Math.controller;

import com.surja.Coco.Math.entity.ODE;
import com.surja.Coco.Math.payload.ODEDto;
import com.surja.Coco.Math.service.implementation.SolutionOfODEImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/solutionOfODE")
public class SolutionOfODEController {
    @Autowired
    SolutionOfODEImplementation solutionOfODEImplementation;

    @PostMapping("/eulersMethod")
    public ResponseEntity<ODEDto> eulersMethodController(@RequestBody ODE ode) {
        String equation = ode.getEquation();
        double x = ode.getValueOfX();
        double y = ode.getValueOfY();
        double p = ode.getValuePoint();
        double h = ode.getHeight();
        double[][] result = this.solutionOfODEImplementation.eulersMethod(equation,x,y,h,p);

        ODEDto newResponse = new ODEDto();
        newResponse.setEquation(equation);
        newResponse.setValueOfX(x);
        newResponse.setValueOfY(y);
        newResponse.setHeight(h);
        newResponse.setValuePoint(p);
        newResponse.setResult(result);
        newResponse.setResultAtPoint(result[result.length-1][1]);

        return new ResponseEntity<>(newResponse, HttpStatus.OK);
    }

    @PostMapping("/eulersModifiedMethod")
    public ResponseEntity<ODEDto> eulersModifiedMethodController(@RequestBody ODE ode) {
        String equation = ode.getEquation();
        double x = ode.getValueOfX();
        double y = ode.getValueOfY();
        double p = ode.getValuePoint();
        double h = ode.getHeight();
        double[][] result = this.solutionOfODEImplementation.eulersModifiedMethod(equation,x,y,h,p);

        ODEDto newResponse = new ODEDto();
        newResponse.setEquation(equation);
        newResponse.setValueOfX(x);
        newResponse.setValueOfY(y);
        newResponse.setHeight(h);
        newResponse.setValuePoint(p);
        newResponse.setResult(result);
        newResponse.setResultAtPoint(result[result.length - 1][1]);

        return new ResponseEntity<>(newResponse, HttpStatus.OK);
    }
}
