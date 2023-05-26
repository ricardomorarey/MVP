package com.ricardomorarey.mycalculatormvp.presenters;

import com.ricardomorarey.mycalculatormvp.interactor.MyInteractorModel;
import com.ricardomorarey.mycalculatormvp.interfaces.MyModelInterface;
import com.ricardomorarey.mycalculatormvp.interfaces.MyOperationView;
import com.ricardomorarey.mycalculatormvp.interfaces.MyPresenterInterface;

public class MyMyPresenter implements MyPresenterInterface {

    private MyOperationView viewInteface;
    private MyModelInterface modelInteface;

    public MyMyPresenter(MyOperationView view) {
        this.viewInteface = view;
        this.modelInteface = new MyInteractorModel(this);
    }

    @Override
    public void showMyResult(String ramdom) {
        viewInteface.showRamdomResult(ramdom);
    }

    @Override
    public void showError() {
        viewInteface.invalidRamdomOperation();
    }

    @Override
    public void calculateRamdom(String myText) {
        modelInteface.calculateRamdom(myText);
    }
}
