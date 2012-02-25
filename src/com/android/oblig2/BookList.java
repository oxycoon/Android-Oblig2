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
	        
		}
		return instance;
	}
	
	private BookList()
	{
		theList = new ArrayList<Book>();
		theList.add(new Book("Placeholder", "Placeholder", "9999-9999-9999-9999"));
	}
	
	public boolean newBook(String t, String a, String i)
	{
		theList.add(new Book (t, a, i));
		
		return true;
	}
	
/*	public void sortList(int id)
	{
		if (id == 0)
		{}
		else if (id == 1)
		{}
		else if (id == 2);
		{}
	}*/
	
	public String[] toStringArray()
	{
		ArrayList<String> temp = new ArrayList<String>();
		
		for (Book b: theList)
		{
			temp.add(b.toString());
		}
		
		return (String[]) temp.toArray();
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