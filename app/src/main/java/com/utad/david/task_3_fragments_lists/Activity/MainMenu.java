package com.utad.david.task_3_fragments_lists.Activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.utad.david.task_3_fragments_lists.Adapter.LessonAdapter;
import com.utad.david.task_3_fragments_lists.Fragment.CommunitiesFragment;
import com.utad.david.task_3_fragments_lists.Fragment.LessonsFragment;
import com.utad.david.task_3_fragments_lists.Fragment.NotesFragment;
import com.utad.david.task_3_fragments_lists.Fragment.NotificationFragment;
import com.utad.david.task_3_fragments_lists.Fragment.TeachersFragment;
import com.utad.david.task_3_fragments_lists.Model.Lesson;
import com.utad.david.task_3_fragments_lists.R;
import com.utad.david.task_3_fragments_lists.Singelton;

import java.io.FileNotFoundException;
import java.io.InputStream;


public class MainMenu extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private ImageView imagemenu;
    private TextView name;
    private TextView surname;
    private TextView email;
    private Toolbar toolbar;
    private DrawerLayout drawer;
    private NavigationView navigationView;
    private ActionBarDrawerToggle toggle;


    @Override

    //Definimos el Toolbar, el DrawerLayout y el NavigationView
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        findById();
        setSupportActionBar(toolbar);

        //Muestra en la pantalla un boton que hace visible que es un menu lateral
        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        //Inflamos el layout del header del menu para poder modificar el contenido del header
        LayoutInflater.from(getBaseContext()).inflate(R.layout.activity_main_menu_navheader, navigationView);
        navigationView.setNavigationItemSelectedListener(this);

        findByIdNavigetionView();

        putInfoUserInHeaderMenu();

        //Si la foto es null cogemos una por defecto
        checkPhotoUserNull();

        //Nuestro título sera Lessons
        setTitle("Lessons");
        displaySelectedScreen(R.id.nav_lessons);

    }

    public void findById() {
        toolbar = findViewById(R.id.toolbar);
        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
    }

    //Se tiene que buscar el id con el navigetionView delante ya que en este elemento se incluye el header del menu
    public void findByIdNavigetionView() {
        imagemenu = navigationView.findViewById(R.id.imagemenu);
        name = navigationView.findViewById(R.id.textviewname_menu);
        surname = navigationView.findViewById(R.id.textviewsurname_menu);
        email = navigationView.findViewById(R.id.textview_email);
    }

    public void putInfoUserInHeaderMenu() {
        name.setText(Singelton.getInstance().user.getStr_name());
        surname.setText(Singelton.getInstance().user.getStr_surname());
        email.setText(Singelton.getInstance().user.getStr_email());
    }

    public void checkPhotoUserNull() {
        if (Singelton.getInstance().user.getStr_img_user() != null) {
            putPhotoUser(Singelton.getInstance().user.getStr_img_user());
        } else {
            imagemenu.setImageResource(R.drawable.ic_person_outline_black_24dp);
        }
    }

    //Sirve para poner la foto que hemos recogido en el PersonalData en la cabecera del menu
    public void putPhotoUser(String stringUri) {
        Uri uri = Uri.parse(stringUri);
        final InputStream imageStream;
        try {
            imageStream = getContentResolver().openInputStream(uri);
            final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
            imagemenu.setImageBitmap(selectedImage);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    //Cuando le damos hacia atrás con el menu abierto se cierra el menu
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    //Inflamos en el menu el layout del main_menu(botón derecha logout)
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    //Funcionalidad de Logout
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_logout) {
            Intent intent = new Intent(this, LoginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            setEmptyItems();

            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //Vacía user
    public void setEmptyItems() {
        Singelton.getInstance().user.setStr_email(null);
        Singelton.getInstance().user.setInt_age(0);
        Singelton.getInstance().user.setStr_address(null);
        Singelton.getInstance().user.setStr_city(null);
        Singelton.getInstance().user.setStr_description(null);
        Singelton.getInstance().user.setStr_first_hobbie(null);
        Singelton.getInstance().user.setStr_gender(null);
        Singelton.getInstance().user.setStr_img_user(null);
        Singelton.getInstance().user.setStr_name(null);
        Singelton.getInstance().user.setStr_phone(null);
        Singelton.getInstance().user.setStr_phone_type(null);
        Singelton.getInstance().user.setStr_postal_code(null);
        Singelton.getInstance().user.setStr_second_hobbie(null);
        Singelton.getInstance().user.setStr_second_surname(null);
        Singelton.getInstance().user.setStr_surname(null);
        Singelton.getInstance().user.setStr_third_hobbie(null);
    }

    //Llamamos a un método propio y le pasamos el id del item pinchado
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        displaySelectedScreen(item.getItemId());
        return true;
    }

    //Este método sirve para cargar los diferentes fragments
    private void displaySelectedScreen(int itemId) {

        //Creamos el objeto fragment
        Fragment fragment = null;

        //iniciamos los fragments dependiendo del item selecionado
        switch (itemId) {
            case R.id.nav_lessons:
                setTitle("Lesson");
                fragment = new LessonsFragment();
                break;
            case R.id.nav_notifications:
                setTitle("Notifications");
                fragment = new NotificationFragment();
                break;
            case R.id.nav_notes:
                setTitle("Notes");
                fragment = new NotesFragment();
                break;
            case R.id.nav_teachers:
                setTitle("Teachers");
                fragment = new TeachersFragment();
                break;
            case R.id.nav_communities:
                setTitle("Communities");
                fragment = new CommunitiesFragment();
                break;

        }

        //Remplazamos el fragment
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment);
            ft.commit();
        }

        //Una vez cambiado el fragment cerramos el menu
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }

}