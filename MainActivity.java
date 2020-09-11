package com.fisindia.fineimagingsolution;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class MainActivity extends AppCompatActivity
{
    Intent intent;
    CardView home,products,about_us,new_ofer,contact,follow,cardmision,cardvision;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        home=findViewById(R.id.idhome);
        products=findViewById(R.id.idproducts);
        about_us=findViewById(R.id.idabout);
        new_ofer=findViewById(R.id.idnewoffer);
        contact=findViewById(R.id.idcontact);
        follow=findViewById(R.id.idfollow);
        cardmision=findViewById(R.id.idmission);
        cardvision=findViewById(R.id.idvision);
        cardvision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(MainActivity.this,vision.class);
                startActivity(intent);

            }
        });
        cardmision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(MainActivity.this,Mission.class);
                startActivity(intent);

            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                intent=new Intent(MainActivity.this,About_Us.class);
                startActivity(intent);
            }
        });
        products.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(MainActivity.this,new_Offer.class);
                startActivity(intent);
            }
        });
        about_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(MainActivity.this,Products.class);
                startActivity(intent);
            }
        });
        new_ofer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                intent=new Intent(MainActivity.this,Conatact_Us.class);
                startActivity(intent);

            }
        });
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(MainActivity.this,FollowShare.class);
                startActivity(intent);
            }
        });
        follow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                String s="Fine Imaging Solution ";
                intent.putExtra(Intent.EXTRA_TEXT,s);
                startActivity(Intent.createChooser(intent,"Share Via"));

            }
        });

    }

    @Override
    public void onBackPressed()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(" CONFIRM  EXIT   ");
        builder.setIcon(R.drawable.close);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.show();
    }
    }
