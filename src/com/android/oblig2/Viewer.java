package com.android.oblig2;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class Viewer extends ListActivity{
	private ArrayAdapter<String> adapter;
	private BookList theList;
	
	public static final String VIEWER = "com.android.oblig2.VIEWER";
	
	//TODO: Brukeren skal kunne velge en boktittel 
	//      og denne skal da returneres fra denne aktiviteten.
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);      
        theList = BookList.getInstance();
        
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, theList.toStringArray());
		setListAdapter(adapter);
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);

		String s = (String) this.getListAdapter().getItem(position);
		Intent result = new Intent();
		
		result.putExtra("returnResult", s);
		setResult(RESULT_OK, result);
		finish();
	}
}
