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
import com.valderas.tablastasaciones.model.Valvano;

public class TableIII extends Fragment {
    private TextView resultado, error, title;
    private EditText x;
    private ImageButton clean, start;
    private Valvano valvano;
    private int CheckedPositionFragment;
    private InterstitialAd mInterstitialAd;
    private int conteo = 0;
    private AdView mAdView;
    private AdRequest adRequest;

    public static TableIII newInstance() {
        TableIII fragment = new TableIII();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_valvano, container, false);

        x = (EditText) v.findViewById(R.id.editTextX);
        resultado = (TextView) v.findViewById(R.id.textViewResultado);
        error = (TextView) v.findViewById(R.id.textViewError);
        clean = (ImageButton) v.findViewById(R.id.clean);
        start = (ImageButton) v.findViewById(R.id.start);
        title = (TextView) v.findViewById(R.id.title);
        mAdView = (AdView) v.findViewById(R.id.adView);

        return v;
    }

    @Override
    public void onActivityCreated(Bundle state) {
        super.onActivityCreated(state);
        valvano = new Valvano(getActivity());
        if (state != null) {
            CheckedPositionFragment = state.getInt("curChoice", 0);
        } else {
            init();
        }
    }

    public void init() {
        title.setPaintFlags(title.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        x.setFilters(new InputFilter[]{new InputFilter.LengthFilter(5)});
        InterstitialAd();
        BannerAd();
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                conteoClick();
                if (x.getText().toString().equals("")) {
                    x.setError("Debe ingresar el indice");
                } else {
                    cleanError();
                    String valor = valvano.getValorTablaIII(getValor(x.getText().toString().trim()));
                    if (valor == null)
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

    public Double getValor(String x) {
        return Double.parseDouble(x);
    }

    public void errorText() {
        resultado.setText("");
        error.setVisibility(View.VISIBLE);
        error.setText("Indice incorrecto");
    }

    public void cleanController() {
        resultado.setText("");
        x.setText("");
        x.clearFocus();
        error.setVisibility(View.GONE);
    }

    public void cleanError() {
        error.setVisibility(View.GONE);
    }

    private void showInterstitial() {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
    }

    public void InterstitialAd() {
        mInterstitialAd = new InterstitialAd(getActivity());
        mInterstitialAd.setAdUnitId(getString(R.string.interstitial_full_screen));

        adRequest = new AdRequest.Builder()
//                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
        //               .addTestDevice("B52960D9E6A2A5833E82FEA8ACD4B80C")
                .build();
        mInterstitialAd.loadAd(adRequest);

    }
    public void BannerAd() {

        adRequest = new AdRequest.Builder()
          //      .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
          //     .addTestDevice("B52960D9E6A2A5833E82FEA8ACD4B80C")
                .build();
        mAdView.loadAd(adRequest);
    }

    public void conteoClick() {
        if (conteo == 5) {
   //         mInterstitialAd.setAdListener(new AdListener() {
     //           public void onAdLoaded() {
                    showInterstitial();
       //         }
         //   });
            conteo = 0;
        } else {
            conteo++;
        }
    }

    @Override
    public void onPause() {
        if (mAdView != null) {
            mAdView.pause();
        }
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mAdView != null) {
            mAdView.resume();
        }
    }

    @Override
    public void onDestroy() {
        if (mAdView != null) {
            mAdView.destroy();
        }
        super.onDestroy();
    }
}
