package com.example.filip.info.display;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.filip.info.MainActivity;
import com.example.filip.info.R;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;


public class DisplayInfoActivity extends Activity {

    ImageView imageV;
    TextView textV;
    Context context;
    StorageReference storageReference;
    StorageReference image;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_display);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        imageV = findViewById(R.id.ImageViewImage);
        textV = findViewById(R.id.editTextV);
        textV.setText(message);
        createView(message);

        context = this;
    }

    public void createView(String id) {
        try {
            DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
            Query landmark = databaseReference.child("Landmark").child(id);
            FirebaseStorage firebaseStorage = FirebaseStorage.getInstance();
            storageReference = firebaseStorage.getReference();

            landmark.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String text = dataSnapshot.child("text").getValue(String.class);
                    String img = dataSnapshot.child("image").getValue(String.class);
                    textV.setText(text);
                    image = storageReference.child("images/"+img);
                    Glide.with(context)
                            .using(new FirebaseImageLoader())
                            .load(image)
                            .into(imageV);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });





        }catch(Exception e){
            textV.setText(e.toString());
        }
    }
}
