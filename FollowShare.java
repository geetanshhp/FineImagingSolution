package com.fisindia.fineimagingsolution;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class FollowShare extends AppCompatActivity
{
    ImageButton Finstagram,Ffacebook,Ftwitter,Flinkedin;
    Button button;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_follow_share);
        Finstagram=findViewById(R.id.instagram);
        Ffacebook=findViewById(R.id.facebook);
        Ftwitter=findViewById(R.id.twitter);
        Flinkedin=findViewById(R.id.linkedid);
        button=findViewById(R.id.cardbutton);
        back=findViewById(R.id.backbutton);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(FollowShare.this,MainActivity.class);
                startActivity(intent);

            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.google.com"));
                startActivity(intent);

            }
        });
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Finstagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                FollowInsta();

            }
        });
        Ffacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                FollowFace();

            }
        });
        Ftwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
              FollowTwitter();
            }
        });
        Flinkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                FollowLinked();

            }
        });

    }






    private void FollowLinked()
    {
        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.linkedin.com"));
        startActivity(intent);

    }

    private void FollowTwitter()
    {
        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://twitter.com/ImagingFine"));
        startActivity(intent);
    }

    private void FollowFace()
    {
        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.facebook.com"));
        startActivity(intent);
    }

    private void FollowInsta()
    {
        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.instagram.com/fineimagingsolution/"));
        startActivity(intent);
    }
}
