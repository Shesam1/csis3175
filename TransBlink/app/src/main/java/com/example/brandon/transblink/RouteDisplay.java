package com.example.brandon.transblink;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class RouteDisplay extends AppCompatActivity {
    public int themeSel;
    ArrayList<Station> pathStations;
    Station[] routeStations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent =  getIntent();
        ThemeChange themeChg = new ThemeChange();
        themeSel = themeChg.findTheme(this);
        setTheme(themeSel);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route_display);

        ListView listViewSelectedRoute = (ListView)findViewById(R.id.listViewStationByStationRoute);
        String caller = (String)intent.getSerializableExtra("caller");
        Path path = (Path)intent.getSerializableExtra("route");
        pathStations = path.pathStops;

        for(int i=0; i< pathStations.size(); i++) {
            Log.i("RouteDisplay route :", pathStations.get(i).getFullName());
        }

        routeStations = new Station[pathStations.size()];
        pathStations.toArray(routeStations);

        ListStationAdapater adapter = new ListStationAdapater(this, routeStations, ListStationAdapater.DISP.ROUTE_DISPLAY);
        listViewSelectedRoute.setAdapter(adapter);

        adapter.notifyDataSetChanged();

    }

    public void drawRouteOnMap(View v){
        Intent intent = new Intent(RouteDisplay.this, MapsActivity.class);

        intent.putExtra("caller","tripRoute");
        intent.putExtra("route",pathStations);

        startActivity(intent);




    }
}
