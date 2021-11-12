package com.example.depozitniy_calculiator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    Button rez;
    TextView  dohod;
    EditText sum, percent;
    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rez = findViewById(R.id.btnrez);
        sum = findViewById(R.id.txtSum);
        percent = findViewById(R.id.txtPersent);
        dohod = findViewById(R.id.dohod);
        checkBox = findViewById(R.id.checkBox);
        checkBox.setChecked(false);
    }

    @SuppressLint("SetTextI18n")
    public  void onClick(View v){
        double suma;
        if ((TextUtils.isEmpty(sum.getText().toString())) && (TextUtils.isEmpty(percent.getText().toString()))) {
         Toast.makeText(this, "Заполните все поля ", Toast.LENGTH_SHORT).show();
        }else {

            Model data = new Model(Float.parseFloat(sum.getText().toString()), Float.parseFloat(percent.getText().toString()));
            UseCase rashetUseCase = new UseCase();
            suma = rashetUseCase.rashet(data);

            if (!checkBox.isChecked()) {
                dohod.setText("Доход в месяц " + suma + "грн.");
                Snackbar.make(v, "Маловато будет!!!", Snackbar.LENGTH_LONG).show();
            }
            else {
                dohod.setText("Доход в месяц " + suma * 1.19 + "грн.");
                Snackbar.make(v, "Налоги надо платить...", Snackbar.LENGTH_LONG).show();
            }
        }
    }

    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("count", (String) dohod.getText());
    }

    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String cnt;
        cnt = savedInstanceState.getString("count");
        dohod.setText(cnt);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
                return true;
    }

    @SuppressLint({"NonConstantResourceId", "SetTextI18n"})
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.MonoBank:
                percent.setText("10");
                Toast.makeText(MainActivity.this, "MonoBank" , Toast.LENGTH_SHORT).show();
                break;
            case R.id.Privat:
                percent.setText("7");
                Toast.makeText(MainActivity.this, "Privat " , Toast.LENGTH_SHORT).show();
                break;
            case R.id.Oshadbank:
                percent.setText("7");
                Toast.makeText(MainActivity.this, "Oschadbank" , Toast.LENGTH_SHORT).show();
                break;
            case R.id.Aval:
                percent.setText("6.25");
                Toast.makeText(MainActivity.this, "Aval" , Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}