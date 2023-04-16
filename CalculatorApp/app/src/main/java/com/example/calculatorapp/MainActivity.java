package com.example.calculatorapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView input,signbox,cal;
    String sign,value1,value2 ,a;
    double num1=0,num2,result;
    boolean hashdot;
    private String calculationString;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calculationString="";
        input=(TextView) findViewById(R.id.input);
        signbox=(TextView)findViewById(R.id.sign);
        cal=findViewById(R.id.cal);
        hashdot=false;
        Toast.makeText(this, "Welcome!", Toast.LENGTH_SHORT).show();

    }

    public void btnClick_7(View view) {
        input.setText(input.getText()+"7");
        calculationString=calculationString+" 7 ";
    }
    public void btnClick_8(View view) {
        input.setText(input.getText()+"8");
        calculationString=calculationString+" 8 ";
    }
    public void btnClick_9(View view) {
        input.setText(input.getText()+"9");
        calculationString=calculationString+" 9 ";
    }
    public void btnClick_6(View view) {
        input.setText(input.getText()+"6");
        calculationString=calculationString+" 6 ";
    }
    public void btnClick_5(View view) {
        input.setText(input.getText()+"5");
        calculationString=calculationString+" 5 ";
    }
    public void btnClick_4(View view) {
        input.setText(input.getText()+"4");
        calculationString=calculationString+" 4 ";
    }
    public void btnClick_3(View view) {
        input.setText(input.getText()+"3");
        calculationString=calculationString+" 3 ";
    }
    public void btnClick_2(View view) {
        input.setText(input.getText()+"2");
        calculationString=calculationString+" 2 ";
    }
    public void btnClick_1(View view) {
        input.setText(input.getText()+"1");
        calculationString=calculationString+" 1 ";
    }
    public void btnClick_0(View view) {
        input.setText(input.getText()+"0");
        calculationString=calculationString+" 0 ";
    }
    public void btnClick_00(View view){ input.setText(input.getText()+"00");
        calculationString=calculationString+" / ";}
    public void btn_dot(View view){
        if(!hashdot){
            if (input.getText().equals("")){
                hashdot=true;
                input.setText("0.");
                calculationString=calculationString+" 0. ";
            }else {
                input.setText(input.getText()+".");
                calculationString=calculationString+".";
            }
            hashdot=true;
        }

    }

    public void btnClick_add(View view){
       sign = "+";
        value1=input.getText().toString();

        input.setText(null);

        signbox.setText("+");
        hashdot=false;
        calculationString=calculationString+" + ";



       }
    public void btnClick_mul(View view){
        sign = "x";
        value1=input.getText().toString();
        input.setText(null);
        signbox.setText("*");
        hashdot=false;
        calculationString=calculationString+" x ";

    }public void btnClick_div(View view){
        sign = "/";
        value1=input.getText().toString();
        input.setText(null);
        signbox.setText("/");
        hashdot=false;
        calculationString=calculationString+" / ";


    }public void btnClick_sub(View view){
        sign = "-";
        value1=input.getText().toString();
        input.setText(null);
        signbox.setText("-");
        hashdot=false;
        calculationString=calculationString+" - ";

    }


    public void btnClick_equal(View view) {
        if (input.getText().equals("")){
            signbox.setText(input.getText()+"");
        }else if (sign!=null){
            value2=input.getText().toString();
            num1=Double.parseDouble(value1);

            num2=Double.parseDouble(value2);
            input.setText(null);
            switch (sign){
                default:
                    break;
                case "+":
                    result=num1+num2;
                    input.setText(result+"");
                    sign=null;
                    signbox.setText(null);
                    num1=0.0;

                    break;
                case "-":
                    result=num1-num2;
                    input.setText(result+"");
                    sign=null;
                    signbox.setText(null);

                    break;
                case "x":
                    result=num1*num2;
                    input.setText(result+"");
                    sign=null;
                    signbox.setText(null);

                    break;
                case "/":
                    result=num1/num2;
                    input.setText(result+"");
                    sign=null;
                    signbox.setText(null);

                    break;
            }cal.setText(calculationString);


        }else input.setText("error!");
    }

    public void btnclick_del(View view) {
        if(input.getText().equals("")){
            input.setText(null);
        }else{
            int len=input.getText().length();
            String s=input.getText().toString();
            if (s.charAt(len-1)== '.'){
                hashdot=false;
                input.setText(input.getText().subSequence(0,input.getText().length()-1));

            }else {
                input.setText(input.getText().subSequence(0,input.getText().length()-1));

            }
        }
    }

    public void btnClick_clear(View view) {
        input.setText(null);
        signbox.setText(null);
        value1=null;
        value2=null;
        sign=null;
        hashdot=false;
        calculationString="";
        cal.setText("");

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        final AlertDialog.Builder builder =new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Do you want to exit?");
        builder.setTitle("EXIT");
        builder.setCancelable(false);
        builder.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                finish();
            }
        });
        builder.setPositiveButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
    }


}