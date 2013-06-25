/**
 * Activity for converting mass and weight units
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
public class MassConvert extends Activity {

	private String spinner[]; // List of items in the spinners
	private Spinner sOne;
	private Spinner sTwo;

	private Button b; // To convert

	private EditText et; // To get user input

	private TextView tv; // To display result

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.massconvert);

		spinner = new String[6];
		spinner[0] = "Gram";
		spinner[1] = "Kilogram";
		spinner[2] = "Metric Ton";
		spinner[3] = "Ounce";
		spinner[4] = "Pound";
		spinner[5] = "Ton";

		sOne = (Spinner) findViewById(R.id.massSpinner1);
		sTwo = (Spinner) findViewById(R.id.massSpinner2);

		// Adapter for the spinners
		// Both spinners use the same adapter and list of options
		ArrayAdapter adapter = new ArrayAdapter(this,
				android.R.layout.simple_spinner_dropdown_item, spinner);
		sOne.setAdapter(adapter);
		sTwo.setAdapter(adapter);

		b = (Button) findViewById(R.id.conMassButton);
		et = (EditText) findViewById(R.id.massInput);
		tv = (TextView) findViewById(R.id.finalMass);

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
					case 0: // If the unit selected in spinner one is: gram
						num = input;
						convertAndSetText(y, num, text);
						break;
					case 1: // If the unit selected in spinner one is: kilogram
						num = Convert.kiloToG(input);
						convertAndSetText(y, num, text);
						break;
					case 2: // If the unit selected in spinner one is: metric
							// ton
						num = Convert.mTonToG(input);
						convertAndSetText(y, num, text);
						break;
					case 3: // If the unit selected in spinner one is: ounce
						num = Convert.ounceToG(input);
						convertAndSetText(y, num, text);
						break;
					case 4: // If the unit selected in spinner one is: pound
						num = Convert.poundToG(input);
						convertAndSetText(y, num, text);
						break;
					case 5: // If the unit selected in spinner one is: ton
						num = Convert.tonToG(input);
						convertAndSetText(y, num, text);
						break;
					default:
						System.err.println("Selected Item Position is Invalid");
						break;
					}
				}
			}

			/**
			 * Converts the given num from gram to other units, and displays the
			 * result
			 * 
			 * @param y
			 * @param num
			 * @param text
			 */
			private void convertAndSetText(int y, float num, String text) {
				num = convertFromGram(y, num);
				text = String.valueOf(num);
				tv.setText(text);
			}
		});
	}

	/**
	 * Converts gram to other units
	 * 
	 * @param y
	 * @param num
	 * @return num
	 */
	public float convertFromGram(int y, float num) {
		switch (y) {
		case 0: // If the selected unit in spinner two is: gram
			break;
		case 1: // If the selected unit in spinner two is: kilogram
			num = Convert.gToKilo(num);
			break;
		case 2: // If the selected unit in spinner two is: metric ton
			num = Convert.gToMTon(num);
			break;
		case 3: // If the selected unit in spinner two is: ounce
			num = Convert.gToOunce(num);
			break;
		case 4: // If the selected unit in spinner two is: pound
			num = Convert.gToPound(num);
			break;
		case 5: // If the selected unit in spinner two is: ton
			num = Convert.gToTon(num);
			break;
		default:
			System.err.println("Selected position is invalid");
			break;
		}

		return num;
	}

}
