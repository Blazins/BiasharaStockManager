package com.example.biasharastockmanager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.biasharastockmanager.model.TransActionList;
import com.google.android.gms.auth.api.signin.internal.Storage;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Date;

public class NewTransaction extends AppCompatActivity implements View.OnClickListener {
    private static final int TRANACTION_IN_REQUEST_CODE = 1;
    private Button inButton;
    private Button outButton;
    private EditText productName;
    private EditText productQuantity;
    private EditText price;

    //Connection to Firestore
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private Storage storageReference;
    private CollectionReference collectionReference = db.collection("NewTransaction");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_transaction);

        productName =  findViewById(R.id.edit_text_product_name);
        productQuantity = findViewById(R.id.edit_text_quantity);
        price = findViewById(R.id.edit_text_price);

        inButton = findViewById(R.id.transaction_in_button);
        inButton.setOnClickListener(this);

        outButton = findViewById(R.id.transaction_out_button);
        outButton.setOnClickListener(this);


    }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.transaction_in_button:
                    //Save transaction and display
                    String newStock = productName.getText().toString().trim();
                    String stockQuantity = productQuantity.getText().toString().trim();
                    String buyingPrice = price.getText().toString().trim();
                    Intent transactionInIntent = new Intent(NewTransaction.this,StockIn.class);
                    transactionInIntent.putExtra("productName", newStock);
                    transactionInIntent.putExtra("Stock Quantity",stockQuantity);
                    transactionInIntent.putExtra("Buying Price",buyingPrice);
                    startActivity(transactionInIntent);

                    TransActionList transActionList = new TransActionList();
                    transActionList.setProduct(newStock);
                    transActionList.setStockquantity(stockQuantity);
                    transActionList.setPrice(buyingPrice);
                    transActionList.setDateSold(new Date());

                    collectionReference.add(transActionList).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {

                        }
                    });



                    break;
                case R.id.transaction_out_button:
                    //Delete Stock from inventory and calculate profit
                    Intent transactionOutIntent = new Intent(NewTransaction.this,StockOutActivity.class);
                    startActivity(transactionOutIntent);
            }


        }

    }

