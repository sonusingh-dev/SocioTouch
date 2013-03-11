package com.socioffice.sociotouch;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.socioffice.sociotouch.model.MenuItem;

public class MenuDetailAct extends MenuBaseAct {

	private int id;
	private boolean ordered;
	private MenuItem menuItem;
	private InitializeSocioTouch app;
	private ArrayList<MenuItem> menuItemList;

	// Body widgets
	private TextView lblMenuName;
	private TextView lblMenuDesc;
	private ImageView imgMenuType;
	private ToggleButton btnPriceOrdered;

	// Bottom bar widgets
	private Button btnPre;
	private Button btnNext;
	private Button btnOrder;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setBodyView(R.layout.menu_detail);		
		super.setBottomBarView(R.layout.bottom_bar_nav);

		app = (InitializeSocioTouch) getApplicationContext();
		menuItemList = app.getMenuItemList();
		id = getIntent().getIntExtra("id", 1);

		// Top Bar widgets
		lblTitle.setText("Menu Detail");
		btnBack.setText("Back");

		this.btnBack.setOnClickListener(new OnClickListener() {

			public void onClick(View view) {
				// TODO Auto-generated method stub
				finish();
			}
		});

		// Body widgets
		lblMenuName = (TextView) findViewById(R.id.lblMenuName);
		lblMenuDesc = (TextView) findViewById(R.id.lblMenuDesc);
		imgMenuType = (ImageView) findViewById(R.id.imgMenuType);
		btnPriceOrdered = (ToggleButton) findViewById(R.id.btnPriceOrdered);
		
		btnPriceOrdered.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			public void onCheckedChanged(CompoundButton buttonView,	boolean isChecked) {
			// TODO Auto-generated method stub
				btnPriceOrderedOnCheckedChanged(buttonView, isChecked);
			}
		});

		// Bottom bar widgets
		btnPre = (Button) findViewById(R.id.btnPre);
		btnNext = (Button) findViewById(R.id.btnNext);
		btnOrder = (Button) findViewById(R.id.btnOrder);
		btnOrder.setText("Order");

		btnPre.setOnClickListener(new OnClickListener() {

			public void onClick(View view) {
				// TODO Auto-generated method stub
				id--;
				if (id < 0) {
					id = menuItemList.size() - 1;
				}
				updateView(id);
			}
		});

		btnNext.setOnClickListener(new OnClickListener() {

			public void onClick(View view) {
				// TODO Auto-generated method stub
				id++;
				if (id > menuItemList.size() - 1) {
					id = 0;
				}
				updateView(id);
			}
		});

		btnOrder.setOnClickListener(new OnClickListener() {

			public void onClick(View view) {
				// TODO Auto-generated method stub
				Intent intent = new Intent().setClass(MenuDetailAct.this, OrderDetailAct.class);
				startActivity(intent);
			}
		});

		updateView(id);
	}

	public void btnPriceOrderedOnCheckedChanged(CompoundButton buttonView,
			boolean isChecked) {

		MenuItem menuItem = menuItemList.get(id);
		menuItem.setOrdered(isChecked);
		menuItemList.set(id, menuItem);
		app.setMenuItemList(menuItemList);

	}

	private void updateView(int id) {

		menuItem = menuItemList.get(id);
		lblMenuName.setText(menuItem.getName());
		lblMenuDesc.setText(menuItem.getDesc());
		btnPriceOrdered.setText("Rs - " + String.valueOf(menuItem.getPrice()));
		btnPriceOrdered.setTextOff("Rs - "
				+ String.valueOf(menuItem.getPrice()));

		ordered = menuItem.isOrdered();
		if (ordered) {
			btnPriceOrdered.setChecked(ordered);
		}

		if (menuItem.getType().equals("V")) {
			imgMenuType.setImageResource(R.drawable.veg);
		} else {
			imgMenuType.setImageResource(R.drawable.non_veg);
		}

	}
}
