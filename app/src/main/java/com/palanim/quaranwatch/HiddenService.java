package com.palanim.quaranwatch;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.os.SystemClock;
import android.widget.Chronometer;

import androidx.annotation.Nullable;


public class HiddenService extends Service {
    //int flag = 0;
    String S;
    int hidflag= MainActivity.flag;

    public static String hidlat = MainActivity.homelat;
    public static String hidlong = MainActivity.homelong;

    LocationManager locationManager;
    LocationListener locationListener;
    Chronometer mChronometer;
    public long lastPause;

    @Override
    public void onCreate() {

        Object context = this;
        mChronometer = (Chronometer)((MainActivity)context).findViewById(R.id.Chronometer);
        locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);

        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {


                // TextView textview =(TextView) findViewById(R.id.textView2);
                // textview.setText(address);

                //Log.i("Location", location.toString());
                if (hidlat == "" || hidlong == "") {
                    return;
                }
                if ((Double.valueOf(hidlat) <= location.getLatitude() && location.getLatitude() <= Double.valueOf(hidlat) + 0.005) || (Double.valueOf(hidlong) <= location.getLatitude() && location.getLatitude() <= Double.valueOf(hidlong) + 0.005)) {
                    if (hidflag == 0) {
                        //Log.i("Location" + "NOT CHANGED", location.toString());
                        lastPause = SystemClock.elapsedRealtime();
                        S = "" + lastPause;
                        // Log.i("Last pause" + "N111", S);
                        mChronometer.stop();
                        hidflag = 1;
                    }
                } else {
                    // Log.i("Location" + "CHANGED", location.toString());
                    if (hidflag == 1) {

                        if (lastPause != 0) {
                            mChronometer.setBase(mChronometer.getBase() + SystemClock.elapsedRealtime() - lastPause);
                        } else {
                            mChronometer.setBase(SystemClock.elapsedRealtime());


                            //Log.i("Location2222" + "CHANGED", location.toString());
                        }
                        mChronometer.start();
                        hidflag = 0;
                    }
                }
            }
            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }


        };
    }


    @Nullable

    public IBinder onBind(Intent intent) {
        return null;
    }


}