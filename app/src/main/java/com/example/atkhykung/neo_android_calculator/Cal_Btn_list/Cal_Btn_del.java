package com.example.atkhykung.neo_android_calculator.Cal_Btn_list;

/**
 * Created by Atkhy Kung on 20/10/2017.
 */

public class Cal_Btn_del extends Cal_Btn_Base {
    public void self_define(){
        my_btn_name = "del";  // divide
        my_btn_type = 1;
        my_btn_value = -1;
    }

    public String Btn_Action(){
        return "del"; //   non finish
    }
}
