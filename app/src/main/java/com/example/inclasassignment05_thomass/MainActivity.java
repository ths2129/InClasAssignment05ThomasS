package com.example.inclasassignment05_thomass;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1; //one image

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(MainActivity.this, R.string.welcome, Toast.LENGTH_SHORT).show();

    }

    public void sendMessage(View view) {
        EditText message = (EditText) findViewById(R.id.the_message); //calling the id of the edittext
        String theMessage = message.getText().toString(); //saving user input into variable

        EditText title = (EditText) findViewById(R.id.the_title);
        String messageTitle = title.getText().toString();

        CheckBox titleHolder = (CheckBox) findViewById(R.id.id_box);
        boolean hasOnlyTitle = titleHolder.isChecked();

        if (!hasOnlyTitle) {
        Intent intent1 = new Intent(Intent.ACTION_SENDTO);
        intent1.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent1.putExtra(Intent.EXTRA_SUBJECT, messageTitle);
        intent1.putExtra(Intent.EXTRA_TEXT, theMessage);
        startActivity(intent1);
    } else {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, messageTitle);
        startActivity(intent);



        // if (intent.resolveActivity(getPackageManager()) != null) { //makes sure the program can handle the intent
        }}


    public void launchActivity(View view) { //calls a new activity
        Intent intent = new Intent(this, Launch_Activity.class);
        EditText editText = (EditText) findViewById(R.id.the_title);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void launchCamera(View view) {

        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }
}



