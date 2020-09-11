package com.fisindia.fineimagingsolution;

import android.app.ProgressDialog;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v4.app.SupportActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import java.io.File;
import java.io.IOException;

public class PrinterAccessories extends AppCompatActivity
{
    TextView textView1,textView2;
    ProgressDialog progressDialog;
    FirebaseStorage storage;
    StorageReference reference;
    ImageView imageView1,imageView2;
    FirebaseDatabase database=FirebaseDatabase.getInstance();
    DatabaseReference point1=database.getReference("PrinterAcc/P1");
    DatabaseReference point2=database.getReference("PrinterAcc/P2");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_printer_accessories);
        progressDialog=new ProgressDialog(this);
        progressDialog.setTitle("Please Wait");
        progressDialog.setMessage("Data is being Loading");
        progressDialog.show();
        textView1=findViewById(R.id.textprinteracc1);
        textView2=findViewById(R.id.textprinteracc2);
        imageView1=findViewById(R.id.imageprinteraccesries1);
        imageView2=findViewById(R.id.imageprinteraccesries2);
       this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
       GetImage();
       GetText();
    }

    private void GetText()
    {
      point1.addValueEventListener(new ValueEventListener() {
          @Override
          public void onDataChange(@NonNull DataSnapshot dataSnapshot)
          {
              String s=dataSnapshot.getValue(String.class);
              textView1.setText(s);

          }

          @Override
          public void onCancelled(@NonNull DatabaseError databaseError)
          {
              Toast.makeText(PrinterAccessories.this, "No internet", Toast.LENGTH_SHORT).show();

          }
      });
      point2.addValueEventListener(new ValueEventListener() {
          @Override
          public void onDataChange(@NonNull DataSnapshot dataSnapshot)
          {
              String s=dataSnapshot.getValue(String.class);
              textView2.setText(s);
              progressDialog.dismiss();

          }

          @Override
          public void onCancelled(@NonNull DatabaseError databaseError)
          {


          }
      });
    }

    private void GetImage()
    {
        storage=FirebaseStorage.getInstance();
        reference=storage.getReferenceFromUrl("gs://fineimagingsolution.appspot.com");
        StorageReference fisrt=reference.child("blade.jpg");
        File myfile=null;
        try
        {
            myfile=File.createTempFile("images",".jpg");
        }

        catch (IOException e) {
            e.printStackTrace();
        }
        final File finalmyfile1=myfile;
        fisrt.getFile(myfile).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot)
            {
                Bitmap bitmap= BitmapFactory.decodeFile(finalmyfile1.getAbsolutePath());
                imageView1.setImageBitmap(bitmap);
                progressDialog.dismiss();

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e)
            {

            }
        });
        StorageReference second=reference.child("roller.jpg");
        File myfile2=null;
        try
        {
            myfile2=File.createTempFile("images",".jpg");
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        final File finalfilefile2=myfile2;
        second.getFile(myfile2).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot)
            {
                Bitmap bitmap= BitmapFactory.decodeFile(finalfilefile2.getAbsolutePath());
                imageView2.setImageBitmap(bitmap);
                progressDialog.dismiss();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e)
            {


            }
        });
    }
}
