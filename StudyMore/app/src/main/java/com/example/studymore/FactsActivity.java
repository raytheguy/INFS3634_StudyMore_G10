package com.example.studymore;

import android.content.Intent;
import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.studymore.Model.Facts;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class FactsActivity extends AppCompatActivity {

    TextView fact;
    Button factButton;
    ImageView factImage;
    RadioGroup radioGroup;
    RadioButton radioButton;
    //integer for application to know whether dog or cat is selected
    //cat = 2131230858; dog = 2131230859
    int catOrDog;
    String url;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facts);
//        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
//        setSupportActionBar(myToolbar);
        //cycle through images using Glide completed

        //set up the layout
        fact = findViewById(R.id.factView);
        factButton = findViewById(R.id.newFactButton);
        factImage = findViewById(R.id.factImage);
        radioGroup = findViewById(R.id.factRadioGroup);

        fact.setText("Loading Fact... Please Wait...");

        //run getNewFact() method when it is loaded
        //url: http://meowfacts.herokuapp.com/
        getNewFact();
        getImage(2131230898);

        //onClickListener to get new Fact
        factButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View myView) {
                getNewFact();
            }
        });

    }

    //this method is to run the query again
    public void getNewFact(){
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //place response to a String of Jsons
                Gson gson = new Gson();
                final Facts jsonCatFact = gson.fromJson(response, Facts.class);
                final String factAsString;
                Snackbar.make(getWindow().getDecorView().getRootView(), "Loading...", Snackbar.LENGTH_SHORT)
                        .setAction("Search on Google!", null).show();

                if (catOrDog == 2131230898) {
                    url = "https://meowfacts.herokuapp.com/";
                    fact.setText(jsonCatFact.getData());
                    factAsString = jsonCatFact.getData();
                    getImage(catOrDog);
                }
                else {
                    fact.setText(jsonCatFact.getFacts());
                    factAsString = jsonCatFact.getFacts();
                    getImage(catOrDog);
                }

                System.out.println("I AM BEING CLICKED");
                //let the user search the fact when they click on the FAB
                FloatingActionButton fab = findViewById(R.id.fab);
                fab.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Snackbar.make(view, factAsString, Snackbar.LENGTH_LONG)
                                .setAction("Search on Google!", null).show();
                        Intent textIntent = new Intent(Intent.ACTION_SEND);
                        textIntent.setType("text/plain");
                            textIntent.putExtra(Intent.EXTRA_TEXT, jsonCatFact.getFacts());
                            startActivity(textIntent);

                    }
                });
            }

        };

        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("There was error" + error.toString());
                //have snackbar intent to let the user know
                Snackbar.make(getWindow().getDecorView().getRootView(), "Connection Failed!", Snackbar.LENGTH_LONG).show();
            }
        };

        //url to get back json of the api
        //testing radio button
        catOrDog = radioGroup.getCheckedRadioButtonId();
        System.out.println("Cat Or Dog" + catOrDog);
        if (catOrDog == 2131230898) {
            url = "https://meowfacts.herokuapp.com/";
        }

        else {
            url = "https://dog-api.kinduff.com/api/facts";
        }
        //create Request Queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest myStringRequest = new StringRequest(Request.Method.GET, url, responseListener, errorListener);
        //add string request to request queue
        requestQueue.add(myStringRequest);

    }

    public void checkButton(View v){
        int radioId = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioId);
    }

    public void getImage(int catOrDog) {
        Response.Listener<String> responseListenerImg = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                final Facts jsonImage = gson.fromJson(response, Facts.class);
                final String imageUrl = jsonImage.getLink();
                Glide.with(getApplicationContext()).load(imageUrl).into(factImage);
            }
        };

        Response.ErrorListener errorListenerImg = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                factImage.setImageResource(R.drawable.catsdogsfacts);
            }
            };

        //create Request Queue
        System.out.println("Car or Dog is: " + catOrDog);
        if (this.catOrDog == 2131230898) {
            url = "https://some-random-api.ml/img/cat";
        }

        else {
            url = "https://some-random-api.ml/img/dog";
        }
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest myStringRequest = new StringRequest(Request.Method.GET, url, responseListenerImg, errorListenerImg);
        //add string request to request queue
        requestQueue.add(myStringRequest);
    }


}
