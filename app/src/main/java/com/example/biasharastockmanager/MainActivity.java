package com.example.biasharastockmanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.internal.Storage;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import util.TransactionApi;

public class MainActivity extends AppCompatActivity {
    private FirebaseAnalytics mFirebaseAnalytics;

    private Button productsButton;
    private Button stockRemainingButton;
    private Button fmcgButton;
    private FloatingActionButton floatingTransactionButton;

    private TextView currentUserTextView;
    private String currentUserId;
    private String currentUserName;

    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;
    private FirebaseUser user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Obtain the FirebaseAnalytics instance.
        //mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        firebaseAuth = FirebaseAuth.getInstance();




        floatingTransactionButton = findViewById(R.id.fab_transaction_button);
        productsButton = findViewById(R.id.products_button);
        stockRemainingButton = findViewById(R.id.stock_remaining_button);
        fmcgButton = findViewById(R.id.fmcg_button);
        currentUserTextView = findViewById(R.id.currentUserTextView);

        if(TransactionApi.getInstance() !=null){
            currentUserId = TransactionApi.getInstance().getUserId();
            currentUserName = TransactionApi.getInstance().getUsername();

            currentUserTextView.setText(currentUserName);
        }
        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                user = firebaseAuth.getCurrentUser();
                if(user != null){

                }else{

                }
            }
        };

        floatingTransactionButton.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this,NewTransaction.class));

        });

        productsButton.setOnClickListener(v -> {

        });
        stockRemainingButton.setOnClickListener(v -> {

        });
        fmcgButton.setOnClickListener(v -> {

        });

    }


}