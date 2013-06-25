/**
 * Activity for converting distance units
 */
package edu.usc.danielcantwell.converter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * @author Daniel
 * 
 */
public class DistConvert extends Activity {

	private String spinner[]; // List of items in the spinners
	private Spinner sOne;
	private Spinner sTwo;

	private Button b; // To convert

	private EditText et; // To get user input

	private TextView tv; // To display result

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.distconvert);

		spinner = new String[9];
		spinner[0] = "Centimeter";
		spinner[1] = "Meter";
		spinner[2] = "Kilometer";
		spinner[3] = "Inch";
		spinner[4] = "Foot";
		spinner[5] = "Yard";
		spinner[6] = "Mile";
		spinner[7] = "Sea League";
		spinner[8] = "Fathom";

		sOne = (Spinner) findViewById(R.id.distSpinner1);
		sTwo = (Spinner) findViewById(R.id.distSpinner2);

		// Adapter for the spinners
		// Both spinners use the same adapter and list of options
		ArrayAdapter adapter = new ArrayAdapter(this,
				android.R.layout.simple_spinner_dropdown_item, spinner);
		sOne.setAdapter(adapter);
		sTwo.setAdapter(adapter);

		b = (Button) findViewById(R.id.conDistButton);
		et = (EditText) findViewById(R.id.distanceInput);
		tv = (TextView) findViewById(R.id.finalDistance);

		/*
		 * Converts the unit from spinner one to the unit from spinner two when
		 * clicked
		 */
		b.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {

				if (et.length() == 0) {
					tv.setText("0.0");
				} else {
					// Spinner One Selection
					int x = sOne.getSelectedItemPosition();
					// Spinner Two Selection
					int y = sTwo.getSelectedItemPosition();
					// User Input Number
					float input = Float.parseFloat(et.getText().toString());
					// Initialized text variable, to display result of
					// conversion
					String text = "";
					// Variable to use for conversions
					float num;

					switch (x) {
					case 0: // If the unit selected in spinner one is:
							// centimeter
						num = Convert.centiToM(input);
						convertAndSetText(y, num, text);
						break;
					case 1: // If the unit selected in spinner one is: meter
						num = input;
						convertAndSetText(y, num, text);
						break;
					case 2: // If the unit selected in spinner one is: kilometer
						num = Convert.kiloToM(input);
						convertAndSetText(y, num, text);
						break;
					case 3: // If the unit selected in spinner one is: inch
						num = Convert.inchToM(input);
						convertAndSetText(y, num, text);
						break;
					case 4: // If the unit selected in spinner one is: foot
						num = Convert.footToM(input);
						convertAndSetText(y, num, text);
						break;
					case 5: // If the unit selected in spinner one is: yard
						num = Convert.yardToM(input);
						convertAndSetText(y, num, text);
						break;
					case 6: // If the unit selected in spinner one is: mile
						num = Convert.mileToM(input);
						convertAndSetText(y, num, text);
						break;
					case 7: // If the unit selected in spinner one is: league
						num = Convert.leagueToM(input);
						convertAndSetText(y, num, text);
						break;
					case 8: // If the unit selected in spinner one is: fathom
						num = Convert.fathomToM(input);
						convertAndSetText(y, num, text);
						break;
					default:
						System.err.println("Selected Item Position is Invalid");
						break;
					}
				}
			}

			/**
			 * Converts the given num from meter to other units, and displays
			 * the result
			 * 
			 * @param y
			 * @param num
			 * @param text
			 */
			private void convertAndSetText(int y, float num, String text) {
				num = convertFromMeter(y, num);
				text = String.valueOf(num);
				tv.setText(text);
			}
		});
	}

	/**
	 * Converts meters to other units
	 * 
	 * @param y
	 * @param num
	 * @return num
	 */
	public float convertFromMeter(int y, float num) {
		switch (y) {
		case 0: // If the selected unit in spinner two is: centimeter
			num = Convert.mToCenti(num);
			break;
		case 1: // If the selected unit in spinner two is: meter
			break;
		case 2: // If the selected unit in spinner two is: kilometer
			num = Convert.mToKilo(num);
			break;
		case 3: // If the selected unit in spinner two is: inch
			num = Convert.mToInch(num);
			break;
		case 4: // If the selected unit in spinner two is: foot
			num = Convert.mToFoot(num);
			break;
		case 5: // If the selected unit in spinner two is: yard
			num = Convert.mToYard(num);
			break;
		case 6: // If the selected unit in spinner two is: mile
			num = Convert.mToMile(num);
			break;
		case 7: // If the selected unit in spinner two is: sea league
			num = Convert.mToLeague(num);
			break;
		case 8: // If the selected unit in spinner two is: fathom
			num = Convert.mToFathom(num);
			break;
		default:
			System.err.println("Selected position is invalid");
			break;
		}

		return num;
	}

}
