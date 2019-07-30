package com.example.justjava;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.NumberFormat;

import static java.lang.Math.sqrt;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 3;
    TextView priceTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        priceTextView = (TextView) findViewById(R.id.price_text_view);
    }

    /**
     * This method is called when the plus button is clicked.
     */
    public void increment(View view) {
        quantity = quantity + 1;
        display(quantity);
    }

    /**
     * This method is called when the plus button is clicked.
     */
    public void decrement(View view) {
        quantity = quantity - 1;
        display(quantity);

    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        display(quantity);
        int price = 5;
        displayPrice(price * quantity);

        int Total = price * quantity;

        Intent intent = new Intent(this, Main2Activity.class);
        intent.putExtra("amount", Total);
        startActivityForResult(intent, 23);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayPrice(int number) {
        //priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == 23) {
            String text = data.getStringExtra("ronnie");
            priceTextView.setText(text);

        }
    }
}
