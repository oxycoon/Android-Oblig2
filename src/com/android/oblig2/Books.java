package com.android.oblig2;


import java.io.*;

import com.android.oblig2.R;

import android.app.Activity;
import android.content.*;
import android.os.Bundle;
import android.widget.*;
import android.view.*;

public class Books extends Activity{
	private Button menu_search, menu_new, menu_view, menu_delete;
	private BookList theList;


	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        theList.getInstance();
        
        
        menu_search = (Button)findViewById(R.id.menu_button_search);
        menu_new = (Button)findViewById(R.id.menu_button_newbook);
        menu_view = (Button)findViewById(R.id.menu_button_view);
        menu_delete = (Button)findViewById(R.id.menu_button_deletebook);
        
        //Activates buttons
        menu_search.setOnClickListener(new ButtonHandler());
        menu_new.setOnClickListener(new ButtonHandler());
        menu_view.setOnClickListener(new ButtonHandler());
        menu_delete.setOnClickListener(new ButtonHandler());
       
        
    }
    
//    protected void onStop()
//    {
//    	super.onStop();
//    	saveData();
//    }
    
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
    	
    }
    
    private void startViewer()
    {
    	startActivity(new Intent(Books.this, Viewer.class));
    }
    private void startSearcher()
    {
    	startActivity(new Intent(Books.this, Searcher.class));
    }
    private void startNewBook()
    {
    	startActivity(new Intent(Books.this, NewBook.class));
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
    			
    		}
    	}	
    }
    
}