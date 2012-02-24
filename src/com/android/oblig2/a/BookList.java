package com.android.oblig2.a;

import java.util.ArrayList;

public class BookList {
	private static BookList instance;
	private  ArrayList<Book> theList;
	
	public static BookList getInstance()
	{
		if(instance == null)
			instance = new BookList();
		return instance;
	}
	
	private BookList()
	{
		theList = new ArrayList<Book>();
	}
	
	public boolean isEmpty()
	{
		return theList.isEmpty();
	}
	
	public Book[] search_onAuthor(String a)
	{
		ArrayList<Book> temp = new ArrayList<Book>();
		
		for (Book b: theList)
		{
			if(b.Author().equals(a))
			{
				temp.add(b);
			}
		}
		return (Book[])temp.toArray();		
	}
	
	public Book[] search_onTitle(String t)
	{
		ArrayList<Book> temp = new ArrayList<Book>();
		
		for (Book b: theList)
		{
			if(b.Title().equals(t))
			{
				temp.add(b);
			}
		}
		return (Book[])temp.toArray();	
	}
	
	public Book search_onISBN(String i)
	{
		for (Book b: theList)
		{
			if(b.ISBN().equals(i))
			{
				return b;
			}
		}
		return null;
	}

}
