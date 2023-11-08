package com.example.demo.services;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.LocationStates;


@Repository
public interface CoronaVirusDataServicesRepository extends JpaRepository<LocationStates, Integer> {
	

	@Query(value = "SELECT * FROM Location_States WHERE LATEST_TOTAL_DEATHS > 0 ORDER BY LATEST_TOTAL_DEATHS DESC LIMIT :count", nativeQuery = true)
	List<LocationStates> findTopNByLatestTotalDeaths(@Param("count") int count);
	
	@Query(value = "SELECT * FROM Location_States  WHERE countryid  = :id", nativeQuery = true)
    List<LocationStates> findIdByTotalDeaths(@Param("id") int id);
	
	@Query(value = "SELECT * FROM Location_States  WHERE COUNTRY  = :name", nativeQuery = true)
	 List<LocationStates> findByCountryTotalDeaths(@Param("name") String name);
	
	

}
