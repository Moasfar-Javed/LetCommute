package com.example.letcommute;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SigninActivity extends AppCompatActivity implements View.OnClickListener{

    List<String> users = new ArrayList<>();
    List<String> passwords = new ArrayList<>();
    TextView username, password;
    Button signIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        users.add("admin");
        passwords.add("admin");
        username = (TextView) findViewById(R.id.usernameTxt);
        password = (TextView) findViewById(R.id.passwordTxt);
        signIn = (Button) findViewById(R.id.signInBtn);



    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.signInBtn){
            String name = username.getText().toString();
            String pass = password.getText().toString();

            boolean existsCheck = users.contains(name) && passwords.contains(pass);
            //boolean matchCheck = users.indexOf(name) == passwords.indexOf(pass);

            if (existsCheck){
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                intent.putExtra("username_key", name);
                startActivity(intent);

            } else {
                AlertDialog alertDialog = new AlertDialog.Builder(SigninActivity.this).create();
                alertDialog.setTitle("Invalid Credentials");
                alertDialog.setMessage("\nCheck your credentials \nSign up if you do not have an account");
                alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();

            }


        } else if (view.getId() == R.id.signUpInsteadbtn){
            Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
            startActivityForResult(intent, 1);

        }


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1){
            if (resultCode == Activity.RESULT_OK){
                String userIntent = data.getStringExtra("username_key");
                String passIntent = data.getStringExtra("password_key");
                users.add(userIntent);
                passwords.add(passIntent);
                System.out.println(users);
                System.out.println(passwords);
            }

        }
    }

}