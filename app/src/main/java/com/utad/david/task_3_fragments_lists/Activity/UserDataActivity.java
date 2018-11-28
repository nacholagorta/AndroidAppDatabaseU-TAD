package com.utad.david.task_3_fragments_lists.Activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.utad.david.task_3_fragments_lists.Fragment.FormDataFragment;
import com.utad.david.task_3_fragments_lists.Fragment.PersonalDataFragment;
import com.utad.david.task_3_fragments_lists.R;
import com.utad.david.task_3_fragments_lists.Singelton;

public class UserDataActivity extends AppCompatActivity implements FormDataFragment.OnFragmentInteractionListener,PersonalDataFragment.OnFragmentInteractionListener{

    private FormDataFragment formDataFragment;
    private PersonalDataFragment personalDataFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_data);

       //Añadimos el formDataFragment al frameContainer
        if (findViewById(R.id.frame_container) != null) {
            if (savedInstanceState != null) {
                return;
            }
            formDataFragment = new FormDataFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.frame_container, formDataFragment).commit();
        }
    }


    //Reemplaza en el frameContainer el fragment anterior por el personalDataFragment
    @Override
    public void comunicationWithButtonClickNext(View view) {
        personalDataFragment = new PersonalDataFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, personalDataFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void comunicationWithButtonClickSave(View view) {
        Intent intent = new Intent(this,MainMenu.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}
