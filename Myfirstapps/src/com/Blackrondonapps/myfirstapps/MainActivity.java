/*Mark v2*/
package com.Blackrondonapps.myfirstapps;
import UtilitiesApps.*;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {
	
	/*To interchange*/
	int P1 = 25;
	int P2 = 25;
	int P3 = 25;
	int P4 = 25;
	
    EditText Quices;
    EditText Expos;
    EditText Practicas;
    EditText Proyecto;
    TextView Answer;
    Button   Calcular;
	
	ValNumber valnumber = new ValNumber();
	ReadData readData = new ReadData();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();
        setContentView(R.layout.activity_main);
        Quices = (EditText) findViewById(R.id.eQuices);
        Expos = (EditText) findViewById(R.id.eExpos);
        Practicas = (EditText) findViewById(R.id.ePracticas);
        Proyecto = (EditText) findViewById(R.id.eProyecto);
        Answer = (TextView) findViewById(R.id.tAnswer);
        Button   Calcular = (Button)	findViewById(R.id.bCalcular);
		Button 	 Reset	  = (Button)	findViewById(R.id.bReset);
        
        

        Calcular.setOnClickListener(new View.OnClickListener() {
        	float Qui,Exp,Pra,Pro,Ans;

					
			@Override
			
			public void onClick(View v) {
				int  lims=5,limi=0;
				Qui= readData.readFloatRange(getApplicationContext(),Quices.getText().toString(),limi,lims);
				if((Qui != limi-1) && (Qui != lims+1) && (Qui != lims+2)){
					Exp= readData.readFloatRange(getApplicationContext(),Expos.getText().toString(),limi,lims);
					if((Exp != limi-1) && (Exp != lims+1) && (Exp != lims+2)){
						Pro= readData.readFloatRange(getApplicationContext(),Proyecto.getText().toString(),limi,lims);
						if((Pro != limi-1) && (Pro != lims+1) && (Pro != lims+2)){
							Pra= readData.readFloatRange(getApplicationContext(),Practicas.getText().toString(),limi,lims);
							if((Pra != limi-1) && (Pra != lims+1) && (Pra != lims+2)){
								
								Ans = Qui*P1/100+Exp*P2/100+Pro*P3/100+Pra*P4/100;
								Toast.makeText(getApplicationContext(), "Final grade is: "+Ans, Toast.LENGTH_LONG).show();
								Answer.setText(Float.toString(Ans));
							}
						}
					}
				}

			}
		});
        Reset.setOnClickListener(new View.OnClickListener() {

			@Override
			
			public void onClick(View v) {
				Quices.setText("");
				Expos.setText("");
				Practicas.setText("");
				Proyecto.setText("");
		
			}
		});
    }
    
    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    } 

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.Percents) {
        	Intent i = new Intent(this,Changes.class);
			i.putExtra("pP1", P1);
			i.putExtra("pP2", P2);
			i.putExtra("pP3", P3);
			i.putExtra("pP4", P4);
			startActivityForResult(i, 1234);
            return true;
        }
        if (id == R.id.Acercade) {
        	Intent i = new Intent(this,Help.class);
        	startActivity(i);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    @Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		
		//super.onActivityResult(requestCode, resultCode, data);
		if (requestCode==1234 && resultCode==RESULT_OK ) {
			
			P1 = Integer.parseInt(data.getExtras().getString("ansQuiz"));
			P2 = Integer.parseInt(data.getExtras().getString("ansExpo"));
			P3 = Integer.parseInt(data.getExtras().getString("ansPrac"));
			P4 = Integer.parseInt(data.getExtras().getString("ansProy"));
			
			
			
			Toast.makeText(getApplicationContext(), "Save", Toast.LENGTH_SHORT).show();
			
		}
		
	}
    /*
    protected void onStart(){
    	super.onStart();
    	Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show();
    }
    protected void onResume(){
    	super.onResume();
    	Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();
    }
    protected void onPause(){
    	super.onPause();
    	Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show();
    }
    protected void onStop(){
    	super.onStop();
    	Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show();
    }
    protected void onDestroy(){
    	super.onDestroy();
    	Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
    }*/
}
