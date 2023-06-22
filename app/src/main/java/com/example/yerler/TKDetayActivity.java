package com.example.yerler;

import android.app.ActionBar;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.squareup.picasso.Picasso;

public class TKDetayActivity extends AppCompatActivity {
    private ImageView tkImageViewResim;
    private TextView tkTextViewIsim;
    private TextView tkTextViewAciklama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detay);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tkImageViewResim = findViewById(R.id.imageViewDetayResim);
        tkTextViewIsim = findViewById(R.id.textViewDetayIsim);
        tkTextViewAciklama = findViewById(R.id.textViewDetayAciklama);

        String isim = getIntent().getStringExtra("isim");
        String aciklama = getIntent().getStringExtra("aciklama");
        String resimUrl = getIntent().getStringExtra("resimUrl");

        tkTextViewIsim.setText(isim);
        tkTextViewAciklama.setText(aciklama);
        Picasso.get().load(resimUrl).into(tkImageViewResim);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}
