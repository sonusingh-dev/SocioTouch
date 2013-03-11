package com.socioffice.sociotouch;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.GridView;

public class OrderDetailAct extends MenuBaseAct {
		
	private Button btnConfirmOrder;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setBodyView(R.layout.body_grid);		
		super.setBottomBarView(R.layout.bottom_bar_nav);
		
		btnConfirmOrder = (Button) findViewById(R.id.btnOrder);

		GridView gridView = (GridView) findViewById(R.id.gridView1);		
		gridView.setAdapter(new OrderDetailAdapter(this, R.layout.ordered_item));

		lblTitle.setText("Order Detail");
		btnBack.setText("Back");
		btnConfirmOrder.setText("Confirm Order");
		gridView.setNumColumns(1);
		
		btnBack.setOnClickListener(new OnClickListener() {

			public void onClick(View view) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		
		btnConfirmOrder.setOnClickListener(new OnClickListener() {

			public void onClick(View view) {
				// TODO Auto-generated method stub
				btnConfirmOrderOnClick(view);
			}
		});
	}
	
	public void btnConfirmOrderOnClick(View view) {
		Intent intent = new Intent().setClass(this, BillDetailAct.class);
		startActivity(intent);
	}
		
}
