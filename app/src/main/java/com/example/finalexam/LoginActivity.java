package com.example.finalexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.finalexam.DB.LedgerItem;
import com.example.finalexam.DB.LedgerRepository;

import java.util.List;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView Username = findViewById(R.id.username_edit_text);
        final String mUser=Username.getText().toString();
        TextView Pass = findViewById(R.id.password_edit_text);
        final String mPass=Pass.getText().toString();
//------------------------------------------------------------------------
        Button regisButton = findViewById(R.id.register_button);
        regisButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
//------------------------------------------------------------------------
        Button loginButton = findViewById(R.id.login_button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mUser.equals("") || mPass.equals("")){
                    //Toast.makeText(LoginActivity.this,"คุณทำการ Login ผิดพลาด กรุณาตรวจสอบ username หรือ pass ให้ครบ",Toast.LENGTH_LONG).show();
                    Toast.makeText(LoginActivity.this,"Invalid username or password",Toast.LENGTH_LONG).show();
                }else {
                    LedgerRepository logView =new LedgerRepository(LoginActivity.this);
                    logView.getLedger(new LedgerRepository.Callback() {
                        @Override
                        public void gettoLoginCallBack(List<LedgerItem> itemList) {
                            int ans=0;
                            String fullN="";
                            for (LedgerItem item : itemList) {
                                if(String.valueOf(item.username).equals(mUser) && String.valueOf(item.password).equals(mPass)) {
                                ans=1;
                                fullN=String.valueOf(item.fullName);
                                break;
                                }
                            }
                            if(ans==1){
                                //Toast.makeText(LoginActivity.this,"คุณ".concat(fullN).concat("ได้ทำการ login สำเร็จ"),Toast.LENGTH_LONG).show();
                                Toast.makeText(LoginActivity.this,"Welcome ".concat(fullN),Toast.LENGTH_LONG).show();
                             }else{
                                //Toast.makeText(LoginActivity.this,"คุณทำการ Login ผิดพลาด กรุณาตรวจสอบ username หรือ pass ให้๔ูกต้อง",Toast.LENGTH_LONG).show();
                                Toast.makeText(LoginActivity.this,"Invalid username or password",Toast.LENGTH_LONG).show();
                            }

                        }
                    });
                }
            }
        });
    }

    @Override
    protected void onResume() {  //ต้องใส่reloadData()ไว้ในonResume() ถึงอัตโนมัติทั้งตอนแรก และ กลับมา
        super.onResume();
        reloadData();
    }


    private void reloadData() {
        LedgerRepository logView = new LedgerRepository(LoginActivity.this);
        logView.getLedger(new LedgerRepository.Callback() {
            @Override
            public void gettoLoginCallBack(List<LedgerItem> itemList) {
                Log.i("head","=== all username in list ===");
                for (int i=0;i<itemList.size();i++){
                    String mUser = itemList.get(i).username;
                    Log.i("username : ",mUser);
                }
            }
        });
    }
}

