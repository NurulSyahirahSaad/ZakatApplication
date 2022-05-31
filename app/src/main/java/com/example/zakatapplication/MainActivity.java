package com.example.zakatapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonStart = (Button) findViewById(R.id.buttonStart);
        buttonStart.setOnClickListener(this);

    }

    public boolean onCreateOptionsMenu(Menu menu){

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu); // resource.directory.xml, variable param

        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){

        switch(item.getItemId()){

            case R.id.about:

                Toast.makeText(this,"Student's Details",Toast.LENGTH_LONG).show();
                //connect and display activitytab :
                Intent intentDev = new Intent(this, AboutUs.class);
                startActivity(intentDev);
                break;

            case R.id.info:

                Toast.makeText(this,"Zakat Information",Toast.LENGTH_LONG).show();
                Intent intentAbt = new Intent(this, ZakatInfo.class);
                startActivity(intentAbt);
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.buttonStart:

                Intent intentZakat = new Intent(this, ZakatCalculator.class);
                startActivity(intentZakat);
                break;

        }
    }
}

