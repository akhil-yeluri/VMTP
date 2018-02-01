package com.baswarajmamidgi.virtualmtp.Faculty;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baswarajmamidgi.virtualmtp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Mentee_info extends Fragment {


    public Mentee_info() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mentee_info, container, false);
    }

}
