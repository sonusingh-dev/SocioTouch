package com.socioffice.sociotouch;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MenuBaseAct extends CustBaseAct {

	protected TextView lblTitle;
	protected EditText txtSearch;
	protected Button btnBack;
	protected Drawable drawable;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTopBarView(R.layout.top_bar_nav);

		lblTitle = (TextView) findViewById(R.id.lblTitle);
		txtSearch = (EditText) findViewById(R.id.txtSearch);
		btnBack = (Button) findViewById(R.id.btnBack);

		drawable = getResources().getDrawable(R.drawable.search);
		drawable.setBounds(0, 0, drawable.getIntrinsicWidth(),
				drawable.getIntrinsicHeight());

		lblTitle.setText("Menu");
		btnBack.setText("Back");
				
		txtSearch.setOnTouchListener(new OnTouchListener() {

			public boolean onTouch(View view, MotionEvent event) {
				// TODO Auto-generated method stub
				txtSearchOnTouch(view, event);
				return false;
			}
		});

		btnBack.setOnClickListener(new OnClickListener() {

			public void onClick(View view) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}

	public void setTopBarView(int id) {
		super.setTopBarView(id);
	}

	public void setBodyView(int id) {
		super.setBodyView(id);
	}

	public void setBottomBarView(int id) {
		super.setBottomBarView(id);
	}

	public boolean txtSearchOnTouch(View v, MotionEvent event) {

		if (txtSearch.getCompoundDrawables() == null) {
			// cross is not being shown so no need to handle
			return false;
		}
		if (event.getAction() != MotionEvent.ACTION_DOWN) {
			// only respond to the down type
			return false;
		}
		if (event.getX() > txtSearch.getMeasuredWidth()
				- txtSearch.getPaddingRight() - drawable.getIntrinsicWidth()) {
			searchMenu();
			return true;
		} else {
			return false;
		}
	}
	
	private void searchMenu() {
		String url = "http://192.168.2.23:8084/sociotouch/webservices/search_menu";
		Intent intent = new Intent().setClass(this, MenuItemAct.class);
		intent.putExtra("url", url);
		intent.putExtra("search", txtSearch.getText().toString());
		intent.putExtra("name", "Search Result");
		startActivity(intent);
	}
}
