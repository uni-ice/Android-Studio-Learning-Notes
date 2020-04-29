package com.example.unitconverter;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
  private String[] strings = new String[]{"Metre", "Celsius", "Kilograms"};
  private TextView tv1, tv2, tv3, tv4, tv5, tv6;
  private ImageView img1, img2, img3;
  private EditText ed;
  private Spinner  spinner;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    spinner = findViewById(R.id.spinner);
    tv1 = findViewById(R.id.tv1);
    tv2 = findViewById(R.id.tv2);
    tv3 = findViewById(R.id.tv3);
    tv4 = findViewById(R.id.tv4);
    tv5 = findViewById(R.id.tv5);
    tv6 = findViewById(R.id.tv6);
    img1 = findViewById(R.id.img1);
    img2 = findViewById(R.id.img2);
    img3 = findViewById(R.id.img3);
    ed = findViewById(R.id.ed);
    ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, strings);
    spinner.setAdapter(adapter);
    spinner.setSelection(0);

    img1.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        spinner.setSelection(0);
        conversion(strings[0]);
      }
    });

    img2.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        spinner.setSelection(1);
        conversion(strings[1]);
      }
    });

    img3.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        spinner.setSelection(2);
        conversion(strings[2]);
      }
    });
  }

  void conversion(String type) {
    String s = ed.getText().toString();
    if (s.isEmpty()) {
      Toast.makeText(MainActivity.this, "The input cannot be null!", Toast.LENGTH_SHORT).show();
    } else {
      int i = Integer.parseInt(s);
      double t1, t2, t3;
      String t4, t5, t6;
      if (type.equals(strings[0])) {//Metre
        t1 = i * 100;
        t4 = "Centimetre";

        t2 = (i * 100) / 2.54 / 12;
        t5 = "Foot";

        t3 = (i * 100) / 2.54;
        t6 = "InCh";
        tv3.setVisibility(View.VISIBLE);
        tv6.setVisibility(View.VISIBLE);
      } else if (type.equals(strings[1])) { // Celsius
        t1 = 32 + (i * 1.8);
        t4 = "Fahrenheit";

        t2 = i + 273.15;
        t5 = "Kelvin";
        t3 = 0;
        t6 = "";
        tv3.setVisibility(View.GONE);
        tv6.setVisibility(View.GONE);
      } else {   //Kilograms
        t1 = i * 1000;
        t4 = "Gram";

        t2 = i * 35.27;
        t5 = "Ounce(Oz)";

        t3 = i * 2.2046226;
        t6 = "Pound(lb)";
        tv3.setVisibility(View.VISIBLE);
        tv6.setVisibility(View.VISIBLE);
      }
      DecimalFormat df = new DecimalFormat("0.00");
      String format1 = df.format(t1);
      String format2 = df.format(t2);
      if (t3 != 0) {
        String format3 = df.format(t3);
        tv3.setText(format3);
      }
      tv1.setText(format1);
      tv2.setText(format2);
      tv4.setText(t4);
      tv5.setText(t5);
      tv6.setText(t6);
    }
  }
}
