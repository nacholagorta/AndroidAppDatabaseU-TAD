package com.utad.david.task_3_fragments_lists.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.utad.david.task_3_fragments_lists.Adapter.CommunitiesAdapter;
import com.utad.david.task_3_fragments_lists.DialogFragment.CommunityDialogFragment;
import com.utad.david.task_3_fragments_lists.DialogFragment.TeacherDialogFragment;
import com.utad.david.task_3_fragments_lists.Model.Communities;
import com.utad.david.task_3_fragments_lists.Model.Lesson;
import com.utad.david.task_3_fragments_lists.Model.Teacher;
import com.utad.david.task_3_fragments_lists.R;

public class CommunitiesFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public CommunitiesFragment() {
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
        configRecyclerViewCommunities(view);
        configAdaparterCommunities();
        return view;
    }
    //Configuramos el RecyclerView
    public void configRecyclerViewCommunities(View view){
        mRecyclerView = view.findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new GridLayoutManager(view.getContext(), 2);
        mRecyclerView.setLayoutManager(mLayoutManager);
    }
    //Configuramos el adapter y añadimos el listener del onClick()
    public void configAdaparterCommunities(){
        mAdapter = new CommunitiesAdapter(createData(), new CommunitiesAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Communities item) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                Fragment prev = getFragmentManager().findFragmentByTag("dialog");
                if (prev != null) {
                    transaction.remove(prev);
                }
                transaction.addToBackStack(null);
                //Pasamos la información del item en el que se está pinchando
                // Creamos el dialogo y lo mostramos
                CommunityDialogFragment newFragment = CommunityDialogFragment.newInstance(item);
                newFragment.show(transaction, "dialog");
            }
        });
        mRecyclerView.setAdapter(mAdapter);
    }

    public Communities[] createData() {
        String [] datos1 = {"19","3","Programame","Android App","****"};
        String [] datos2 = {"32","2","SouthSummit","IOS App","*****"};
        String [] datos3 = {"26","1","CompanyDay","WebApp","***"};
        String [] datos4 = {"14","3","Hackaton","DatabaseApp","**"};
        Communities communities1 = new Communities("Desarrollo de Software", R.drawable.desarrollo_software, "Dani", "Desarrollo de software","Descripción Desarrollo de Software","desarrollosoftwareu-tad@gmail.com", datos1);
        Communities communities2 = new Communities("Realidad Virtual", R.drawable.vr, "Fanso", "Desarrollo y diseño para VR","Descripción Realidad Virtual","realidadvirtualu-tad@gmail.com", datos2);
        Communities communities3 = new Communities("BigData", R.drawable.big_data, "Juan", "Funcionamiento de bigData","Descripción BigData","bigdatau-tad@gmail.com" ,datos3);
        Communities communities4 = new Communities("Ciberseguridad", R.drawable.ciberseguridad, "Pedro", "Ciberseguridad","Descripción Ciberseguridad","ciberseguridadu-tad@gmail.com", datos4);


        Communities[] data = {communities1,communities2,communities3,communities4};
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
