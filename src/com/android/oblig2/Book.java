package com.android.oblig2;

public class Book {
	private String title, author, isbn;
	
	public Book(String t, String a, String i)
	{
		title = t;
		author = a;
		isbn = i;
	}
	
	public String Title()
	{
		return title;
	}
	
	public String Author()
	{
		return author;
	}
	
	public String ISBN()
	{
		return isbn;
	}
	
	public String toString()
	{
		return "Title: " + title + " by " + author + ". " + isbn;
	}
}
