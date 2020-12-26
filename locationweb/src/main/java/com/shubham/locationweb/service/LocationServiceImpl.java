package com.shubham.locationweb.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shubham.locationweb.entities.Location;
import com.shubham.locationweb.repository.LocationRepository;

@Service
public class LocationServiceImpl implements LocationService {
	
	private static final Logger logger = LoggerFactory.getLogger(LocationServiceImpl.class);
	
	@Autowired
	private LocationRepository repository;

	@Override
	public Location saveLocation(Location location) {
		logger.info("inside saveLocation service method");
		logger.info("value of location :"+location.toString());
		return repository.save(location);
	}

	@Override
	public Location updateLocation(Location location) {
		logger.info("inside update location");
		logger.info("value of location :"+location.toString());
		return repository.save(location);
	}

	@Override
	public void deleteLocation(Location location) {
		logger.info("inside deleteLocation method");
		logger.info("deleteLocation : value of location :"+location.toString());
      repository.delete(location);		
	}

	@Override
	public Location getLocationByID(int id) {
		logger.info("getLocationByID : value of id :"+id);
			return repository.findById(id).get();
	}

	@Override
	public List<Location> getAllLocation() {
		logger.info("getAllLocation");
		return repository.findAll();
	}

	
}
