package com.utad.david.task_3_fragments_lists.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.utad.david.task_3_fragments_lists.Adapter.NotesAdapter;
import com.utad.david.task_3_fragments_lists.Adapter.NotificationsAdapter;
import com.utad.david.task_3_fragments_lists.Model.Notes;
import com.utad.david.task_3_fragments_lists.Model.Notifications;
import com.utad.david.task_3_fragments_lists.R;

public class NotificationFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public NotificationFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recycle_view_notifications, container, false);
        configRecyclerViewNotifications(view);
        configAdaparterNotifications();
        return view;
    }

    //Configuramos el RecyclerView
    public void configRecyclerViewNotifications(View view){
        mRecyclerView = view.findViewById(R.id.recycle_view_notifications);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(view.getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
    }

    //Configuramos el adapter
    public void configAdaparterNotifications(){
        mAdapter = new NotificationsAdapter(createData());
        mRecyclerView.setAdapter(mAdapter);
    }

    public Notifications[] createData() {
        Notifications notifications1 = new Notifications("2018/08/28", "David", "New Note");
        Notifications notifications2 = new Notifications("2018/09/06", "Pablo", "New Event");
        Notifications notifications3 = new Notifications("2018/09/10", "Sebas", "New work");
        Notifications notifications4 = new Notifications("2018/10/15", "Nacho", "New Note");

        Notifications[] data = {notifications1,notifications2,notifications3,notifications4};
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
