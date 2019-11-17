package com.example.finalexam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.finalexam.DB.LedgerItem;
import com.example.finalexam.DB.LedgerRepository;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button saveButton =findViewById(R.id.register_button);

        EditText FullnameEditText =findViewById(R.id.full_name_edit_text);
        final String Fullname =FullnameEditText.getText().toString();

        EditText UsernameEditText =findViewById(R.id.username_edit_text);
        final String Username =UsernameEditText.getText().toString();

        EditText PassEditText =findViewById(R.id.password_edit_text);
        final String Pass =PassEditText.getText().toString();

        saveButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                     if (Fullname.equals("") || Username.equals("") || Pass.equals("")){

                         //Toast.makeText(RegisterActivity.this,"คุณสมัครสมาชิกไม่สำเร้จ กรุณากรอกข้อมูลให้ครบ",Toast.LENGTH_LONG).show();
                         Toast.makeText(RegisterActivity.this,"All fields are required",Toast.LENGTH_LONG).show();

                     }else {
                         //Toast.makeText(RegisterActivity.this,"คุณสมัครสมาชิกสำเร้จ",Toast.LENGTH_LONG).show();
                         Toast.makeText(RegisterActivity.this,"Register successfully",Toast.LENGTH_LONG).show();

                         LedgerItem item=new LedgerItem(0,Fullname,Username,Pass);

                         LedgerRepository logView = new LedgerRepository(RegisterActivity.this);
                         logView.insertLedger(item,new LedgerRepository.InsertCallback(){
                             @Override
                             public void onInsertCallBack() {
                                 finish();
                             }
                         });
                     }
                }
            }
        );

//        saveButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                EditText FullnameEditText =findViewById(R.id.full_name_edit_text);
//                String Fullname =FullnameEditText.getText().toString();
//
//                EditText UsernameEditText =findViewById(R.id.username_edit_text);
//                String Username =UsernameEditText.getText().toString();
//
//                EditText PassEditText =findViewById(R.id.password_edit_text);
//                String Pass =PassEditText.getText().toString();
//
//
//
//                LedgerItem item=new LedgerItem(0,Fullname,Username,Pass);
//
//                LedgerRepository repo =new LedgerRepository(RegisterActivity.this);
//                repo.insertLedger(item, new LedgerRepository.InsertCallback() {
//                    @Override
//                    public void onInsertSuccess() {
//                        //reloadData();
//                        Toast.makeText(RegisterActivity.this,"คุณสมัครสมาชิกสำเร้จ",Toast.LENGTH_LONG).show();
//                        finish();
//                    }
//                });
//            }
//        });
    }
}
