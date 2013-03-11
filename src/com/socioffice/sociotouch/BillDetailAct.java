package com.socioffice.sociotouch;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class BillDetailAct extends MenuBaseAct {
	
	private Button btnCash;
	private Button btnCard;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setBodyView(R.layout.bill_detail);		
		super.setBottomBarView(R.layout.bottom_bar_payment);
                       
		btnCash = (Button) findViewById(R.id.btnCashPay);
		btnCard = (Button) findViewById(R.id.btnCardPay);
		
		lblTitle.setText("Bill Detail");
		btnBack.setText("Cancel");
				
		btnCash.setOnClickListener(new OnClickListener() {

			public void onClick(View view) {
				// TODO Auto-generated method stub
				btnCashOnClick(view);
			}
		});

		btnCard.setOnClickListener(new OnClickListener() {

			public void onClick(View view) {
				// TODO Auto-generated method stub
				btnCardOnClick(view);
			}
		});

	}

	public void btnCashOnClick(View view) {
		// Later on

	}

	public void btnCardOnClick(View view) {
		Intent intent = new Intent().setClass(this, CardPaymentAct.class);
		startActivity(intent);
	}
}
