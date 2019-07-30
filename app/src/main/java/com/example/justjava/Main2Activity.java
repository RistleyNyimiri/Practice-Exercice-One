package com.example.justjava;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    Button button;
    TextView textView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editText2);

        Intent totalPrice = getIntent();
        int amount = totalPrice.getIntExtra("amount", 0);

        String amountFinal = String.valueOf(amount);

        textView.setText(amountFinal);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SendText();
            }
        });
    }

    public void SendText() {
        String text = editText.getText().toString();
        Intent intent = new Intent(Main2Activity.this, MainActivity.class);
        intent.putExtra("ronnie", text);
        setResult(23, intent);

        finish();
    }

}
