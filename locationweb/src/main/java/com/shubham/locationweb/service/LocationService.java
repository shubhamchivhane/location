package com.shubham.locationweb.service;

import java.util.List;


import com.shubham.locationweb.entities.Location;


public interface LocationService {

	Location saveLocation(Location location);

	Location updateLocation(Location location);

	void deleteLocation(Location location);

	Location getLocationByID(int id);

	List<Location> getAllLocation();

}
