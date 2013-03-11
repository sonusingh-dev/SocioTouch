package com.socioffice.sociotouch;

import java.util.ArrayList;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.socioffice.sociotouch.model.MenuItem;

public class OrderDetailAdapter extends BaseAdapter {

	private Activity activity;
	private int resource;
	private InitializeSocioTouch app;
	private ArrayList<MenuItem> menuOrderList;

	public OrderDetailAdapter(Activity activity, int resource) {
		this.activity = activity;
		this.resource = resource;
		init();
	}

	public void init() {
		app = (InitializeSocioTouch) activity.getApplicationContext();
		ArrayList<MenuItem> menuItemList = app.getMenuItemList();
		menuOrderList = new ArrayList<MenuItem>();
		for (MenuItem menuItem : menuItemList) {
			if (menuItem.isOrdered()) {
				menuOrderList.add(menuItem);
			}
		}
	}

	public int getCount() {
		// TODO Auto-generated method stub
		return menuOrderList.size();
	}

	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub

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

		EditText txtQ = (EditText) view.findViewById(R.id.txtQ);

		ImageButton imgBtnItem = (ImageButton) view.findViewById(R.id.imgBtnItem);
		ImageButton imgBtnUp = (ImageButton) view.findViewById(R.id.imgBtnUp);
		ImageButton imgBtnDown = (ImageButton) view.findViewById(R.id.imgBtnDown);
		
		MenuItem menuItem = menuOrderList.get(id);

		lblMenuName.setText(menuItem.getName());
		lblMenuDesc.setText(menuItem.getDesc());
		
		txtQ.setTag(position);
		txtQ.setText(String.valueOf(menuItem.getQnty()));
		
		if (menuItem.getType().equals("V")) {
			imgMenuType.setImageResource(R.drawable.veg);
		} else {
			imgMenuType.setImageResource(R.drawable.non_veg);
		}

		imgBtnUp.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				imgBtnUpOnClick(view, id);
			}
		});

		imgBtnDown.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				imgBtnDownOnClick(view, id);
			}
		});

		imgBtnItem.setOnClickListener(new OnClickListener() {

			public void onClick(View view) {
				// TODO Auto-generated method stub
				imgBtnItemOnClick(view, id);
			}
		});

		return view;
	}

	public void imgBtnUpOnClick(View view, int position) {
		
		EditText txtQ = (EditText) view.findViewWithTag(position);
		String strQ = txtQ.getText().toString();
		int q = Integer.parseInt(strQ);
		if (q >= 10) {
			q = 0;
		}
		q++;
		txtQ.setText(String.valueOf(q));
		updateOrderList(position, q);

	}

	public void imgBtnDownOnClick(View view, int position) {
		
		EditText txtQ = (EditText) view.findViewWithTag(position);
		String strQ = txtQ.getText().toString();
		int q = Integer.parseInt(strQ);
		if (q <= 1) {
			q = 10;
		}
		q--;
		txtQ.setText(String.valueOf(q));
		updateOrderList(position, q);
				
	}
	
	public void updateOrderList(int id, int q) {
		MenuItem menuItem = menuOrderList.get(id);
		menuItem.setQnty(q);
		menuOrderList.set(id, menuItem);
		app.setMenuOrderList(menuOrderList);
	}
	
	public void imgBtnItemOnClick(View view, int position) {
		/*Intent intent = new Intent().setClass(activity, MenuDetailAct.class);
		activity.startActivity(intent);*/
	}
}
