package com.example.belfunfair.ui.map;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

import com.example.belfunfair.ui.attractions.Artist;
import com.example.belfunfair.ui.attractions.AttractionsViewModel;
import com.example.belfunfair.ui.attractions.Manege;
import com.example.belfunfair.ui.attractions.Stand;

import java.util.ArrayList;
import java.util.Arrays;

public class JavaScriptInterface {
    Context mContext;
    MapFragment mMapFragment;
    JavaScriptInterface(Context c, MapFragment mapFragment) {
        mContext = c;
        mMapFragment = mapFragment;
    }

    @JavascriptInterface
    public void showToast(String toast) {
        Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
    }
    @JavascriptInterface
    public void getAttractions(String id){
        ArrayList<Object> attractions = new ArrayList<Object>();
        if (id.contains("manege")) {
            int number = Integer.parseInt(id.replace("manege",""));
            Manege[] MANEGES = AttractionsViewModel.Companion.getManeges();
            for (Manege manege : MANEGES) {
                if (number == manege.getIdSlot()) {
                    attractions.add(manege);
                }
            }
        }
        else if (id.contains("stand")) {
            int number = Integer.parseInt(id.replace("stand",""));
            Stand[] STANDS = AttractionsViewModel.Companion.getStands();
            for (Stand stand : STANDS) {
                if (number == stand.getIdSlot()) {
                    attractions.add(stand);
                }
            }
        }
        else if (id.contains("stage")) {
            Artist[] artists = AttractionsViewModel.Companion.getArtists();
            attractions.addAll(Arrays.asList(artists));
        }
        mMapFragment.setAttractions(attractions);
    }

}
