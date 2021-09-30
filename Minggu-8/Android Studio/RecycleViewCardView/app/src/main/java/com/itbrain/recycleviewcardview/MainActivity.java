package com.itbrain.recycleviewcardview;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rcvSiswa;
    SiswaAdapter adapter;
    List<Siswa> siswaList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        IsiData();
    }

    private void initView() {
        rcvSiswa = (RecyclerView) findViewById(R.id.rcvSiswa);
        rcvSiswa.setLayoutManager(new LinearLayoutManager(this));
    }

    public void IsiData(){
        siswaList = new ArrayList<Siswa>();
        siswaList.add(new Siswa("JONI","Sidoarjo"));
        siswaList.add(new Siswa("BOLE","Malang"));
        siswaList.add(new Siswa("Sefa","Jakarta"));
        siswaList.add(new Siswa("Flase","Madiun"));
        siswaList.add(new Siswa("Toes","Surabaya"));
        siswaList.add(new Siswa("JONI","Sidoarjo"));
        siswaList.add(new Siswa("JONI","Sidoarjo"));
        siswaList.add(new Siswa("JONI","Sidoarjo"));
        siswaList.add(new Siswa("JONI","Sidoarjo"));
        siswaList.add(new Siswa("JONI","Sidoarjo"));
        siswaList.add(new Siswa("JONI","Sidoarjo"));
        siswaList.add(new Siswa("JONI","Sidoarjo"));
        siswaList.add(new Siswa("JONI","Sidoarjo"));
        siswaList.add(new Siswa("JONI","Sidoarjo"));
        siswaList.add(new Siswa("JONI","Sidoarjo"));

        adapter = new SiswaAdapter(this,siswaList);
        rcvSiswa.setAdapter(adapter);
    }

    public void btnTambah(View view) {
        siswaList.add(new Siswa("Rafa","Gedangan"));
        adapter.notifyDataSetChanged();
    }
}