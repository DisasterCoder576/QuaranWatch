package com.palanim.quaranwatch;


import android.Manifest.permission;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Chronometer;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    static int flag = 0;
    String S;

    public static String homelat ="";
    public static String homelong = "";

    LocationManager locationManager;
    LocationListener locationListener;
    Chronometer mChronometer;
    public long lastPause;


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

            if (ContextCompat.checkSelfPermission(this, permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {

                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
            }
        }
    }

    public void saveData(View view) {

        if (checkSelfPermission(permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    Activity#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for Activity#requestPermissions for more details.
            return;
        }


            Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            SharedPreferences sharedPreferences = this.getSharedPreferences("com.palanim.sharedpreferences", Context.MODE_PRIVATE);
            String text1 = String.valueOf(location.getLatitude());
            String text2 = String.valueOf(location.getLongitude());
            sharedPreferences.edit().putString("latitude", text1).apply();
            sharedPreferences.edit().putString("longitude", text2).apply();
            homelat = sharedPreferences.getString("latitude", "");
            homelong = sharedPreferences.getString("longitude", "");
            Log.i("Latitude1111", homelat);
            Log.i("Longitude1111", homelong);






    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mChronometer = (Chronometer) findViewById(R.id.Chronometer);
        locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);

        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                Geocoder geocoder = new Geocoder(getApplicationContext(), Locale.getDefault());

                try {

                    String address = "Could not find address";

                    List<Address> listAddresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);

                    if (listAddresses != null && listAddresses.size() > 0 ) {

                        Log.i("PlaceInfo", listAddresses.get(0).toString());

                        address = "Address: \n";

                        if (listAddresses.get(0).getSubThoroughfare() != null) {

                            address += listAddresses.get(0).getSubThoroughfare() + " ";

                        }

                        if (listAddresses.get(0).getThoroughfare() != null) {

                            address += listAddresses.get(0).getThoroughfare() + "\n";

                        }

                        if (listAddresses.get(0).getLocality() != null) {

                            address += listAddresses.get(0).getLocality() + "\n";

                        }

                        if (listAddresses.get(0).getPostalCode() != null) {

                            address += listAddresses.get(0).getPostalCode() + "\n";

                        }

                        if (listAddresses.get(0).getCountryName() != null) {

                            address += listAddresses.get(0).getCountryName() + "\n";

                        }

                    }

                    TextView addressTextView = (TextView) findViewById(R.id.textView2);

                    addressTextView.setText(address);


                } catch (IOException e) {

                    e.printStackTrace();

                }
               // TextView textview =(TextView) findViewById(R.id.textView2);
               // textview.setText(address);

                //Log.i("Location", location.toString());
                if(homelat=="" || homelong== ""){
                    return;
                }
                if ((Double.valueOf(homelat) <= location.getLatitude() && location.getLatitude() <= Double.valueOf(homelat)+0.005) ||(Double.valueOf(homelong) <= location.getLatitude() && location.getLatitude() <= Double.valueOf(homelong)+0.005) ) {
                    if(flag==0) {
                        //Log.i("Location" + "NOT CHANGED", location.toString());
                        lastPause = SystemClock.elapsedRealtime();
                        S = "" + lastPause;
                       // Log.i("Last pause" + "N111", S);
                        mChronometer.stop();
                        flag = 1;
                    }
                }  else {
                   // Log.i("Location" + "CHANGED", location.toString());
                    if(flag==1) {

                    if (lastPause != 0) {
                        mChronometer.setBase(mChronometer.getBase() + SystemClock.elapsedRealtime() - lastPause);
                    } else {
                        mChronometer.setBase(SystemClock.elapsedRealtime());


                        //Log.i("Location2222" + "CHANGED", location.toString());
                    }
                    mChronometer.start();
                    flag=0;
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

        } ;

        if(ContextCompat.checkSelfPermission(this,permission.ACCESS_FINE_LOCATION)!=PackageManager.PERMISSION_GRANTED)

            {
                ActivityCompat.requestPermissions(this, new String[]{permission.ACCESS_FINE_LOCATION}, 1);
            } else {
            if (checkSelfPermission(permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    Activity#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for Activity#requestPermissions for more details.
                return;
            }
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
            //Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);


        }


    }
}
