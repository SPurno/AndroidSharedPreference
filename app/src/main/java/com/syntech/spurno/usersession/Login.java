package com.syntech.spurno.usersession;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


public class Login extends AppCompatActivity {
    EditText username,password;
    Button submit, show;
    TextView data;
    RelativeLayout loginForm;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.usernameText);
        password = (EditText)findViewById(R.id.passwordText);
        submit = findViewById(R.id.submit);
        show = findViewById(R.id.showdata);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    SaveData();
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    LoadData();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void SaveData(){
        String mUserName = username.getText().toString();
        String mPass = password.getText().toString();
        
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("key_name1", mUserName);  // Saving string
        editor.putString("key_name2", mPass);  // Saving string
        // Save the changes in SharedPreferences
        editor.commit(); // commit changes
        Toast.makeText(getApplicationContext(), "Data is saved successfully", Toast.LENGTH_LONG).show();
    }

    private void LoadData() {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        String Pass = pref.getString("key_name1", null);             // getting Integer
        String email = pref.getString("key_name2", null);         // getting String

        Toast.makeText(getApplicationContext(),"User Name: " + email +  "\n Password: " + Pass, Toast.LENGTH_LONG).show();
    }

}

