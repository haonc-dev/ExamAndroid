package com.example.nguyenchihao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import com.example.nguyenchihao.model.FeedbackEntity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn;
    EditText etFirstName, etEmail, etPassword;
    boolean isAllFieldsChecked = false; AppDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = AppDatabase.getAppDatabase(this);
        btn= findViewById(R.id.button);
        etFirstName = findViewById(R.id.name);

        etEmail = findViewById(R.id.email);
        etPassword = findViewById(R.id.edittext);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                isAllFieldsChecked = CheckAllFields();


                if (isAllFieldsChecked) {
                    Intent i = new Intent(MainActivity.this, MainActivity.class);
                    startActivity(i);
                }
            }
        });
    }
    private void onAdd(){
        if (!CheckAllFields()) {
            return;
        }


        FeedbackEntity customerEntity = new FeedbackEntity();
        customerEntity.username = etFirstName.getText().toString();
        customerEntity.email = etEmail.getText().toString();
        customerEntity.content = etPassword.getText().toString();
        db.customerDao().insertCustomer(customerEntity);
        goToListUser();

    }
    private void goToListUser() {
        Intent intent = new Intent(this, ListCustomerActivity.class);
        startActivity(intent);
    }
    private boolean CheckAllFields() {
        if (etFirstName.length() == 0) {
            etFirstName.setError("This field is required");
            return false;
        }


        if (etEmail.length() == 0) {
            etEmail.setError("Email is required");
            return false;
        }

        if (etPassword.length() == 0) {
            etPassword.setError(" is required");
            return false;
        } else if (etPassword.length() < 8) {
            etPassword.setError(" must be minimum 8 characters");
            return false;
        }


        return true;
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                onAdd();
                break;
            default:
                break;
        }
    }
}