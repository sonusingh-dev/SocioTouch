package com.socioffice.sociotouch;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

import com.socioffice.sociotouch.model.MenuCategory;
import com.socioffice.sociotouch.model.WebService;

public class MenuCategoryAct extends MenuBaseAct {

	/*private Integer[] mThumbIds = { R.drawable.soup, R.drawable.salad,
			R.drawable.starter, R.drawable.main_course, R.drawable.bread_roti,
			R.drawable.rice };
		
	private String[] mNameIds = { "Soup", "Salad", "Starter", "Main Course",
			"Bread/Roti/Rice", "Bar/Desserts" };*/
	
	private static final String TAG = "MenuCategory";
	private static final String URL = "http://192.168.2.23:8084/sociotouch/webservices/menu_category";
		
	private GridView gridView;
	
	ArrayList<MenuCategory> menuCategoryList;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setBodyView(R.layout.body_grid);		
		super.setBottomBarView(R.layout.bottom_bar_nav);
		
		gridView = (GridView) findViewById(R.id.gridView1);
		gridView.setNumColumns(2);
		getMenuCategories();
				
		gridView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				gridViewOnItemClick(parent, view, position, id);
			}
		});

		gridView.setAdapter(new MenuCategoryAdapter(this, R.layout.menu_category, menuCategoryList));
	}

	public void gridViewOnItemClick(AdapterView<?> parent, View view,
			int position, long id) {
		Intent intent = new Intent().setClass(this, MenuItemAct.class);
		startActivity(intent);
	}
			
	private void getMenuCategories() {

		// JSON object to hold the information, which is sent to the server
		JSONObject jsonObjSend = new JSONObject();
		menuCategoryList = new ArrayList<MenuCategory>();

		try {
			// Add key/value pairs			
			// jsonObjSend.put("id", 3);

			// Add a nested JSONObject (e.g. for header information)
			JSONObject header = new JSONObject();
			header.put("deviceType", "Android"); // Device type
			header.put("deviceVersion", "2.3.3"); // Device OS version
			header.put("language", "es-es"); // Language of the Android client
			jsonObjSend.put("header", header);

			// Output the JSON object we're sending to Logcat:
			// Log.i(TAG, jsonObjSend.toString(2));

			// Send the HttpPostRequest and receive a JSONObject in return
			String result = WebService.sendHttpPost(URL, jsonObjSend);
						
			JSONArray jMenuCateList = new JSONArray(result);
			for (int i = 0; i <= jMenuCateList.length() - 1; i++) {
				JSONObject jMenuCate = jMenuCateList.getJSONObject(i);
				MenuCategory menuCate = new MenuCategory();
				menuCate.setId(jMenuCate.getInt("id"));
				menuCate.setName(jMenuCate.getString("name"));
				menuCategoryList.add(menuCate);
			}
			

		} catch (Exception e) {
			Log.i(TAG, e.getMessage());
			e.printStackTrace();
		}

		/*
		 * From here on do whatever you want with your JSONObject, e.g. 1) Get
		 * the value for a key: jsonObjRecv.get("key"); 2) Get a nested
		 * JSONObject: jsonObjRecv.getJSONObject("key") 3) Get a nested
		 * JSONArray: jsonObjRecv.getJSONArray("key")
		 */

	}
	
}
