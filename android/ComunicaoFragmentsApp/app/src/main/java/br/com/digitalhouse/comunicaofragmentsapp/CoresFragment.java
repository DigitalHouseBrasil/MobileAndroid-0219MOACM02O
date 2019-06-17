package br.com.digitalhouse.comunicaofragmentsapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class CoresFragment extends Fragment {


    public CoresFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cores, container, false);

        Bundle bundle = getArguments();

        String cor = bundle.getString("COR");

        FrameLayout frameLayout = view.findViewById(R.id.cores_frame_layout);
        TextView corText = view.findViewById(R.id.cor_text);

        if(cor.equals("VERDE")){
            frameLayout.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.colorPrimary));
            corText.setText("VERDE");
        }else if (cor.equals("ROSA")){
            frameLayout.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.colorAccent));
            corText.setText("ROSA");
        }

        return view;
    }

}
