package com.android.oblig2.a;

import java.io.*;
import java.util.ArrayList;

import com.android.oblig2.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.*;

public class Books extends Activity {
	private Button menu_search, menu_new, menu_view;
	public BookList list;
	private File savedFile;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
       
        
    }
    
    
    
    public void saveData()
    {
    	
    }
    
    public void loadData()
    {
    	
    }
    
}