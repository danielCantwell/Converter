/**
 * Activity for converting volume units
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

public class VolConvert extends Activity {

	private String spinner[]; // List of items in the spinners
	private Spinner sOne;
	private Spinner sTwo;

	private Button b; // To convert

	private EditText et; // To get user input

	private TextView tv; // To display result

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.volconvert);

		spinner = new String[9];
		spinner[0] = "Milliliter";
		spinner[1] = "Liter";
		spinner[2] = "Fluid Ounces";
		spinner[3] = "Cup";
		spinner[4] = "Pint";
		spinner[5] = "Quart";
		spinner[6] = "Gallon";
		spinner[7] = "Teaspoon";
		spinner[8] = "Tablespoon";

		sOne = (Spinner) findViewById(R.id.volSpinner1);
		sTwo = (Spinner) findViewById(R.id.volSpinner2);

		// Adapter for the spinners
		// Both spinners use the same adapter and list of options
		ArrayAdapter adapter = new ArrayAdapter(this,
				android.R.layout.simple_spinner_dropdown_item, spinner);
		sOne.setAdapter(adapter);
		sTwo.setAdapter(adapter);

		b = (Button) findViewById(R.id.conVolButton);
		et = (EditText) findViewById(R.id.volumeInput);
		tv = (TextView) findViewById(R.id.finalVolume);

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
							// milliliter
						num = Convert.milliToL(input);
						convertAndSetText(y, num, text);
						break;
					case 1: // If the unit selected in spinner one is: liter
						num = input;
						convertAndSetText(y, num, text);
						break;
					case 2: // If the unit selected in spinner one is: fluid
							// ounces
						num = Convert.fluidOuncesToL(input);
						convertAndSetText(y, num, text);
						break;
					case 3: // If the unit selected in spinner one is: cup
						num = Convert.cupToL(input);
						convertAndSetText(y, num, text);
						break;
					case 4: // If the unit selected in spinner one is: pint
						num = Convert.pintToL(input);
						convertAndSetText(y, num, text);
						break;
					case 5: // If the unit selected in spinner one is: quart
						num = Convert.quartToL(input);
						convertAndSetText(y, num, text);
						break;
					case 6: // If the unit selected in spinner one is: gallon
						num = Convert.gallonToL(input);
						convertAndSetText(y, num, text);
						break;
					case 7: // If the unit selected in spinner one is: teaspoon
						num = Convert.teaToL(input);
						convertAndSetText(y, num, text);
						break;
					case 8: // If the unit selected in spinner one is:
							// tablespoon
						num = Convert.tableToL(input);
						convertAndSetText(y, num, text);
						break;
					default:
						System.err.println("Selected Item Position is Invalid");
						break;
					}

				}
			}

			/**
			 * Converts the given num from liter to other units, and displays
			 * the result
			 * 
			 * @param y
			 * @param num
			 * @param text
			 */
			private void convertAndSetText(int y, float num, String text) {
				num = convertFromLiter(y, num);
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
	public float convertFromLiter(int y, float num) {
		switch (y) {
		case 0: // If the selected unit in spinner two is: milliliter
			num = Convert.lToMilli(num);
			break;
		case 1: // If the selected unit in spinner two is: liter
			break;
		case 2: // If the selected unit in spinner two is: fluid ounces
			num = Convert.lToFluidOunces(num);
			break;
		case 3: // If the selected unit in spinner two is: cup
			num = Convert.lToCup(num);
			break;
		case 4: // If the selected unit in spinner two is: pint
			num = Convert.lToPint(num);
			break;
		case 5: // If the selected unit in spinner two is: quart
			num = Convert.lToQuart(num);
			break;
		case 6: // If the selected unit in spinner two is: gallon
			num = Convert.lToGallon(num);
			break;
		case 7: // If the selected unit in spinner two is: teaspoon
			num = Convert.lToTea(num);
			break;
		case 8: // If the selected unit in spinner two is: tablespoon
			num = Convert.lToTable(num);
			break;
		default:
			System.err.println("Selected position is invalid");
			break;
		}

		return num;
	}

}