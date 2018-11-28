package com.utad.david.task_3_fragments_lists.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.utad.david.task_3_fragments_lists.Singelton;
import com.utad.david.task_3_fragments_lists.R;

import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.editTextEmail)
    EditText et_email;
    @BindView(R.id.editTextPassword)
    EditText et_password;
    @BindView(R.id.btn_login)
    Button btn_login;

    private String str_email;
    private String str_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        // Asignamos el Listener a los EditText
        et_email.addTextChangedListener(loginTextWatcher);
        et_password.addTextChangedListener(loginTextWatcher);
    }
     //Método que escucha si los editText han sido cambiados
    public TextWatcher loginTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            str_email = et_email.getText().toString().trim();
            str_password = et_password.getText().toString().trim();
            //Comprobamos que los campos son validos y habilitamos el botón
            btn_login.setEnabled(enableButton());
            if (!enableButton()) {
                if (!emailValidate(str_email)) {
                    et_email.setError("incorrect e-mail");
                }
                if (!passValidate(str_password)) {
                    et_password.setError("password must have 6 characters");
                }
            }
        }
    };

    public boolean enableButton() {
        if (emailValidate(str_email) && passValidate(str_password)) {
            return true;
        } else {
            return false;
        }
    }

    //Compruebo que el formato del email es correcto
    public boolean emailValidate(String str_email) {
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        if (pattern.matcher(str_email).matches()) {
            return true;

        } else {
            return false;

        }
    }
    //Compruebo que la contraseña tenga más de 6 caracteres
    public boolean passValidate(String str_password) {
        if (str_password.length() >= 6) {
            return true;

        } else {
            return false;

        }
    }

    //Método del intent para pasar a la siguiente view guardando el email en el singleton
    public void onLoginAction(View view) {
        Singelton.getInstance().user.setStr_email(str_email);
        Intent intent = new Intent(this, UserDataActivity.class);
        startActivity(intent);
    }
}
