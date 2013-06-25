/**
 * Activity for converting temperature units
 */
package edu.usc.danielcantwell.converter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

/**
 * @author Daniel
 * 
 */
public class TempConvert extends Activity {

	private RadioButton cOne;
	private RadioButton fOne;
	private RadioButton kOne;

	private RadioButton cTwo;
	private RadioButton fTwo;
	private RadioButton kTwo;

	private TextView finalTemp;
	private EditText tempInput;
	private Button convertTemp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tempconvert);

		cOne = (RadioButton) findViewById(R.id.cOne);
		fOne = (RadioButton) findViewById(R.id.fOne);
		kOne = (RadioButton) findViewById(R.id.KOne);
		cTwo = (RadioButton) findViewById(R.id.cTwo);
		fTwo = (RadioButton) findViewById(R.id.fTwo);
		kTwo = (RadioButton) findViewById(R.id.kTwo);
		finalTemp = (TextView) findViewById(R.id.finalTemp);
		tempInput = (EditText) findViewById(R.id.tempInput);
		convertTemp = (Button) findViewById(R.id.convertTemp);

		convertTemp.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {

				if (tempInput.length() == 0) {
					finalTemp.setText("0.0");
				} else {

					float input = Float.parseFloat(tempInput.getText()
							.toString());
					float num;
					String text;

					if (cOne.isChecked()) {
						if (cTwo.isChecked()) {
							text = String.valueOf(input);
							finalTemp.setText(text);
						} else if (fTwo.isChecked()) {
							num = Convert.cToF(input);
							text = String.valueOf(num);
							finalTemp.setText(text);
						} else if (kTwo.isChecked()) {
							num = Convert.cToK(input);
							text = String.valueOf(num);
							finalTemp.setText(text);
						}
					} else if (fOne.isChecked()) {
						if (cTwo.isChecked()) {
							num = Convert.fToC(input);
							text = String.valueOf(num);
							finalTemp.setText(text);
						} else if (fTwo.isChecked()) {
							text = String.valueOf(input);
							finalTemp.setText(text);
						} else if (kTwo.isChecked()) {
							num = Convert.fToK(input);
							text = String.valueOf(num);
							finalTemp.setText(text);
						}
					} else if (kOne.isChecked()) {
						if (cTwo.isChecked()) {
							num = Convert.kToC(input);
							text = String.valueOf(num);
							finalTemp.setText(text);
						} else if (fTwo.isChecked()) {
							num = Convert.kToF(input);
							text = String.valueOf(num);
							finalTemp.setText(text);
						} else if (kTwo.isChecked()) {
							text = String.valueOf(input);
							finalTemp.setText(text);
						}
					}
				}
			}
		});
	}
}
