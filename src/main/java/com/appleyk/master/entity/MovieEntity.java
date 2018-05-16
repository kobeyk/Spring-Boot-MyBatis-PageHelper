package com.appleyk.master.entity;

import javax.persistence.Table;

@Table(name = "movie")
public class MovieEntity {

	private Long movie_id;
	private String movie_title;
	private String movie_introduction;
	private Float  movie_rating;
	private String movie_release_date;
	
	public Long getMovie_id() {
		return movie_id;
	}
	public void setMovie_id(Long movie_id) {
		this.movie_id = movie_id;
	}
	public String getMovie_title() {
		return movie_title;
	}
	public void setMovie_title(String movie_title) {
		this.movie_title = movie_title;
	}
	public String getMovie_introduction() {
		return movie_introduction;
	}
	public void setMovie_introduction(String movie_introduction) {
		this.movie_introduction = movie_introduction;
	}
	public Float getMovie_rating() {
		return movie_rating;
	}
	public void setMovie_rating(Float movie_rating) {
		this.movie_rating = movie_rating;
	}
	public String getMovie_release_date() {
		return movie_release_date;
	}
	public void setMovie_release_date(String movie_release_date) {
		this.movie_release_date = movie_release_date;
	}

	
	
}
