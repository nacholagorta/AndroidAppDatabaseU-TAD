package com.utad.david.task_3_fragments_lists.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.utad.david.task_3_fragments_lists.Adapter.TeacherAdapter;
import com.utad.david.task_3_fragments_lists.DialogFragment.TeacherDialogFragment;
import com.utad.david.task_3_fragments_lists.Model.Teacher;
import com.utad.david.task_3_fragments_lists.R;

public class TeachersFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public TeachersFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_recycleview, container, false);
        configRecyclerViewTeacher(view);
        configAdaparterTeacher();
        return view;
    }

    //Configuramos el RecyclerView
    public void configRecyclerViewTeacher(View view){
        mRecyclerView = view.findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new GridLayoutManager(view.getContext(), 2);
        mRecyclerView.setLayoutManager(mLayoutManager);
    }

    //Configuramos el adapter y añadimos el listener del onClick()
    public void configAdaparterTeacher(){
        mAdapter = new TeacherAdapter(createData(), new TeacherAdapter.OnItemClickListener() {
            //Hacemos una transición y mostramos el nuevo fragment
            @Override
            public void onItemClick(Teacher item) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                Fragment prev = getFragmentManager().findFragmentByTag("dialog");
                if (prev != null) {
                    transaction.remove(prev);
                }
                transaction.addToBackStack(null);
                //Pasamos la información del item en el que se está pinchando
                TeacherDialogFragment newFragment = TeacherDialogFragment.newInstance(item);
                newFragment.show(transaction, "dialog");
            }
        });
        mRecyclerView.setAdapter(mAdapter);
    }

    public Teacher[] createData() {
        String [] subject1 = {"Acceso a datos","Base de datos","Lenguaje de marcas"};
        String [] subject2 = {"Desarollo de interfaces","Programación","Sistemas Informaticos"};
        String [] subject3 = {"Ingles G.Superior","Ingles G.Medio","Ingles Bachillerato"};
        String [] subject4 = {"Servicios y Procesos","Programación","Entornos del desarollo"};
        String [] subject5 = {"Empresa","Fol","Ingles"};
        String [] subject6 = {"S.G.Empresarial","Entornos del desarollo","Programaciòn"};
        String [] subject7 = {"Ios","Programacòn","Base de datos"};

        Teacher teacher1 = new Teacher("Jaime","Latorre", R.drawable.jaime,subject1,"Experto en SQL","jaime.latorre@utad.com");
        Teacher teacher2 = new Teacher("David","Jardon", R.drawable.david,subject2,"Experto en Android","david.jardon@utad.com");
        Teacher teacher3 = new Teacher("Cristina"," Espinosa", R.drawable.cristina,subject3,"Profesora nativa","cristina.espinosa@utad.com");
        Teacher teacher4 = new Teacher("Pedro","Camacho", R.drawable.pedro,subject4,"Experto en POO","pedro.camacho@utad.com");
        Teacher teacher5 = new Teacher("Meritxel","Bretos" ,R.drawable.meritxel,subject5,"Emprendedora","meritxel.bretos@utad.com");
        Teacher teacher6 = new Teacher("Laura", "Jaen",R.drawable.laura,subject6,"Experiencia en consultoras","laura.jaen@utad.com");
        Teacher teacher7 = new Teacher("Carlos","Jimenez",R.drawable.ic_person_outline_black_24dp,subject7,"Experto en Ios","carlos.jimenez@utad.com");

        Teacher[] data = {teacher1,teacher2,teacher3,teacher4,teacher5,teacher6,teacher7};
        return data;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}