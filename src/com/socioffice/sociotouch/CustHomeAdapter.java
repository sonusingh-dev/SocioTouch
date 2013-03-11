package com.socioffice.sociotouch;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;

public class CustHomeAdapter extends BaseAdapter {

	private int resource;
	private Activity activity;

	private Integer[] mThumbIds = { R.drawable.menu, R.drawable.gallery,
			R.drawable.newspaper, R.drawable.movies, R.drawable.testimonial,
			R.drawable.games, };

	public CustHomeAdapter(Activity activity, int resource) {
		this.activity = activity;
		this.resource = resource;
	}

	public int getCount() {
		return mThumbIds.length;
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

		ImageButton imgMenuItem = (ImageButton) view.findViewById(R.id.imgBtnCustItem);

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
		if (position == 2) {
			Intent intent = new Intent().setClass(activity, NewsPaperAct.class);
			activity.startActivity(intent);
		} else {
			Intent intent = new Intent().setClass(activity,
					MenuCategoryAct.class);
			activity.startActivity(intent);
		}
	}

}
