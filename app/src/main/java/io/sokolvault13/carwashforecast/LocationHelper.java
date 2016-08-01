package io.sokolvault13.carwashforecast;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.app.ActivityCompat;
import android.util.Log;

public class LocationHelper implements LocationListener {
    private static final long TEN_MINUTES = 10 * 60 * 1000;
    private double mLatitude;
    private double mLongitude;

    private Context mContext;
    private LocationManager mLocationManager;
    private String mProvider;

    private LocationHelper(Context context) {
        mContext = context;
        mLocationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
    }

    public static LocationHelper newInstance(Context context) {
        return new LocationHelper(context);
    }

    public double getLatitude() {
        return mLatitude;
    }

    public double getLongitude() {
        return mLongitude;
    }

    public void requestLocationUpdates() {
        Criteria criteria = new Criteria();
        mProvider = mLocationManager.getBestProvider(criteria, false);

        if (ActivityCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }

        Location location = mLocationManager.getLastKnownLocation(mProvider);
        if (location != null) {
            onLocationChanged(location);
        }
        mLocationManager.requestLocationUpdates(mProvider, TEN_MINUTES, 1000f, this, Looper.myLooper());
    }

    @Override
    public void onLocationChanged(Location location) {
        String TAG = "onLocationChanged";
        this.mLatitude = location.getLatitude();
        this.mLongitude = location.getLongitude();
        Log.d(TAG, String.valueOf(mLatitude));
        Log.d(TAG, String.valueOf(mLongitude));
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }

    public void removeUpdates() throws SecurityException {
        mLocationManager.removeUpdates(this);
    }
}
