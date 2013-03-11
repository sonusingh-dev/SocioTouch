package com.socioffice.sociotouch;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.GridView;

import com.socioffice.sociotouch.model.MenuItem;
import com.socioffice.sociotouch.model.WebService;

public class MenuItemAct extends MenuBaseAct {

	private static final String TAG = "MenuCategory";
	
	private int id;
	private int position;
	private String url;
	private String title;
	private String search;
		
	private Button btnOrder;
	private Button btnNext;
	private Button btnPre;
	private GridView gridView;

	private InitializeSocioTouch app;
	private ArrayList<MenuItem> menuItemList;
		
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setBodyView(R.layout.body_grid);		
		super.setBottomBarView(R.layout.bottom_bar_nav);
		
		id = getIntent().getIntExtra("id", 1);
		url = getIntent().getStringExtra("url");
		title = getIntent().getStringExtra("name");
		search = getIntent().getStringExtra("search");
		
		app = (InitializeSocioTouch) getApplicationContext();
		getMenuItemList();
		
		btnOrder = (Button) findViewById(R.id.btnOrder);
		btnNext = (Button) findViewById(R.id.btnNext);
		btnPre = (Button) findViewById(R.id.btnPre);

		gridView = (GridView) findViewById(R.id.gridView1);

		lblTitle.setText(title);
		btnBack.setText("Back");
		btnOrder.setText("Order");
		gridView.setNumColumns(2);

		gridView.setAdapter(new MenuItemAdapter(this, R.layout.menu_item, menuItemList));
		
		btnBack.setOnClickListener(new OnClickListener() {

			public void onClick(View view) {
				// TODO Auto-generated method stub				
				finish();
			}
		});

		btnOrder.setOnClickListener(new OnClickListener() {

			public void onClick(View view) {
				// TODO Auto-generated method stub
				btnOrderOnClick(view);
			}
		});

		btnNext.setOnClickListener(new OnClickListener() {

			public void onClick(View view) {
				// TODO Auto-generated method stub
				btnNext(view);
			}
		});

		btnPre.setOnClickListener(new OnClickListener() {

			public void onClick(View view) {
				// TODO Auto-generated method stub
				btnPre(view);
			}
		});

		
	}

	public void btnOrderOnClick(View view) {
		Intent intent = new Intent().setClass(this, OrderDetailAct.class);
		startActivity(intent);
	}

	private void getMenuItemList() {

		// JSON object to hold the information, which is sent to the server
		JSONObject jsonObjSend = new JSONObject();
		menuItemList = new ArrayList<MenuItem>();

		try {
			// Add key/value pairs			
			jsonObjSend.put("id", id);
			jsonObjSend.put("search", search);

			// Add a nested JSONObject (e.g. for header information)
			JSONObject header = new JSONObject();
			header.put("deviceType", "Android"); // Device type
			header.put("deviceVersion", "2.3.3"); // Device OS version
			header.put("language", "es-es"); // Language of the Android client
			jsonObjSend.put("header", header);

			// Output the JSON object we're sending to Logcat:
			// Log.i(TAG, jsonObjSend.toString(2));

			// Send the HttpPostRequest and receive a JSONObject in return
			String result = WebService.sendHttpPost(url, jsonObjSend);

			/*
			 * From here on do whatever you want with your JSONObject, e.g. 1)
			 * Get the value for a key: jsonObjRecv.get("key"); 2) Get a nested
			 * JSONObject: jsonObjRecv.getJSONObject("key") 3) Get a nested
			 * JSONArray: jsonObjRecv.getJSONArray("key")
			 */
			JSONArray jMenuItemList = new JSONArray(result);
			for (int i = 0; i <= jMenuItemList.length() - 1; i++) {
				JSONObject jMenuItem = jMenuItemList.getJSONObject(i);
				MenuItem menuItem = new MenuItem();
				menuItem.setId(jMenuItem.getInt("id"));
				menuItem.setName(jMenuItem.getString("name"));
				menuItem.setType(jMenuItem.getString("type"));
				menuItem.setPrice(jMenuItem.getInt("price"));
				menuItem.setDesc(jMenuItem.getString("desc"));
				menuItemList.add(menuItem);
			}

			app.setMenuItemList(menuItemList);

		} catch (Exception e) {
			Log.i(TAG, e.getMessage());
			e.printStackTrace();
		}

	}

	public void btnNext(View view) {
		for (int count = position; count <= position + 5; count++) {

		}
	}

	public void btnPre(View view) {
		for (int count = position; count >= position - 5; count--) {

		}
	}

	public void updatedView(int position) {

	}

}
