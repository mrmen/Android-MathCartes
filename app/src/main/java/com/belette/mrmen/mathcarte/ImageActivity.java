package com.belette.mrmen.mathcarte;

import android.graphics.drawable.Drawable;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Toast;

public class ImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        Bundle b = getIntent().getExtras();
        String carteName = "";
        if(b != null) {
            carteName = b.getString("image");
            WebView webView = (WebView) findViewById(R.id.webView);
            webView.loadDataWithBaseURL("file:///android_asset/", "<img width='100%' src='file:///android_res/drawable/"+carteName+"' />", "text/html", "utf-8", null);
            webView.getSettings().setBuiltInZoomControls(true);
            webView.getSettings().setDisplayZoomControls(true);
        }
        else{
            Toast.makeText(getApplicationContext(), "Une erreur est survenue.",Toast.LENGTH_LONG).show();
            NavUtils.navigateUpFromSameTask(this);
        }
    }
}
