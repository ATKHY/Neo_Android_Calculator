package com.example.atkhykung.neo_android_calculator.Cal_Btn_list;

/**
 * Created by Atkhy Kung on 19/10/2017.
 */

public class Cal_Btn_Base {
    String my_btn_name = "";
    int my_btn_type = 0;    //  0 = value (number / integer),   1 = operator (+, -, x, /, C )
    int my_btn_value = -1;  //  -1 = not a integer button
    int btn_stage = 0;

    public Cal_Btn_Base(){
        self_define();
    }

    public void self_define(){}

    public String Btn_Action(){return "null";}

    public boolean Btn_identify(String btn_name){
        if(my_btn_name == btn_name){
            return true;
        }
        return false;
    }

    public double operator_action(double num_a, double num_b){
        return 0.0f;
    }

    public int get_btn_value(){
        return my_btn_value;
    }
}
