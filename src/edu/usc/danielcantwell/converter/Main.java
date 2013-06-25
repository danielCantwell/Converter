/**
 * Home Screen when app is started
 * Gives options for the user to select between unit conversions
 */
package edu.usc.danielcantwell.converter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Main extends Activity {
    /** Called when the activity is first created. */
	
	private Button distButton;
	private Button massButton;
	private Button volButton;
	private Button tempButton;
		
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        distButton = (Button) this.findViewById(R.id.distanceButton);
        distButton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				startActivity(new Intent(Main.this, DistConvert.class));
			}
		});
        
        massButton = (Button) this.findViewById(R.id.massButton);
        massButton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				startActivity(new Intent(Main.this, MassConvert.class));
			}
		});
        
        volButton = (Button) this.findViewById(R.id.volumeButton);
        volButton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				startActivity(new Intent(Main.this, VolConvert.class));
			}
		});
        
        tempButton = (Button) this.findViewById(R.id.temperatureButton);
        tempButton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				startActivity(new Intent(Main.this, TempConvert.class));
			}
		});
        
    }
}