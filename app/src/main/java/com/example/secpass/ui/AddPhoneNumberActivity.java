package com.example.secpass.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.secpass.R;
import java.util.ArrayList;

public class AddPhoneNumberActivity extends AppCompatActivity implements View.OnClickListener {

    AutoCompleteTextView txtCategory;
    AutoCompleteTextView txtCountry;
    ImageView btnClose;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_phone_number);

        txtCategory = findViewById(R.id.txtCategory);
        txtCountry = findViewById(R.id.txtCountry);
        btnClose = findViewById(R.id.btnClose);

        btnClose.setOnClickListener(this);
        ArrayList<String> categories = new ArrayList<>();
        categories.add("abc");
        categories.add("xyz");
        categories.add("pqr");

        ArrayAdapter<String> categoriesAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                categories
        );

        txtCategory.setAdapter(categoriesAdapter);

        ArrayList<String> countries = new ArrayList<>();
        countries.add("India");
        countries.add("Canada");
        countries.add("US");

        ArrayAdapter<String> countriesAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                countries
        );

        txtCountry.setAdapter(countriesAdapter);
    }

    @Override
    public void onClick(View v) {
        onBackPressed();
    }
}
