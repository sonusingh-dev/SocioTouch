package com.socioffice.sociotouch;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class SignUpAct extends CustBaseAct {
	
	private TextView lblTitle;
	private Button btnCancel;
	private Button btnSignUp;

	 /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setBodyView(R.layout.sign_up);
		super.setTopBarView(R.layout.top_bar_nav);
                
        lblTitle = (TextView) findViewById(R.id.lblTitle);
        btnCancel = (Button) findViewById(R.id.btnBack);
        
        btnSignUp = (Button) findViewById(R.id.btnSignUp);
            				
		lblTitle.setText("Sign Up");
		btnCancel.setText("Cancel");
				
		this.btnCancel.setOnClickListener(new OnClickListener() {

			public void onClick(View view) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		
		this.btnSignUp.setOnClickListener(new OnClickListener() {

			public void onClick(View view) {
				// TODO Auto-generated method stub
				btnSignUpOnClick(view);
			}
		});
               
    }
        
	public void btnSignUpOnClick(View view) {
		
	}
}
