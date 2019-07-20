package com.devom.brastlewarkcity.ui.information;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.devom.brastlewarkcity.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class InformationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        TextView tvLink = findViewById(R.id.tv_link);
        tvLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendToLink("https://github.com/devom7022/Brastlewark-City/blob/master/LICENSE");
            }
        });

        FloatingActionButton fabReturn = findViewById(R.id.fab_return);
        fabReturn.setOnClickListener(v -> onBackPressed());

    }

    private void sendToLink(String url) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
    }
}