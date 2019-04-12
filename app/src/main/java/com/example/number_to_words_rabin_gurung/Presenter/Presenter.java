package com.example.number_to_words_rabin_gurung.Presenter;

import android.view.View;
import android.widget.Button;

import com.example.number_to_words_rabin_gurung.MainActivity;

public class Presenter {
    private MainActivity mainActivity;
    private Button button;

    private  char[] array;
    private  int length_of_Array;
    private final String[] firstNumber ={"zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
    private final String[] tensNumber ={"Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen",
            "Eighteen","Nineteen",};
    private final String[] twentyAbove ={"Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    private final String[] hundreds ={"Hundred","Hundreds"};

    public Presenter(final MainActivity mainActivity, Button button) {
        this.mainActivity = mainActivity;
        this.button = button;

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mainActivity.CheckForInput() == false){
                    mainActivity.SetResult("Please give a input");
                }else{
                    array = String.valueOf(mainActivity.getNumber()).toCharArray();
                    length_of_Array = array.length;
                    mainActivity.SetResult(Check());
                }

            }
        });

    }
    public String Check(){

        switch (length_of_Array){
            case 1:
                return oneDigitHere(Character.getNumericValue(array[0]));
            case 2:
                return twoDigitHere(Character.getNumericValue(array[0]),Character.getNumericValue(array[1]));
            case 3:
                return threeDigitHere(Character.getNumericValue(array[0]),Character.getNumericValue(array[1]),Character.getNumericValue(array[2]));
        }
        return "Invalid Number Format";
    }

    private String oneDigitHere(int x){
        return firstNumber[x];
    }

    private String twoDigitHere(int x, int y){
        if(x == 1){
            return tensNumber[y];
        }
        else if(x == 0){
            if( y == 0 ){
                return "";
            }else{
                return firstNumber[y];
            }
        }
        else{
            if(y == 0){
                return twentyAbove[x-2];
            }
            return twentyAbove[x-2]+oneDigitHere(y);
        }
    }

    private String threeDigitHere(int x, int y, int z){
        if(x == 1){
            return firstNumber[x]+" "+hundreds[0]+" and "+twoDigitHere(y,z);
        }else{
            if(y ==0 && z == 0){
                return firstNumber[x]+" "+hundreds[1]+twoDigitHere(y,z);
            }
            return firstNumber[x]+" "+hundreds[1]+" and "+twoDigitHere(y,z);
        }
    }
}
