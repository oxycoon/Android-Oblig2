package com.android.oblig2;

import com.android.oblig2.R;

import android.app.Activity;
import android.os.Bundle;

public class NewBook extends Activity{
	private BookList theList;
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
       
        theList.getInstance();
    }
}
