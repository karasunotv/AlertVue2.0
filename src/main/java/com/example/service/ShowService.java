package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Listofshows;
import com.example.entity.TvAndMovie;
import com.example.repository.ShowRepo;
import com.example.repository.UserAndShowRepo;

@Service
public class ShowService {

	@Autowired
	ShowRepo showRepo;
	
	@Autowired
	UserAndShowRepo userAndShowRepo;
	
	public List<TvAndMovie> getMyShowList() {
		return showRepo.findAll().subList(0, 36);
	}
	
	public Optional<TvAndMovie> getMyShowInfo(int id){
		return showRepo.findById(id);
	}
	
	public void addShow(Listofshows listofshows) {
		userAndShowRepo.save(listofshows);
	}
	
	public List<TvAndMovie> getTrackedShows(int userId) {
		
		List<Integer> showIDs = userAndShowRepo.getTrackedList(userId);
		
		System.out.println("IDS : "+showIDs);
		if(!showIDs.isEmpty()) 
			return showRepo.getTrackedList(showIDs);
		else
			return null;
	}
	public void  removeTrackedShows(int showId, int userId){
		userAndShowRepo.deleteById(showId, userId);
		
		}
	
	
	public Listofshows getListofShows(int showId, int userId) {
		return userAndShowRepo.getShowById(showId, userId);
	}
	
	
	public void saveListofShows(Listofshows show)
	{
		userAndShowRepo.save(show);
	}
	
	
public List<TvAndMovie> getHistoryOfShows(int userId) {
		
		List<Integer> showIDs = userAndShowRepo.getShowHistoryList(userId);
		
		System.out.println("IDS : "+showIDs);
		if(!showIDs.isEmpty()) 
			return showRepo.getTrackedList(showIDs);
		else
			return null;
	}
public List<TvAndMovie> getWord(String word)
{
	System.out.println("search : "+word);
	 return showRepo.getWord(word);
	}
}
