package com.socioffice.sociotouch;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

public class NewsPaperAct extends CustBaseAct {
	
	private TextView lblTitle;
	private Button btnCancel;
	private WebView mWebView;
	
	@Override
	/** Called when the activity is first created. */    
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setBodyView(R.layout.news);
        super.setTopBarView(R.layout.top_bar_nav);
               
        btnCancel = (Button) findViewById(R.id.btnBack);
        lblTitle = (TextView) findViewById(R.id.lblTitle);
               
        mWebView = (WebView) findViewById(R.id.webview);
        mWebView.getSettings().setJavaScriptEnabled(true);              
        mWebView.loadUrl("http://timesofindia.indiatimes.com");
        mWebView.setWebViewClient(new NewsWebViewClient());

        lblTitle.setText("News Paper");
		btnCancel.setText("Back");
    }

	private class NewsWebViewClient extends WebViewClient {
	    @Override
	    public boolean shouldOverrideUrlLoading(WebView view, String url) {
	        view.loadUrl(url);
	        return true;
	    }
	}
}
