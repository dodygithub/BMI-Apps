package com.example.bmiapps;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editTinggi,editBerat;
    TextView result;
    Button buttonKirim,buttonReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTinggi = (EditText) findViewById(R.id.tinggi);
        editBerat = (EditText) findViewById(R.id.berat);
        result = (TextView) findViewById(R.id.result);
        buttonKirim = (Button) findViewById(R.id.buttonKirim);
        buttonReset = (Button) findViewById(R.id.buttonReset);

        buttonKirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float tinggi = Integer.parseInt(editTinggi.getText().toString());
                float berat = Integer.parseInt(editBerat.getText().toString());
                float tinggi2 = tinggi/100;
                float hasil = berat/(tinggi2*tinggi2);

                String muncul;
                if (hasil < 18.5){
                    muncul = "Kekurangan Berat Badan";
                }
                else if (hasil >= 18.5 && hasil < 24.9){
                    muncul = "Normal (Ideal)";
                }
                else if (hasil >= 25.0 && hasil < 29.9){
                    muncul = "Kelebihan Berat Badan";
                }
                else{
                    muncul = "Kegemukan (Obesitas)";
                }

                result.setText(muncul);
            }
        });

        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editBerat.setText("");
                editTinggi.setText("");
                result.setText("");
                editBerat.requestFocus();
            }
        });
    }
}
