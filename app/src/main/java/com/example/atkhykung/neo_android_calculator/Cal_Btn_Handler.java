package com.example.atkhykung.neo_android_calculator;

import com.example.atkhykung.neo_android_calculator.Cal_Btn_list.*;

import java.util.Objects;

/**
 * Created by Atkhy Kung on 19/10/2017.
 */

public class Cal_Btn_Handler {
    Cal_Btn_Base[] cb_list = new Cal_Btn_Base[20];
    String tv_text = "";
    public Cal_Btn_Handler(){
        cb_list[0] = new Cal_Btn_C();
        cb_list[1] = new Cal_Btn_divide();
        cb_list[2] = new Cal_Btn_multiple();
        cb_list[3] = new Cal_Btn_del();
        cb_list[4] = new Cal_Btn_7();
    }

//    public String recieve_btn_click(String btn_name){
//        int this_btn_id = define_btn(btn_name);
//        String the_action = cb_list[this_btn_id].Btn_Action().toLowerCase();
//        if(the_action,equals("num") == true){
//            tv_text += cb_list[this_btn_id].get_btn_value();
//        }else if(the_action.equals("operator")){
//
//        }else if(the_action.equals("clean")){
//
//        }
//    }

    private int define_btn(String btn_name){
        int cb_int_id = -1;
        for(int i=0; i<cb_list.length; i++){
            boolean correct = cb_list[i].Btn_identify(btn_name);
            if(correct){
                cb_int_id = i;
                break;
            }
        }
        return cb_int_id;
    }
}
