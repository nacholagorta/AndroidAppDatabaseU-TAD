package com.utad.david.task_3_fragments_lists.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.utad.david.task_3_fragments_lists.Adapter.LessonAdapter;
import com.utad.david.task_3_fragments_lists.DialogFragment.LessonDialogFragment;
import com.utad.david.task_3_fragments_lists.Model.Lesson;
import com.utad.david.task_3_fragments_lists.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LessonsFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public LessonsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recycleview, container, false);
        configRecyclerViewLesson(view);
        configAdaparterLesson();
        return view;
    }
    //Configuramos el RecyclerView
    public void configRecyclerViewLesson(View view){
        mRecyclerView = view.findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new GridLayoutManager(view.getContext(), 2);
        mRecyclerView.setLayoutManager(mLayoutManager);
    }
    //Configuramos el adapter y añadimos el listener del onClick()
    public void configAdaparterLesson(){
        mAdapter = new LessonAdapter(createData(), new LessonAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Lesson item) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                Fragment prev = getFragmentManager().findFragmentByTag("dialog");
                if (prev != null) {
                    transaction.remove(prev);
                }
                transaction.addToBackStack(null);
                //Pasamos la información del item en el que se está pinchando
                // Creamos el dialogo y lo mostramos
                LessonDialogFragment newFragment = LessonDialogFragment.newInstance(item);
                newFragment.show(transaction, "dialog");
            }
        });
        mRecyclerView.setAdapter(mAdapter);
    }

    public Lesson[] createData() {
        String [] estadisticas1 = {"25","David","8.1","8.5","8"};
        String [] estadisticas2 = {"27","Meritxel","7.6","7.4","15"};
        String [] estadisticas3 = {"34","Laura","9.1","8.1","18"};
        String [] estadisticas4 = {"21","Pedro","6.3","7.2","7"};
        String [] estadisticas5 = {"18","Jaime","8.4","8.1","9"};
        String [] estadisticas6 = {"32","Cristina","8.3","7.4","17"};
        String [] estadisticas7 = {"12","Carlos","7.2","8.2","4"};

        Lesson lesson1 = new Lesson("DINT", R.drawable.dint, "2018", "Desarrollo de interfaces",estadisticas7);
        Lesson lesson2 = new Lesson("EIEM", R.drawable.eiem, "2018", "Empresa e iniciativa emprendedora", estadisticas1);
        Lesson lesson3 = new Lesson("SGEM", R.drawable.sgem, "2018", "Sistemas de gestión empresarial", estadisticas2);
        Lesson lesson4 = new Lesson("PSPR", R.drawable.pspr, "2018", "Programación de servicios y procesos", estadisticas3);
        Lesson lesson5 = new Lesson("ADAT", R.drawable.acceso_datos, "2018", "Acceso a datos",estadisticas4);
        Lesson lesson6 = new Lesson("ITGS", R.drawable.english, "2018", "Inglés técnico de grado superior", estadisticas5);
        Lesson lesson7 = new Lesson("PMDM", R.drawable.pmdm, "2018", "Programación en dispositivos multimedia", estadisticas6);

        Lesson[] data = {lesson1,lesson2,lesson3,lesson4,lesson5,lesson6,lesson7};
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
