package com.pl.primer_zone.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table (name ="player_statistic")
public class player {
	@Id
	@Column(name = "name", unique = true)
	private String Name;
	private String Club;
	private String Position;	
	private String Nationality;	
	private int Age;
	private int Appearances	;
	private int Wins;	
	private int Losses;	
	private int Goals;	
	private int Assists;	
	private int Passes;	
	private float Passes_per_match;
	private int Yellow_cards;	
	private int Red_cards;

	private player() {
		
	}
	
	private player( String name, String club, String position, String nationality, int age, int appearances,
			int wins, int losses, int goals, int assists, int passes, float passes_per_match, int yellow_cards,
			int red_cards) {
		super();
		Name = name;
		Club = club;
		Position = position;
		Nationality = nationality;
		Age = age;
		Appearances = appearances;
		Wins = wins;
		Losses = losses;
		Goals = goals;
		Assists = assists;
		Passes = passes;
		Passes_per_match = passes_per_match;
		Yellow_cards = yellow_cards;
		Red_cards = red_cards;
	}
	
	private player(String name) {
		this.Name = name;
	}

	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getClub() {
		return Club;
	}
	public void setClub(String club) {
		Club = club;
	}
	public String getPosition() {
		return Position;
	}
	public void setPosition(String position) {
		Position = position;
	}
	public String getNationality() {
		return Nationality;
	}
	public void setNationality(String nationality) {
		Nationality = nationality;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public int getAppearances() {
		return Appearances;
	}
	public void setAppearances(int appearances) {
		Appearances = appearances;
	}
	public int getWins() {
		return Wins;
	}
	public void setWins(int wins) {
		Wins = wins;
	}
	public int getLosses() {
		return Losses;
	}
	public void setLosses(int losses) {
		Losses = losses;
	}
	public int getGoals() {
		return Goals;
	}
	public void setGoals(int goals) {
		Goals = goals;
	}
	public int getAssists() {
		return Assists;
	}
	public void setAssists(int assists) {
		Assists = assists;
	}
	public int getPasses() {
		return Passes;
	}
	public void setPasses(int passes) {
		Passes = passes;
	}
	public float getPasses_per_match() {
		return Passes_per_match;
	}
	public void setPasses_per_match(float passes_per_match) {
		Passes_per_match = passes_per_match;
	}
	public int getYellow_cards() {
		return Yellow_cards;
	}
	public void setYellow_cards(int yellow_cards) {
		Yellow_cards = yellow_cards;
	}
	public int getRed_cards() {
		return Red_cards;
	}
	public void setRed_cards(int red_cards) {
		Red_cards = red_cards;
	}
}
