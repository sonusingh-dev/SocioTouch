package com.socioffice.sociotouch;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;

import com.socioffice.sociotouch.model.MenuCategory;

public class MenuCategoryAdapter extends BaseAdapter {

	private int resource;
	private Activity activity;
	private ArrayList<MenuCategory> menuCategoryList;
	
	private Integer[] mThumbIds = { R.drawable.soup, R.drawable.salad,
			R.drawable.starter, R.drawable.main_course, R.drawable.bread_roti,
			R.drawable.rice };

	public MenuCategoryAdapter(Activity activity, int resource,
			ArrayList<MenuCategory> menuCategoryList) {
		this.activity = activity;
		this.resource = resource;
		this.menuCategoryList = menuCategoryList;
	}

	public int getCount() {
		return menuCategoryList.size();
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

		// TextView lblMenuItem = (TextView) view.findViewById(R.id.lblMenuItem);
		ImageButton imgMenuItem = (ImageButton) view.findViewById(R.id.imgBtnMenuCategory);

		// MenuCategory menuCate = menuCategoryList.get(id);
		// lblMenuItem.setText(menuCate.getName());
		imgMenuItem.setImageResource(mThumbIds[id]);

		imgMenuItem.setOnClickListener(new OnClickListener() {

			public void onClick(View view) {
				// TODO Auto-generated method stub
				imgBtnMenuItemOnClick(view, id);
			}
		});

		return view;
	}

	public void imgBtnMenuItemOnClick(View view, int position) {
		String url = "http://192.168.2.23:8084/sociotouch/webservices/menu_item";
		Intent intent = new Intent().setClass(activity, MenuItemAct.class);
		MenuCategory menuCate = menuCategoryList.get(position);
		intent.putExtra("url", url);
		intent.putExtra("id", menuCate.getId());		
		intent.putExtra("name", menuCate.getName());
		activity.startActivity(intent);
	}
}