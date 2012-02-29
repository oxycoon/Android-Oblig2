package com.android.oblig2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import com.android.oblig2.R;

import android.view.View;
import android.widget.*;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

public class NewBook extends Activity{
	private Button submit;
	private EditText title, author, isbn;
	private BookList theList;
	
	public static final String NEW_BOOK_ADDED = "com.android.oblig2.NEW_BOOK";
	public static final String NEWBOOK = "com.android.oblig2.NEWBOOK";
	
	
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
    		try
    		{
    			//TODO: ISBN-validator (####-####-####-####), gjøres bare hvis vi får tid.
    			if (theList.newBook(title.getText().toString(), 
						author.getText().toString(), isbn.getText().toString()))
    			{
    				FileOutputStream fos;
    	    		
    	    		fos = NewBook.this.getApplicationContext().openFileOutput("books.txt", MODE_APPEND);
    	    		OutputStreamWriter osw = new OutputStreamWriter(fos);
    	    		
    	    		osw.write(title.getText().toString() + "," + author.getText().toString() + 
    	    					"," + isbn.getText().toString() + "\n");
    	    		osw.close();
    	    		fos.close();
    	    		
    	    		Intent intent = new Intent(NEW_BOOK_ADDED);
    	    		intent.putExtra("bookTitle", title.getText().toString());
    	    		
    	    		sendBroadcast(intent);

    				//TODO: Broadcast
    				title.setText("");
    				author.setText("");
    				isbn.setText("");	
    				
    			}
    			else
    			{    				
    				final AlertDialog alertDialog = new AlertDialog.Builder(NewBook.this).create();
    				alertDialog.setTitle("Invalid ISBN");
    				alertDialog.setMessage("The ISBN-number written is already taken.");
    				alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
    				   public void onClick(DialogInterface dialog, int which) {
    				      alertDialog.dismiss();
    				   }
    				});
    				alertDialog.show();
    			}
    		}
        	catch (FileNotFoundException e)
        	{;}
        	catch (IOException e)
        	{;}
    		catch(Exception e)
    		{;}
    	}	
    }
    
    
}
