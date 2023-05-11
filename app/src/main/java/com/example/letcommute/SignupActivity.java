package com.example.letcommute;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener{

    RadioButton owner, finder;
    TextView username, password, confirmPassword;
    Button signUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        username = (TextView) findViewById(R.id.usernameTxt);
        password = (TextView) findViewById(R.id.passwordTxt);
        confirmPassword = (TextView) findViewById(R.id.confPasswordTxt);
        signUp = (Button) findViewById(R.id.signUpBtn);
        owner = (RadioButton) findViewById(R.id.ownerRadio);
        finder = (RadioButton) findViewById(R.id.finderRadio);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.signUpBtn){
            String name = username.getText().toString();
            String pass = password.getText().toString();
            String cPass = confirmPassword.getText().toString();

            boolean passMatchCheck = pass.equals(cPass);
            boolean fieldsEmptyCheck = !name.equals("") && !pass.equals("") && !cPass.equals("");
            boolean radioSelectCheck = !owner.isChecked() || !finder.isChecked();

            if (fieldsEmptyCheck && passMatchCheck && radioSelectCheck){
                Intent intent = new Intent(getApplicationContext(), SigninActivity.class);
                intent.putExtra("username_key", name);
                intent.putExtra("password_key", pass);
                setResult(Activity.RESULT_OK, intent);
                finish();
            } else {
                AlertDialog alertDialog = new AlertDialog.Builder(SignupActivity.this).create();
                alertDialog.setTitle("Invalid Input");
                alertDialog.setMessage("\nCheck your credentials \nInvalid or incomplete input provided");
                alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();
            }

        } else if (view.getId() == R.id.signInInsteadBtn){
            Intent intent = new Intent(getApplicationContext(), SigninActivity.class);
            setResult(Activity.RESULT_CANCELED, intent);
            finish();

        }
    }
}