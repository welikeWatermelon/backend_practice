package com.ssafy.ws.step2.dto;

public class Movie {

	private String title; // 영화 제목
	private String director; // 감독 이름
	private String genre; // 장르
	private int mileage; // 러닝타임
	
	public Movie() {
		
	}
	public Movie(String title, String director, String genre, int mileage) {
		super();
		this.title = title;
		this.director = director;
		this.genre = genre;
		this.mileage = mileage;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public int getMileage() {
		return mileage;
	}
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
	
	@Override
	public String toString() {
		return "Movie [title=" + title + ", director=" + director + ", genre=" + genre + ", mileage=" + mileage + "]";
	}
}