package com.baswarajmamidgi.virtualmtp.Student;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.baswarajmamidgi.virtualmtp.MentorInfo;
import com.baswarajmamidgi.virtualmtp.R;
import com.baswarajmamidgi.virtualmtp.SendImage;
import com.baswarajmamidgi.virtualmtp.StudentQuestionnaire;
import com.baswarajmamidgi.virtualmtp.UpdateStatus;

public class StudentActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(click);
    }
    FragmentManager manager=getFragmentManager();
    private BottomNavigationView.OnNavigationItemSelectedListener click = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.questionnaire:
                    FragmentTransaction transaction=manager.beginTransaction();
                    StudentQuestionnaire studentQuestionnaire=new StudentQuestionnaire();
                    transaction.replace(R.id.fragment,studentQuestionnaire);
                    transaction.commit();
                    return true;
                case R.id.send_image:
                    FragmentTransaction transaction2=manager.beginTransaction();
                    SendImage sendImage=new SendImage();
                    transaction2.replace(R.id.fragment,sendImage);
                    transaction2.commit();
                    return true;
                case R.id.chat:
                    FragmentTransaction transaction3=manager.beginTransaction();
                    MentorInfo mentorinfo =new MentorInfo();
                    transaction3.replace(R.id.fragment,mentorinfo);
                    transaction3.commit();
                    return true;
                case R.id.update_status:
                    FragmentTransaction transaction4=manager.beginTransaction();
                    UpdateStatus updateStatus=new UpdateStatus();
                    transaction4.replace(R.id.fragment,updateStatus);
                    transaction4.commit();
                    return true;
            }
            return false;
        }
    };
}



