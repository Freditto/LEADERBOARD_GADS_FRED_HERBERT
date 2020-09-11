package com.example.leaderboard_gads_fred_herbert;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class SubmissionActivity extends AppCompatActivity {

//    WebView formWebview;

    Button submitprojectbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submission);

//        formWebview = (WebView) findViewById(R.id.formWebview);
//
//        webView();;

        submitprojectbtn = (Button)findViewById(R.id.submitProjectBTN);

        submitprojectbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }


//    private void webView(){
//
//        formWebview.getSettings().setJavaScriptEnabled(true);
//
//        formWebview.setWebViewClient(new MyWebViewClient());
//
//        formWebview.loadUrl("https://docs.google.com/forms/d/e/1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/viewform");
//    }
//
//
//    @Override public void onBackPressed() {
//        if(formWebview.canGoBack()) {
//            formWebview.goBack();
//        } else {
//            super.onBackPressed();
//        }
//    }
//
//
//    class MyWebViewClient extends WebViewClient {
//        @Override
//        public boolean shouldOverrideUrlLoading(WebView view, String url) {
//            if (Uri.parse(url).getHost().equals("")) { //Force to open the url in WEBVIEW
//                return false;
//            }
//            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
//            startActivity(intent);
//            return true;
//        }
//    }
}