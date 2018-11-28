package com.utad.david.task_3_fragments_lists.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.utad.david.task_3_fragments_lists.Adapter.NotesAdapter;
import com.utad.david.task_3_fragments_lists.Model.Notes;
import com.utad.david.task_3_fragments_lists.R;

public class NotesFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public NotesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recycle_view_notes, container, false);
        configRecyclerViewNotes(view);
        configAdaparterNotes();

        return view;
    }

    //Configuramos el RecyclerView
    public void configRecyclerViewNotes(View view){
        mRecyclerView = view.findViewById(R.id.recycle_view_notes);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(view.getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
    }

    //Configuramos el adapter
    public void configAdaparterNotes(){
        mAdapter = new NotesAdapter(createData());
        mRecyclerView.setAdapter(mAdapter);
    }

    public Notes[] createData() {
        Notes notes1 = new Notes("2018/11/18", "Android", "Listas", "9");
        Notes notes2 = new Notes("2018/11/09", "IOS", "Tablas", "8.5");
        Notes notes3 = new Notes("2018/10/28", "Procesos", "Semáforos", "6.5");
        Notes notes4 = new Notes("2018/10/19", "Ingles", "Reading", "7.5");
        Notes notes5 = new Notes("2018/10/14", "Acceso a datos", "Hibernate", "10");
        Notes notes6 = new Notes("2018/10/10", "Empresa", "Plan de empresa", "10");
        Notes notes7 = new Notes("2018/09/28", "GG Empresarial", "Odoo", "6.5");

        Notes[] data = {notes1,notes2,notes3,notes4,notes5,notes6,notes7};
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
