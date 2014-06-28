package com.francescovitullo.polymeronandroid;

import com.francescovitullo.polymeronandroid.R;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {

	private WebView mWebView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mWebView = (WebView) findViewById(R.id.webview);
		mWebView.setWebViewClient(new WebViewClient());

		WebSettings webSettings = mWebView.getSettings();
		webSettings.setJavaScriptEnabled(true);
		webSettings.setAllowFileAccessFromFileURLs(true);

		if (savedInstanceState != null)
		{
			mWebView.restoreState(savedInstanceState);
		}
		else
		{
			mWebView.loadUrl("file:///android_asset/app/index.html");
		}
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		if(mWebView != null)
			mWebView.saveState(outState);
	}
}
