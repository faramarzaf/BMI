package com.google.bmi.mvp_bmi;

public class Presenter implements Contract.Presenter {

    Contract.Model model = new Model();
    Contract.View view;

    @Override
    public void get_bmi_metric(float height, float weight) {
        model.get_bmi_metric(height, weight);
    }

    @Override
    public void get_bmi_english(float height, float weight) {
        model.get_bmi_english(height, weight);
    }

    @Override
    public void onBmiReceived(float result) {
        view.onBmiReceived(result);
    }

    @Override
    public void attachView(Contract.View view) {
        this.view = view;
        model.attachPresenter(this);
    }
}
