package com.Blackrondonapps.myfirstapps;
import UtilitiesApps.*;
import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
//import android.widget.Toast;
import android.content.Intent;
import android.view.View;
//import android.view.View.OnClickListener;





public class Changes extends Activity {
	 EditText Quices;
	 EditText Expos ;
	 EditText Practicas;
	 EditText Proyecto;
	 Button   Guardar ;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Toast.makeText(this, "onCreate/Help", Toast.LENGTH_SHORT).show();
        setContentView(R.layout.changes);
        
        Quices = (EditText) findViewById(R.id.eChangesQuices);
        Expos = (EditText) findViewById(R.id.eChangesExpos);
        Practicas = (EditText) findViewById(R.id.eChangesPracticas);
        Proyecto = (EditText) findViewById(R.id.eChangesProyecto);
        Guardar = (Button)	findViewById(R.id.bChangesGuardar);
        
		Bundle captura = getIntent().getExtras();
		Quices.setText(String.valueOf(captura.getInt("pP1")));
		Expos.setText(String.valueOf(captura.getInt("pP2")));
		Practicas.setText(String.valueOf(captura.getInt("pP3")));
		Proyecto.setText(String.valueOf(captura.getInt("pP4")));
		Button 	 Reset	  = (Button)	findViewById(R.id.bReset);
	     Guardar.setOnClickListener(new View.OnClickListener() {
	        	//float Qui,Exp,Pra,Pro,Ans;
	        	ValNumber valnumber = new ValNumber();
						
				@Override
				
				public void onClick(View v) {
					int total_percent=0;
					if (v.getId() == R.id.bChangesGuardar) {
						if((valnumber.isInteger(Quices.getText().toString()))&&(valnumber.isInteger(Expos.getText().toString()))&&(valnumber.isInteger(Practicas.getText().toString()))&&(valnumber.isInteger(Proyecto.getText().toString()))){
							total_percent=Integer.parseInt((Quices.getText().toString()))+Integer.parseInt((Expos.getText().toString()))+Integer.parseInt((Practicas.getText().toString()))+Integer.parseInt((Proyecto.getText().toString()));
							if(total_percent==100){
								Intent i = new Intent();
								i.putExtra("ansQuiz", Quices.getText().toString());
								i.putExtra("ansExpo", Expos.getText().toString());
								i.putExtra("ansPrac", Practicas.getText().toString());
								i.putExtra("ansProy", Proyecto.getText().toString());
								setResult(RESULT_OK,i);
								finish(); //DEstruir la actividad			
							}else{
								Toast.makeText(getApplicationContext(), "Error:The total percent is: "+total_percent, Toast.LENGTH_SHORT).show();

							}

						}else{
							Toast.makeText(getApplicationContext(), "Error:Please review the fields", Toast.LENGTH_SHORT).show();
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
	
	
	
	
}
