package com.example.islav.barcodereaderapp.fragments;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.islav.barcodereaderapp.R;


public class PublicCardsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.public_cards_fragment, container, false);
        return v;
    }
}
