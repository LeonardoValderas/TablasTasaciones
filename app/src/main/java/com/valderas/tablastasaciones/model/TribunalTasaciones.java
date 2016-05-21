package com.valderas.tablastasaciones.model;

import android.content.Context;

import java.util.HashMap;

/**
 * Created by LEO on 21/5/2016.
 */
public class TribunalTasaciones {
    Context c;
    public TribunalTasaciones (Context context){
       this.c = context;
    }

    public String getValorMetros(String valor){

        HashMap<String,String> datos = new HashMap<>();
        datos =getDatosTabla();
        String resultado = null;
           for (String key : datos.keySet()) {
                if (key.toString().equals(valor)) {
                    resultado = datos.get(valor).toString();
                    break;
                }
            }

        return resultado;
    }

    public HashMap<String,String> getDatosTabla (){

        HashMap<String,String> datos = new HashMap<>();
        //fila 10
        datos.put("6-10","1,245");
        datos.put("7-10","1,365");
        datos.put("8-10","1,460");
        datos.put("8.66-10","1,523");
        datos.put("9-10","1,556");
        datos.put("10-10","1,580");
        datos.put("11-10","1,604");
        datos.put("12-10","1,635");
        datos.put("13-10","1,674");
        datos.put("14-10","1,716");
        datos.put("15-10","1,763");
        datos.put("16,13-10","1,755");
        datos.put("17-10","1,743");
        datos.put("18-10","1,722");
        datos.put("19-10","1,691");
        datos.put("20-10","1,651");
        datos.put("21-10","1,613");
        datos.put("22-10","1,575");
        datos.put("23-10","1,537");
        datos.put("24-10","1,506");
        datos.put("25-10","1,480");
        datos.put("26-10","1,458");
        datos.put("27-10","1,443");
        datos.put("28-10","1,431");
        datos.put("29-10","1,425");
        datos.put("30-10","1,422");
       return datos;
    }
}
