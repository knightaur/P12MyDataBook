package sg.edu.rp.c346.p12_mydatabook;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class AboutUs extends AppCompatActivity {

    ActionBar ab;
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        iv = findViewById(R.id.iv);

        ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        String imageUrl = "https://en.wikipedia.org/wiki/Republic_Polytechnic#/media/File:Republic_Polytechnic_Logo.jpg";
        Picasso.with(this).load(imageUrl).placeholder(R.drawable.ajax_loader).error(R.drawable.error).into(iv, new Callback() {
            @Override
            public void onSuccess() {
                Toast.makeText(AboutUs.this, "Success", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError() {
                Toast.makeText(getApplicationContext(), "An error occurred", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
