package com.example.modul_1_zaniatie_2_dom_3_textview;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 0; i <= 8; i++){


            Log.d("MYLOG", "" + i);
        }

        int ticketPrice = 10;

        TextView tvEnter = findViewById(R.id.tvEnter);
        tvEnter.setText("Hello, passenger! Please, provide your age.");
        tvEnter.setTextSize(32);
        tvEnter.setTextColor(Color.BLACK);
        tvEnter.setBackgroundColor(Color.WHITE);
        tvEnter.setPadding(200,300,200,100);

        TextView tvText = findViewById(R.id.tvText);
        tvText.setText("Your age");
        tvText.setTextSize(18);
        tvText.setTextColor(Color.BLACK);

        Button btEnter = findViewById(R.id.btEnter);
        EditText etInput = findViewById(R.id.etInput);

        btEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int etAge = Integer.parseInt(etInput.getText().toString());

                if (etAge < 18){
                    tvEnter.setBackgroundColor(Color.CYAN);
                    tvEnter.setText("You are child. Ticket is free for you. Please, take your place.");
                    Log.d("MYLOG", "You are child. Ticket is free for you. Please, take your place.");
                } else if ((etAge >= 18) && (etAge <= 60)){

                    tvEnter.setText("You are adult. You need a ticket. Please, make a payment.");
                    Log.d("MYLOG", "You are adult. You need a ticket. Please, make a payment.");

                    btEnter.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int etPayment = Integer.parseInt(etInput.getText().toString());
                            int needPayment = ticketPrice - etPayment;

                            if (etPayment == ticketPrice){
                                tvEnter.setBackgroundColor(Color.CYAN);
                                tvEnter.setText("Thank you. Please, take your place.");
                                Log.d("MYLOG", "Thank you. Please, take your place.");
                            } else if (etPayment < ticketPrice){
                                tvEnter.setBackgroundColor(Color.RED);
                                tvEnter.setText("Ticket price is 10, please add money. You need to add " + needPayment + " UAH.");
                                Log.d("MYLOG", "Ticket price is 10, please add money. You need to add \" + needPayment + \" UAH.");
                                Log.d("MYLOG", "You need to add " + needPayment + " UAH.");

                                btEnter.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        int etPayment = Integer.parseInt(etInput.getText().toString());

                                        if (etPayment == needPayment){
                                            tvEnter.setBackgroundColor(Color.CYAN);
                                            tvEnter.setText("Thank you. Please, take your place.");
                                            Log.d("MYLOG", "Thank you. Please, take your place.");
                                        } else if (etPayment < needPayment){
                                            tvEnter.setBackgroundColor(Color.RED);
                                            tvEnter.setText("Excuse me. This bus is not for you. Goodbye.");
                                            Log.d("MYLOG", "Excuse me. This bus is not for you. Goodbye.");
                                        } else if (etPayment > needPayment){
                                            int refund = etPayment - needPayment;
                                            tvEnter.setBackgroundColor(Color.CYAN);
                                            tvEnter.setText("Ok. Thank you. " + refund + " UAH will be refunded back to you. Please, take your place.");
                                            Log.d("MYLOG", "Ok. Thank you. " + refund + " UAH will be refunded back to you. Please, take your place.");
                                        }
                                    }
                                });
                            } else if (etPayment > ticketPrice){
                                int refund = etPayment - ticketPrice;

                                tvEnter.setBackgroundColor(Color.CYAN);
                                tvEnter.setText("Ok. Thank you. " + refund + " UAH will be refunded back to you. Please, take your place.");
                                Log.d("MYLOG", "Thank you. Please, take your place.");
                            }
                        }
                    });
                } else if (etAge > 60){
                    tvEnter.setText("You are pensioner. Do you have pensioner's ID?");
                    tvText.setText("Yes - 1 / 0 - No");
                    Log.d("MYLOG", "You are pensioner. Do you have pensioner's ID?");

                    btEnter.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int etPensionerId = Integer.parseInt(etInput.getText().toString());

                            if (etPensionerId == 1){
                                tvEnter.setText("Ok. Thank you. Please, take your place.");
                                Log.d("MYLOG","Ok. Thank you. Please, take your place.");
                            } else {
                                tvEnter.setText("You need a ticket. Please, make a payment.");
                                tvText.setText("Payment");
                                btEnter.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        int etPayment = Integer.parseInt(etInput.getText().toString());
                                        int needPayment = ticketPrice - etPayment;

                                        if (etPayment == ticketPrice){
                                            tvEnter.setBackgroundColor(Color.CYAN);
                                            tvEnter.setText("Thank you. Please, take your place.");
                                            Log.d("MYLOG", "Thank you. Please, take your place.");
                                        } else if (etPayment < ticketPrice){
                                            tvEnter.setBackgroundColor(Color.RED);
                                            tvEnter.setText("Ticket price is 10, please add money. You need to add " + needPayment + " UAH.");
                                            Log.d("MYLOG", "Ticket price is 10, please add money. You need to add \" + needPayment + \" UAH.");
                                            Log.d("MYLOG", "You need to add " + needPayment + " UAH.");

                                            btEnter.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    int etPayment = Integer.parseInt(etInput.getText().toString());

                                                    if (etPayment == ticketPrice){
                                                        tvEnter.setBackgroundColor(Color.CYAN);
                                                        tvEnter.setText("Thank you. Please, take your place.");
                                                        Log.d("MYLOG", "Thank you. Please, take your place.");
                                                    } else if (etPayment < ticketPrice){
                                                        tvEnter.setBackgroundColor(Color.RED);
                                                        tvEnter.setText("Excuse me. This bus is not for you. Goodbye.");
                                                        Log.d("MYLOG", "Excuse me. This bus is not for you. Goodbye.");
                                                    } else if (etPayment > ticketPrice){
                                                        int refund = etPayment - ticketPrice;
                                                        tvEnter.setBackgroundColor(Color.CYAN);
                                                        tvEnter.setText("Ok. Thank you. " + refund + " UAH will be refunded back to you. Please, take your place.");
                                                        Log.d("MYLOG", "Ok. Thank you. " + refund + " UAH will be refunded back to you. Please, take your place.");
                                                    }
                                                }
                                            });
                                        } else if (etPayment > ticketPrice){
                                            int refund = etPayment - ticketPrice;

                                            tvEnter.setBackgroundColor(Color.CYAN);
                                            tvEnter.setText("Ok. Thank you. " + refund + " UAH will be refunded back to you. Please, take your place.");
                                            Log.d("MYLOG", "Thank you. Please, take your place.");
                                        }
                                    }
                                });
                            }
                        }
                    });
                }
            }
        });



    }
}