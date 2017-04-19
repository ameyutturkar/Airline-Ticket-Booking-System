package com.myproject.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.myproject.pojo.Flight;

public class FlightValidator implements Validator
{
	public boolean supports(Class aClass)
    {
        return aClass.equals(Flight.class);
    }

    public void validate(Object obj, Errors errors)
    {
        Flight flight = (Flight) obj;
        flight.getFlightName().replaceAll("[^\\dA-Za-z ]","").replaceAll("\\s+","").trim();
        flight.getSource().replaceAll("[^\\dA-Za-z ]","").replaceAll("\\s+","").trim();
        flight.getDestination().replaceAll("[^\\dA-Za-z ]","").replaceAll("\\s+","").trim();
       
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "flightName", "error.invalid.flightName", "Flight Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "source", "error.invalid.source", "Source Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "destination", "error.invalid.destination", "Destination Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "quantity", "error.invalid.quantity", "Quantity Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "startDateTime", "error.invalid.startDateTime", "Start Date Time Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "endDateTime", "error.invalid.endDateTime", "End Date Time Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "error.invalid.price", "Price Required");
    }
}
