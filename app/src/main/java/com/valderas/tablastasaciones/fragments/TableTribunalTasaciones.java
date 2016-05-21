package com.valderas.tablastasaciones.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.valderas.tablastasaciones.R;
import com.valderas.tablastasaciones.model.TribunalTasaciones;

public class TableTribunalTasaciones extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    public static final String ARG_PARAM1 = "param1";
    public static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    private TextView resultado, error;
    private EditText x, y;
    private ImageButton clean, start;
    private TribunalTasaciones tribunalTasaciones;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_tribunal_tasaciones, container, false);

        x = (EditText) v.findViewById(R.id.editTextX);
        y = (EditText) v.findViewById(R.id.editTextY);
        resultado = (TextView) v.findViewById(R.id.textViewResultado);
        error = (TextView) v.findViewById(R.id.textViewError);
        clean = (ImageButton) v.findViewById(R.id.clean);
        start = (ImageButton) v.findViewById(R.id.start);
        return v;
    }

    @Override
    public void onActivityCreated(Bundle state) {
        super.onActivityCreated(state);
        tribunalTasaciones = new TribunalTasaciones(getActivity());
        init();
    }

    public void init() {

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (x.getText().toString().equals("")) {
                    x.setError("Debe ingresar el frente");
                } else if (y.getText().toString().equals("")) {
                    y.setError("Debe ingresar el frente");
                } else {
                    cleanError();
                    String valor = tribunalTasaciones.getValorMetros(getValor(x.getText().toString().trim(), y.getText().toString().trim()));

                    if(valor == null)
                    errorText();
                    else
                    resultado.setText(valor);
                }
            }
        });

        clean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 cleanController();
            }
        });
    }

    public String getValor(String x, String y) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(x);
        stringBuilder.append("-");
        stringBuilder.append(y);

        return stringBuilder.toString();
    }

    public void errorText(){
        resultado.setText("");
        error.setVisibility(View.VISIBLE);
        error.setText("No existen los paramentros");
    }
    public void cleanController(){
        resultado.setText("");
        y.setText("");
        x.setText("");
        y.clearFocus();
        error.setVisibility(View.GONE);
    }
    public void cleanError(){
        error.setVisibility(View.GONE);
    }
}
