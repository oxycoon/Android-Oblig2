package com.android.oblig2;

import com.android.oblig2.R;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.*;



public class Viewer extends ListActivity{
	private BookList theList;
	private ArrayAdapter<String> adapter;
	
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        theList.getInstance();        
      
        adapter = new ArrayAdapter<String>(this, R.layout.viewer, R.id.viewer_textbox_list, theList.toStringArray());
        setListAdapter(adapter);
	}

}
