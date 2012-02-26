package com.android.oblig2;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

import com.android.oblig2.R;


public class Searcher extends Activity {
	private Spinner theSpinner;
	private ArrayAdapter<String> targets;
	private Button theButton;
	private EditText editor;
	private BookList theList;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.searcher);        
        
        theList = BookList.getInstance();
        //Spinner
        theSpinner = (Spinner) findViewById(R.id.searcher_spinner);
		targets = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item);
		targets.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		theSpinner.setAdapter(targets);
		targets.add(getResources().getString(R.string.searcher_spinner_content1));
		targets.add(getResources().getString(R.string.searcher_spinner_content2));
		targets.add(getResources().getString(R.string.searcher_spinner_content3));
		targets.setNotifyOnChange(true);
		
		theButton = new Button(this);
		theButton.setText("Search");
		theButton.setOnClickListener(new ButtonHandler());
		
		editor = (EditText) findViewById(R.id.searcher_search);
		
		
		notYetImplemented();
		
    }
    
    public void notYetImplemented()
    {
    	final AlertDialog alertDialog = new AlertDialog.Builder(Searcher.this).create();
		alertDialog.setTitle("Not yet implemented");
		alertDialog.setMessage("This feature has not yet been implemented into this software.");
		alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
		   public void onClick(DialogInterface dialog, int which) {
		      alertDialog.dismiss();
		   }
		});
		alertDialog.show();
    }
    
    public Book[] search(String s)
    {
    	if (theSpinner.getSelectedItemPosition() == 0)
    	{
    		return theList.search_onTitle(s);
    	}
    	else if (theSpinner.getSelectedItemPosition() == 1)
    	{
    		return theList.search_onAuthor(s);
    	}
    	else 
    	{
    		return theList.search_onISBN(s);
    	}
    }
    
    private class ButtonHandler implements View.OnClickListener
    {
    	public void onClick(View v)
    	{
    		try
    		{
    			search(editor.getText().toString());
    		}
    		catch(NullPointerException e) {;}
    	}	
    }
    
    
}
