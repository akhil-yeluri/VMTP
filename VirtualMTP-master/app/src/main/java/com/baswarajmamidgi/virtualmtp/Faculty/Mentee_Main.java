package com.baswarajmamidgi.virtualmtp.Faculty;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import com.baswarajmamidgi.virtualmtp.R;
import com.baswarajmamidgi.virtualmtp.StudentQuestionnaire;

import java.lang.reflect.Field;

public class Mentee_Main extends AppCompatActivity {



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @SuppressLint("ResourceType")
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.mentor_questionnaire:
                     Mentee_info mentee_info =new Mentee_info();
                    //fragment object instance
                    FragmentManager manager1=getFragmentManager();
                    FragmentTransaction transaction1=manager1.beginTransaction();
                    transaction1.replace(R.id.fragment1,mentee_info,"");
                    transaction1.commit();
                    return true;
                case R.id.mentee_attendence:
                     MentorQuestionnaire mentorQuestionnaire=new MentorQuestionnaire();
                    //fragment object instance
                    FragmentManager manager=getFragmentManager();
                    FragmentTransaction transaction=manager.beginTransaction();
                    transaction.replace(R.id.fragment1,mentorQuestionnaire,"a");
                    transaction.commit();
                    return true;
                case R.id.navigation_notifications:
                    Toast.makeText(Mentee_Main.this, " ", Toast.LENGTH_SHORT).show();
                    return true;
            }
            return false;
        }
    };

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mentee_details);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        BottomNavigationViewHelper helper=new BottomNavigationViewHelper();
        helper.disableShiftMode(navigation);
        Mentee_info fragment0=new Mentee_info();
        //fragment object instance
        FragmentManager manager=getFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();
        transaction.add(R.id.fragment1,fragment0,"");
        transaction.commit();
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }
    public class BottomNavigationViewHelper {
        @SuppressLint("RestrictedApi")
        public  void disableShiftMode(BottomNavigationView view) {
            BottomNavigationMenuView menuView = (BottomNavigationMenuView) view.getChildAt(0);
            try {
                Field shiftingMode = menuView.getClass().getDeclaredField("mShiftingMode");
                shiftingMode.setAccessible(true);
                shiftingMode.setBoolean(menuView, false);
                shiftingMode.setAccessible(false);
                for (int i = 0; i < menuView.getChildCount(); i++) {
                    BottomNavigationItemView item = (BottomNavigationItemView) menuView.getChildAt(i);
                    //noinspection RestrictedApi
                    item.setShiftingMode(false);
                    // set once again checked value, so view will be updated
                    //noinspection RestrictedApi
                    item.setChecked(item.getItemData().isChecked());
                }
            } catch (NoSuchFieldException e) {
                Log.e("BNVHelper", "Unable to get shift mode field", e);
            } catch (IllegalAccessException e) {
                Log.e("BNVHelper", "Unable to change value of shift mode", e);
            }
        }
    }


}
