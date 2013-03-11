package com.socioffice.sociotouch;

import java.net.URL;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.socioffice.sociotouch.weather.GoogleWeatherHandler;
import com.socioffice.sociotouch.weather.WeatherSet;

public class CustBaseAct extends Activity {

	protected TextView lblTemp;

	protected Spinner spnProfile;

	protected Button btnHome;
	protected Button btnSignIn;
	protected Button btnWaiter;
	protected ImageButton imgBtnLogo;

	protected LinearLayout layout;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.cust_main);

		lblTemp = (TextView) findViewById(R.id.lblTemp);

		spnProfile = (Spinner) findViewById(R.id.spnProfile);

		btnHome = (Button) findViewById(R.id.btnHome);
		btnSignIn = (Button) findViewById(R.id.btnSignIn);
		btnWaiter = (Button) findViewById(R.id.btnWaiter);
		imgBtnLogo = (ImageButton) findViewById(R.id.imgBtnLogo);

		lblTemp.setText(getTemperature() + "°C");
		
		ArrayAdapter<CharSequence> myProfile = ArrayAdapter.createFromResource(
				this, R.array.profile,
				android.R.layout.simple_dropdown_item_1line);
		spnProfile.setAdapter(myProfile);

		spnProfile.setOnItemSelectedListener(new OnItemSelectedListener() {

			public void onItemSelected(AdapterView<?> parent, View view, int pos,
					long row) {
				// TODO Auto-generated method stub
				if (pos == 1) {
					Intent intent = new Intent().setClass(CustBaseAct.this, ProfileAct.class);
					startActivity(intent);
				} else if (pos == 2) {
					spnProfile.setVisibility(View.GONE);
					btnSignIn.setVisibility(View.VISIBLE);
				}
			}

			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub

			}
		});

		imgBtnLogo.setOnClickListener(new OnClickListener() {

			public void onClick(View view) {
				// TODO Auto-generated method stub
				imgBtnLogoOnClick(view);

			}
		});

		btnHome.setOnClickListener(new OnClickListener() {

			public void onClick(View view) {
				// TODO Auto-generated method stub
				btnHomeOnClick(view);

			}
		});

		btnWaiter.setOnClickListener(new OnClickListener() {

			public void onClick(View view) {
				// TODO Auto-generated method stub
				btnWaiterOnClick(view);
			}
		});

		btnSignIn.setOnClickListener(new OnClickListener() {

			public void onClick(View view) {
				// TODO Auto-generated method stub
				btnSignInOnClick(view);
			}
		});

	}

	@Override
	public void setContentView(int id) {
		LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(id, layout);
		lblTemp.setText(getTemperature() + "°C");
	}

	public void setHeaderView(int id) {
		layout = (LinearLayout) findViewById(R.id.header_layout);
		setContentView(id);
	}

	public void setTopBarView(int id) {
		layout = (LinearLayout) findViewById(R.id.top_bar_layout);
		setContentView(id);
	}

	public void setBodyView(int id) {
		layout = (LinearLayout) findViewById(R.id.body_layout);
		setContentView(id);
	}

	public void setBottomBarView(int id) {
		layout = (LinearLayout) findViewById(R.id.bottom_nav_layout);
		setContentView(id);
	}

	public void setFooterView(int id) {
		layout = (LinearLayout) findViewById(R.id.footer_layout);
		setContentView(id);
	}

	public void imgBtnLogoOnClick(View view) {

		final Dialog dialog = new Dialog(this);

		dialog.setContentView(R.layout.pin_dialog);
		dialog.setTitle("Enter pin");

		final EditText txtPassword = (EditText) dialog
				.findViewById(R.id.txtPassword);
		final Button btnSubmit = (Button) dialog.findViewById(R.id.btnSubmit);
		final Button btnCancel = (Button) dialog.findViewById(R.id.btnCancel);

		btnSubmit.setOnClickListener(new OnClickListener() {

			public void onClick(View view) { // TODO Auto-generated method stub
				String strPassword = txtPassword.getText().toString();
				if (strPassword.equals("admin")) {
					Intent intent = new Intent().setClass(CustBaseAct.this,
							SocioTouchAct.class);
					startActivity(intent);
				} else {
					Toast toast = Toast.makeText(CustBaseAct.this,
							"Pin is incorrect", Toast.LENGTH_LONG);
					toast.setGravity(Gravity.CENTER, 0, 0);
					toast.show();
				}

			}
		});

		btnCancel.setOnClickListener(new OnClickListener() {

			public void onClick(View view) { // TODO Auto-generated method stub
				dialog.dismiss();
			}
		});

		dialog.show();

	}

	public void btnHomeOnClick(View view) {
		Intent intent = new Intent().setClass(this, CustHomeAct.class);
		startActivity(intent);
	}

	public void btnWaiterOnClick(View view) {

	}

	public void btnSignInOnClick(View view) {
		Intent intent = new Intent().setClass(this, SignInAct.class);
		startActivity(intent);
	}

	private final String DEBUG_TAG = "WeatherForcaster";

	private String getTemperature() {

		try {

			/* Create a URL we want to load some xml-data from. */
			URL url = new URL(
					"http://www.google.com/ig/api?weather=mumbai,india");

			/* Get a SAXParser from the SAXPArserFactory. */
			SAXParserFactory spf = SAXParserFactory.newInstance();
			SAXParser sp = spf.newSAXParser();

			/* Get the XMLReader of the SAXParser we created. */
			XMLReader xr = sp.getXMLReader();
			/* Create a new ContentHandler and apply it to the XML-Reader */
			GoogleWeatherHandler gwh = new GoogleWeatherHandler();
			xr.setContentHandler(gwh);

			/* Parse the xml-data from our URL. */
			xr.parse(new InputSource(url.openStream()));
			/* Parsing has finished. */

			/* Our ExampleHandler now provides the parsed data to us. */
			WeatherSet ws = gwh.getWeatherSet();

			/* Set the result to be displayed in our GUI. */
			return ws.getTemperature();

		} catch (Exception e) {
			/* Display any Error to the GUI. */
			lblTemp.setText("Error: " + e.getMessage());
			Log.e(DEBUG_TAG, "WeatherQueryError", e);
		}

		return null;
	}
}