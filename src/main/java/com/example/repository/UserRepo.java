package com.example.repository;


import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entity.TvAndMovie;
import com.example.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

	
	@Query("Select R from User R where userName =:userName and password =:password")
	public User login(@Param("userName") String userName, @Param("password") String password );
	
	@Query(value="SELECT T.firstName as firstName, T.id as Id, T.email as email, T.telephone as telephone, M.showId as showId, M.showTitle as showTitle, M.showAirTime as showAirTime, M.station as station FROM User T, Listofshows L, TvAndMovie M where T.id = L.userId and M.showId = L.showId and L.notification is null and TIMESTAMPDIFF(HOUR, NOW(),  M.showAirTime) between 0 and 3", nativeQuery = true)
	List<UserAndShow> findbyNativeQuery();
	
	public static interface UserAndShow{
		
		String getShowTitle();
		Timestamp getShowAirTime();
		String getStation();
		String getFirstName();
		String getEmail();
		String getTelephone();
		Integer getShowId();
		Integer getId();
		}
	}
