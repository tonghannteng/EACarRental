package mum.cs544.project.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mum.cs544.project.service.ReservationService;



@RestController
public class ReservationController {
	@Autowired
	ReservationService reservationService;

	@RequestMapping(value = "/reserveRequest", method = RequestMethod.GET)
	public String createEmployee(@RequestParam(value = "fromLocation", defaultValue = "") String fromLocation,
			@RequestParam(value = "toLocation", defaultValue = "") String toLocation,
			@RequestParam(value = "fromDate", defaultValue = "") String fromDate,
			@RequestParam(value = "toDate", defaultValue = "") String toDate,
			@RequestParam(value = "carId", defaultValue = "") String carId) {

		Date fromDateFormat, toDateFormat;
		SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-DD");
		try {
			fromDateFormat = formatter.parse(fromDate);
			toDateFormat = formatter.parse(toDate);
			return reservationService.reserve(carId, fromLocation, toLocation, fromDateFormat, toDateFormat);
		} catch (Exception E) {
			System.out.println(E.getMessage());
		}
		return "Error in your input";
	}
}
