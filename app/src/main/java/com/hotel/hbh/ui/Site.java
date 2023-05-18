package com.hotel.hbh.ui;

import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.hotel.hbh.R;

public class Site extends AppCompatActivity {
    WebView webView;
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_site);

        webView = (WebView) findViewById(R.id.webView);
        // loadUrl
        webView.loadUrl("https://www.hotel-benihamad.dz/");
        webView.setWebViewClient(new WebViewClient());


        WebSettings webSettings = webView.getSettings();
        // سماح للجافا  سكربت بالعمل
        webSettings.setJavaScriptEnabled(true);
        // لسماح لتحزين
        webSettings.setDomStorageEnabled(true);
        // لتمكين اعدادت viewPort
        webSettings.setUseWideViewPort(true);

        webSettings.setAllowContentAccess(true);
        webSettings.setAllowFileAccess(true);

        webSettings.setDisplayZoomControls(true);
        webSettings.setSupportZoom(true);

    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()){
            webView.goBack();
            return  true;
        }
        return super.onKeyDown(keyCode, event);
    }
}