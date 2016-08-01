package io.sokolvault13.carwashforecast;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

import io.sokolvault13.carwashforecast.ParserObjects.Daily;
import io.sokolvault13.carwashforecast.ParserObjects.WeatherData;

public class EntryActivity extends AppCompatActivity {
    private final static String TAG = "Entry Activity";
    LocationHelper locationHelper;
    double mLatitude, mLongitude;
    Button mGetCoordinatesBtn;
    TextView mLongitudeText, mLatitudeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry);
        locationHelper  = LocationHelper.newInstance(this);
        getCoordinates(locationHelper);

        mGetCoordinatesBtn = (Button) findViewById(R.id.get_coordinates_btn);
        mLatitudeText = (TextView) findViewById(R.id.latidue_text);
        mLongitudeText = (TextView) findViewById(R.id.longitude_text);

        setUI();

        mGetCoordinatesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getCoordinates(locationHelper);
                mLongitudeText.setText(String.valueOf(mLongitude));
                mLatitudeText.setText(String.valueOf(mLatitude));
            }
        });

        String result = TestRawData.RAW_DATA;
        Gson gson = new Gson();
        WeatherData weatherData = gson.fromJson(result, WeatherData.class);
        Log.d(TAG, String.valueOf(gson.fromJson(result, WeatherData.class).toString()));
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (locationHelper != null) {
            locationHelper.removeUpdates();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (locationHelper != null) {
            locationHelper.requestLocationUpdates();
            setUI();
        }

    }

    private void getCoordinates(LocationHelper locationHelper) {
        locationHelper.requestLocationUpdates();
        mLatitude = locationHelper.getLatitude();
        mLongitude = locationHelper.getLongitude();
    }

    private void setUI(){
        mLongitudeText.setText(String.valueOf(mLongitude));
        mLatitudeText.setText(String.valueOf(mLatitude));
    }

    private class FetchDataTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            String result = TestRawData.RAW_DATA;

            Gson gson = new Gson();

            return gson.fromJson(result, Daily.class).toString();
        }
    }

}
