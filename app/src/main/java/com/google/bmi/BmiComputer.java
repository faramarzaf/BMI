package com.google.bmi;

public class BmiComputer {

   public float height;
   public float weight;

    public BmiComputer() {

    }

    public float bmi_result_metric(float height, float weight){
        float H2 = height * height;
        float W2 = weight;
        float result = (W2/H2)*10000;
        return result;
    }
    public float bmi_result_english(float height, float weight){
        float H2 = height * height;
        float W2 = weight;
        float result = (W2/H2)*703;
        return result;
    }

}
