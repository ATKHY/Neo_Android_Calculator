package com.example.atkhykung.neo_android_calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    TextView tv01;
    Button[] btn_list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //  TextView collect
        tv01 = (TextView)this.findViewById(R.id.tv_txt);
        //  Button Collect
        Button_collect();
    }

    public void OnCalBtnClick(String btn_name){
        Cal_Btn_Handler cb_handler = new Cal_Btn_Handler();
//        cb_handler.recieve_btn_click(btn_name);
    }

    public void Change_TextView_text(String new_text){
        if(tv01 != null) {
            tv01.setText(new_text);
        }
    }

    public View.OnClickListener Btn_click(int num){
        public void onClick(View v) {
            Change_TextView_text(btn_list[num].getText().toString());
        };
    }

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
        for(int i=0; i<10; i++){
            btn_list[i].setOnClickListener(Btn_click(i));
        }
    }
}