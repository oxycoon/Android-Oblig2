package com.android.oblig2;

import java.util.ArrayList;

public class BookList {
	private static BookList instance;
	
	public ArrayList<Book> theList;
	
	public static BookList getInstance()
	{
		if(instance == null)
		{
			instance = new BookList();
	        instance.theList.add(new Book("Test", "Test", "1337-1337-1337-1337"));
		}
		return instance;
	}
	
	private BookList()
	{
		theList = new ArrayList<Book>();
	}
	
	public boolean newBook(String t, String a, String i)
	{
		int temp = theList.size();
		boolean unique = true;
		
		for (Book b: theList)
		{
			if(b.ISBN().equals(i))
				unique = false;
		}
		
		if (unique)
			theList.add(new Book (t, a, i));
		
		if (temp + 1 == theList.size())
			return true;
		else
			return false;
	}
	
	public String[] toStringArray()
	{
		String[] temp = new String[theList.size()];
		
		for (int i = 0; i < temp.length; i++)
		{
			temp[i] = theList.get(i).toString();
		}
		
		return temp;
	}
	
	public String[] toStringArray(Book[] al)
	{
		{
			String[] temp = new String[al.length];
			
			
			for (int i = 0; i < temp.length; i++)
			{
				temp[i] = al[i].toString();
			}
			
			return temp;
		}
	}
	
	public boolean isEmpty()
	{
		return theList.isEmpty();
	}
	
	/**
	 * Unused features. Implemented to use in later versions.
	 * */
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
	
	public Book[] search_onISBN(String i)
	{
		ArrayList<Book> temp = new ArrayList<Book>();
		
		for (Book b: theList)
		{
			if(b.ISBN().equals(i))
			{
				temp.add(b);
			}
		}
		return (Book[])temp.toArray();
	}

	public String printSelected(Book[] in)
	{
		String temp = "";
		for (Book b: in)
		{
			temp = b.toString() + "\n";
		}
		return temp;
	}
	
	public String printSelected(Book in)
	{
		return in.toString();
	}
	
	public String printList()
	{
		String temp = "";
		for(Book b: theList)
		{
			temp = b.toString() + "\n";
		}
		return temp;
	}
}
