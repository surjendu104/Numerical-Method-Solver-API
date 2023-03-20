package com.surja.Coco.Math.controller;

import com.surja.Coco.Math.entity.AlgebraicAndTranscendentalEqations;
import com.surja.Coco.Math.payload.AlgebraicFunctionsDto;
import com.surja.Coco.Math.service.implementation.AlgebraicAndTranscendentalEquationImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/algebraicAndTranscendentalEquation")
public class AlgebraicAndTranscendentalEquationController {
    @Autowired
    AlgebraicAndTranscendentalEquationImplementation algebraicAndTranscendentalEquationImplementation;

    @PostMapping("/bisectionMethod")
    public ResponseEntity<AlgebraicFunctionsDto> findRootByBisectionMethod(@RequestBody AlgebraicAndTranscendentalEqations algebraicAndTranscendentalEqations) {
        String equation = algebraicAndTranscendentalEqations.getEquation();
        double a = algebraicAndTranscendentalEqations.getLowerLimit();
        double b = algebraicAndTranscendentalEqations.getUpperLimit();
        int n = algebraicAndTranscendentalEqations.getNumberOfIteration();
        double[] root = this.algebraicAndTranscendentalEquationImplementation.calculateRootInBisectionMethod(equation,a,b,n);

        AlgebraicFunctionsDto newResponse = new AlgebraicFunctionsDto();
        newResponse.setFunctionValue(root[0]);
        newResponse.setCalculatedRoot(root[1]);
        newResponse.setEquation(equation);
        newResponse.setLowerLimit(a);
        newResponse.setUpperLimit(b);
        newResponse.setNumberOfIteration(n);

        return new ResponseEntity<>(newResponse, HttpStatus.OK);
    }

    @PostMapping("/newtonRaphsonMethod")
    public ResponseEntity<AlgebraicFunctionsDto> findRootByNewtonRaphsonMethod(@RequestBody AlgebraicAndTranscendentalEqations algebraicAndTranscendentalEqations) {
        String equation = algebraicAndTranscendentalEqations.getEquation();
        double a = algebraicAndTranscendentalEqations.getLowerLimit();
        double b = algebraicAndTranscendentalEqations.getUpperLimit();
        int n = algebraicAndTranscendentalEqations.getNumberOfIteration();
        double[] root = this.algebraicAndTranscendentalEquationImplementation.calculateRootInNewtonRaphsonMethod(equation,a,n);

        AlgebraicFunctionsDto newResponse = new AlgebraicFunctionsDto();
        newResponse.setFunctionValue(root[0]);
        newResponse.setCalculatedRoot(root[1]);
        newResponse.setEquation(equation);
        newResponse.setLowerLimit(a);
        newResponse.setNumberOfIteration(n);

        return new ResponseEntity<>(newResponse, HttpStatus.OK);
    }

    @PostMapping("/regulaFalsiMethod")
    public ResponseEntity<AlgebraicFunctionsDto> findRootByRegulaFalsiMethod(@RequestBody AlgebraicAndTranscendentalEqations algebraicAndTranscendentalEqations) {
        String equation = algebraicAndTranscendentalEqations.getEquation();
        double a = algebraicAndTranscendentalEqations.getLowerLimit();
        double b = algebraicAndTranscendentalEqations.getUpperLimit();
        int n = algebraicAndTranscendentalEqations.getNumberOfIteration();
        double[] root = this.algebraicAndTranscendentalEquationImplementation.calculateRootInRegulaFalsiMethod(equation,a,b,n);

        AlgebraicFunctionsDto newResponse = new AlgebraicFunctionsDto();
        newResponse.setFunctionValue(root[0]);
        newResponse.setCalculatedRoot(root[1]);
        newResponse.setEquation(equation);
        newResponse.setLowerLimit(a);
        newResponse.setUpperLimit(b);
        newResponse.setNumberOfIteration(n);

        return new ResponseEntity<>(newResponse, HttpStatus.OK);
    }
}
