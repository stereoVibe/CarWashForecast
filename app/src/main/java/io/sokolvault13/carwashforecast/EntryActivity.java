package io.sokolvault13.carwashforecast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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

}
