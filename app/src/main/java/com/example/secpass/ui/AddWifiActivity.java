package com.example.secpass.ui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.res.ResourcesCompat;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.secpass.R;

public class AddWifiActivity extends AppCompatActivity {

    CardView crdwifi;
    Spinner spncategory;
    Context ctx =this;
    ArrayAdapter<String> adapter;
    ImageView imgClose , imageAccount;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_wifi);

        spncategory = findViewById(R.id.spnCategory);

        initView();
        spinnerItem();
    }

    private void initView() {
        imgClose = findViewById(R.id.imgClose);
        imageAccount = findViewById(R.id.imgAccount);
        btnSave = findViewById(R.id.btnSave);
        imgClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        imageAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddWifiActivity.this, DashBoardActivity.class));
                finish();
            }
        });
    }

    private void spinnerItem() {
        final Typeface tf = ResourcesCompat.getFont(ctx, R.font.gilroysemi);

        adapter = new ArrayAdapter<String>(ctx, android.R.layout.simple_spinner_item){

            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                TextView v = (TextView)super.getView(position,convertView,parent);
                if (position == getCount()) {
                    ((TextView)v.findViewById(android.R.id.text1)).setText("");
                    ((TextView)v.findViewById(android.R.id.text1)).setHint(getItem(getCount())); //"Hint to be displayed"
                }
                v.setTypeface(tf);
                return v;
            }

            @Override
            public int getCount() {
                return super.getCount() -1; // you dont display last item. It is used as hint.
            }

        };

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter.add("Ids");
        adapter.add("Passwords");
        adapter.add("Credit/Debit Cards");
        adapter.add("Personal Info");
        adapter.add("choose category"); //This is the text that will be displayed as hint.

        spncategory.setAdapter(adapter);
        spncategory.setSelection(adapter.getCount()); //set the hint the default selection so it appears on launch.
        //spncategory.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
    }

}
