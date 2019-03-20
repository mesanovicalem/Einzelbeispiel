package com.example.einzelbeispiel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button berechnen = (Button) findViewById(R.id.button2);
        berechnen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText eingabeFeld = (EditText) findViewById(R.id.editText);
                TextView ergebnis = (TextView) findViewById(R.id.textView3);

                String value = eingabeFeld.getText().toString();

                int[] ziffern = new int[value.length()];
                for (int i = 0; i < value.length(); i++) {
                    ziffern[i] = Integer.parseInt(String.valueOf(value.charAt(i)));
                }

                for (int j = 0; j < value.length(); j++) {
                    if (ziffern[j] % 2 == 0 || ziffern[j] % 3 == 0) {
                        continue;
                    } else {
                        ziffern[j] = 0;
                    }
                }

                Arrays.sort(ziffern);

                int count = 0;
                for (int n = 0; n < value.length(); n++) {
                    if (ziffern[n] == 0) {
                        count++;
                    }
                }

                int[] arr = new int[value.length() - count];
                int x = 0;
                for (int k = 0; k < value.length(); k++) {
                    if (ziffern[k] == 0) {
                        continue;
                    } else {
                        arr[x] = ziffern[k];
                        x++;
                    }
                }

                Arrays.sort(arr);

                String endErgebnis = Arrays.toString(arr);

                ergebnis.setText(endErgebnis);

                String message = "Die Ziffern wurden nach der Größe sortiert, die Primzahlen wurden gestrichen.";

                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
            }
        });

    }
}
