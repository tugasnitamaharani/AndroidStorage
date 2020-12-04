package com.example.androidstorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText_username,editText_password;
    Button button_login;
    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_PASSWORD = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText_username = findViewById(R.id.editext_username);
        editText_password = findViewById(R.id.editext_password);
        button_login = findViewById(R.id.button_login);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);

        String username = sharedPreferences.getString(KEY_USERNAME, null);

        if (username != null){
            Intent intent = new Intent(MainActivity.this,HomeActivity.class);
            startActivity(intent);

        }

        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences.Editor editor =sharedPreferences.edit();
                editor.putString(KEY_USERNAME,editText_username.getText().toString());
                editor.putString(KEY_PASSWORD,editText_password.getText().toString());
                editor.apply();

                Intent intent = new Intent(MainActivity.this,HomeActivity.class);
                startActivity(intent);

                Toast.makeText(MainActivity.this, "Login Success", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
