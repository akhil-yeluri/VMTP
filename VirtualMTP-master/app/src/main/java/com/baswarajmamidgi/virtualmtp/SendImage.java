package com.baswarajmamidgi.virtualmtp;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Camera;
import android.os.Bundle;
import android.app.Fragment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class SendImage extends Fragment {


    public SendImage() {

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case 0:
                if(ContextCompat.checkSelfPermission(getActivity(),Manifest.permission.CAMERA)== PackageManager.PERMISSION_GRANTED){
                Intent intent  = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,0);}
                break;
            default:
                Toast.makeText(getActivity(), "Cant Access Camera", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.CAMERA},0);
        if(ContextCompat.checkSelfPermission(getActivity(),Manifest.permission.CAMERA)== PackageManager.PERMISSION_GRANTED){
        Intent intent  = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,0);}
        return inflater.inflate(R.layout.fragment_send_image, container, false);
    }

}
