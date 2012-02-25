package com.android.oblig2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

import com.android.oblig2.R;


public class Searcher extends Activity {
	private BookList theList;
	private Spinner theSpinner;
	private ArrayAdapter<String> targets;
	private Button theButton;
	private EditText editor;
	
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
    }
    
    public void search(String s)
    {
    	if (theSpinner.getSelectedItemPosition() == 0)
    	{
    		theList.search_onTitle(s);
    	}
    	else if (theSpinner.getSelectedItemPosition() == 1)
    	{
    		theList.search_onAuthor(s);
    	}
    	else if (theSpinner.getSelectedItemPosition() == 2)
    	{
    		theList.search_onISBN(s);
    	}
    }
    
    private class ButtonHandler implements View.OnClickListener
    {
    	public void onClick(View v)
    	{
    		search(editor.getText().toString());
    	}	
    }
    
    
}
