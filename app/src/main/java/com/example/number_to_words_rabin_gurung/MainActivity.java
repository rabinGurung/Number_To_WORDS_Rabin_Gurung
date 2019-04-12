package com.example.number_to_words_rabin_gurung;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.number_to_words_rabin_gurung.Presenter.Presenter;

public class MainActivity extends AppCompatActivity {
    private Button btnsubmit;
    private TextView tv;
    private EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnsubmit =findViewById(R.id.btnsubmit);
        tv = findViewById(R.id.tv);
        et = findViewById(R.id.et);

        new Presenter(this, btnsubmit);
    }

    public Boolean CheckForInput(){
        if(TextUtils.isEmpty(et.getText())){
            et.setError("Please Enter Number");
            return false;
        }
        return true;
    }

    public int getNumber(){
        return Integer.parseInt(et.getText().toString());
    }

    public void SetResult(String result){
        tv.setText(result);
    }
}
