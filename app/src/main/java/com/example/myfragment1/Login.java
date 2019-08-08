package com.example.myfragment1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {
    EditText ed_account,ed_password;
    Button btn_login,btn_account,btn_forgetpw;
    TextView tv_view;
    private FirebaseAnalytics mFirebaseAnalytics;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ed_account=findViewById(R.id.ed_accont);
        ed_password=findViewById(R.id.ed_password);
        tv_view=findViewById(R.id.tv_view);
        btn_login=findViewById(R.id.btn_login);
        btn_account=findViewById(R.id.btn_newaccount);
        btn_forgetpw=findViewById(R.id.btn_forgetpw);
        // Obtain the FirebaseAnalytics instance.
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        mAuth=FirebaseAuth.getInstance();
        initHandler();
        updateUserStatus();
    }

    private void initHandler() {
        mAuth.addAuthStateListener(new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                updateUserStatus();
            }
        });
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseUser user= mAuth.getCurrentUser();
                if(user==null){
                    String account1=ed_account.getText().toString();
                    String password1=ed_password.getText().toString();
                    if(account1.isEmpty()){
                        Toast.makeText(Login.this,"請輸入帳號(E-Mail)",Toast.LENGTH_LONG).show();
                        return;
                    }
                    if(password1.isEmpty()){
                        Toast.makeText(Login.this,"請輸入密碼",Toast.LENGTH_LONG).show();
                        return;
                    }

                    mAuth.signInWithEmailAndPassword(account1,password1).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(Login.this,"登入失敗："+e.getLocalizedMessage(),Toast.LENGTH_LONG).show();

                        }
                    });
                }

            }
        });
        btn_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Login.this,Account.class);
                startActivity(intent);
            }
        });
        btn_forgetpw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account1=ed_account.getText().toString();
                if(account1.isEmpty()){
                    Toast.makeText(Login.this,"請輸入帳號(E-Mail)",Toast.LENGTH_LONG).show();
                    return;
                }
                mAuth.sendPasswordResetEmail(account1).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Login.this,"已成功送出變更密碼E-Mail，請檢查電子信箱",Toast.LENGTH_LONG).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Login.this,"無法送出變更密碼E-Mail"+e.getLocalizedMessage(),Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
    public void updateUserStatus(){
        FirebaseUser user= mAuth.getCurrentUser();
        if(user==null){
            btn_login.setText("登入");
            btn_account.setVisibility(View.VISIBLE);
            btn_forgetpw.setVisibility(View.VISIBLE);

        }else {
            tv_view.setText("已登入\n"+"\n是否已驗證:"+user.isEmailVerified());
            btn_account.setVisibility(View.INVISIBLE);
            btn_forgetpw.setVisibility(View.INVISIBLE);
            Intent it=new Intent();
            it.setClass(Login.this,MainActivity.class);
            startActivity(it);
            finish();

            /*if(!user.isEmailVerified()){
                user.sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(Login.this,"已成功送出驗證E-Mail，請檢查電子信箱",Toast.LENGTH_LONG).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Login.this,"無法送出驗證E-Mail"+e.getLocalizedMessage(),Toast.LENGTH_LONG).show();
                    }
                });
            }*/
        }
    }
}
