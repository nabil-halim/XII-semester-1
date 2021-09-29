package com.itbrain.messagedialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.println("OnCreate");
    }

    public void showToast(String pesan){
        Toast.makeText(this, pesan, Toast.LENGTH_SHORT).show();
    }

    public void showAlert(String pesan){
        AlertDialog.Builder buatAlert = new AlertDialog.Builder(this);
        buatAlert.setTitle("PERHATIAN !");
        buatAlert.setMessage(pesan);
        buatAlert.show();
    }

    public void showAlertButton(String pesan){
        AlertDialog.Builder showAlert = new AlertDialog.Builder(this);
        showAlert.setTitle("PERINGATAN !");
        showAlert.setMessage(pesan);

        showAlert.setPositiveButton("YA", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
              showToast("Data Sudah Dihapus");
            }
        });

        showAlert.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                showToast("Data Tidak Dihapus");
            }
        });

        showAlert.show();
    }

    public void btnToast(View view) {
        showToast("Selamat Belajar");
    }

    public void btnAlert(View view) {
        showAlert("Selamat Belajar");
    }

    public void btnAlertDialogButton(View view) {
        showAlertButton("Yakin akan menghapus ?");
    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//
//        System.out.println("onStart");
//    }
//
//    @Override
//    protected void onPostResume() {
//        super.onPostResume();
//
//        System.out.println("onPostResume");
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//
//        System.out.println("onPause");
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//
//        System.out.println("onStop");
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//
//        System.out.println("onDestroy");
//    }
}