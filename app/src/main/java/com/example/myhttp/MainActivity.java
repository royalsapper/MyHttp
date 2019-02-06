package com.example.myhttp;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;

    Handler handler = new Handler();

    String urlStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        textView = (TextView) findViewById(R.id.textView);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                urlStr = editText.getText().toString().trim();

                RequestThread thread = new RequestThread();
                thread.start();
            }
        });
    }

    class RequestThread extends Thread {
        public void run() {
            request();
        }

        public void request() {
            try {
                URL url = new URL(urlStr);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void println(final String data) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                textView.append(data + "\n");
            }
        });

    }
}
