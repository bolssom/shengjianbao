package com.blossom.workrecd.Launcher;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blossom.workrecd.MainActivity;
import com.blossom.workrecd.R;
import com.blossom.workrecd.Utils.AnimationUtil;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment3 extends Fragment {


    public Fragment3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater,container,savedInstanceState);
        // Inflate the layout for this fragment
       View view =  inflater.inflate(R.layout.launcher_f3, container, false);
        view.findViewById(R.id.ToMainView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), MainActivity.class));
                AnimationUtil.finishActivityAnimation(getActivity());
            }
        });
        return view;
    }


}
