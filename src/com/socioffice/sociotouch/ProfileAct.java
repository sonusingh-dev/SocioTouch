package com.socioffice.sociotouch;

import android.app.LocalActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class ProfileAct extends CustBaseAct {
	
	 TabHost tabHost;
	 TabSpec tab;
		
	@Override
	/** Called when the activity is first created. */
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setBodyView(R.layout.profile);
				
	    tabHost = (TabHost) findViewById(R.id.tabHost);  // The activity TabHost
	    LocalActivityManager mlam = new LocalActivityManager(this, false);
	    mlam.dispatchCreate(savedInstanceState);
	    tabHost.setup(mlam);
	    	    	    
	    Intent intent = new Intent().setClass(this, MyAccountAct.class);

	    // Initialize a TabSpec for each tab and add it to the TabHost
	    tab = tabHost.newTabSpec("myAccount");
	    tab.setIndicator("My Account");
	    tab.setContent(intent);
	    tabHost.addTab(tab);
	    
	    intent.setClass(this, FavoritesAct.class);
	    tab = tabHost.newTabSpec("favorites");
	    tab.setIndicator("Favorites");
	    tab.setContent(intent);
	    tabHost.addTab(tab);
		
	}
	
}