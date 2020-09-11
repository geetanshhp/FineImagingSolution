package com.fisindia.fineimagingsolution;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Conatact_Us extends AppCompatActivity
{
    String getphone1,getphone2,getphone3,getphone4,getmail,getname;
    FirebaseDatabase database=FirebaseDatabase.getInstance();
    DatabaseReference name=database.getReference("Contact_us/Name");
    DatabaseReference Phone1=database.getReference("Contact_us/Phone1");
    DatabaseReference phone2=database.getReference("Contact_us/Phone2");
    DatabaseReference phone3=database.getReference("Contact_us/Phone3");
    DatabaseReference phone4=database.getReference("Contact_us/Phone4");
    DatabaseReference mail=database.getReference("Contact_us/Gmail");
    ProgressDialog progressDialog;

    TextView Tname,ph1,ph2,email,ph3,ph4;
    FloatingActionButton Fshare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conatact__us);
        Tname=findViewById(R.id.idname);
        ph1=findViewById(R.id.idphone1);
        ph2=findViewById(R.id.idphone2);
        ph3=findViewById(R.id.idphone3);
        ph4=findViewById(R.id.idphone4);
        email=findViewById(R.id.idemail);
        Fshare=findViewById(R.id.floatingShare);
        progressDialog=new ProgressDialog(this);
        progressDialog.setTitle("Please Wait");
        progressDialog.setMessage("Data is Being Loading");
        progressDialog.show();
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ph3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                makephone3();

            }
        });
        ph4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                makephone4();

            }
        });
        mail.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                getmail=dataSnapshot.getValue(String.class);
                email.setText(getmail);
                progressDialog.dismiss();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        name.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                getname=dataSnapshot.getValue(String.class);
                Tname.setText(getname);
               progressDialog.dismiss();


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {
                Toast.makeText(Conatact_Us.this, "Sorry", Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();

            }
        });
        Phone1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                getphone1=dataSnapshot.getValue(String.class);
                ph1.setText(getphone1);
               progressDialog.dismiss();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {

            }
        });
        phone2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                getphone2=dataSnapshot.getValue(String.class);
                ph2.setText(getphone2);
                progressDialog.dismiss();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        phone3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                getphone3=dataSnapshot.getValue(String.class);
                ph3.setText(getphone3);
                progressDialog.dismiss();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        phone4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                getphone4=dataSnapshot.getValue(String.class);
                ph4.setText(getphone4);
                progressDialog.dismiss();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        ph1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                makephone1();

            }
        });
        ph2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                makephone2();

            }
        });
        Fshare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                share();
            }
        });

    }

    private void makephone4()
    {
        Intent i=new Intent(Intent.ACTION_DIAL);
        i.setData(Uri.parse("tel:+91-11-43052227"));
        startActivity(i);
    }

    private void makephone3()
    {
        Intent i=new Intent(Intent.ACTION_DIAL);
        i.setData(Uri.parse("tel:8527937327"));
        startActivity(i);
    }

    private void makephone2()
    {

        Intent i=new Intent(Intent.ACTION_DIAL);
        i.setData(Uri.parse("tel:9310089827"));
        startActivity(i);
    }

    private void makephone1()
    {
        Intent i=new Intent(Intent.ACTION_DIAL);
        i.setData(Uri.parse("tel:9540037327"));
        startActivity(i);

    }

    private void share()
    {
        Intent intent=new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        String v="We are here to answere any question you may have about our sevices \n Feel free to ask:\n Name: "+getname+" \n Mobile 1 :"+ getphone1+ "\n Mobile 2:" + getphone2 +" \n Mobile3 "+ getphone3+" \n Office :"+ getphone4 +"\n Mail "+getmail;                                   ;
        intent.putExtra(Intent.EXTRA_TEXT,v);
        startActivity(Intent.createChooser(intent,"Share Via"));

    }

}
