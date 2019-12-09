    package com.example.hw4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

    public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etEmail;
    EditText etPass;
    Button btSave;
    Button btClear;
    Button btRetrieve;
    String mypreference;

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = (EditText) findViewById(R.id.etName);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPass = (EditText) findViewById(R.id.etPass);

        btSave = findViewById(R.id.btSave);
        btClear = findViewById(R.id.btClear);
        btRetrieve = findViewById(R.id.btRetrieve);

        final SharedPreferences sharedpreferences = getSharedPreferences(mypreference, Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedpreferences.edit();

        btClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etEmail.setText("");
                etName.setText("");
                etPass.setText("");
                editor.clear();
                editor.commit();
            }
        });

            btSave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    editor.putString("name",etName.getText().toString());
                    editor.putString("email", etEmail.getText().toString());
                    editor.putString("password",etPass.getText().toString());
                    editor.commit();
                }
            });

            btRetrieve.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    etName.setText(sharedpreferences.getString("name",null));
                    etEmail.setText(sharedpreferences.getString("email",null));
                    etPass.setText(sharedpreferences.getString("password",null));
                }
            });

    }


}
