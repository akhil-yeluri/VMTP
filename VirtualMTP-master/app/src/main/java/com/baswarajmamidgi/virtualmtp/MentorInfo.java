package com.baswarajmamidgi.virtualmtp;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.baswarajmamidgi.virtualmtp.Student.StudentActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

/**
 * Created by aditya on 6/1/18.
 */

public class MentorInfo extends Fragment{

    public MentorInfo() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mentor_info, container, false);
        ImageView mentorpic = (ImageView) view.findViewById(R.id.mentor_pic);
        Glide
                .with(getActivity())
                .load(R.drawable.mentor)
                .apply(new RequestOptions()
                        .override(mentorpic.getWidth(),((mentorpic.getHeight())/2)))
                .into(mentorpic);

        return view;
    }
}
