package com.example.bookstore;

public class Book{
	private int id;
	private String bookName;
	private  int year;
	private boolean isAvailable;

	public Book( int id,String bookName,int year,  boolean isAvailable) {
		this.id = id;
		this.bookName = bookName;
		this.year = year;
		this.isAvailable=isAvailable;
	}

	public void setId(String title){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setBookName(String bookName){
		this.bookName = bookName;
	}
	public String getBookName(){
		return bookName;
	}

	public void setYear(int year){
		this.year = year;
	}

	public int getYear(){
		return year;
	}

	public void setAvailable(boolean available) {
		isAvailable = available;
	}

	public boolean isAvailable() {
		return isAvailable;
	}
	@Override
	public String toString() {
		return "Book{" +
				"id=" + id +
				", Book Name='" + bookName + '\'' +
				", year=" + year +
				", isAvailable=" + isAvailable +
				'}';
	}

}
