package com.fisindia.fineimagingsolution;

import android.app.ProgressDialog;
import android.content.pm.ActivityInfo;
import android.opengl.GLES10;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class About_Us extends AppCompatActivity
{
    TextView p1,p2,p3,p4;
    ProgressDialog progressDialog;
    FirebaseDatabase database=FirebaseDatabase.getInstance();
    DatabaseReference pone=database.getReference("About_Us/P1");
    DatabaseReference ptwo=database.getReference("About_Us/P2");
    DatabaseReference pthree=database.getReference("About_Us/P3");
    DatabaseReference pfour=database.getReference("About_Us/p4");

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about__us);
        p1=findViewById(R.id.id_p1);
        p2=findViewById(R.id.id_p2);
        p3=findViewById(R.id.id_p3);
        p4=findViewById(R.id.id_p4);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        progressDialog=new ProgressDialog(this);
        progressDialog.setTitle("Please Wait");
        progressDialog.setMessage("Data is being Loading");
        progressDialog.show();
        pone.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                String s=dataSnapshot.getValue(String.class);
                p1.setText(s);
                progressDialog.dismiss();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {

            }
        });
        ptwo.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
              String s1=dataSnapshot.getValue(String.class);
              p2.setText(s1);
                progressDialog.dismiss();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {
                Toast.makeText(About_Us.this, "No Internet ", Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();

            }
        });
        pthree.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                String s=dataSnapshot.getValue(String.class);
                p3.setText(s);
                progressDialog.dismiss();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {
                Toast.makeText(About_Us.this, "No Internet ", Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();

            }
        });
        pfour.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                String d=dataSnapshot.getValue(String.class);
                p4.setText(d);
                progressDialog.dismiss();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {
                Toast.makeText(About_Us.this, "No Internet", Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        });
    }
}
