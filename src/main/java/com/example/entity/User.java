package com.example.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity // link to the MySQl database
public class User {

	@Id //the primary key for the table
	@GeneratedValue(strategy=GenerationType.AUTO)// use to generate a random number
	private int id;
	
	@Column //make a column in the table
	private String firstName;
	
	@Column
	private String lastName;
	
	@Column
	private String password;
	
	@Column
	private String userName;
	
	@Column
	private String email;
	
	@Column
	private String telephone;
	
	// make into a class for easy
	/**@Transient // used for list 
	private List<Show> shows = new ArrayList<Show>();*/
	
	public User() {}
	
	public User(int id, String firstName, String lastName, String password, String userName,String email,String telephone) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		//NEED TO DELETE THE COMMITS BFORE UNLOADING TO GITHUB
		//this.shows = shows;
		this.password = password;
		this.userName = userName;
		this.email = email;
		this.telephone = telephone;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	/**public List<Show> getShows() {
		return shows;
	}


	public void setShows(List<Show> shows) {
		this.shows = shows;
	}*/

	
	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", password=" + password
				+ ", userName=" + userName + ", email=" + email + ", telephone=" + telephone + " ]";
	}

	



	
	
	
}
