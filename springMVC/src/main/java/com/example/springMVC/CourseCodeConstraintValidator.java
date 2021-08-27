package com.example.springMVC;

import com.example.springMVC.annotations.CourseCode;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator <CourseCode,String> {
    private String coursePreFix;
    @Override
    public void initialize(CourseCode theCourseCode) {
        coursePreFix=theCourseCode.value();
    }

    @Override
    public boolean isValid(String theCode, ConstraintValidatorContext theConstraintValidatorContext) {
        boolean result;
        if(theCode!= null)
               result= theCode.startsWith(coursePreFix);
        else{
            result=true;
        }
        return result;
    }
}
