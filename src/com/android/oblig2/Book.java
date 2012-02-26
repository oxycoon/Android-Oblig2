package com.android.oblig2;

public class Book {
	private String title, author, isbn;
	private boolean selected;
	
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
	
	public boolean isSelected()
	{
		return selected;
	}
	
	public void setSelected(boolean s)
	{
		this.selected = s;
	}
	
	public String toString()
	{
		return title + " by " + author + ". " + isbn;
	}
}
