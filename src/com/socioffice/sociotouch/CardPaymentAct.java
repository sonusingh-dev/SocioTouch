package com.socioffice.sociotouch;

import android.os.Bundle;

public class CardPaymentAct extends MenuBaseAct {
	
		
	@Override
	/** Called when the activity is first created. */    
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setBodyView(R.layout.card_payment);
                                  
        lblTitle.setText("Card Payment");
		btnBack.setText("Cancel");
				
    }
}
