package com.example.bookstore;

public class Book{
	private int id;
	private String author;
	private  int year;

	public Book(int year, String author, int id) {
		this.year = year;
		this.author = author;
		this.id = id;
	}

	public void setYear(int year){
		this.year = year;
	}

	public int getYear(){
		return year;
	}

	public void setAuthor(String author){
		this.author = author;
	}

	public String getAuthor(){
		return author;
	}

	public void setId(String title){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"Book{" + 
			"year = '" + year + '\'' + 
			",author = '" + author + '\'' +
			",id = '" + id + '\'' +
			"}";
		}
}
