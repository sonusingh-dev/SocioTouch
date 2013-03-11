package com.socioffice.sociotouch;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.socioffice.sociotouch.model.MenuItem;

public class MenuItemAdapter extends BaseAdapter {

	private Activity activity;
	private int resource;
	private InitializeSocioTouch app;
	private ArrayList<MenuItem> menuItemList;

	public MenuItemAdapter(Activity activity, int resource, ArrayList<MenuItem> menuItemList) {
		this.activity = activity;
		this.resource = resource;
		this.menuItemList = menuItemList;
		init();
	}

	public void init() {
		app = (InitializeSocioTouch) activity.getApplicationContext();
		menuItemList = app.getMenuItemList();
	}

	public int getCount() {
		return menuItemList.size();
	}

	public Object getItem(int position) {
		return null;
	}

	public long getItemId(int position) {
		return 0;
	}

	// create a new ImageView for each item referenced by the Adapter
	public View getView(int position, View convertView, ViewGroup parent) {

		final int id = position;
		final View view;
		final LayoutInflater inflater;

		if (convertView == null) {

			inflater = activity.getLayoutInflater();
			view = inflater.inflate(resource, null);

		} else {
			view = convertView;
		}

		TextView lblMenuName = (TextView) view.findViewById(R.id.lblMenuName);
		TextView lblMenuDesc = (TextView) view.findViewById(R.id.lblMenuDesc);
		ImageView imgMenuType = (ImageView) view.findViewById(R.id.imgMenuType);
		ImageButton imgBtnItem = (ImageButton) view.findViewById(R.id.imgBtnItem);
		ToggleButton btnPriceOrdered = (ToggleButton) view.findViewById(R.id.btnPriceOrdered);

		MenuItem menuItem = menuItemList.get(id);
		lblMenuName.setText(menuItem.getName());
		lblMenuDesc.setText(menuItem.getDesc());

		btnPriceOrdered.setText("Rs - " + String.valueOf(menuItem.getPrice()));
		btnPriceOrdered.setTextOff("Rs - " + String.valueOf(menuItem.getPrice()));

		if (menuItem.getType().equals("V")) {
			imgMenuType.setImageResource(R.drawable.veg);
		} else {
			imgMenuType.setImageResource(R.drawable.non_veg);
		}

		imgBtnItem.setOnClickListener(new OnClickListener() {

			public void onClick(View view) {
				// TODO Auto-generated method stub
				imgBtnItemOnClick(view, id);
			}
		});

		btnPriceOrdered.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					public void onCheckedChanged(CompoundButton buttonView,
							boolean isChecked) {
						// TODO Auto-generated method stub
						btnPriceOrderedonCheckedChanged(buttonView, isChecked,
								id);
					}
				});

		return view;
	}

	public void imgBtnItemOnClick(View view, int position) {

		app.setMenuItemList(menuItemList);
		Intent intent = new Intent().setClass(activity, MenuDetailAct.class);
		intent.putExtra("id", position);
		activity.startActivity(intent);

	}

	public void btnPriceOrderedonCheckedChanged(CompoundButton buttonView,
			boolean isChecked, int position) {

		MenuItem menuItem = menuItemList.get(position);
		menuItem.setOrdered(isChecked);
		menuItemList.set(position, menuItem);
		app.setMenuItemList(menuItemList);

	}
}