package com.socioffice.sociotouch;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class SignInAct extends CustBaseAct {
	
	private TextView lblTitle;
	private Button btnCancel;
	private Button btnSignIn;
	private Button btnSignUp;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setBodyView(R.layout.sign_in);
		super.setTopBarView(R.layout.top_bar_nav);
                
        lblTitle = (TextView) findViewById(R.id.lblTitle);
        btnCancel = (Button) findViewById(R.id.btnBack);
		btnSignIn = (Button) findViewById(R.id.btnSignIn);
		btnSignUp = (Button) findViewById(R.id.btnSignUp);
				
		super.btnSignIn.setVisibility(View.GONE);		
		
		lblTitle.setText("Sign In");
		btnCancel.setText("Cancel");
		
		this.btnCancel.setOnClickListener(new OnClickListener() {

			public void onClick(View view) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		
		this.btnSignIn.setOnClickListener(new OnClickListener() {

			public void onClick(View view) {
				// TODO Auto-generated method stub
				btnSignInOnClick(view);
			}
		});

		this.btnSignUp.setOnClickListener(new OnClickListener() {

			public void onClick(View view) {
				// TODO Auto-generated method stub
				btnSignUpOnClick(view);
			}
		});

	}
		
	public void btnSignInOnClick(View view) {
		
	}
	
	public void btnSignUpOnClick(View view) {
		Intent intent = new Intent().setClass(this, SignUpAct.class);
		startActivity(intent);
	}
}
