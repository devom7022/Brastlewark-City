package com.devom.brastlewarkcity.ui.detail;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.devom.brastlewarkcity.R;
import com.devom.brastlewarkcity.adapters.SimpleItemAdapter;
import com.devom.brastlewarkcity.model.Citizen;
import com.devom.brastlewarkcity.utils.Constants;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.zolad.zoominimageview.ZoomInImageView;

public class DetailActivity extends AppCompatActivity {
    private static String TAG = DetailActivity.class.getSimpleName();
    private Citizen citizen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Toolbar toolbar = findViewById(R.id.tb_toolbar);

        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        Bundle params = getIntent().getExtras();
        if (params != null) {
            citizen = params.getParcelable(Constants.PARAM_ITEM);
            Log.d(TAG, citizen.toString());
        }

        ZoomInImageView ivProfile = findViewById(R.id.iv_profile);
        Glide
                .with(this)
                .load(citizen.getThumbnail())
                .apply(RequestOptions.circleCropTransform())
                .placeholder(R.drawable.item_blank_state)
                .into(ivProfile);

        FloatingActionButton fabReturn = findViewById(R.id.fab_return);
        fabReturn.setOnClickListener(v -> onBackPressed());

        TextView tvTitle = findViewById(R.id.tv_title);
        tvTitle.setText(citizen.getName());

        TextView tvValAge = findViewById(R.id.tv_val_age);
        tvValAge.setText(String.valueOf(citizen.getAge()));

        TextView tvValHair = findViewById(R.id.tv_val_hair);
        tvValHair.setText(citizen.getHairColor() == null ? getString(R.string.not_register) : citizen.getHairColor());

        RecyclerView rvFriends = findViewById(R.id.rv_friends);
        if (citizen.getFriends() != null) {
            SimpleItemAdapter adapterF = new SimpleItemAdapter(citizen.getFriends());
            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            rvFriends.setLayoutManager(layoutManager);
            rvFriends.setAdapter(adapterF);

        }

        RecyclerView rvProfessions = findViewById(R.id.rv_professions);
        if (citizen.getProfessions() != null) {
            SimpleItemAdapter adapterP = new SimpleItemAdapter(citizen.getProfessions());
            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            rvProfessions.setLayoutManager(layoutManager);
            rvProfessions.setAdapter(adapterP);

        }
    }
}
