package com.faaris.tipcalculator.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText bill;
    private SeekBar seekBar;
    private Button calculateTip;
    private TextView totalCost;
    private TextView percentage;
    private int seekBarPercentage;
    private float enteredBill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bill = (EditText) findViewById(R.id.billAmountID);
        seekBar = (SeekBar) findViewById(R.id.seekBarID);
        calculateTip = (Button) findViewById(R.id.calculateButtonID);
        totalCost = (TextView) findViewById(R.id.resultID);
        percentage = (TextView) findViewById(R.id.textViewSeekBar);

        calculateTip.setOnClickListener(this);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                percentage.setText(String.valueOf(seekBar.getProgress()) + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                seekBarPercentage = seekBar.getProgress();

            }
        });

    }

    public void onClick(View v)
    {
        calculate();
    }

    public void calculate()
    {
        float result = 0.0f;

        if(!bill.getText().toString().equals(""))
        {
            enteredBill = Float.parseFloat(bill.getText().toString());
            result = enteredBill * seekBarPercentage / 100;
            float total = result + enteredBill;
            totalCost.setText("Your tip will be $" + String.valueOf(result) + "\n" + "Your total will be $" + String.valueOf(total)); //converts float to string
        }
        else{
            Toast.makeText(MainActivity.this, "Please enter a bill amount", Toast.LENGTH_LONG).show();
        }
    }
}
