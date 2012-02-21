package com.android.oblig2.a;

import com.android.oblig2.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

public class Books extends Activity {
	private Button menu_search, menu_new, menu_view;
	
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
    }
}