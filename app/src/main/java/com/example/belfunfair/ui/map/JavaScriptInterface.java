package com.example.belfunfair.ui.map;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

import com.example.belfunfair.ui.attractions.AttractionsViewModel;

public class JavaScriptInterface {
    Context mContext;
    JavaScriptInterface(Context c) {
        mContext = c;
    }

    @JavascriptInterface
    public void showToast(String toast) {
        Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
    }

    public void getAttractions(String id){
    }
}
