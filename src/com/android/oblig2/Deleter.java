package com.android.oblig2;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class Deleter extends ListActivity{
	private ArrayAdapter<String> adapter;
	private BookList theList;
	
	//TODO:
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);      
        theList = BookList.getInstance();
        
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, theList.toStringArray());
		setListAdapter(adapter);
      
	}
}
