package com.example.a12_travaux;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button bp_mise_a_jour;
    Button bp_page_web;
    Button bp_second_activier;


    TextView tv_nom;
    TextView tv_prenom;
    TextView tv_sexe;
    TextView tv_per_age;
    TextView tv_per_adr_1;
    TextView tv_per_adr_2;
    TextView tv_per_adr_3;
    TextView tv_permis_sexe;
    TextView tv_permis_permisText;
    TextView tv_permis_classe;

    ImageView imgv_signature;

    CheckBox CB_signature;

    int orientation;

    Switch s_H_F;
    Switch s_lang;

    EditText edt_nom;
    EditText edt_prenom;

    Boolean switch_sexe;
    Boolean switch_lang;
    Boolean check_signature;

   Context context;
    String text;
    int duration;


    String str;

    Toast toast_info ;


    private static final String TAG = "DIM - Menu";
    private static final String TAG2 = "DIM - Cycle de vie";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        if (intent != null){
            String str = "";
            if (intent.hasExtra("Message")){
                str = intent.getStringExtra("Message");
            }
            TextView textView = (TextView) findViewById(R.id.tv_message);
            textView.setText(str);
        }

        //Toast
        context = getApplicationContext();
        text = "Hello World !";
        duration = Toast.LENGTH_SHORT;
        toast_info = Toast.makeText(context, text, duration);

        //Button
        bp_mise_a_jour = (Button) findViewById(R.id.bp_mise_a_jour);
        bp_page_web = (Button) findViewById(R.id.bp_page_web);
        bp_second_activier = (Button) findViewById(R.id.bp_Second_activiter);

        //string
        str ="Hello a toi !";

        //TextView
        tv_nom = (TextView) findViewById(R.id.personne_nom);
        tv_prenom = (TextView) findViewById(R.id.personne_prenom);
        tv_sexe = (TextView) findViewById(R.id.personne_sexe);
        tv_permis_permisText = (TextView) findViewById(R.id.permis_permisText);
        tv_permis_classe = (TextView) findViewById(R.id.permis_classe);


        //EditText
        edt_nom = (EditText) findViewById(R.id.nom_a_changer);
        edt_prenom = (EditText) findViewById(R.id.prenom_a_changer);

        //ImageViez
        imgv_signature = (ImageView) findViewById(R.id.image_signature);

        //CheckBox
        CB_signature = (CheckBox) findViewById(R.id.cb_signature);

        //Switch
        s_H_F = (Switch) findViewById(R.id.switch_h_f);
        s_lang = (Switch) findViewById(R.id.switch_Lang);


        tv_per_adr_1 = (TextView) findViewById(R.id.tv_permis_adresse_1);
        tv_per_adr_2 = (TextView) findViewById(R.id.tv_permis_adresse_2);
        tv_per_adr_3 = (TextView) findViewById(R.id.tv_permis_adresse_3);
        tv_per_age = (TextView) findViewById(R.id.tv_personne_date);

        tv_sexe = (TextView) findViewById(R.id.personne_sexe);
        tv_permis_sexe = (TextView) findViewById(R.id.permis_sexe);


        orientation = getResources().getConfiguration().orientation;
        if(orientation == Configuration.ORIENTATION_LANDSCAPE){
            final GridLayout.LayoutParams params= (GridLayout.LayoutParams)tv_per_age.getLayoutParams();
            params.setMargins(640,185,0,0);
            tv_per_age.setLayoutParams(params);

            GridLayout.LayoutParams params2 = (GridLayout.LayoutParams)tv_per_adr_1.getLayoutParams();
            params2.setMargins(0,230,0,0);
            tv_per_adr_1.setLayoutParams(params2);

            GridLayout.LayoutParams params3 = (GridLayout.LayoutParams)tv_per_adr_2.getLayoutParams();
            params3.setMargins(0,280,0,0);
            tv_per_adr_2.setLayoutParams(params3);

            GridLayout.LayoutParams params4 = (GridLayout.LayoutParams)tv_per_adr_3.getLayoutParams();
            params4.setMargins(0,330,0,0);
            tv_per_adr_3.setLayoutParams(params4);

            GridLayout.LayoutParams params5 = (GridLayout.LayoutParams)tv_permis_sexe.getLayoutParams();
            params5.setMargins(1030,0,0,0);
            tv_permis_sexe.setLayoutParams(params5);


            GridLayout.LayoutParams params6 = (GridLayout.LayoutParams)tv_sexe.getLayoutParams();
            params6.setMargins(1160,0,0,0);
            tv_sexe.setLayoutParams(params6);


        }else{

            GridLayout.LayoutParams params = (GridLayout.LayoutParams)tv_per_age.getLayoutParams();
            params.setMargins(0,230,0,0);
            tv_per_age.setLayoutParams(params);

            GridLayout.LayoutParams params2 = (GridLayout.LayoutParams)tv_per_adr_1.getLayoutParams();
            params2.setMargins(0,280,0,0);
            tv_per_adr_1.setLayoutParams(params2);

            GridLayout.LayoutParams params3 = (GridLayout.LayoutParams)tv_per_adr_2.getLayoutParams();
            params3.setMargins(0,330,0,0);
            tv_per_adr_2.setLayoutParams(params3);

            GridLayout.LayoutParams params4 = (GridLayout.LayoutParams)tv_per_adr_3.getLayoutParams();
            params4.setMargins(0,380,0,0);
            tv_per_adr_3.setLayoutParams(params4);

        }


        s_H_F.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch_sexe = s_H_F.isChecked();
                if(switch_sexe){
                    tv_sexe.setText(R.string.app_personne_sexe_F_FR);
                }else{
                    tv_sexe.setText(R.string.app_personne_sexe_M_FR);
                }
            }
        });


        CB_signature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check_signature = CB_signature.isChecked();
                if(check_signature){
                   imgv_signature.setVisibility(View.INVISIBLE);
                }else{
                    imgv_signature.setVisibility(View.VISIBLE);
                }
            }
        });

        s_lang.setOnClickListener(new View.OnClickListener() {
          public void onClick(View v) {
              switch_lang = s_lang.isChecked();
              if(!switch_lang){
                /*  if(switch_sexe){
                      tv_sexe.setText(R.string.app_personne_sexe_F_FR);
                  }else{
                      tv_sexe.setText(R.string.app_personne_sexe_M_FR);
                  }*/
                  tv_permis_classe.setText(R.string.app_permis_classe_FR);
                  tv_permis_permisText.setText(R.string.app_permis_FR);
                  tv_permis_sexe.setText(R.string.app_permis_sexe_FR);
                  tv_permis_classe.setText(R.string.app_permis_classe_FR);

              }else{
                 /* if(switch_sexe){
                      tv_sexe.setText(R.string.app_personne_sexe_W_UK);
                  }else{
                      tv_sexe.setText(R.string.app_personne_sexe_M_UK);
                  }*/
                  tv_permis_classe.setText(R.string.app_permis_classe_UK);
                  tv_permis_permisText.setText(R.string.app_permis_UK);
                  tv_permis_sexe.setText(R.string.app_permis_sexe_UK);
                  tv_permis_classe.setText(R.string.app_permis_classe_UK);
              }
            }
           });


        bp_mise_a_jour.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                addNotification();
                String chaine_nom = edt_nom.getText().toString();
                String chaine_prenom = edt_prenom.getText().toString();

                if(!chaine_nom.isEmpty() && !chaine_prenom.isEmpty()){
                    tv_nom.setText(chaine_nom);
                    tv_prenom.setText(chaine_prenom);

                }else{
                    toast_info.setText("Rentrer le nom et prénom");
                    toast_info.show();

                }
            }
        });





        bp_second_activier.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                createSecondActivity();
            }
        });



    }

    public void createSecondActivity(){
        Intent intent = new Intent(MainActivity.this,SecondActivity.class);
        intent.putExtra("Message", str);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
       // toast_info.setText("OnStart");
        Log.v(TAG2, "OnStart");
       // toast_info.show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //toast_info.setText("OnResume");
        Log.v(TAG2, "OnResume");
        //toast_info.show();


    }

    protected void onPause() {
        super.onPause();
        //toast_info.setText("OnPause");
        Log.v(TAG2, "OnPause");
        //toast_info.show();
    }

    @Override
    protected void onStop() {
        super.onStop();
       // toast_info.setText("OnStop");
        Log.v(TAG2, "OnStop");
       // toast_info.show();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //toast_info.setText("OnDestroy");
        Log.v(TAG2, "OnDestroy");
      //  toast_info.show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        switch (item.getItemId()){
            case R.id.menu_preference:

                Log.v(TAG, "menu_preference");
                return true;

            case R.id.menu_autre:
                Log.v(TAG, "menu_autre");
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


    public static void setMargins (View v, int l, int t, int r, int b) {
        if (v.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) v.getLayoutParams();
            p.setMargins(l, t, r, b);
            v.requestLayout();
        }
    }

private void addNotification(){
    NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
            .setSmallIcon(R.mipmap.ic_launcher_round)
            .setContentTitle("Les 12-Travaux")
            .setContentText("On a besoin de vous !!!")
            .setTicker("Hey ! tu a reçu un message de nous !!")
            .setPriority(Notification.PRIORITY_HIGH);

    Intent notificationIntent = new Intent(this,MainActivity.class);
    PendingIntent constantIntent = PendingIntent.getActivity(this,0,notificationIntent,PendingIntent.FLAG_UPDATE_CURRENT);
    builder.setContentIntent(constantIntent);

    NotificationManager manager = (NotificationManager)  getSystemService(Context.NOTIFICATION_SERVICE);
    manager.notify(0,builder.build());






}

public void goToAEMI(View view){
        goToUrl("https://www.facebook.com/aemiuqac/");
}

    private void goToUrl(String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }


}


