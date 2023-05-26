package com.ricardomorarey.mycalculatormvp.interactor;

import android.util.Log;

import com.ricardomorarey.mycalculatormvp.interfaces.MyModelInterface;
import com.ricardomorarey.mycalculatormvp.interfaces.MyPresenterInterface;

import java.util.Random;

public class MyInteractorModel implements MyModelInterface {
    private String myText;
    private MyPresenterInterface presenterInterface;

    public MyInteractorModel(MyPresenterInterface myPresenterInterface) {
        this.presenterInterface = myPresenterInterface;
    }

    @Override
    public void calculateRamdom(String frase) {
        int valor = (int) (Math.random() * 10 + 1);
        String myvalor = String.valueOf(valor);
        Log.i("ric", myvalor);
        myText = frase + " " + myvalor;
        presenterInterface.showMyResult(myText);
    }
}
