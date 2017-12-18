package com.example.meetkumarpatel.helix;

<<<<<<< HEAD
<<<<<<< HEAD
import android.Manifest;

import android.app.AlertDialog;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
=======
=======
>>>>>>> origin/master
import com.example.meetkumarpatel.helix.GetNearbyDeals;
import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.app.NotificationManager;
import android.app.PendingIntent;
<<<<<<< HEAD
>>>>>>> 7a76bfd260043ca929aa209d2284af603d746e12
=======
>>>>>>> origin/master
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;

import android.location.LocationListener;

import android.location.LocationManager;
<<<<<<< HEAD
<<<<<<< HEAD
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
=======
=======
>>>>>>> origin/master
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
<<<<<<< HEAD
>>>>>>> 7a76bfd260043ca929aa209d2284af603d746e12
=======
>>>>>>> origin/master
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;
<<<<<<< HEAD
<<<<<<< HEAD
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;

=======
=======
>>>>>>> origin/master
import android.view.View;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
<<<<<<< HEAD
>>>>>>> 7a76bfd260043ca929aa209d2284af603d746e12
=======
>>>>>>> origin/master
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
<<<<<<< HEAD
<<<<<<< HEAD
=======
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
>>>>>>> 7a76bfd260043ca929aa209d2284af603d746e12
=======
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
>>>>>>> origin/master
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

<<<<<<< HEAD
<<<<<<< HEAD
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
=======
import java.io.IOException;
>>>>>>> 7a76bfd260043ca929aa209d2284af603d746e12
=======
import java.io.IOException;
>>>>>>> origin/master
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private GoogleApiClient client;
    private LocationRequest locationRequest;
    private Location lastLocation;
    private Marker currentLocationMarker;
    private LocationListener mLocationListener;
    public static final int PERMISSION_REQUEST_LOCATION_CODE = 99;
    public int PROXIMITY_RADIUS = 10000;
    double latitude, longitude;
    LocationManager locationManager;
    TextView mDisplay;
<<<<<<< HEAD
<<<<<<< HEAD
    private RecyclerView mRecyclerView;
    private DataBinder mAdapter;
    private static final String TAG = MapsActivity.class.getSimpleName();
=======
>>>>>>> 7a76bfd260043ca929aa209d2284af603d746e12
=======
>>>>>>> origin/master


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_maps);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            checkLocationPermission();
        }
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
<<<<<<< HEAD
<<<<<<< HEAD
        //mDisplay = findViewById(R.id.progressBar);
=======
        mDisplay = findViewById(R.id.progressBar);
>>>>>>> 7a76bfd260043ca929aa209d2284af603d746e12
=======
        mDisplay = findViewById(R.id.progressBar);
>>>>>>> origin/master
        mapFragment.getMapAsync(this);
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        if(locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)){
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1000, 100, new android.location.LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                //get latitude
                latitude = location.getLatitude();
                //get longitude
                longitude = location.getLongitude();
                //instantiate the latitude and longitude class
                LatLng latLng = new LatLng(latitude,longitude);
                //Instatiate the class, Geocoder
                Geocoder geocoder = new Geocoder(getApplicationContext());
                try {
                    List<Address> addressList = geocoder.getFromLocation(latitude,longitude,1);
                    String address = addressList.get(0).getLocality()+" ";
                    address += addressList.get(0).getCountryName();
                    mMap.addMarker(new MarkerOptions().position(latLng).title(address));
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,15.2f));
                    String url = getUrl(latitude,longitude,"almond");
                    Object[] dataTransfer = new Object[2];
                    dataTransfer[0] = mMap;
                    dataTransfer[1] = url;
<<<<<<< HEAD
<<<<<<< HEAD
                    new GetNearbyDeals().execute(dataTransfer);
=======

>>>>>>> 7a76bfd260043ca929aa209d2284af603d746e12
=======

>>>>>>> origin/master

                    sendNotification();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }

            @Override
            public void onProviderEnabled(final String s) {

            }

            @Override
            public void onProviderDisabled(String s) {

            }
        });
        }
        else if(locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 100, new android.location.LocationListener() {
                @Override
                public void onLocationChanged(Location location) {
                    //get latitude
                    latitude = location.getLatitude();
                    //get longitude
                    longitude = location.getLongitude();
                    //instantiate the latitude and longitude class
                    LatLng latLng = new LatLng(latitude,longitude);
                    //Instatiate the class, Geocoder
                    Geocoder geocoder = new Geocoder(getApplicationContext());
                    try {
                        List<Address> addressList = geocoder.getFromLocation(latitude,longitude,1);
                        String address = addressList.get(0).getLocality()+" ";
                        address += addressList.get(0).getCountryName();
                        mMap.addMarker(new MarkerOptions().position(latLng).title(address));
                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,15.2f));

                        sendNotification();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onStatusChanged(String s, int i, Bundle bundle) {

                }

                @Override
                public void onProviderEnabled(String s) {

                }

                @Override
                public void onProviderDisabled(String s) {
                    Message msg = handler.obtainMessage();
                    msg.arg1 =1;
                    handler.sendMessage(msg);
                }

                private final Handler handler = new Handler() {
                    public void handleMessage(Message msg) {
                        if (msg.arg1 == 1) {
                            if (!isFinishing()) { // Without this in certain cases application will show ANR
                                AlertDialog.Builder builder = new AlertDialog.Builder(MapsActivity.this);
                                builder.setMessage("Your GPS is disabled! Would you like to enable it?").setCancelable(false).setPositiveButton("Enable GPS", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        Intent gpsOptionsIntent = new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                                        startActivity(gpsOptionsIntent);
                                    }
                                });
                                builder.setNegativeButton("Do nothing", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });
                                AlertDialog alert = builder.create();
                                alert.show();
                            }
                        }
                    }
                };
            });
        }
    }

<<<<<<< HEAD
<<<<<<< HEAD
    public class GetNearbyDeals extends AsyncTask<Object,String,String> {
        GoogleMap mMap;
        String url;
        String googlePlaces;
        TextView mapsActivity;
        ProgressDialog pdLoading = new ProgressDialog(MapsActivity.this);



        @Override
        protected String doInBackground(Object... objects) {

            mMap = (GoogleMap) objects[0];
            url = (String)objects[1];
            String httpData = null;
            InputStream inputStream = null;
            HttpURLConnection urlConnection = null;
            try {
                URL uri = new URL(url);
                urlConnection = (HttpURLConnection) uri.openConnection();
                urlConnection.connect();

                inputStream = urlConnection.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
                StringBuffer sb = new StringBuffer();

                String line ="";
                while((line = br.readLine()) != null){
                    sb.append(line).append('\n');
                }
                httpData = sb.toString();
                br.close();
            } catch (MalformedURLException e) {
                Log.e(TAG,"MalformedURLException: "+ e.getMessage());
            } catch (IOException e) {
                Log.e(TAG,"IOException: "+ e.getMessage());
            }catch (Exception e){
                Log.e(TAG,"Exception: "+ e.getMessage());
            }
            finally {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                urlConnection.disconnect();
            }
            googlePlaces = httpData;
            return googlePlaces;
        }

        @Override
        protected void onPostExecute(String s) {
            List<HashMap<String,String>> nearbyDeals = null;
            List<DataStructure> data = new ArrayList<>();
            DataParser parser = new DataParser();
            nearbyDeals = parser.parse(s);
            for(int i=0;i<nearbyDeals.size();i++){
                HashMap<String,String> googlePlace = nearbyDeals.get(i);

                DataStructure dataStructure = new DataStructure();

                dataStructure.name = googlePlace.get("name");
                dataStructure.itemId = googlePlace.get("itemId");
                dataStructure.msrp = googlePlace.get("msrp");
                dataStructure.sales_price = googlePlace.get("sales_price");
                dataStructure.itemImage = googlePlace.get("itemImage");
                data.add(dataStructure);
            }
            mRecyclerView = (RecyclerView) findViewById(R.id.dataList);
            mRecyclerView.hasFixedSize();
            LinearLayoutManager llm = new LinearLayoutManager(MapsActivity.this);
            mRecyclerView.setLayoutManager(llm);
            mAdapter = new DataBinder(MapsActivity.this, data);
            mRecyclerView.setAdapter(mAdapter);
            mRecyclerView.setLayoutManager(new LinearLayoutManager(MapsActivity.this));

        }
    }

=======
>>>>>>> 7a76bfd260043ca929aa209d2284af603d746e12
=======
>>>>>>> origin/master
    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


    }

    public void sendNotification(){
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.ic_launcher_background)
                        .setWhen(System.currentTimeMillis())
                        .setContentTitle("Location")
                        .setAutoCancel(true)
                        .setContentText(latitude+" "+longitude);
        Intent notificationIntent = new Intent(this, MapsActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this,0,notificationIntent,PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilder.setContentIntent(contentIntent);
        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(001,mBuilder.build());
    }

    public String getUrl(double latitude, double longitude, String query){
        StringBuilder googlePlace = new StringBuilder("http://api.walmartlabs.com/v1/search?apiKey=w6m52dk9j55kr92ubzh47hve");
        googlePlace.append("&query=milk");
        googlePlace.append("&format="+"json");
        googlePlace.append("&facet=on");
        googlePlace.append("&facet.filter="+query);

        return googlePlace.toString();
    }




    public boolean checkLocationPermission(){
        if(ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED){
            if(ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.ACCESS_FINE_LOCATION)){
                ActivityCompat.requestPermissions(this, new  String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSION_REQUEST_LOCATION_CODE);
            }
            else{
                ActivityCompat.requestPermissions(this, new  String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSION_REQUEST_LOCATION_CODE);
            }
            return false;
        }
        else
            return false;
    }

}
