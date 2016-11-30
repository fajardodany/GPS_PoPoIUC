package pt.isec.a21240085.popoiuc;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.widget.Toast;

/**
 * Created by francisco on 29-11-2016.
 */

public class moduloCalculo extends ContextWrapper{
    private double resultado=0;
    private int ano_c=0,cilindrada_c=0,co2_c=0,combustivel_c;
    public moduloCalculo(int ano,int cilindrada,int co2,int combustivel,Context base){
        super(base);
        ano_c=ano;
        cilindrada_c=cilindrada;
        co2_c=co2;
        combustivel_c=combustivel;
    }
    public double devolve_resultado(){
        return resultado;
    }
    public void calcular(){
    if(ano_c<1989){
        resultado= Double.parseDouble(getString(R.string.A2007_add_1_1981));
    }
    }
}
