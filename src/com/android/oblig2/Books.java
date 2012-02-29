package com.android.oblig2;


import java.io.*;
import java.util.ArrayList;

import com.android.oblig2.R;

import android.app.Activity;
import android.content.*;
import android.os.Bundle;
import android.widget.*;
import android.view.*;

public class Books extends Activity{
	private Button menu_search, menu_new, menu_view, menu_delete;
	private BookList theList;
	
	public static final int BOOKS_SUBACTIVITY = 2;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        theList = BookList.getInstance();
        
        
        menu_search = (Button)findViewById(R.id.menu_button_search);
        menu_new = (Button)findViewById(R.id.menu_button_newbook);
        menu_view = (Button)findViewById(R.id.menu_button_view);
        menu_delete = (Button)findViewById(R.id.menu_button_deletebook);
        
        //Activates buttons
        menu_search.setOnClickListener(new ButtonHandler());
        menu_new.setOnClickListener(new ButtonHandler());
        menu_view.setOnClickListener(new ButtonHandler());
        menu_delete.setOnClickListener(new ButtonHandler());
       
        loadData();
    }
    
//    protected void onStop()
//    {
//    	super.onStop();
//    	saveData();
//    }
    
    //TODO: Save data to file
    public boolean saveData()
    {
    	FileOutputStream fos;
    	
    	try
    	{
    		// Sørger for at vi ikke får duplikater, filen overskrives ved lagring
    		this.getApplicationContext().deleteFile("books.txt");
    		
    		fos = this.getApplicationContext().openFileOutput("books.txt", MODE_APPEND);
    		OutputStreamWriter osw = new OutputStreamWriter(fos);
    		
    		for(Book b: theList.theList)
    		{
    			osw.write(b.Title() + ',' + b.Author() + ',' + b.ISBN() + '\n');
    		}
    		osw.close();
    		fos.close();
    		return true;
    	}
    	catch (FileNotFoundException e)
    	{
    		return false;
    	}
    	catch (IOException e)
    	{
    		return false;
    	}
    }
    
    public void loadData()
    {
    	ArrayList<String> stringstemp = new ArrayList<String>();
    	String[] var = new String[3];
    	boolean unique = true;
    	
    	try
    	{
    		FileInputStream fis = this.getApplicationContext().openFileInput("books.txt");
    		InputStreamReader isr = new InputStreamReader(fis);
    		BufferedReader reader = new BufferedReader(isr);
    		
    		String line = reader.readLine();
    		stringstemp.clear();
    		while (line != null) 
    		{
    			stringstemp.add(line);
    			line = reader.readLine();
    		}
    		
    		isr.close();
    		reader.close();
    		fis.close();
    	} 
    	catch (FileNotFoundException e) 
    	{
    		e.printStackTrace();
    	} 
    	catch (IOException e) 
    	{
    		e.printStackTrace();
    	}
    	
    	
    	for(String s: stringstemp)
    	{
    		unique = true;
    		var = s.split(",");
    		
    		for (Book b: theList.theList)
    		{
    			if(var[2].toString().equals(b.ISBN()))
    			{
    				unique = false;
    			}
    		}
    		if (unique)
    		{
    			theList.theList.add(new Book(var[0], var[1], var[2]));
    		}
    	}
    }
    
    private void startViewer()
    {
    	startActivityForResult(new Intent(Books.this, Viewer.class), BOOKS_SUBACTIVITY);
    }
    private void startSearcher()
    {
    	startActivity(new Intent(Books.this, Searcher.class));
    }
    private void startNewBook()
    {
    	startActivity(new Intent(Books.this, NewBook.class));
    }
    private void startDeleter()
    {
    	startActivity(new Intent(Books.this, Deleter.class));
    }
    
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
    	super.onActivityResult(requestCode, resultCode, data);
    	
    	switch(requestCode)
    	{
    		case(BOOKS_SUBACTIVITY):
    		{
    			if (resultCode == Activity.RESULT_OK)
    			{
    				if(data!=null)
    				{
    					Toast t = Toast.makeText(this, data.getStringExtra("returnResult") + ", hentet fra Viewer.", 10);
    					t.show();
    				}
    			}
    		}
    	}	
    }
    
    private class ButtonHandler implements View.OnClickListener
    {
    	public void onClick(View v)
    	{
    		if (v.getId() == R.id.menu_button_search)
    		{
    			startSearcher();
    		}
    		else if (v.getId() == R.id.menu_button_newbook)
    		{
    			startNewBook();
    		}
    		else if (v.getId() == R.id.menu_button_view)
    		{
    			startViewer();
    		}
    		else if(v.getId() == R.id.menu_button_deletebook)
    		{
    			startDeleter();
    		}
    	}	
    }    
}