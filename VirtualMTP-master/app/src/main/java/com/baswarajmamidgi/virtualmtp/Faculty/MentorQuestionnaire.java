package com.baswarajmamidgi.virtualmtp.Faculty;


import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.baswarajmamidgi.virtualmtp.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MentorQuestionnaire extends Fragment {
    public static MentorQuestionnaire newInstance() {
        MentorQuestionnaire fragment = new MentorQuestionnaire();
        return fragment;
    }


    public MentorQuestionnaire() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_mentorquestionnaire, container, false);
        Questions questions1=new Questions("What is your recent Certification course?","8","9");
        Questions questions2=new Questions("Describe the progress of your project?","b","e","c","d");
        Questions questions3=new Questions("How is your health?","option1","option2");
        Questions questions4=new Questions("How is your Academics going?","option1","option2");
        Questions questions5=new Questions("Give an update on your achievements recently?","option1","option2");
        Questions questions6=new Questions("Tell me about your future plans?","option1","option2");
        ArrayList arrayList=new ArrayList();
        arrayList.add(questions1);
        arrayList.add(questions2);
        arrayList.add(questions3);
        arrayList.add(questions4);
        arrayList.add(questions5);
        arrayList.add(questions6);
        ListView lv =(ListView) view.findViewById(R.id.listview);
        LAdapter adapter=new LAdapter(getActivity(),arrayList);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                CheckBox checkBox=(CheckBox)view.findViewById(R.id.checkbox);
                if(checkBox.isChecked()==false)
                checkBox.setChecked(true);
                else
                    checkBox.setChecked(false);
            }
        });
        return view;
    }

}
class LAdapter extends ArrayAdapter{
    ArrayList arrayList;
    public LAdapter(@NonNull Context context,ArrayList arrayList) {
        super(context,R.layout.listvview_row,arrayList);
        this.arrayList=arrayList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.listvview_row,parent,false);
        TextView text = (TextView)row.findViewById(R.id.questionss);
        CheckBox checkBox=(CheckBox) row.findViewById(R.id.checkbox);
        Questions c= (Questions) arrayList.get(position);
        text.setText(c.get_Questions().toString());
        return row;
    }
}
