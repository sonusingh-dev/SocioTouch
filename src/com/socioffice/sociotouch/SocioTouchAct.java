package com.socioffice.sociotouch;

import java.util.ArrayList;

import com.socioffice.sociotouch.model.MenuItem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SocioTouchAct extends Activity {

	private ArrayList<MenuItem> menuItemList;
	private ArrayList<MenuItem> menuOrderList;
	
	private InitializeSocioTouch app;
	
	private EditText txtUserType;
	private EditText txtPassword;
	private Button btnNone;
	private Button btn01;
	private Button btn02;
	private Button btn03;
	private Button btn04;
	private Button btn05;
	private Button btn06;
	private Button btn07;
	private Button btn08;
	private Button btn09;
	private Button btn10;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.main);
		
		menuItemList = new ArrayList<MenuItem>();
		menuOrderList = new ArrayList<MenuItem>();
		app = (InitializeSocioTouch) getApplicationContext();
		app.setMenuItemList(menuItemList);
		app.setMenuOrderList(menuOrderList);
		
		txtUserType = (EditText) findViewById(R.id.txtUserType);
		txtPassword = (EditText) findViewById(R.id.txtPassword);
		btnNone = (Button) findViewById(R.id.btnNone);
		btn01 = (Button) findViewById(R.id.btn01);
		btn02 = (Button) findViewById(R.id.btn02);
		btn03 = (Button) findViewById(R.id.btn03);
		btn04 = (Button) findViewById(R.id.btn04);
		btn05 = (Button) findViewById(R.id.btn05);
		btn06 = (Button) findViewById(R.id.btn06);
		btn07 = (Button) findViewById(R.id.btn07);
		btn08 = (Button) findViewById(R.id.btn08);
		btn09 = (Button) findViewById(R.id.btn09);
		btn10 = (Button) findViewById(R.id.btn10);

		btnNone.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {
				// TODO Auto-generated method stub
				btnNoneOnClick(view);
			}
		});

		btn01.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {
				// TODO Auto-generated method stub
				btnOnClick(view);
			}
		});

		btn02.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {
				// TODO Auto-generated method stub
				btnOnClick(view);
			}
		});

		btn03.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {
				// TODO Auto-generated method stub
				btnOnClick(view);
			}
		});

		btn04.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {
				// TODO Auto-generated method stub
				btnOnClick(view);
			}
		});

		btn05.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {
				// TODO Auto-generated method stub
				btnOnClick(view);
			}
		});

		btn06.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {
				// TODO Auto-generated method stub
				btnOnClick(view);
			}
		});

		btn07.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {
				// TODO Auto-generated method stub
				btnOnClick(view);
			}
		});

		btn08.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {
				// TODO Auto-generated method stub
				btnOnClick(view);
			}
		});

		btn09.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {
				// TODO Auto-generated method stub
				btnOnClick(view);
			}
		});

		btn10.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {
				// TODO Auto-generated method stub
				btnOnClick(view);
			}
		});
	}

	public void btnOnClick(View view) {

		String strUserType = txtUserType.getText().toString();
		String strPassword = txtPassword.getText().toString();

		if(strUserType.equals("") && strPassword.equals("")) {
			Intent intent = new Intent().setClass(SocioTouchAct.this,CustHomeAct.class);
			startActivity(intent);
		} else {
			Toast toast = Toast.makeText(this, "User name or password is incorrect", Toast.LENGTH_LONG);
			toast.setGravity(Gravity.CENTER, 0, 0);
			toast.show();
		}		
		
	}

	public void btnNoneOnClick(View view) {

		Toast toast = Toast.makeText(this, "None is clicked", Toast.LENGTH_LONG);
		toast.setGravity(Gravity.CENTER, 0, 0);
		toast.show();
	}
}