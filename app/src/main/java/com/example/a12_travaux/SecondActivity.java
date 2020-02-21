package com.example.a12_travaux;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {


    Button bp_renvoyer;

    EditText edt_renvoyer;

    String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        bp_renvoyer = (Button) findViewById(R.id.bp_renvoyer);

        edt_renvoyer = (EditText) findViewById(R.id.edt_renvoyer);

        bp_renvoyer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                str = edt_renvoyer.getText().toString();
                createSecondActivity();
            }
        });

       Intent intent = getIntent();
        if (intent != null){
            String str = "";
            if (intent.hasExtra("Message")){
                str = intent.getStringExtra("Message");
            }
            TextView textView = (TextView) findViewById(R.id.message_recu);
            textView.setText(str);
        }
    }

    public void createSecondActivity(){
        Intent intent = new Intent(SecondActivity.this,MainActivity.class);
        intent.putExtra("Message", str);
        startActivity(intent);
    }

}
