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
        if(ano_c>=2007){
            if(cilindrada_c<=1250)
                resultado+=Double.parseDouble(getString(R.string.P2007_1));
            else if(cilindrada_c<=1750)
                resultado+=Double.parseDouble(getString(R.string.P2007_2));
            else if(cilindrada_c<=2500)
                resultado+=Double.parseDouble(getString(R.string.P2007_3));
            else if(cilindrada_c>2500)
                resultado+=Double.parseDouble(getString(R.string.P2007_4));


            if(co2_c<=120)
                
                resultado+=Double.parseDouble(getString(R.string.P2007_1_co2));
            else if (co2_c <= 180)
                resultado += Double.parseDouble(getString(R.string.P2007_2_co2));
            else if (co2_c <= 250)
                resultado += Double.parseDouble(getString(R.string.P2007_3_co2));
            else if (co2_c > 250)
                resultado += Double.parseDouble(getString(R.string.P2007_4_co2));

            if(ano_c==2007)
                resultado*=Double.parseDouble(getString(R.string.C2007));
            else if(ano_c==2008)
                resultado*=Double.parseDouble(getString(R.string.C2008));
            else if(ano_c==2009)
                resultado*=Double.parseDouble(getString(R.string.C2009));
            else if(ano_c>=2010)
                resultado*=Double.parseDouble(getString(R.string.C2010));

        }
        if(combustivel_c==0)
        {
            if(cilindrada_c<1000) {
                if (ano_c < 1989){
                    resultado = Double.parseDouble(getString(R.string.A2007_1_1981));
                    return;
                }
                if(ano_c<1995) {
                    resultado = Double.parseDouble(getString(R.string.A2007_1_1990));
                    return;
                }
                if(ano_c<2007){
                    resultado = Double.parseDouble(getString(R.string.A2007_1_1995));
                    return;
                }
            }
            if(cilindrada_c<0){

            }

        }
    }
}
