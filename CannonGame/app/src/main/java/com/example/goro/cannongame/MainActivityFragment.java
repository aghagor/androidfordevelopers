package com.example.goro.cannongame;


import android.media.AudioManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainActivityFragment extends Fragment {
    private CannonView cannonView;

    public MainActivityFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreateView(inflater, container, savedInstanceState);
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        cannonView = (CannonView) view.findViewById(R.id.cannonView);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //Sound volume control
        getActivity().setVolumeControlStream(AudioManager.STREAM_MUSIC);
    }

    //When MainActivity will stope, the game will over
    @Override
    public void onPause() {
        super.onPause();
        cannonView.stopGame();
    }
    //When MainActivity will stop, the resurse will free

    @Override
    public void onDestroy() {
        super.onDestroy();
        cannonView.releaseResourses();
    }
}
