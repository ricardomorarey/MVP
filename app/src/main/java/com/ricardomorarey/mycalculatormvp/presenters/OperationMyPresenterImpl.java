package com.ricardomorarey.mycalculatormvp.presenters;


import com.ricardomorarey.mycalculatormvp.interactor.OperationInteractorImpl;
import com.ricardomorarey.mycalculatormvp.interfaces.OperationInteractor;
import com.ricardomorarey.mycalculatormvp.interfaces.OperationPresenter;
import com.ricardomorarey.mycalculatormvp.interfaces.OperationView;

public class OperationMyPresenterImpl implements OperationPresenter{

    private OperationView view;
    private OperationInteractor interactor;

    public OperationMyPresenterImpl(OperationView view) {
        this.view = view;
        this.interactor = new OperationInteractorImpl(this);
    }

    @Override
    public void showResult(String result) {
        if (view != null) {
            view.showResult(result);
        }
    }

    @Override
    public void invalidOperation() {
        if (view != null) {
            view.invalidOperation();
        }
    }


    @Override
    public void add(int num1, int num2) {
        if (interactor != null) {
            interactor.add(num1, num2);
        }
    }

    @Override
    public void subtract(int num1, int num2) {
        if (interactor != null) {
            interactor.subtract(num1, num2);
        }
    }

    @Override
    public void multiply(int num1, int num2) {
        if (interactor != null) {
            interactor.multiply(num1, num2);
        }
    }

    @Override
    public void divide(int num1, int num2) {
        if (interactor != null) {
            interactor.divide(num1, num2);
        }
    }
}
