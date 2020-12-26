package com.shubham.locationweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shubham.locationweb.entities.Location;

public interface LocationRepository extends JpaRepository<Location, Integer>{

}
