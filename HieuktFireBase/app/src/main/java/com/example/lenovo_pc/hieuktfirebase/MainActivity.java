package com.example.lenovo_pc.hieuktfirebase;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    Button btn_dangky, btn_dangnhap;
    EditText edt_taikhoan, edt_matkhau, edtTaiKhoan, edtMatKhau;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        AnhXa();
        btn_dangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DangKy();
            }
        });

        btn_dangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DangNhap();
            }
        });
    }

    private void DangKy() {
        String email = edt_taikhoan.getText().toString();
        String password = edt_matkhau.getText().toString();
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful() == true) {
                            Toast.makeText(MainActivity.this, "ĐĂng ký thành công", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MainActivity.this, "ĐĂng ký thất bại", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }

    private void DangNhap() {
        String email = edtTaiKhoan.getText().toString();
        String password = edtMatKhau.getText().toString();
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful() == true) {
                            Toast.makeText(MainActivity.this, "ĐĂng nhập thành công", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MainActivity.this, "ĐĂng nhập thất bại", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void AnhXa() {
        btn_dangky = findViewById(R.id.btn_dangky);
        edt_taikhoan = findViewById(R.id.edt_taikhoan);
        edt_matkhau = findViewById(R.id.edt_matkhau);
        btn_dangnhap = findViewById(R.id.btn_dangnhap);
        edtTaiKhoan = findViewById(R.id.edtTaiKhoan);
        edtMatKhau = findViewById(R.id.edtMatKhau);
    }
}
