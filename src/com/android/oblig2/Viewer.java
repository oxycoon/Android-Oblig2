package com.android.oblig2;

import com.android.oblig2.R;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.*;


public class Viewer extends ListActivity{
	private ArrayAdapter<String> adapter;
	private BookList theList;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);      
        theList = BookList.getInstance();
        
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, theList.toStringArray());
		setListAdapter(adapter);
      
        //adapter = new ArrayAdapter<String>(this, R.layout.viewer, R.id.viewer_textbox_list, theList.toStringArray());
        //setListAdapter(adapter);
	}

}
