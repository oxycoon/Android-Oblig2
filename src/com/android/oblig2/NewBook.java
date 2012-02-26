package com.android.oblig2;

import com.android.oblig2.R;

import android.view.View;
import android.widget.*;

import android.app.Activity;
import android.os.Bundle;

public class NewBook extends Activity{
	private Button submit;
	private EditText title, author, isbn;
	private BookList theList;
	
	
	//TODO:whole class
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newbook);
        
        theList = BookList.getInstance();
        
        title = (EditText)findViewById(R.id.newbook_title);
        author = (EditText)findViewById(R.id.newbook_author);
        isbn = (EditText)findViewById(R.id.newbook_isbn);
        
        submit = (Button)findViewById(R.id.newbook_button_submit);
        submit.setOnClickListener(new ButtonHandler());

    }
    
    private class ButtonHandler implements View.OnClickListener
    {
    	public void onClick(View v)
    	{
    		boolean unique = true;
    		
    		for(Book b: BookList.getInstance().theList)
    		{
    			if(b.ISBN().equals(isbn.getText().toString()))
    			{
    				unique = false;
    			}
    		}
    		
    		try
    		{
    			if (unique)
    			{
    				BookList.getInstance().newBook(title.getText().toString(), 
    						author.getText().toString(), isbn.getText().toString());
    				title.setText("");
    				author.setText("");
    				isbn.setText("");
    			}
    		}
    		catch(Exception e)
    		{
    		}
    	}	
    }
    
    
}
