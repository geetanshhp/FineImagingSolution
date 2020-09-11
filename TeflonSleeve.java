package com.fisindia.fineimagingsolution;

import android.app.ProgressDialog;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
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

public class TeflonSleeve extends AppCompatActivity
{
    FirebaseDatabase database=FirebaseDatabase.getInstance();
    DatabaseReference point=database.getReference("Teflonsleeves/P1");
    StorageReference reference;
    ProgressDialog progressDialog;
    FirebaseStorage storage;
    ImageView imageView;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teflon_sleeve);
        progressDialog=new ProgressDialog(this);
        progressDialog.setTitle("Please Wait");
        progressDialog.setMessage("Data is being loaded");
        progressDialog.show();
        imageView=findViewById(R.id.imageteflonsleeve);
        textView=findViewById(R.id.textteflonsleeve);
       this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
       GetImage();
       GetText();
    }

    private void GetText()
    {

       point.addValueEventListener(new ValueEventListener() {
           @Override
           public void onDataChange(@NonNull DataSnapshot dataSnapshot)
           {
               String s=dataSnapshot.getValue(String.class);
               textView.setText(s);
               progressDialog.dismiss();
           }

           @Override
           public void onCancelled(@NonNull DatabaseError databaseError)
           {
               Toast.makeText(TeflonSleeve.this, "No internet", Toast.LENGTH_SHORT).show();
               progressDialog.dismiss();
           }
       });

    }

    private void GetImage()
    {
        storage=FirebaseStorage.getInstance();
        reference=storage.getReferenceFromUrl("gs://fineimagingsolution.appspot.com");
        StorageReference teflonsleeve=reference.child("image5.jpg");
        File myfile=null;
        try
        {
            myfile=File.createTempFile("images",".jpg");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        final File finalfile=myfile;
        teflonsleeve.getFile(myfile).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot)
            {
                Bitmap bitmap= BitmapFactory.decodeFile(finalfile.getAbsolutePath());
                imageView.setImageBitmap(bitmap);
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
