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

public class new_Offer extends AppCompatActivity
{
    ProgressDialog progressDialog;
    FirebaseStorage storage;
    StorageReference reference;
    ImageView imageView1,imageView2,imageView3,imageView4,imageView5,imageView6,imageView8,imageView7,imageView9,imageView10;
    TextView TittletextView1,TittletextView2,TittletextView3,TittletextView4,TittletextView5,TittletextView6,TittletextView7,TittletextView8,TittletextView9,TittletextView10;
    TextView DiscriptionTextView1,DiscriptionTextView2,DiscriptionTextView3,DiscriptionTextView4,DiscriptionTextView5,DiscriptionTextView6,DiscriptionTextView7,DiscriptionTextView8,DiscriptionTextView9,DiscriptionTextView10;
    FirebaseDatabase database=FirebaseDatabase.getInstance();
    DatabaseReference t1=database.getReference("New_Offer/T1");
    DatabaseReference t2=database.getReference("New_Offer/T2");
    DatabaseReference t3=database.getReference("New_Offer/T3");
    DatabaseReference t4=database.getReference("New_Offer/T4");
    DatabaseReference t5=database.getReference("New_Offer/T5");
    DatabaseReference t6=database.getReference("New_Offer/T6");
    DatabaseReference t7=database.getReference("New_Offer/T7");
    DatabaseReference t8=database.getReference("New_Offer/T8");
    DatabaseReference t9=database.getReference("New_Offer/T9");
    DatabaseReference t10=database.getReference("New_Offer/T10");
    DatabaseReference d1=database.getReference("New_Offer/D1");
    DatabaseReference d2=database.getReference("New_Offer/D2");
    DatabaseReference d3=database.getReference("New_Offer/D3");
    DatabaseReference d4=database.getReference("New_Offer/D4");
    DatabaseReference d5=database.getReference("New_Offer/D5");
    DatabaseReference d6=database.getReference("New_Offer/D6");
    DatabaseReference d7=database.getReference("New_Offer/D7");
    DatabaseReference d8=database.getReference("New_Offer/D8");
    DatabaseReference d9=database.getReference("New_Offer/D9");
    DatabaseReference d10=database.getReference("New_Offer/D10");
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new__offer);
        progressDialog=new ProgressDialog(this);
        progressDialog.setTitle("Please Wait");
        progressDialog.setMessage("Data is being loading ");
        progressDialog.show();
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        imageView1=findViewById(R.id.id_image1);
        TittletextView1=findViewById(R.id.idtittle1);
        TittletextView2=findViewById(R.id.idtittle2);
        TittletextView3=findViewById(R.id.idtittle3);
        TittletextView4=findViewById(R.id.idtittle4);
        TittletextView5=findViewById(R.id.idtittle5);
        TittletextView6=findViewById(R.id.idtittle6);
        TittletextView7=findViewById(R.id.idtittle7);
        TittletextView8=findViewById(R.id.idtittle8);
        TittletextView9=findViewById(R.id.idtittle9);
        TittletextView10=findViewById(R.id.idtittle10);
        DiscriptionTextView1=findViewById(R.id.id_description1);
        DiscriptionTextView2=findViewById(R.id.id_description2);
        DiscriptionTextView3=findViewById(R.id.id_description3);
        DiscriptionTextView4=findViewById(R.id.id_description4);
        DiscriptionTextView5=findViewById(R.id.id_description5);
        DiscriptionTextView6=findViewById(R.id.id_description6);
        DiscriptionTextView7=findViewById(R.id.id_description7);
        DiscriptionTextView8=findViewById(R.id.id_description8);
        DiscriptionTextView9=findViewById(R.id.id_description9);
        DiscriptionTextView10=findViewById(R.id.id_description10);
        imageView2=findViewById(R.id.id_image2);
        imageView3=findViewById(R.id.id_image3);
        imageView4=findViewById(R.id.id_image4);
        imageView5=findViewById(R.id.id_image5);
        imageView6=findViewById(R.id.id_image6);
        imageView7=findViewById(R.id.id_image7);
        imageView8=findViewById(R.id.id_image8);
        imageView9=findViewById(R.id.id_image9);
        imageView10=findViewById(R.id.id_image10);
        Imageinit();
        TextInit();
    }






    private void TextInit()
    {
        d1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                String s=dataSnapshot.getValue(String.class);
                DiscriptionTextView1.setText(s);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {

            }
        });
        d2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                String s=dataSnapshot.getValue(String.class);
                DiscriptionTextView2.setText(s);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        d3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String s=dataSnapshot.getValue(String.class);
                DiscriptionTextView3.setText(s);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        d4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                String s=dataSnapshot.getValue(String.class);
                DiscriptionTextView4.setText(s);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {

            }
        });
        d5.addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                String s=dataSnapshot.getValue(String.class);
                DiscriptionTextView5.setText(s);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {

            }
        });
        d6.addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                String s=dataSnapshot.getValue(String.class);
                DiscriptionTextView6.setText(s);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {

            }
        });
        d7.addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                String s=dataSnapshot.getValue(String.class);
                DiscriptionTextView7.setText(s);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {

            }
        });
        d8.addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                String s=dataSnapshot.getValue(String.class);
                DiscriptionTextView8.setText(s);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {

            }
        });
        d9.addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                String s=dataSnapshot.getValue(String.class);
                DiscriptionTextView9.setText(s);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {

            }
        });
        d10.addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                String s=dataSnapshot.getValue(String.class);
                DiscriptionTextView10.setText(s);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {

            }
        });


        t1.addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                String s=dataSnapshot.getValue(String.class);
                TittletextView1.setText(s);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {

            }
        });
        t2.addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                String s=dataSnapshot.getValue(String.class);
                TittletextView2.setText(s);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {

            }
        });
        t3.addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                String s=dataSnapshot.getValue(String.class);
                TittletextView3.setText(s);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {

            }
        });
        t4.addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                String s=dataSnapshot.getValue(String.class);
                TittletextView4.setText(s);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {

            }
        });
        t5.addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                String s=dataSnapshot.getValue(String.class);
                TittletextView5.setText(s);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {


            }
        });
        t6.addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {

                String d=dataSnapshot.getValue(String.class);
                TittletextView6.setText(d);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {

            }
        });
        t7.addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
            String d=dataSnapshot.getValue(String.class);
            TittletextView7.setText(d);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        t8.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String s=dataSnapshot.getValue(String.class);
                TittletextView8.setText(s);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {

            }
        });
        t9.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                String s=dataSnapshot.getValue(String.class);
                TittletextView9.setText(s);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {

            }
        });
        t10.addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
              String s=dataSnapshot.getValue(String.class);
              TittletextView10.setText(s);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {

            }
        });

    }
    private void Imageinit()
    {
        storage=FirebaseStorage.getInstance();
        reference=storage.getReferenceFromUrl("gs://fineimagingsolution.appspot.com");
        StorageReference fisrt=reference.child("image1.jpg");
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
        StorageReference second=reference.child("image2.jpg");
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
        StorageReference third=reference.child("image3.jpg");
        File myfile3=null;
        try {
            myfile3=File.createTempFile("images",".jpg");
        } catch (IOException e) {
            e.printStackTrace();
        }
        final  File finalfile3=myfile3;
        third.getFile(myfile3).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot)
            {
                Bitmap bitmap= BitmapFactory.decodeFile(finalfile3.getAbsolutePath());
                imageView3.setImageBitmap(bitmap);
                progressDialog.dismiss();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e)
            {

            }
        });



        StorageReference four=reference.child("image4.jpg");
        File myfile4=null;
        try {
            myfile4=File.createTempFile("images",".jpg");
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        final File finalfile4=myfile4;
        four.getFile(myfile4).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot)
            {
                Bitmap bitmap= BitmapFactory.decodeFile(finalfile4.getAbsolutePath());
                imageView4.setImageBitmap(bitmap);
                progressDialog.dismiss();

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e)
            {

            }
        });




        StorageReference five = reference.child("image5.jpg");
        File myfile5=null;
        try {
            myfile5=File.createTempFile("images",".jpg");
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        final File finalfile5=myfile5;
        five.getFile(myfile5).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot)
            {
                Bitmap bitmap= BitmapFactory.decodeFile(finalfile5.getAbsolutePath());
              imageView5.setImageBitmap(bitmap);
                progressDialog.dismiss();

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e)
            {

            }
        });



        StorageReference six = reference.child("image6.jpg");
        File myfile6=null;
        try {
            myfile6=File.createTempFile("images",".jpg");
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        final File finalfile6=myfile6;
        six.getFile(myfile6).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot)
            {
                Bitmap bitmap= BitmapFactory.decodeFile(finalfile6.getAbsolutePath());
                imageView6.setImageBitmap(bitmap);
                progressDialog.dismiss();

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e)
            {

            }
        });


        StorageReference seven=reference.child("image7.jpg");
        File myfile7=null;
        try
        {
            myfile7=File.createTempFile("images",".jpg");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        final File finalmyfile7=myfile7;
        seven.getFile(myfile7).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot)
            {
                Bitmap bitmap= BitmapFactory.decodeFile(finalmyfile7.getAbsolutePath());
               imageView7.setImageBitmap(bitmap);
                progressDialog.dismiss();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });
        StorageReference eight=reference.child("image8.jpg");
        File myfile8=null;
        try
        {
            myfile8=File.createTempFile("images",".jpg");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        final File finalfile8=myfile8;
        eight.getFile(myfile8).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot)
            {
                Bitmap bitmap= BitmapFactory.decodeFile(finalfile8.getAbsolutePath());
                imageView8.setImageBitmap(bitmap);
                progressDialog.dismiss();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e)
            {

            }
        });
        StorageReference nine=reference.child("image9.jpg");
        File myfile9=null;
        try
        {
            myfile9=File.createTempFile("images",".jpg");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        final File finalfile9=myfile9;
        nine.getFile(myfile9).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot)
            {
                Bitmap bitmap= BitmapFactory.decodeFile(finalfile9.getAbsolutePath());
               imageView9.setImageBitmap(bitmap);
                progressDialog.dismiss();

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });
        StorageReference ten=reference.child("image10.jpg");
        File myfile10=null;
        try
        {
            myfile10=File.createTempFile("images",".jpg");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        final File finalfile10=myfile10;
        ten.getFile(myfile10).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot)
            {
                Bitmap bitmap= BitmapFactory.decodeFile(finalfile10.getAbsolutePath());
                imageView10.setImageBitmap(bitmap);
                progressDialog.dismiss();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });


    }
}
