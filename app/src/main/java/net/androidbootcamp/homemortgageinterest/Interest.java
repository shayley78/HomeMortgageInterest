package net.androidbootcamp.homemortgageinterest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Interest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interest);
        TextView interestPaid = (TextView)findViewById(R.id.txtInterest);
        ImageView image = (ImageView)findViewById(R.id.imgYears);
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        float decPayment = sharedPref.getFloat("key1", 0);
        int intYears = sharedPref.getInt("key2", 0);
        int intMonths = sharedPref.getInt("key3", 0);
        int intPrincipal = sharedPref.getInt("key4", 0);
        float decIntPaid;

        decIntPaid = (decPayment * intMonths) - intPrincipal;
        DecimalFormat currency = new DecimalFormat("$###,###.##");
        interestPaid.setText("Total interest paid " + currency.format(decIntPaid));
        if(intYears == 10){
            image.setImageResource(R.drawable.ten);
        } else if (intYears == 20) {
            image.setImageResource(R.drawable.twenty);
        } else if (intYears == 30) {
            image.setImageResource(R.drawable.thirty);
        } else {
            interestPaid.setText("Enter 10, 20 or 30 years");
        }
    }
}
