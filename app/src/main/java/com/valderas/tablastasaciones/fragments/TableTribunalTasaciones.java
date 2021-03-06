package com.valderas.tablastasaciones.fragments;

import android.graphics.Paint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.valderas.tablastasaciones.R;
import com.valderas.tablastasaciones.model.TribunalTasaciones;

public class TableTribunalTasaciones extends Fragment {

    private TextView resultado, error, title;
    private EditText x, y;
    private ImageButton clean, start;
    private TribunalTasaciones tribunalTasaciones;
    private InterstitialAd mInterstitialAd;
    private int conteo = 0;
    private AdView mAdView;
    private AdRequest adRequest;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_tribunal_tasaciones, container, false);

        x = (EditText) v.findViewById(R.id.editTextX);
        y = (EditText) v.findViewById(R.id.editTextY);
        resultado = (TextView) v.findViewById(R.id.textViewResultado);
        error = (TextView) v.findViewById(R.id.textViewError);
        title = (TextView) v.findViewById(R.id.title);
        clean = (ImageButton) v.findViewById(R.id.clean);
        start = (ImageButton) v.findViewById(R.id.start);
        mAdView = (AdView) v.findViewById(R.id.adView);

        return v;
    }


    @Override
    public void onActivityCreated(Bundle state) {
        super.onActivityCreated(state);

        tribunalTasaciones = new TribunalTasaciones(getActivity());
        init();
    }

    public void init() {
        y.setFilters(new InputFilter[] { new InputFilter.LengthFilter(2)});
        x.setFilters(new InputFilter[] { new InputFilter.LengthFilter(4)});
        title.setText(getActivity().getResources().getString(R.string.tribunal_tasaciones_fragment));
        title.setPaintFlags(title.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        InterstitialAd();
        BannerAd();
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                conteoClick();
                if (x.getText().toString().equals("")) {
                    x.setError("Debe ingresar el frente");
                } else if (y.getText().toString().equals("")) {
                    y.setError("Debe ingresar el frente");
                } else {
                    cleanError();
                    String frente =  x.getText().toString().trim();

                    int valorFrente = nrOfDecimal(frente);
                    if(valorFrente == 0){
                        frente = frente+".00";
                    }else if(valorFrente == 1){
                        frente = frente+"0";
                    }

                    String valor = tribunalTasaciones.getValorMetros(getValor(frente, y.getText().toString().trim()));

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
                 conteoClick();
                 cleanController();
            }
        });

    }

    private void showInterstitial() {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
    }
    private int nrOfDecimal(String nr){
        int len = nr.length();
        int pos = len;
        for(int i=0 ; i<len; i++){
            if(nr.charAt(i)=='.'){
                pos=i+1;
                break;
            }
        }
        return len-pos;
    }

    public void InterstitialAd() {
        mInterstitialAd = new InterstitialAd(getActivity());
        mInterstitialAd.setAdUnitId(getString(R.string.interstitial_full_screen));

        adRequest = new AdRequest.Builder()
                //.addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
               // .addTestDevice("B52960D9E6A2A5833E82FEA8ACD4B80C")
                .build();
        mInterstitialAd.loadAd(adRequest);

    }
    public void BannerAd() {

        adRequest = new AdRequest.Builder()
             //   .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
             //   .addTestDevice("B52960D9E6A2A5833E82FEA8ACD4B80C")
                .build();
        mAdView.loadAd(adRequest);
    }

    public String getValor(String x, String y) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(y);
        stringBuilder.append("-");
        stringBuilder.append(x);

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

    public  void conteoClick(){
        if(conteo==5){
                    showInterstitial();
            conteo=0;
        }else{
            conteo++;
        }
    }
}
