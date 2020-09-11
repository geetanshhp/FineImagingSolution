package com.fisindia.fineimagingsolution;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class Products extends AppCompatActivity
{
    CardView lasertonercartidge,lasertonerpower,opcdrum,carteidgechip,carteidgeaccessories,printeraccessories,teflonsleeve,inkjetink;

    @Override
    protected void onCreate(final Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
        lasertonercartidge=findViewById(R.id.idlaserTonerCartridge);
        lasertonerpower=findViewById(R.id.idLaserTonerPowder);
        opcdrum=findViewById(R.id.idOpcDrum);
        carteidgechip=findViewById(R.id.idCartidgeChip);
        carteidgeaccessories=findViewById(R.id.idCartidgeAccessories);
        printeraccessories=findViewById(R.id.idPrinterAccessories);
        teflonsleeve=findViewById(R.id.idTeflonSleeve);
        inkjetink=findViewById(R.id.idInkJetInk);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        lasertonercartidge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(Products.this,LaserTonerCartridge.class);
                startActivity(intent);

            }
        });
        lasertonerpower.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(Products.this,LaserTonerPowder.class);
                startActivity(intent);

            }
        });
        opcdrum.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
              Intent intent=new Intent(Products.this,OpcDrum.class);
              startActivity(intent);

            }
        });
        carteidgechip.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(Products.this,CartidgeChip.class);
                startActivity(intent);


            }
        });
        carteidgeaccessories.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(Products.this,carteidgeAccessories.class);
                startActivity(intent);


            }
        });
        printeraccessories.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(Products.this,PrinterAccessories.class);
                startActivity(intent);

            }
        });
        teflonsleeve.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(Products.this,TeflonSleeve.class);
                startActivity(intent);
            }
        });
        inkjetink.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(Products.this,InkJetInk.class);
                startActivity(intent);

            }
        });

    }
}
