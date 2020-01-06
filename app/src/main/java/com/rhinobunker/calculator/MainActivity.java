package com.rhinobunker.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/*
Things to Add:
- a memory value function with M+ , M- , MR , MC buttons
- a history calculation function (displays below the calculator
- formatting the final calculation so it doesn't show '.0' if a whole number
- a percent button (%)
- a squared function (x^2)
- fix the button layout


 */

public class MainActivity extends AppCompatActivity {
    private EditText operand1;
    private EditText operand2;
    private Button btnAddition;
    private Button btnSubtraction;
    private Button btnDivision;
    private Button btnMultiplication;
    private Button btnClear;
    private Button btnDecimal;
    private Button btnEquals;
    private Button btnPosNeg;
    private Button btnSqrt;
    private Button btnBackspace;
    private Button btnPercent;

    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private Button btn0;

    String operator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        operand2 = (EditText) findViewById(R.id.txtOperand2);
        operand1 = (EditText) findViewById(R.id.txtOperand1);
        btnAddition = (Button) findViewById(R.id.btnAddition);
        btnSubtraction = (Button) findViewById(R.id.btnSubtraction);
        btnDivision = (Button) findViewById(R.id.btnDivision);
        btnMultiplication = (Button) findViewById(R.id.btnMultiplication);
        btnClear = (Button) findViewById(R.id.btnClear);
        btnDecimal = (Button) findViewById(R.id.btnDecimal);
        btnEquals = (Button) findViewById(R.id.btnEquals);
        btnPosNeg = (Button) findViewById(R.id.btnPosNeg);
        btnSqrt = (Button) findViewById(R.id.btnSqrt);
        btnBackspace = (Button) findViewById(R.id.btnBackspace);
        btnPercent = (Button) findViewById(R.id.btnPercent);

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btn0 = (Button) findViewById(R.id.btn0);

        // ON-CLICK-LISTENERS
        btnAddition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (operand1.getText().length() > 0) {
                    operand2.setText(operand1.getText().toString());
                    operand1.setText("");
                    operator = "Addition";
                } else {
                    Toast.makeText(MainActivity.this, "Please enter numbers in both operand fields", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnSubtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (operand1.getText().length() > 0) {
                    operand2.setText(operand1.getText().toString());
                    operand1.setText("");
                    operator = "Subtraction";
                } else {
                    Toast.makeText(MainActivity.this, "Please enter numbers in both operand fields", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnMultiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (operand1.getText().length() > 0) {
                    operand2.setText(operand1.getText().toString());
                    operand1.setText("");
                    operator = "Multiplication";
                } else {
                    Toast.makeText(MainActivity.this, "Please enter numbers in both operand fields", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (operand1.getText().length() > 0) {
                    operand2.setText(operand1.getText().toString());
                    operand1.setText("");
                    operator = "Division";
                } else {
                    Toast.makeText(MainActivity.this, "Please enter numbers in both operand fields", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operand1.setText("");
                operand2.setText("");
                operand1.requestFocus();
            }
        });

        btnDecimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (operand1.getText().length() > 0 && !hasDecimal(operand1.getText().toString())) {
                    String str1 = operand1.getText().toString();
                    String str2 = ".";
                    String str3 = str1 + str2;
                    operand1.setText(str3);
                } else if (operand1.getText().length() == 0 && !hasDecimal(operand1.getText().toString())) {
                    operand1.setText("0.");
                }
            }
        });

        btnEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double oper1 = Double.parseDouble(operand1.getText().toString());
                Double oper2 = Double.parseDouble(operand2.getText().toString());
                Double theResult;

                switch (operator) {
                    case "Addition" : theResult = oper2 + oper1; break;
                    case "Subtraction" : theResult = oper2 - oper1; break;
                    case "Multiplication" : theResult = oper2 * oper1; break;
                    case "Division" : theResult = oper2 / oper1; break;
                    default : theResult = 0.0000;
                }

                operand1.setText(Double.toString(theResult));
            }
        });

        btnPosNeg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isValidNumber(operand1.getText().toString())) {
                    Double oper1 = Double.parseDouble(operand1.getText().toString());
                    Double theResult = oper1 * -1;
                    operand1.setText(Double.toString(theResult));
                } else {
                    operand1.setText("-0");
                }
            }
        });

        btnSqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isValidNumber(operand1.getText().toString())) {
                    Double oper1 = Double.parseDouble(operand1.getText().toString());
                    Double theResult = Math.sqrt(oper1);
                    operand1.setText(Double.toString(theResult));
                }
            }
        });

        btnBackspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value = operand1.getText().toString();
                if (value.length() > 0 && !value.equalsIgnoreCase("0")) {
                    operand1.setText(value.substring(0, value.length() - 1));
                } else {
                    operand1.setText("0");
                }
            }
        });

        btnPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isValidNumber(operand1.getText().toString())) {
                    Double oper1 = Double.parseDouble(operand1.getText().toString());
                    Double theResult = oper1 * .01;
                    operand1.setText(Double.toString(theResult));
                } else {
                    operand1.setText("0");
                }
            }
        });


        // ON-CLICK-LISTENERS FOR THE NUMBER BUTTONS
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str1 = operand1.getText().toString();
                String str2 = "1";
                String str3 = str1 + str2;
                operand1.setText(str3);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str1 = operand1.getText().toString();
                String str2 = "2";
                String str3 = str1 + str2;
                operand1.setText(str3);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str1 = operand1.getText().toString();
                String str2 = "3";
                String str3 = str1 + str2;
                operand1.setText(str3);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str1 = operand1.getText().toString();
                String str2 = "4";
                String str3 = str1 + str2;
                operand1.setText(str3);
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str1 = operand1.getText().toString();
                String str2 = "5";
                String str3 = str1 + str2;
                operand1.setText(str3);
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str1 = operand1.getText().toString();
                String str2 = "6";
                String str3 = str1 + str2;
                operand1.setText(str3);
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str1 = operand1.getText().toString();
                String str2 = "7";
                String str3 = str1 + str2;
                operand1.setText(str3);
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str1 = operand1.getText().toString();
                String str2 = "8";
                String str3 = str1 + str2;
                operand1.setText(str3);
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str1 = operand1.getText().toString();
                String str2 = "9";
                String str3 = str1 + str2;
                operand1.setText(str3);
            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str1 = operand1.getText().toString();
                String str2 = "0";
                String str3 = str1 + str2;
                operand1.setText(str3);
            }
        });
    }

    public Boolean hasDecimal(String string) {
        boolean result = false;
        Character[] number = new Character[string.length()];
        for (int i = 0; i < string.length(); i++) {
            number[i] = string.charAt(i);
            if (number[i].equals('.')) {
                result = true;
            }
        }
        Log.d("TESTING !!!!!", "ReSuLt for hasDecimal() = " + result);
        return result;
    }

    public Boolean hasDecimalLast(String string) {
        boolean result = false;
        int last = string.length() - 1;

        if ((Character) string.charAt(last) == '.') {
            result = true;
        }

        Log.d("TeStInG !!!", "Result for hasDecimalLast() = " + result);
        return result;
    }

    public Boolean isValidNumber(String string) {
        if (string.equalsIgnoreCase("")) {
            return false;
        } else {
            return true;
        }
    }
}
