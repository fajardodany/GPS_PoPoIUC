package pt.isec.a21240085.popoiuc;


import android.content.Context;
import android.content.ContextWrapper;
import android.widget.Toast;

/**
 * Created by francisco on 29-11-2016.
 */

public class moduloCalculo extends ContextWrapper{
    private double resultado;
    private int ano_c=0,cilindrada_c=0,co2_c=0,combustivel_c;
    public moduloCalculo(int ano,int cilindrada,int co2,int combustivel,Context base){
        super(base);
        ano_c=ano;
        cilindrada_c=cilindrada;
        co2_c=co2;
        combustivel_c=combustivel;
    }
    public void resetValores(int ano,int cilindrada,int co2,int combustivel) {
        ano_c=ano;
        cilindrada_c=cilindrada;
        co2_c=co2;
        combustivel_c=combustivel;
    }
    public int getAno(){
        return ano_c;
    }
    public int getCilindrada(){
        return cilindrada_c;
    }
    public int getCo2(){
        return co2_c;
    }
    public int getCombustivel(){
        return combustivel_c;
    }
    public void setAno(int ano){
        ano_c=ano;
    }
    public void setCilindrada(int cilindrada){
        cilindrada_c=cilindrada;
    }
    public void setCo2(int co2){
        co2_c=co2;
    }
    public void setCombustivel(int combustivel){
        combustivel_c=combustivel;
    }
    public double getResultado(){
        return resultado;
    }
    public void calcular(){
        resultado=0;
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
                resultado += Double.parseDouble(getString(R.string.P2007_1_co2));
            else if (co2_c <= 180)
                resultado += Double.parseDouble(getString(R.string.P2007_2_co2));
            else if (co2_c <= 250)
                resultado += Double.parseDouble(getString(R.string.P2007_3_co2));
            else if (co2_c > 250)
                resultado += Double.parseDouble(getString(R.string.P2007_4_co2));

            if(combustivel_c!=0){
                if(cilindrada_c<=1250)
                    resultado+=Double.parseDouble(getString(R.string.P2007_1_gasoleo));
                else if(cilindrada_c<=1750)
                    resultado+=Double.parseDouble(getString(R.string.P2007_2_gasoleo));
                else if(cilindrada_c<=2500)
                    resultado+=Double.parseDouble(getString(R.string.P2007_3_gasoleo));
                else if(cilindrada_c>2500)
                    resultado+=Double.parseDouble(getString(R.string.P2007_4_gasoleo));

            }
            if(ano_c==2007)
                resultado*=Double.parseDouble(getString(R.string.C2007));
            else if(ano_c==2008)
                resultado*=Double.parseDouble(getString(R.string.C2008));
            else if(ano_c==2009)
                resultado*=Double.parseDouble(getString(R.string.C2009));
            else if(ano_c>=2010)
                resultado*=Double.parseDouble(getString(R.string.C2010));


        }else{
            if(combustivel_c==0){
                if(cilindrada_c<=1000){
                    if(ano_c<=1989){
                        resultado += Double.parseDouble(getString(R.string.A2007_1_1981));}
                    else if(ano_c<=1995){
                        resultado += Double.parseDouble(getString(R.string.A2007_1_1990));}
                    else if(ano_c>1995){
                        resultado += Double.parseDouble(getString(R.string.A2007_1_1995));}}
                else if(cilindrada_c<=1300){
                    if(ano_c<=1989){
                        resultado += Double.parseDouble(getString(R.string.A2007_2_1981));}
                    else if(ano_c<=1995){
                        resultado += Double.parseDouble(getString(R.string.A2007_2_1990));}
                    else if(ano_c>1995){
                        resultado += Double.parseDouble(getString(R.string.A2007_2_1995));}
                }
                else if(cilindrada_c<=1750){
                    if(ano_c<=1989){
                        resultado += Double.parseDouble(getString(R.string.A2007_3_1981));}
                    else if(ano_c<=1995){
                        resultado += Double.parseDouble(getString(R.string.A2007_3_1990));}
                    else if(ano_c>1995){
                        resultado += Double.parseDouble(getString(R.string.A2007_3_1995));}
                }
                else if(cilindrada_c<=2600){
                    if(ano_c<=1989){
                        resultado += Double.parseDouble(getString(R.string.A2007_4_1981));}
                    else if(ano_c<=1995){
                        resultado += Double.parseDouble(getString(R.string.A2007_4_1990));}
                    else if(ano_c>1995){
                        resultado += Double.parseDouble(getString(R.string.A2007_4_1995));}
                }
                else if(cilindrada_c<=3500){
                    if(ano_c<=1989){
                        resultado += Double.parseDouble(getString(R.string.A2007_5_1981));}
                    else if(ano_c<=1995){
                        resultado += Double.parseDouble(getString(R.string.A2007_5_1990));}
                    else if(ano_c>1995){
                        resultado += Double.parseDouble(getString(R.string.A2007_5_1995));}
                }else if(cilindrada_c>3500){
                    if(ano_c<=1989){
                        resultado += Double.parseDouble(getString(R.string.A2007_6_1981));}
                    else if(ano_c<=1995){
                        resultado += Double.parseDouble(getString(R.string.A2007_6_1990));}
                    else if(ano_c>1995){
                        resultado += Double.parseDouble(getString(R.string.A2007_6_1995));}
                }

            }
            else{
                if(cilindrada_c<=1500){
                    if(ano_c<=1989){
                        resultado += Double.parseDouble(getString(R.string.A2007_1_1981));
                        resultado += Double.parseDouble(getString(R.string.A2007_add_1_1981));
                    }
                    else if(ano_c<=1995){
                        resultado += Double.parseDouble(getString(R.string.A2007_1_1990));
                        resultado += Double.parseDouble(getString(R.string.A2007_add_1_1990));
                    }
                    else if(ano_c>1995){
                        resultado += Double.parseDouble(getString(R.string.A2007_1_1995));
                        resultado += Double.parseDouble(getString(R.string.A2007_add_1_1995));
                    }}
                else if(cilindrada_c<=2000){
                    if(ano_c<=1989){
                        resultado += Double.parseDouble(getString(R.string.A2007_2_1981));
                        resultado += Double.parseDouble(getString(R.string.A2007_add_2_1981));
                    }
                    else if(ano_c<=1995){
                        resultado += Double.parseDouble(getString(R.string.A2007_2_1990));
                        resultado += Double.parseDouble(getString(R.string.A2007_add_2_1990));}
                    else if(ano_c>1995){
                        resultado += Double.parseDouble(getString(R.string.A2007_2_1995));
                        resultado += Double.parseDouble(getString(R.string.A2007_add_2_1995));
                    }
                }
                else if(cilindrada_c<=3000){
                    if(ano_c<=1989){
                        resultado += Double.parseDouble(getString(R.string.A2007_3_1981));
                        resultado += Double.parseDouble(getString(R.string.A2007_add_3_1981));}
                    else if(ano_c<=1995){
                        resultado += Double.parseDouble(getString(R.string.A2007_3_1990));
                        resultado += Double.parseDouble(getString(R.string.A2007_add_3_1990));}
                    else if(ano_c>1995){
                        resultado += Double.parseDouble(getString(R.string.A2007_3_1995));
                        resultado += Double.parseDouble(getString(R.string.A2007_add_3_1995));}
                }
                else if(cilindrada_c>3000){
                    if(ano_c<=1989){
                        resultado += Double.parseDouble(getString(R.string.A2007_4_1981));
                        resultado += Double.parseDouble(getString(R.string.A2007_add_4_1981));}
                    else if(ano_c<=1995){
                        resultado += Double.parseDouble(getString(R.string.A2007_4_1990));
                        resultado += Double.parseDouble(getString(R.string.A2007_add_4_1990));}
                    else if(ano_c>1995){
                        resultado += Double.parseDouble(getString(R.string.A2007_4_1995));
                        resultado += Double.parseDouble(getString(R.string.A2007_add_4_1995));}
                }

            }


        }

    }
}
