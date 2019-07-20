package com.devom.brastlewarkcity.ui.citizens;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.SearchView.OnQueryTextListener;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.devom.brastlewarkcity.R;
import com.devom.brastlewarkcity.adapters.CitizenAdapter;
import com.devom.brastlewarkcity.adapters.CitizenAdapterView;
import com.devom.brastlewarkcity.app.BaseApplication;
import com.devom.brastlewarkcity.model.Citizen;
import com.devom.brastlewarkcity.ui.detail.DetailActivity;
import com.devom.brastlewarkcity.ui.information.InformationActivity;
import com.devom.brastlewarkcity.utils.Constants;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import javax.inject.Inject;

public class CitizensActivity extends AppCompatActivity implements CitizensView, CitizenAdapterView {

    private ProgressBar progressBar;
    private static long back_pressed;
    private static final long SECONDS_LAPSE = 2000;
    private View v;

    @Inject
    CitizensPresenter presenter;

    @Inject
    CitizenAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_citizens);

        ((BaseApplication) getApplication()).plusPresenterSubComponent().inject(this);

        v = findViewById(android.R.id.content);

        progressBar = findViewById(R.id.pb_progress);

        Toolbar toolbar = findViewById(R.id.tb_toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }

        Display display = getWindowManager().getDefaultDisplay();//SizeScreen, obtenemos las medidas del dispositivo para asignar la altura
        Point sizeScreen = new Point();
        display.getSize(sizeScreen);

        adapter.setView(this, sizeScreen.x, 3);//Funge como presenter ya que ahí mismo se encuentra su funcionamiento
        GridLayoutManager layoutManager = new GridLayoutManager(this, 3);//new GridLayoutManager(getContext(), 3);//Setup de layout

        RecyclerView rvCity = findViewById(R.id.rv_city);
        rvCity.setAdapter(adapter);
        rvCity.setLayoutManager(layoutManager);

        presenter.setView(this);
        presenter.getCityData();

    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);

    }

    @Override
    public void setItemsOnAdapters(List<Citizen> citizenList) {
        adapter.setData(citizenList);
    }

    @Override
    public void onFailure(String error) {
        Snackbar snackbar = Snackbar.make(v, error, Snackbar.LENGTH_SHORT);
        View snackView = snackbar.getView();
        TextView textView = snackView.findViewById(com.google.android.material.R.id.snackbar_text);
        textView.setTextColor(getResources().getColor(R.color.colorSecondaryLight));
        snackbar.show();
    }

    @Override
    public void setItemOnClick(Citizen citizen, ImageView ivThumbnail) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(Constants.PARAM_ITEM, citizen);
        ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(this, ivThumbnail, ViewCompat.getTransitionName(ivThumbnail));
        startActivity(intent, optionsCompat.toBundle());
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        if (back_pressed + SECONDS_LAPSE > System.currentTimeMillis()) super.onBackPressed();
        else
            Toast.makeText(getBaseContext(), getText(R.string.msj_exit_app), Toast.LENGTH_SHORT).show();
        back_pressed = System.currentTimeMillis();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_action_search, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);

        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);
        searchView.setOnQueryTextListener(new OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                presenter.setNameToFilter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                presenter.setNameToFilter(newText);
                return false;
            }
        });

        searchView.setOnCloseListener(() -> {
            presenter.setNameToFilter("");
            return false;
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_info) {
            startActivity(new Intent(this, InformationActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}