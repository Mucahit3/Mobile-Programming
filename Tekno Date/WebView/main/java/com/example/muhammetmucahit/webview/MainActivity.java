package com.example.muhammetmucahit.webview;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        WebView webView = new WebView(context);
//        WebSettings webSettings = webView.getSettings();
//        webSettings.setBuiltInZoomControls(true);
//        webSettings.setJavaScriptEnabled(true);
//        webView.loadUrl("http://www.nefisyemektarifleri.com/");
//        setContentView(webView);

//        WebView webView = new WebView(context);
//        WebSettings webSettings = webView.getSettings();
//        webSettings.setBuiltInZoomControls(true);
//        webSettings.setJavaScriptEnabled(true);
//        String data =
//        "<html>\n" +
//	        "\t<body>\n" +
//                "\t\t<a href=\"http://www.nefisyemektarifleri.com/\" target = \"_blank\">Nefis Yemek Tarifleri</a>\n" +
//                "\t</body>\t\n" +
//                "\n" +
//                "</html>";
//        String mime = "text/html";
//        String encoding = "utf-8";
//
//        webView.loadData(data, mime, encoding);
//        setContentView(webView);

        WebView webView = new WebView(context);
        WebSettings webSettings = webView.getSettings();
        webSettings.setBuiltInZoomControls(true);
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new Client());
        Resources res = this.getResources();

        String line = "";
        String data = "";
        String mime = "text/html";
        String encoding = "utf-8";

        try {
            InputStream stream = res.openRawResource(R.raw.file);
            InputStreamReader isr = new InputStreamReader(stream);
            BufferedReader buffer = new BufferedReader(isr);


            while (true) {

                line = buffer.readLine();
                if (line != null) {
                    data += line;
                } else {
                    break;
                }

            }
            buffer.close();
            isr.close();
            stream.close();
            webView.loadData(data, mime, encoding);
            setContentView(webView);
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public class Client extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return false;
        }
    }
}
