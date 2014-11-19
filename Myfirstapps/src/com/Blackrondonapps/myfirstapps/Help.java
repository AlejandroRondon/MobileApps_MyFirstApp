package com.Blackrondonapps.myfirstapps;

import android.app.Activity;
import android.os.Bundle;
//import android.widget.Toast;

public class Help extends Activity{
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Toast.makeText(this, "onCreate/Help", Toast.LENGTH_SHORT).show();
        setContentView(R.layout.help);
	}
	
}
