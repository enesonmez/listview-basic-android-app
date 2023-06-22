package com.example.yerler;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<TKYerler> tkYerlerListesi;
    private ListView tkYerlerListview;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tkYerlerListview = findViewById(R.id.listViewYerler);
        tkYerlerListesi = new ArrayList<>();
        db = FirebaseFirestore.getInstance();

        db.collection("locations").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                for (DocumentSnapshot document : queryDocumentSnapshots) {
                    Log.d("msg",document.getString("tkIsim"));
                    String isim = document.getString("tkIsim");
                    String aciklama = document.getString("tkAciklama");
                    String resimUrl = document.getString("tkResimUrl");
                    tkYerlerListesi.add(new TKYerler(isim, aciklama, resimUrl));
                }
                TKYerlerAdapter adapter = new TKYerlerAdapter(MainActivity.this, R.layout.list_item_yerler, tkYerlerListesi);
                tkYerlerListview.setAdapter(adapter);
            }
        });

        tkYerlerListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TKYerler tkSecilenIl = tkYerlerListesi.get(position);
                Intent tkIntent = new Intent(MainActivity.this, TKDetayActivity.class);
                tkIntent.putExtra("isim", tkSecilenIl.getTkIsim());
                tkIntent.putExtra("aciklama", tkSecilenIl.getTkAciklama());
                tkIntent.putExtra("resimUrl", tkSecilenIl.getTkResimUrl());
                startActivity(tkIntent);
            }
        });
    }
}