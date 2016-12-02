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
        /*Segundo a Tabela 1 do Documento de Apoio ao Módulo de Cálculo*/
        if(ano_c>=2007){//apos 2007
            if(cilindrada_c<=1250)//Até 1.250cm3
                resultado+=Double.parseDouble(getString(R.string.P2007_1));
            else if(cilindrada_c<=1750)//Mais de 1.250cm3 até 1750cm3
                resultado+=Double.parseDouble(getString(R.string.P2007_2));
            else if(cilindrada_c<=2500)//Mais de 1.700cm3 até 2.500cm3
                resultado+=Double.parseDouble(getString(R.string.P2007_3));
            else if(cilindrada_c>2500)//Mais de 2.500cm3
                resultado+=Double.parseDouble(getString(R.string.P2007_4));

            /*Segundo a Tabela 1 do Documento de Apoio ao Módulo de Cálculo*/
            if(co2_c<=120)//Até 120g/km
                resultado += Double.parseDouble(getString(R.string.P2007_1_co2));
            else if (co2_c <= 180)//Mais de 120g/km até 180g/km
                resultado += Double.parseDouble(getString(R.string.P2007_2_co2));
            else if (co2_c <= 250)//Mais de 180g/km até 250g/km
                resultado += Double.parseDouble(getString(R.string.P2007_3_co2));
            else if (co2_c > 250)//Mais de 250g/km
                resultado += Double.parseDouble(getString(R.string.P2007_4_co2));
            /*Segundo a Tabela 2 do Documento de Apoio ao Módulo de Cáculo*/
            if(combustivel_c!=0){
                if(cilindrada_c<=1250)//Até 1.250cm3
                    resultado+=Double.parseDouble(getString(R.string.P2007_1_gasoleo));
                else if(cilindrada_c<=1750)//Mais de 1.250cm3 até 1750cm3
                    resultado+=Double.parseDouble(getString(R.string.P2007_2_gasoleo));
                else if(cilindrada_c<=2500)//Mais de 1.700cm3 até 2.500cm3
                    resultado+=Double.parseDouble(getString(R.string.P2007_3_gasoleo));
                else if(cilindrada_c>2500)//Mais de 2.500cm3
                    resultado+=Double.parseDouble(getString(R.string.P2007_4_gasoleo));

            }
            /*Segundo a Tabela 3 do Documento de Apoio ao Módulo de Cáculo*/
            if(ano_c==2007)
                resultado*=Double.parseDouble(getString(R.string.C2007));
            else if(ano_c==2008)
                resultado*=Double.parseDouble(getString(R.string.C2008));
            else if(ano_c==2009)
                resultado*=Double.parseDouble(getString(R.string.C2009));
            else if(ano_c>=2010)
                resultado*=Double.parseDouble(getString(R.string.C2010));


        }else{//Anterior a 2007
            /*Segundo a Tabela 4 do Documento de Apoio ao Módulo de Cáculo*/
            if(combustivel_c==0){//Carros a Gasolina
                if(cilindrada_c<=1000){//Até 1.000cm3
                    if(ano_c<=1989){//Antes de 1989
                        resultado += Double.parseDouble(getString(R.string.A2007_1_1981));}
                    else if(ano_c<=1995){//De 1990 a 1995
                        resultado += Double.parseDouble(getString(R.string.A2007_1_1990));}
                    else if(ano_c>1995){//Posterior a 1995
                        resultado += Double.parseDouble(getString(R.string.A2007_1_1995));}
                }
                else if(cilindrada_c<=1300){//Entre 1.000cm3 e 1.300cm3
                    if(ano_c<=1989){//Antes de 1989
                        resultado += Double.parseDouble(getString(R.string.A2007_2_1981));}
                    else if(ano_c<=1995){//De 1990 a 1995
                        resultado += Double.parseDouble(getString(R.string.A2007_2_1990));}
                    else if(ano_c>1995){//Posterior a 1995
                        resultado += Double.parseDouble(getString(R.string.A2007_2_1995));}
                }
                else if(cilindrada_c<=1750){//Entre 1.300cm3 e 1.750cm3
                    if(ano_c<=1989){//Antes de 1989
                        resultado += Double.parseDouble(getString(R.string.A2007_3_1981));}
                    else if(ano_c<=1995){//De 1990 a 1995
                        resultado += Double.parseDouble(getString(R.string.A2007_3_1990));}
                    else if(ano_c>1995){//Posterior a 1995
                        resultado += Double.parseDouble(getString(R.string.A2007_3_1995));}
                }
                else if(cilindrada_c<=2600){//Entre 1.750cm3 e 2.600cm3
                    if(ano_c<=1989){//Antes de 1989
                        resultado += Double.parseDouble(getString(R.string.A2007_4_1981));}
                    else if(ano_c<=1995){//De 1990 a 1995
                        resultado += Double.parseDouble(getString(R.string.A2007_4_1990));}
                    else if(ano_c>1995){//Posterior a 1995
                        resultado += Double.parseDouble(getString(R.string.A2007_4_1995));}
                }
                else if(cilindrada_c<=3500){//Entre 2.600cm3 e 3.500cm3
                    if(ano_c<=1989){//Antes de 1989
                        resultado += Double.parseDouble(getString(R.string.A2007_5_1981));}
                    else if(ano_c<=1995){//De 1990 a 1995
                        resultado += Double.parseDouble(getString(R.string.A2007_5_1990));}
                    else if(ano_c>1995){//Posterior a 1995
                        resultado += Double.parseDouble(getString(R.string.A2007_5_1995));}
                }else if(cilindrada_c>3500){//Superior a 3.500cm3
                    if(ano_c<=1989){//Antes de 1989
                        resultado += Double.parseDouble(getString(R.string.A2007_6_1981));}
                    else if(ano_c<=1995){//De 1990 a 1995
                        resultado += Double.parseDouble(getString(R.string.A2007_6_1990));}
                    else if(ano_c>1995){//Posterior a 1995
                        resultado += Double.parseDouble(getString(R.string.A2007_6_1995));}
                }
            }
            else{//Sem ser a gasolina
                /*Recorrendo também à Tabela 5 do Documento de Apoio ao Módulo de Cáculo*/
                if(cilindrada_c<=1500){//Até 1.500cm3
                    if(ano_c<=1989){//Antes de 1989
                        resultado += Double.parseDouble(getString(R.string.A2007_1_1981));
                        resultado += Double.parseDouble(getString(R.string.A2007_add_1_1981));//Valor Tabela 5
                    }
                    else if(ano_c<=1995){//De 1990 a 1995
                        resultado += Double.parseDouble(getString(R.string.A2007_1_1990));
                        resultado += Double.parseDouble(getString(R.string.A2007_add_1_1990));//Valor Tabela 5
                    }
                    else if(ano_c>1995){//Posterior a 1995
                        resultado += Double.parseDouble(getString(R.string.A2007_1_1995));
                        resultado += Double.parseDouble(getString(R.string.A2007_add_1_1995));//Valor Tabela 5
                    }}
                else if(cilindrada_c<=2000){//Entre 1.500cm3 e 2.000cm3
                    if(ano_c<=1989){//Antes de 1989
                        resultado += Double.parseDouble(getString(R.string.A2007_2_1981));
                        resultado += Double.parseDouble(getString(R.string.A2007_add_2_1981));//Valor Tabela 5
                    }
                    else if(ano_c<=1995){//De 1990 a 1995
                        resultado += Double.parseDouble(getString(R.string.A2007_2_1990));
                        resultado += Double.parseDouble(getString(R.string.A2007_add_2_1990));}//Valor Tabela 5
                    else if(ano_c>1995){//Posterior a 1995
                        resultado += Double.parseDouble(getString(R.string.A2007_2_1995));
                        resultado += Double.parseDouble(getString(R.string.A2007_add_2_1995));//Valor Tabela 5
                    }
                }
                else if(cilindrada_c<=3000){//Entre 2.000cm3 e 3.000cm3
                    if(ano_c<=1989){//Antes de 1989
                        resultado += Double.parseDouble(getString(R.string.A2007_3_1981));
                        resultado += Double.parseDouble(getString(R.string.A2007_add_3_1981));}//Valor Tabela 5
                    else if(ano_c<=1995){//De 1990 a 1995
                        resultado += Double.parseDouble(getString(R.string.A2007_3_1990));
                        resultado += Double.parseDouble(getString(R.string.A2007_add_3_1990));}//Valor Tabela 5
                    else if(ano_c>1995){//Posterior a 1995
                        resultado += Double.parseDouble(getString(R.string.A2007_3_1995));
                        resultado += Double.parseDouble(getString(R.string.A2007_add_3_1995));}//Valor Tabela 5
                }
                else if(cilindrada_c>3000){//Mais de 3.000cm3
                    if(ano_c<=1989){//Antes de 1989
                        resultado += Double.parseDouble(getString(R.string.A2007_4_1981));
                        resultado += Double.parseDouble(getString(R.string.A2007_add_4_1981));}//Valor Tabela 5
                    else if(ano_c<=1995){//De 1990 a 1995
                        resultado += Double.parseDouble(getString(R.string.A2007_4_1990));
                        resultado += Double.parseDouble(getString(R.string.A2007_add_4_1990));}//Valor Tabela 5
                    else if(ano_c>1995){//Posterior a 1995
                        resultado += Double.parseDouble(getString(R.string.A2007_4_1995));
                        resultado += Double.parseDouble(getString(R.string.A2007_add_4_1995));}//Valor Tabela 5
                }

            }


        }

    }
}
