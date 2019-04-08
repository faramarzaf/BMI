package com.google.bmi.mvp_bmi;

public interface Contract {

    interface View {
        void onBmiReceived(float result);

    }

    interface Presenter {
        void get_bmi_metric(float height, float weight);

        void get_bmi_english(float height, float weight);

        void onBmiReceived(float result);

        void attachView(View view);

    }

    interface Model {
        void attachPresenter(Presenter presenter);

        void get_bmi_metric(float height, float weight);

        void get_bmi_english(float height, float weight);
    }


}
