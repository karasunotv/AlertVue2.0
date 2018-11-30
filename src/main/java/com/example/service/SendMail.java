package com.example.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.entity.Listofshows;
import com.example.entity.User;
import com.example.repository.UserAndShowRepo;
import com.example.repository.UserRepo;
import com.example.repository.UserRepo.UserAndShow;

@Service
public class SendMail {

	 @Autowired
	  private JavaMailSender emailSender;
	 
	 @Autowired
	 UserRepo userRepo;
	 
	 @Autowired
	 UserAndShowRepo listofshows;
	 
	 
	 
	  
	  public void sendMail(String toEmail, String subject, String msg) {
		  
		  System.out.println("To: "+toEmail);
	  SimpleMailMessage message = new SimpleMailMessage();
	  message.setTo(toEmail);
	  message.setSubject(subject);
	  message.setText(msg);
	  message.setFrom("capstonead89@gmail.com");

	  emailSender.send(message);
	  }
	  
	  
	  
	  //scheduler for notification
	 @Scheduled(cron = "0 0/1 * * * ?")
	    public void reportCurrentTime() {
		   List<UserAndShow> myShows = this.userRepo.findbyNativeQuery();
		   for(int i =0; i< myShows.size(); i++){
		   
		   this.emailshownotify(myShows.get(i));
		   this.mobileshownotify(myShows.get(i));
		   
		   }
		  
	    }
	  
	  private void mobileshownotify(UserAndShow userAndShow) {
		// TODO Auto-generated method stub
		
	}

	public void emailshownotify(UserAndShow userShow ) {
		  
		 	sendMail (userShow.getEmail(),  userShow.getShowTitle()+" is starting in next 3 hours",  "HI " + userShow.getFirstName()+ ","
		 			+ "\n" + "The show you pick is starting soon on" + userShow.getStation()+".");
		 
		 	// this is where the update goes
		 	Listofshows myShow = listofshows.getShowById(userShow.getShowId(), userShow.getId());
		 	myShow.setNotification(true);
		 	listofshows.save(myShow);
		 	
		
		 
		  System.out.println("THis is a test *************************************************************************************************************************************************");

	  }
	  
	} 

