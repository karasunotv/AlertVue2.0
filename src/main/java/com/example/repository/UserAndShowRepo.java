package com.example.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entity.Listofshows;
import com.example.entity.TvAndMovie;

@Repository
public interface UserAndShowRepo extends JpaRepository<Listofshows, Integer>{
	
	@Query("Select L.showId from Listofshows L where userId =:userId and history=0")
	public List<Integer> getTrackedList(@Param("userId") int userId);

	@Transactional
	@Modifying
	@Query("Delete from  Listofshows L where showId =:showId and userId =:userId")
	public void deleteById(@Param("showId")int showId, @Param("userId") int userId);
	

	@Query("Select T from Listofshows T where showId =:showId and userId =:userId")
	public Listofshows getShowById(@Param("showId")int showId, @Param("userId") int userId);
	
	@Query("Select L.showId from Listofshows L where userId =:userId and history=1")
	public List<Integer> getShowHistoryList(@Param("userId") int userId);

	@Query("Select T from User T where showId in getShowList")
	public Listofshows getUserNotification(); 

}
