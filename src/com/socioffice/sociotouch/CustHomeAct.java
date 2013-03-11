package com.socioffice.sociotouch;

import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;

public class CustHomeAct extends CustBaseAct {

	/*private Integer[] mThumbIds = { R.drawable.menu, R.drawable.gallery,
			R.drawable.newspaper, R.drawable.movies, R.drawable.testimonial,
			R.drawable.games, };*/

	private TextView lblTitle;
	

	@Override
	/** Called when the activity is first created. */
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setBodyView(R.layout.body_grid);
		super.setTopBarView(R.layout.top_bar);
		
		lblTitle = (TextView) findViewById(R.id.lblTitle);

		GridView gridView = (GridView) findViewById(R.id.gridView1);
		gridView.setAdapter(new CustHomeAdapter(this, R.layout.cust_item));

		gridView.setNumColumns(2);
		lblTitle.setText("Message");
		btnHome.setVisibility(View.GONE);
		
	}
	
}
