package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.entity.TvAndMovie;

public interface ShowRepo extends JpaRepository<TvAndMovie, Integer>{

	@Query("Select T from TvAndMovie T where showId in (:ids)")
	public List<TvAndMovie> getTrackedList(@Param("ids") List<Integer> ids);

	//query for search function
	@Query("Select T from TvAndMovie T where showTitle like %:word% or showSummary like %:word% ")
	public List<TvAndMovie> getWord(@Param("word") String word);
	
	
}
