package com.example.atkhykung.neo_android_calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView tv01;
    Button[] btn_list;
    String tv_txt = "";

    ArrayList<Integer> action_step = new ArrayList<Integer>();
    int cur_stage = 0; //   0= being numbers, 1= being operater, 2=result
    boolean positive = true;
    boolean col_started = false;
    ArrayList<Double> number_group = new ArrayList<Double>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //  TextView collect
        tv01 = (TextView)this.findViewById(R.id.tv_txt);
        //  Button Collect
        Button_collect();
        Button_Method_SetUp();
    }

    public void OnCalBtnClick(String btn_name){
        Cal_Btn_Handler cb_handler = new Cal_Btn_Handler();
//        cb_handler.recieve_btn_click(btn_name);
    }

    public boolean Check_btn_id(int receive_id, int check_id){
        if(receive_id == check_id){
            return true;
        }
        return false;
    }

    public void Change_TextView_text(String new_text){
        if(tv01 != null) {
            tv01.setText(new_text);
        }
    }

    public View.OnClickListener Btn_click = new View.OnClickListener(){
        public void onClick(View v) {
//            if(Check_btn_id(v.getId(), R.id.btn_0) == true){
//                tv_txt += "0";
//            }else  if(Check_btn_id(v.getId(), R.id.btn_1) == true){
//                tv_txt += "1";
//            }else if(Check_btn_id(v.getId(), R.id.btn_2) == true){
//                tv_txt += "2";
//            }else if(Check_btn_id(v.getId(), R.id.btn_3) == true){
//                tv_txt += "3";
//            }else if(Check_btn_id(v.getId(), R.id.btn_4) == true){
//                tv_txt += "4";
//            }else if(Check_btn_id(v.getId(), R.id.btn_5) == true){
//                tv_txt += "5";
//            }else if(Check_btn_id(v.getId(), R.id.btn_6) == true){
//                tv_txt += "6";
//            }else if(Check_btn_id(v.getId(), R.id.btn_7) == true){
//                tv_txt += "7";
//            }else if(Check_btn_id(v.getId(), R.id.btn_8) == true){
//                tv_txt += "8";
//            }else if(Check_btn_id(v.getId(), R.id.btn_9) == true){
//                tv_txt += "9";
//            }else
            if(Check_btn_id(v.getId(), R.id.btn_c) == true){
                tv_txt = "0";
            }else if(Check_btn_id(v.getId(), R.id.btn_divde) == true){
                tv_txt += "/";
            }else if(Check_btn_id(v.getId(), R.id.btn_multi) == true){
                tv_txt += "x";
            }else if(Check_btn_id(v.getId(), R.id.btn_del) == true){
                tv_txt = tv_txt.substring(0, tv_txt.length()-1);
            }else if(Check_btn_id(v.getId(), R.id.btn_subt) == true){
                tv_txt += "-";
            }else if(Check_btn_id(v.getId(), R.id.btn_plus) == true){
                tv_txt += "+";
            }else if(Check_btn_id(v.getId(), R.id.btn_col) == true){
                if(col_started == false){
                    tv_txt += "(";
                }else{
                    tv_txt += ")";
                }
            }else if(Check_btn_id(v.getId(), R.id.btn_result) == true){
                //tv_txt = "9";
            }else if(Check_btn_id(v.getId(), R.id.btn_plusMinus) == true){
                tv_txt = "plusMinus";
            }else if(Check_btn_id(v.getId(), R.id.btn_dot) == true){
                tv_txt += ".";
            }else{
                tv_txt += id_return_btn_num(v.getId());
            }

            if(Check_btn_id(v.getId(), R.id.btn_c) == true){
                action_step = new ArrayList<Integer>();
            }else if(Check_btn_id(v.getId(), R.id.btn_del) == true){
                action_step.remove(action_step.size()-1);
            }else {
                action_step.add(v.getId());
            }

            //String txt = ""+v.getId();
            Change_TextView_text(tv_txt);
        }
    };

    public void Button_collect(){
//        System.out.println("Neo Yeah Method In");
        btn_list = new Button[20];
        btn_list[0] = (Button)this.findViewById(R.id.btn_0);
        btn_list[1] = (Button)this.findViewById(R.id.btn_1);
        btn_list[2] = (Button)this.findViewById(R.id.btn_2);
        btn_list[3] = (Button)this.findViewById(R.id.btn_3);
        btn_list[4] = (Button)this.findViewById(R.id.btn_4);
        btn_list[5] = (Button)this.findViewById(R.id.btn_5);
        btn_list[6] = (Button)this.findViewById(R.id.btn_6);
        btn_list[7] = (Button)this.findViewById(R.id.btn_7);
        btn_list[8] = (Button)this.findViewById(R.id.btn_8);
        btn_list[9] = (Button)this.findViewById(R.id.btn_9);
        btn_list[10] = (Button)this.findViewById(R.id.btn_c);
        btn_list[11] = (Button)this.findViewById(R.id.btn_divde);
        btn_list[12] = (Button)this.findViewById(R.id.btn_multi);
        btn_list[13] = (Button)this.findViewById(R.id.btn_del);
        btn_list[14] = (Button)this.findViewById(R.id.btn_subt);
        btn_list[15] = (Button)this.findViewById(R.id.btn_plus);
        btn_list[16] = (Button)this.findViewById(R.id.btn_col);
        btn_list[17] = (Button)this.findViewById(R.id.btn_result);
        btn_list[18] = (Button)this.findViewById(R.id.btn_plusMinus);
        btn_list[19] = (Button)this.findViewById(R.id.btn_dot);
        Change_TextView_text("Neo Yeah Method In");
    }

    public void Button_Method_SetUp(){
        for(int i=0; i<btn_list.length; i++){
            btn_list[i].setOnClickListener(Btn_click);
        }
    }

    public double group_up_numbers(int index_start, int index_last){
        int total = 0;
        for(int i=index_start; i<index_last; i++){
            int mid_num = id_return_btn_num(index_last- (i-index_start));
            for(int j=index_start; j<i; j++){
                mid_num *= 10;
            }
            total += mid_num;
            return total;
            //total +=
        }
        return -1;
    }

    public int id_return_btn_num(int btn_id){
        if(Check_btn_id(btn_id, R.id.btn_0) == true){
            return 0;
        }else  if(Check_btn_id(btn_id, R.id.btn_1) == true){
            return 1;
        }else if(Check_btn_id(btn_id, R.id.btn_2) == true){
            return 2;
        }else if(Check_btn_id(btn_id, R.id.btn_3) == true){
            return 3;
        }else if(Check_btn_id(btn_id, R.id.btn_4) == true){
            return 4;
        }else if(Check_btn_id(btn_id, R.id.btn_5) == true){
            return 5;
        }else if(Check_btn_id(btn_id, R.id.btn_6) == true){
            return 6;
        }else if(Check_btn_id(btn_id, R.id.btn_7) == true){
            return 7;
        }else if(Check_btn_id(btn_id, R.id.btn_8) == true){
            return 8;
        }else if(Check_btn_id(btn_id, R.id.btn_9) == true){
            return 9;
        }else if(Check_btn_id(btn_id, R.id.btn_c) == true){
            return 10;
        }
        return -1;
    }
}