package net.androidbootcamp.homemortgageinterest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    float decPayment;
    int intYears;
    int intMonths;
    int intPrincipal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText payment = (EditText) findViewById(R.id.txtPayment);
        final EditText years = (EditText) findViewById(R.id.txtYears);
        final EditText principal = (EditText) findViewById(R.id.txtPrincipal);
        Button button = (Button) findViewById(R.id.btnCompute);
        final SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decPayment = Float.parseFloat(payment.getText().toString());
                intYears = Integer.parseInt(years.getText().toString());
                intMonths = intYears*12;
                intPrincipal = Integer.parseInt((principal.getText().toString()));
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putFloat("key1", decPayment);
                editor.putInt("key2", intYears);
                editor.putInt("key3", intMonths);
                editor.putInt("key4", intPrincipal);
                editor.commit();
                startActivity(new Intent(MainActivity.this, Interest.class));
            }
        });
    }
}
