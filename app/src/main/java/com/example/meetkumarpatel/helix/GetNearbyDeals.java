package com.example.meetkumarpatel.helix;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

/**
 * Created by meetkumarpatel on 11/15/17.
 */

public class GetNearbyDeals extends AppCompatActivity{
    GoogleMap mMap;
    String url;
    String googlePlaces;
    TextView mapsActivity;
    private RecyclerView mRecyclerView;
    private DataBinder mAdapter;

    public class AsyncLogin extends AsyncTask<Object,String,String>{
    @Override
    protected String doInBackground(Object... objects) {
        mMap = (GoogleMap) objects[0];
        url = (String)objects[1];
        HttpConnector httpConnector = new HttpConnector();
        try {
            googlePlaces = httpConnector.readUrl(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return googlePlaces;
    }

    @Override
    protected void onPostExecute(String s) {
        List<HashMap<String,String>> nearbyDeals = null;
        List<DataStructure> data = new ArrayList<>();
        DataParser parser = new DataParser();
        nearbyDeals = parser.parse(s);
        data = showNearbyPlaces(nearbyDeals);
        mRecyclerView = (RecyclerView) findViewById(R.id.dataList);
        mAdapter = new DataBinder(GetNearbyDeals.this,data);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(GetNearbyDeals.this));
    }

    private List<DataStructure> showNearbyPlaces(List<HashMap<String,String>> nearbyDealsList){
        List<DataStructure> data = new ArrayList<>();
        for(int i=0;i<nearbyDealsList.size();i++){
            MarkerOptions markerOptions = new MarkerOptions();
            HashMap<String,String> googlePlace = nearbyDealsList.get(i);

            DataStructure dataStructure = new DataStructure();

            dataStructure.name = googlePlace.get("name");
            dataStructure.itemId = googlePlace.get("itemId");
            dataStructure.msrp = googlePlace.get("msrp");
            dataStructure.sales_price = googlePlace.get("sales_price");

            data.add(dataStructure);


            /*double lat = 37.511302;
            double lng = -121.943195;

            LatLng latLng = new LatLng(lat,lng);
            markerOptions.position(latLng);
            markerOptions.title(itemId+" : "+name+" MSRP : "+msrp+" Sales Price : "+salesPrice);
            markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN));
            mMap.addMarker(markerOptions);
            mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
            mMap.animateCamera(CameraUpdateFactory.zoomTo(15));*/
        }
        return data;

    }
}
}
