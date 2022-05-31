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

public class ZakatCalculator extends AppCompatActivity implements View.OnClickListener {

    TextView output1;
    TextView output2;
    TextView output3;

    EditText weight;
    EditText value;
    Button button1;
    Button button2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zakat_calculator);

        //process1
        weight = (EditText) findViewById(R.id.weightgold);
        if(weight.getText().toString().equals("")){
            weight.setError("Please enter the weight (g).");
        }
        value = (EditText) findViewById(R.id.valuegold);
        if(value.getText().toString().equals("")){
            value.setError("Please enter the value per (g).");
        }
        output1 = (TextView) findViewById(R.id.totalvaluegold);
        button1 = (Button) findViewById(R.id.btnkeep);
        button1.setOnClickListener(this);

        //process2
        output2 = (TextView) findViewById(R.id.totalvaluepayable);
        output3 = (TextView) findViewById(R.id.totalvaluezakat);
        button2 = (Button) findViewById(R.id.btnwear);
        button2.setOnClickListener(this);

    }

    public boolean OnCreteOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.info:

                Toast.makeText(this, "Zakat Information", Toast.LENGTH_SHORT).show();
                Intent intentInfo = new Intent(this, ZakatInfo.class);
                startActivity(intentInfo);
                break;

            case R.id.about:

                Toast.makeText(this, "Student's Information", Toast.LENGTH_SHORT).show();
                Intent intentAbout = new Intent(this, AboutUs.class);
                startActivity(intentAbout);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {

        double weightgrams;
        double valuegrams;
        double totalvaluegold;
        int keep = 85;
        int wear = 200;
        double zakatpayable;
        double totalzakat;

        switch (view.getId()){

            case R.id.btnkeep:

                //process1
                weightgrams = Double.parseDouble(weight.getText().toString());
                valuegrams = Double.parseDouble(value.getText().toString());
                totalvaluegold = weightgrams * valuegrams;

                //process2
                zakatpayable = (weightgrams - keep) * valuegrams;
                if(zakatpayable < 0.0)
                {
                    totalzakat = 0 * 0.025;
                    output1.setText("The Total Value of Gold: RM"+totalvaluegold);
                    output2.setText("Total Zakat Payable: RM"+zakatpayable+" or RM0.00 because Zakat Payable is less than 0.");
                    output3.setText("Total Zakat : RM "+totalzakat);
                }

                else
                {
                    totalzakat = zakatpayable * 0.025;
                    output1.setText("The Total Value of Gold: RM"+totalvaluegold);
                    output2.setText("Total Zakat Payable: RM"+zakatpayable);
                    output3.setText("The Total Zakat : RM "+totalzakat);
                }
                Toast.makeText(this,"Successfully calculated for Keep.",Toast.LENGTH_LONG).show();

                break;

            case R.id.btnwear:

                //process1
                weightgrams = Double.parseDouble(weight.getText().toString());
                valuegrams = Double.parseDouble(value.getText().toString());
                totalvaluegold = weightgrams * valuegrams;

                //process2
                zakatpayable = (weightgrams - wear) * valuegrams;
                if(zakatpayable < 0.0)
                {
                    totalzakat = 0 * 0.025;
                    output1.setText("The Total Value of Gold: RM"+totalvaluegold);
                    output2.setText("Total Zakat Payable: RM"+zakatpayable+" or RM0.00 because Zakat Payable is less than 0.");
                    output3.setText("The Total Zakat : RM "+totalzakat);
                }

                else
                {
                    totalzakat = zakatpayable * 0.025;
                    output1.setText("The Total Value of Gold: RM"+totalvaluegold);
                    output2.setText("Total Zakat Payable: RM"+zakatpayable);
                    output3.setText("The Total Zakat : RM "+totalzakat);
                }
                Toast.makeText(this,"Successfully calculated for Wear.",Toast.LENGTH_LONG).show();

                break;
        }



    }
}

