package com.example.zad11;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.util.Log;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.graphics.Color;


public class MainActivity extends AppCompatActivity {

    RatingBar ratingbar;
    TextView textview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        RatingBar ratingBar = findViewById(R.id.ratingBar);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                Log.d(" Ocena:"+v,""+b);
                Log.d(" klik:"+b," "+v);
                float ocena=(float)ratingBar.getRating();
                int kolor;
                Toast.makeText(MainActivity.this, "ocena: "+ocena , Toast.LENGTH_SHORT).show();

                textview=findViewById(R.id.textview);

                if(ocena<=3){
                    kolor=Color.RED;
                    ratingBar.setProgressTintList(ColorStateList.valueOf(kolor));
                    textview.setText("Słabo");
                }else if (ocena==5){
                    kolor=Color.YELLOW;
                    ratingBar.setProgressTintList(ColorStateList.valueOf(kolor));
                    textview.setText("Doskonale");
                }else {
                    kolor=Color.GREEN;
                    ratingBar.setProgressTintList(ColorStateList.valueOf(kolor));
                    textview.setText("Dobrze");
                }

            }
        });

    }
}