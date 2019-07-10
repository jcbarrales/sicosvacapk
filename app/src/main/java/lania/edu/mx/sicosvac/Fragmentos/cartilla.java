package lania.edu.mx.sicosvac.Fragmentos;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import lania.edu.mx.sicosvac.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class cartilla extends Fragment {


    public cartilla() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cartilla, container, false);
    }

}
