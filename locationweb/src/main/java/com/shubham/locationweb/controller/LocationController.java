package com.shubham.locationweb.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shubham.locationweb.entities.Location;
import com.shubham.locationweb.repository.LocationRepository;
import com.shubham.locationweb.service.LocationService;
import com.shubham.locationweb.service.LocationServiceImpl;

@Controller
public class LocationController {

	private static final Logger logger = LoggerFactory.getLogger(LocationServiceImpl.class);

	@Autowired
	LocationService service;
	static {
		logger.info("+++++++++++++++++++++++into the controller++++++++++++++++++++++++++++++++++==");
	}

	@RequestMapping("/showCreate")
	public String showcreate() {
		logger.info("+++++++++++++++++++++++inside showcreate++++++++++++++++++++++++++++++++++==");
		return "createlocation";
	}

	@RequestMapping("/saveloc")
	public String saveLocation(@ModelAttribute("location") Location location, ModelMap modelMap) {
		logger.info("inside saveLocation handler mapper");
		logger.info("value of location:" + location.toString());
		try {
			Location locationsaved = service.saveLocation(location);
			String msg = "Location saved with id :" + location.getId();
			modelMap.addAttribute("msg", msg);
			return "createlocation";
		} catch (Exception e) {
			System.out.println(e.getMessage());
			String msg = "Location not saved with id :" + location.getId();
			modelMap.addAttribute("msg", msg);
			return "createlocation";
		}
	}

	// displayLoc

	@RequestMapping("/displayLoc")
	public String displaylocation(ModelMap modelMap) {
		logger.info("inside displaylocation handler mapper");

		List<Location> locations = service.getAllLocation();
		logger.info("value of locations:" + locations.toString());

		modelMap.addAttribute("location", locations);
		return "displaylocation";
	}

	@RequestMapping("/deletelocation")
	public String deleteLocation(@RequestParam("id") int id, ModelMap modelMap) {
		logger.info("inside deleteLocation handler mapper");
		Location location = service.getLocationByID(id);
		logger.info("value of location:" + location.toString());

		service.deleteLocation(location);
		List<Location> allLocation = service.getAllLocation();
		modelMap.addAttribute("location", allLocation);
		return "displaylocation";
	}

	@RequestMapping("/updatelocation")
	public String updateLocation(@RequestParam("id") int id, ModelMap modelMap) {
		logger.info("inside updateLocation handler mapper");
		Location location = service.getLocationByID(id);
		logger.info("value of location:" + location.toString());
		modelMap.addAttribute("location", location);
		return "createlocation";
	}

}
