package com.example.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.entity.Listofshows;
import com.example.entity.TvAndMovie;
import com.example.entity.User;
import com.example.service.SendMail;
import com.example.service.ShowService;
import com.example.service.UserService;

@Controller
public class HomeController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	ShowService showService;
	
	@Autowired
	SendMail sendMail;
	
	@RequestMapping("/")
	public ModelAndView index()
	{
		return new ModelAndView("index");
	}

	
	@RequestMapping("/homepage")
	public ModelAndView homepage(HttpSession session)
	{
		session.setAttribute("recommedList", showService.getMyShowList());
		System.out.println(showService.getMyShowList().size());
		return new ModelAndView("homepage");
	}
	
	@RequestMapping("/signup")
	public ModelAndView signup()
	{
		return new ModelAndView("signup" , "user" , new User());
	}
	
	@RequestMapping("/login")
	public ModelAndView login()
	{
		return new ModelAndView("login" , "user" , new User());
	}
	
	@RequestMapping("/showinfo")
	public ModelAndView showinfo(@RequestParam("id")int  showId, HttpSession session)
	{
		
		Optional<TvAndMovie> tvAndMovie = showService.getMyShowInfo(showId);
		
		
		System.out.println(tvAndMovie.get().getShowAirTime().toString());
		session.setAttribute("infoShows", tvAndMovie.get());
		return new ModelAndView("showinfo");
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public ModelAndView register(@ModelAttribute("user") User user, HttpSession session)
	{
		userService.saveUser(user);
		sendMail.sendMail(user.getEmail(), "Welcome!", "Hi "+user.getFirstName()+"Thank you for registering.");
		session.setAttribute("recommedList", showService.getMyShowList());
		return new ModelAndView("login");
	}
	
	@RequestMapping(value="/loggingin", method=RequestMethod.POST)
	public ModelAndView loggingin(@ModelAttribute("user") User user, HttpSession session)
	{
		User loggedinUser = userService.loginUser(user);
		
		if(loggedinUser != null) {
			session.setAttribute("loggedinUser", loggedinUser);
			session.setAttribute("trackedList", showService.getTrackedShows(loggedinUser.getId()));
			session.setAttribute("recommedList", showService.getMyShowList());
			return new ModelAndView("homepage");
			
		}
		else {
			return new ModelAndView("index", "user", new User());
		}

	}
	
	@RequestMapping("/history")
	public ModelAndView history(HttpSession session)
	{
		User loggedinUser = (User) session.getAttribute("loggedinUser");
		session.setAttribute("showHistoryList", showService.getHistoryOfShows(loggedinUser.getId()));
		return new ModelAndView("history");
	}
	
	@RequestMapping("logout")
	public ModelAndView logout( HttpSession session) {
		session.setAttribute("loggedinUser", null);
		 return new ModelAndView("index");
	}
	
	//to add shows
	@RequestMapping("/add")
	public ModelAndView addShow(@RequestParam("id")int  showId, HttpSession session)
	{
		User loggedinUser = (User) session.getAttribute("loggedinUser");
		Listofshows newShow = new Listofshows( loggedinUser.getId(), showId);
		showService.addShow(newShow);
		
		session.setAttribute("trackedList", showService.getTrackedShows(loggedinUser.getId()));
		session.setAttribute("recommedList", showService.getMyShowList());
		return new ModelAndView("homepage");
	}
	
	//remove from tracked show list
	@RequestMapping("/remove")
	public ModelAndView removeShow(@RequestParam("id")int showId, HttpSession session) 
	{
		System.out.print(showId);
		User loggedinUser = (User) session.getAttribute("loggedinUser");
		Listofshows myShow = showService.getListofShows(showId, loggedinUser.getId());	
		myShow.setHistory(true);
		showService.saveListofShows(myShow);
		
		session.setAttribute("trackedList", showService.getTrackedShows(loggedinUser.getId()));
		session.setAttribute("recommedList", showService.getMyShowList());
		return new ModelAndView("homepage");
	}
	
	//Sends an Email notification
	@RequestMapping("/notify")
	public ModelAndView notify(@RequestParam("id")int  showId, HttpSession session)
	{
		
		Optional<TvAndMovie> tvAndMovie = showService.getMyShowInfo(showId);
		User loggedinUser = (User) session.getAttribute("loggedinUser");
		
		
		sendMail.sendMail(loggedinUser.getEmail(), "Welcome!", "Hi "+ loggedinUser.getFirstName()+" the show you picked, "
				+ tvAndMovie.get().getShowTitle()+ " will be airing at " + tvAndMovie.get().getShowAirTime() +
				" on " + tvAndMovie.get().getStation());

		session.setAttribute("trackedList", showService.getTrackedShows(loggedinUser.getId()));
		session.setAttribute("recommedList", showService.getMyShowList());
		return new ModelAndView("showinfo");}
	
	//Search Function
		@RequestMapping("/searchShows")
		public ModelAndView searchShows(HttpServletRequest request, HttpSession session)
		{
			String word = request.getParameter("word");
			System.out.println(word);
			if(word.isEmpty())
			{
				User loggedinUser = (User) session.getAttribute("loggedinUser");
				session.setAttribute("trackedList", showService.getTrackedShows(loggedinUser.getId()));
				session.setAttribute("recommedList", showService.getMyShowList());
				return new ModelAndView("homepage");
			}
			 
			 session.setAttribute("searchShowList", showService.getWord(word));
			return new ModelAndView("searchresult");
		}
}

	
