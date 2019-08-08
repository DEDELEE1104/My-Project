package com.example.myfragment1;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

public class Account extends AppCompatActivity {
    EditText newaccount1,nickname,pw1,pw2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        newaccount1=findViewById(R.id.ed_email);
        nickname=findViewById(R.id.ed_nickname);
        pw1=findViewById(R.id.ed_newpassword1);
        pw2=findViewById(R.id.ed_newpassword2);
    }
    public  void createNewAccount(View v){
        final String account= newaccount1.getText().toString();
        final String nickname1=nickname.getText().toString();
        final String password=pw1.getText().toString();
        String cpassword=pw2.getText().toString();
if(password.isEmpty()){
    Toast.makeText(Account.this,"請輸入欄位資料",Toast.LENGTH_LONG).show();
    return;
}
        if(account.isEmpty()){
            Toast.makeText(Account.this,"請輸入帳號(E-Mail)",Toast.LENGTH_LONG).show();
            return;
        }
        if(nickname1.isEmpty()){
            Toast.makeText(Account.this,"請輸入名字",Toast.LENGTH_LONG).show();
            return;
        }
        if(!password.equals(cpassword)){
            Toast.makeText(Account.this,"請再次輸入正確密碼",Toast.LENGTH_LONG).show();
            return;
        }
        final FirebaseAuth mAuth=FirebaseAuth.getInstance();
        mAuth.createUserWithEmailAndPassword(account,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(Account.this,"Account Created",Toast.LENGTH_LONG).show();
                    FirebaseUser user=mAuth.getCurrentUser();
                    UserProfileChangeRequest request=new UserProfileChangeRequest.Builder().setDisplayName(nickname1).build();
                    user.updateProfile(request);

                    mAuth.signInWithEmailAndPassword(account,password);

                    finish();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Account.this,"Fail:"+e.getLocalizedMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
