package com.ricardomorarey.mycalculatormvp.views;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ricardomorarey.mycalculatormvp.R;
import com.ricardomorarey.mycalculatormvp.interfaces.MyOperationView;
import com.ricardomorarey.mycalculatormvp.interfaces.MyPresenterInterface;
import com.ricardomorarey.mycalculatormvp.interfaces.OperationPresenter;
import com.ricardomorarey.mycalculatormvp.interfaces.OperationView;
import com.ricardomorarey.mycalculatormvp.presenters.MyMyPresenter;
import com.ricardomorarey.mycalculatormvp.presenters.OperationMyPresenterImpl;

public class OperationActivityView extends AppCompatActivity implements OperationView, MyOperationView {

    private EditText number1;
    private EditText number2;
    private TextView mytextview;
    private TextView txtResult;
    private OperationPresenter presenter;
    private MyPresenterInterface mypresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operation);

        number1 = findViewById(R.id.txtNumber1);
        number2 = findViewById(R.id.txtNumber2);
        txtResult = findViewById(R.id.txtResult);
        mytextview = findViewById(R.id.textView);
        Button btnRamdom = findViewById(R.id.show_ramdom);
        presenter = new OperationMyPresenterImpl(this);
        mypresenter = new MyMyPresenter(this);

        btnRamdom.setOnClickListener(v -> doRamdom());
    }

    public void doAdd(View view) {
        try {
            int num1 = Integer.parseInt(number1.getText().toString());
            int num2 = Integer.parseInt(number2.getText().toString());
            presenter.add(num1, num2);
        } catch (NumberFormatException e) {
            invalidOperation();
        }
    }

    public void doSubtract(View view) {
        try {
            int num1 = Integer.parseInt(number1.getText().toString());
            int num2 = Integer.parseInt(number2.getText().toString());
            presenter.subtract(num1, num2);
        } catch (NumberFormatException e) {
            invalidOperation();
        }

    }

    public void doMultiply(View view) {
        try {
            int num1 = Integer.parseInt(number1.getText().toString());
            int num2 = Integer.parseInt(number2.getText().toString());
            presenter.multiply(num1, num2);
        } catch (NumberFormatException e) {
            invalidOperation();
        }

    }

    public void doDivide(View view) {
        try {
            int num1 = Integer.parseInt(number1.getText().toString());
            int num2 = Integer.parseInt(number2.getText().toString());
            presenter.divide(num1, num2);
        } catch (NumberFormatException e) {
            invalidOperation();
        }

    }

    public void doRamdom() {
        try {
            mypresenter.calculateRamdom("hola cara bola");
        } catch (Exception e) {
            Log.e("ric", e.toString());
            invalidRamdomOperation();
        }

    }

    @Override
    public void showResult(String result) {
        txtResult.setText(result);
    }

    @Override
    public void invalidOperation() {
        Toast.makeText(this, "Invalid operation", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showRamdomResult(String result) {
        mytextview.setText(result);
    }

    @Override
    public void invalidRamdomOperation() {
        Toast.makeText(this, "Invalid operation", Toast.LENGTH_SHORT).show();
    }
}
