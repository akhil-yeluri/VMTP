package com.baswarajmamidgi.virtualmtp.Faculty;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.baswarajmamidgi.virtualmtp.R;


public class MenteeList extends AppCompatActivity {
    String[] student= {"Holly Holm","Leo Tolstoy","Henry David","Napoleon Hill"};
    String[] year ={"1st Year","2nd Year","3rd Year","4th Year"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mentee_list);
        ListView listView=(ListView)findViewById(R.id.student_list);
        Adapter adapter=new Adapter(MenteeList.this,student,year);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(MenteeList.this,Mentee_Main.class);
                startActivity(intent);
            }
        });

    }
    public class Adapter extends ArrayAdapter{
        String[] student,year;

        public Adapter(@NonNull Context context,String[] student,String[] year) {
            super(context,R.layout.mentee_list,student);
            this.student=student;
            this.year=year;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater inflater=(LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
            View row=inflater.inflate(R.layout.mentee_list,parent,false);
            TextView student_name=(TextView)row.findViewById(R.id.student_name);
            TextView student_year=(TextView)row.findViewById(R.id.student_year);
            student_name.setText(student[position]);
            student_year.setText(year[position]);
            return row;
        }
    }
}
