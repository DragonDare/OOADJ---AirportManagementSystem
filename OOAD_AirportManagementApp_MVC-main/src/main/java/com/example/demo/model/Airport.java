package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "airport")
public class Airport {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;

	@Id
    @Column(name = "airport_name")
    private String airport_name;

    @Column(name = "city")
    private String city;

	@Column(name = "state")
    private String state;

	@Column(name="passenger_name")
	private String passenger_name;

	@Column(name="flight_name")
	private String flight_name;

	@Column(name="reviews")
	private String reviews;

	@Column(name="usr_id")
	private int usr_id;

	public String getPassenger_name() {
		return passenger_name;
	}

	public void setPassenger_name(String passenger_name) {
		this.passenger_name = passenger_name;
	}

	public String getFlight_name() {
		return flight_name;
	}

	public void setFlight_name(String flight_name) {
		this.flight_name = flight_name;
	}

	public String getReviews() {
		return reviews;
	}

	public void setReviews(String reviews) {
		this.reviews = reviews;
	}

	public int getUsr_id() {
		return usr_id;
	}

	public void setUsr_id(int usr_id) {
		this.usr_id = usr_id;
	}




	public Airport() {
		super();
		// TODO Auto-generated constructor stub
	}

	
    public Airport(String airport_name, String city, String state,String passenger_name,String flight_name,String reviews) {
		super();
		this.airport_name = airport_name;
		this.city = city;
		this.state = state;
		this.passenger_name=passenger_name;
		this.flight_name=flight_name;
		this.reviews=reviews;
	}

//	public long getId() {
//		return id;
//	}

//	public void setId(long id) {
//		this.id = id;
//	}

	public String getAirport_name() {
		return airport_name;
	}

	public void setAirport_name(String airport_name) {
		this.airport_name = airport_name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
    
    
    
}