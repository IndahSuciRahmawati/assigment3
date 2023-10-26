package com.example.assigment3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView casesDataTv, recoveredDataTv, deatsDataTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        casesDataTv = findViewById(R.id.total_casses);
        recoveredDataTv = findViewById(R.id.total_recovered);
        deatsDataTv = findViewById(R.id.total_deaths);

        getDataCovid();

    }

    private void getDataCovid() {
        Call<CovidData> callDataCovid = RetrofitClient.getInstance().myApi().getCovidData();
        callDataCovid.enqueue(new Callback<CovidData>() {
            @Override
            public void onResponse(Call<CovidData> call, Response<CovidData> response) {
                CovidData data = response.body();
                casesDataTv.setText(String.valueOf(data.getCases()));
                recoveredDataTv.setText(String.valueOf(data.getRecovered()));
                deatsDataTv.setText(String.valueOf(data.getDeaths()));
            }

            @Override
            public void onFailure(Call<CovidData> call, Throwable t) {

            }
        });
    }
}