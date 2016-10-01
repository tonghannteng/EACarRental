package mum.cs544.project.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mum.cs544.project.service.CarSearchService;



@RestController
public class SearchController {
	@Autowired
	CarSearchService carSearchService;

	private static final Logger logger = LoggerFactory.getLogger(SearchController.class);
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String createEmployee(@RequestParam(value = "fromLocation", defaultValue = "") String fromLocation,
			@RequestParam(value = "toLocation", defaultValue = "") String toLocation,
			@RequestParam(value = "fromDate", defaultValue = "") String fromDate,
			@RequestParam(value = "toDate", defaultValue = "") String toDate) {
		Date fromDateFormat, toDateFormat;
		SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-DD");
		try {
			fromDateFormat = formatter.parse(fromDate);
			toDateFormat = formatter.parse(toDate);
			return carSearchService.search(fromLocation, toLocation, fromDateFormat, toDateFormat).toJSONString();
		} catch (Exception E) {
			logger.error(E.getMessage());
		}
		return "Error in your input";
	}
}
