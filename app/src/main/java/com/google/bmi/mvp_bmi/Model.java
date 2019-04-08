package com.google.bmi.mvp_bmi;

public class Model implements Contract.Model {
    Contract.Presenter presenter;

    @Override
    public void attachPresenter(Contract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void get_bmi_metric(float height, float weight) {
        float H2 = height * height;
        float W2 = weight;
        float result = (W2 / H2) * 10000;
        presenter.onBmiReceived(result);
    }

    @Override
    public void get_bmi_english(float height, float weight) {
        float H2 = height * height;
        float W2 = weight;
        float result = (W2 / H2) * 703;
        presenter.onBmiReceived(result);
    }
}
