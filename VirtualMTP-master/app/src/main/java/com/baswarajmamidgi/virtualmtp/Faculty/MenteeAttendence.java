package com.baswarajmamidgi.virtualmtp.Faculty;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.baswarajmamidgi.virtualmtp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MenteeAttendence extends Fragment {
    Button bt1;


    public MenteeAttendence() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_mentee_attendence, container, false);
        bt1=(Button)view.findViewById(R.id.mentee_attendence_button);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "hello vnr", Toast.LENGTH_SHORT).show();
            }
        });
        return view;

    }

}
