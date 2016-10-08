package com.valderas.tablastasaciones.model;

import android.content.Context;

import java.util.HashMap;

/**
 * Created by LEO on 21/5/2016.
 */
public class Valvano {
    Context c;

    public Valvano(Context context) {
        this.c = context;
    }

    public String getValorTablaI(Double valor) {

        String resultado = null;

        if (valor >= 0.00 && valor <= 1.12) {
            return resultado = "0,15";
        } else if (valor >= 1.13 && valor <= 1.37) {
            return resultado = "0,17";
        } else if (valor >= 1.38 && valor <= 1.62) {
            return resultado = "0,19";
        } else if (valor >= 1.63 && valor <= 1.87) {
            return resultado = "0,20";
        } else if (valor >= 1.88 && valor <= 2.12) {
            return resultado = "0,22";
        } else if (valor >= 2.13 && valor <= 2.37) {
            return resultado = "0,24";
        } else if (valor >= 2.38 && valor <= 2.62) {
            return resultado = "0,26";
        } else if (valor >= 2.63 && valor <= 2.87) {
            return resultado = "0,27";
        } else if (valor >= 2.88 && valor <= 3.12) {
            return resultado = "0,29";
        } else if (valor >= 3.13 && valor <= 3.37) {
            return resultado = "0,31";
        } else if (valor >= 3.38 && valor <= 3.62) {
            return resultado = "0,33";
        } else if (valor >= 3.63 && valor <= 3.87) {
            return resultado = "0,34";
        } else if (valor >= 3.88 && valor <= 4.12) {
            return resultado = "0,36";
        } else if (valor >= 4.13 && valor <= 4.37) {
            return resultado = "0,38";
        } else if (valor >= 4.38 && valor <= 4.62) {
            return resultado = "0,40";
        } else if (valor >= 4.63 && valor <= 4.87) {
            return resultado = "0,41";
        } else if (valor >= 4.88 && valor <= 5.12) {
            return resultado = "0,43";
        } else if (valor >= 5.13 && valor <= 5.37) {
            return resultado = "0,45";
        } else if (valor >= 5.38 && valor <= 5.62) {
            return resultado = "0,47";
        } else if (valor >= 5.63 && valor <= 5.87) {
            return resultado = "0,48";
        } else if (valor >= 5.88) {
            return resultado = "0,50";
        }
        return resultado;
    }

    public String getValorTablaII(Double valor) {

        String resultado = null;

        if (valor >= 0.00 && valor <= 1.12) {
            return resultado = "0,10";
        } else if (valor >= 1.13 && valor <= 1.37) {
            return resultado = "0,11";
        } else if (valor >= 1.38 && valor <= 1.62) {
            return resultado = "0,12";
        } else if (valor >= 1.63 && valor <= 1.87) {
            return resultado = "0,13";
        } else if (valor >= 1.88 && valor <= 2.12) {
            return resultado = "0,14";
        } else if (valor >= 2.13 && valor <= 2.37) {
            return resultado = "0,15";
        } else if (valor >= 2.38 && valor <= 2.62) {
            return resultado = "0,16";
        } else if (valor >= 2.63 && valor <= 2.87) {
            return resultado = "0,17";
        } else if (valor >= 2.88 && valor <= 3.12) {
            return resultado = "0,18";
        } else if (valor >= 3.13 && valor <= 3.37) {
            return resultado = "0,19";
        } else if (valor >= 3.38 && valor <= 3.62) {
            return resultado = "0,20";
        } else if (valor >= 3.63 && valor <= 3.87) {
            return resultado = "0,21";
        } else if (valor >= 3.88 && valor <= 4.12) {
            return resultado = "0,22";
        } else if (valor >= 4.13 && valor <= 4.37) {
            return resultado = "0,23";
        } else if (valor >= 4.38 && valor <= 4.62) {
            return resultado = "0,24";
        } else if (valor >= 4.63 && valor <= 4.87) {
            return resultado = "0,25";
        } else if (valor >= 4.88 && valor <= 5.12) {
            return resultado = "0,26";
        } else if (valor >= 5.13 && valor <= 5.37) {
            return resultado = "0,27";
        } else if (valor >= 5.38 && valor <= 5.62) {
            return resultado = "0,28";
        } else if (valor >= 5.63 && valor <= 5.87) {
            return resultado = "0,29";
        } else if (valor >= 5.88) {
            return resultado = "0,30";
        }
        return resultado;
    }

    public String getValorTablaIII(Double valor) {

        String resultado = null;

        if (valor >= 0.00 && valor <= 1.12) {
            return resultado = "0,05";
        } else if (valor >= 1.13 && valor <= 1.37) {
            return resultado = "0,06";
        } else if (valor >= 1.38 && valor <= 1.62) {
            return resultado = "0,07";
        } else if (valor >= 1.63 && valor <= 1.87) {
            return resultado = "0,07";
        } else if (valor >= 1.88 && valor <= 2.12) {
            return resultado = "0,08";
        } else if (valor >= 2.13 && valor <= 2.37) {
            return resultado = "0,09";
        } else if (valor >= 2.38 && valor <= 2.62) {
            return resultado = "0,10";
        } else if (valor >= 2.63 && valor <= 2.87) {
            return resultado = "0,10";
        } else if (valor >= 2.88 && valor <= 3.12) {
            return resultado = "0,11";
        } else if (valor >= 3.13 && valor <= 3.37) {
            return resultado = "0,12";
        } else if (valor >= 3.38 && valor <= 3.62) {
            return resultado = "0,13";
        } else if (valor >= 3.63 && valor <= 3.87) {
            return resultado = "0,13";
        } else if (valor >= 3.88 && valor <= 4.12) {
            return resultado = "0,14";
        } else if (valor >= 4.13 && valor <= 4.37) {
            return resultado = "0,15";
        } else if (valor >= 4.38 && valor <= 4.62) {
            return resultado = "0,16";
        } else if (valor >= 4.63 && valor <= 4.87) {
            return resultado = "0,16";
        } else if (valor >= 4.88 && valor <= 5.12) {
            return resultado = "0,17";
        } else if (valor >= 5.13 && valor <= 5.37) {
            return resultado = "0,18";
        } else if (valor >= 5.38 && valor <= 5.62) {
            return resultado = "0,19";
        } else if (valor >= 5.63 && valor <= 5.87) {
            return resultado = "0,19";
        } else if (valor >= 5.88) {
            return resultado = "0,20";
        }
        return resultado;
    }

    public String getValorTablaIV(Double valor) {

        String resultado = null;

        if (valor >= 0.00 && valor <= 1.12) {
            return resultado = "0,00";
        } else if (valor >= 1.13 && valor <= 1.37) {
            return resultado = "0,01";
        } else if (valor >= 1.38 && valor <= 1.62) {
            return resultado = "0,02";
        } else if (valor >= 1.63 && valor <= 1.87) {
            return resultado = "0,02";
        } else if (valor >= 1.88 && valor <= 2.12) {
            return resultado = "0,03";
        } else if (valor >= 2.13 && valor <= 2.37) {
            return resultado = "0,04";
        } else if (valor >= 2.38 && valor <= 2.62) {
            return resultado = "0,05";
        } else if (valor >= 2.63 && valor <= 2.87) {
            return resultado = "0,05";
        } else if (valor >= 2.88 && valor <= 3.12) {
            return resultado = "0,06";
        } else if (valor >= 3.13 && valor <= 3.37) {
            return resultado = "0,07";
        } else if (valor >= 3.38 && valor <= 3.62) {
            return resultado = "0,08";
        } else if (valor >= 3.63 && valor <= 3.87) {
            return resultado = "0,08";
        } else if (valor >= 3.88 && valor <= 4.12) {
            return resultado = "0,09";
        } else if (valor >= 4.13 && valor <= 4.37) {
            return resultado = "0,10";
        } else if (valor >= 4.38 && valor <= 4.62) {
            return resultado = "0,11";
        } else if (valor >= 4.63 && valor <= 4.87) {
            return resultado = "0,12";
        } else if (valor >= 4.88 && valor <= 5.12) {
            return resultado = "0,13";
        } else if (valor >= 5.13 && valor <= 5.37) {
            return resultado = "0,14";
        } else if (valor >= 5.38 && valor <= 5.62) {
            return resultado = "0,14";
        } else if (valor >= 5.63 && valor <= 5.87) {
            return resultado = "0,14";
        } else if (valor >= 5.88) {
            return resultado = "0,15";
        }
        return resultado;
    }

}
