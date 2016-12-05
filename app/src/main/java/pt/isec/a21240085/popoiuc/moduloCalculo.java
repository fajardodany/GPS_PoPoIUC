package pt.isec.a21240085.popoiuc;


import android.content.Context;
import android.content.ContextWrapper;

import java.util.Calendar;

/**
 * Created by francisco on 29-11-2016.
 */

public class moduloCalculo extends ContextWrapper {
    private double resultado;
    private int ano_c = 0, cilindrada_c = 0, co2_c = 0, combustivel_c;

    public moduloCalculo(int ano, int cilindrada, int co2, int combustivel, Context base) {
        super(base);
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        if (!(ano < 1981 || ano > year)) {
            ano_c = ano;
        } else {
            throw new IllegalArgumentException("Ano fora dos parametros aceitaveis");
        }
        if (!(cilindrada < 0)) {
            cilindrada_c = cilindrada;
        } else {
            throw new IllegalArgumentException("Cilindrada fora dos parametros aceitaveis");
        }
        if (!(co2 < 0)) {
            co2_c = co2;
        } else {
            throw new IllegalArgumentException("CO2 fora dos parametros aceitaveis");
        }
        if (!(combustivel <= 0 && combustivel >= 2)) {
            combustivel_c = combustivel;
        } else {
            throw new IllegalArgumentException("Valor do Combustivel fora dos parametros aceitaveis");
        }
    }

    public void resetValores(int ano, int cilindrada, int co2, int combustivel) {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        if (!(ano < 1981 || ano > year)) {
            ano_c = ano;
        } else {
            throw new IllegalArgumentException("Ano fora dos parametros aceitaveis");
        }
        if (!(cilindrada < 0)) {
            cilindrada_c = cilindrada;
        } else {
            throw new IllegalArgumentException("Cilindrada fora dos parametros aceitaveis");
        }
        if (!(co2 < 0)) {
            co2_c = co2;
        } else {
            throw new IllegalArgumentException("CO2 fora dos parametros aceitaveis");
        }
        if (!(combustivel <= 0 && combustivel >= 2)) {
            combustivel_c = combustivel;
        } else {
            throw new IllegalArgumentException("Valor do Combustivel fora dos parametros aceitaveis");
        }
    }

    public int getAno() {
        return ano_c;
    }

    public int getCilindrada() {
        return cilindrada_c;
    }

    public int getCo2() {
        return co2_c;
    }

    public int getCombustivel() {
        return combustivel_c;
    }

    public void setAno(int ano) {
        ano_c = ano;
    }

    public void setCilindrada(int cilindrada) {
        cilindrada_c = cilindrada;
    }

    public void setCo2(int co2) {
        co2_c = co2;
    }

    public void setCombustivel(int combustivel) {
        combustivel_c = combustivel;
    }

    public double getResultado() {
        return resultado;
    }

    public void calcular() {
        resultado = 0;
        /*Segundo a Tabela 1 do Documento de Apoio ao Módulo de Cálculo*/
        if (ano_c >= 2007) {//apos 2007
            if (cilindrada_c <= 1250)//Até 1.250cm3
            {
                try {
                    resultado += Double.parseDouble(getString(R.string.P2007_1));
                } catch (NumberFormatException ex) {
                }
            } else if (cilindrada_c <= 1750)//Mais de 1.250cm3 até 1750cm3
            {
                try {
                    resultado += Double.parseDouble(getString(R.string.P2007_2));
                } catch (NumberFormatException ex) {
                }
            } else if (cilindrada_c <= 2500)//Mais de 1.700cm3 até 2.500cm3
            {
                try {
                    resultado += Double.parseDouble(getString(R.string.P2007_3));
                } catch (NumberFormatException ex) {
                }
            } else if (cilindrada_c > 2500)//Mais de 2.500cm3
            {
                try {
                    resultado += Double.parseDouble(getString(R.string.P2007_4));
                } catch (NumberFormatException ex) {
                }
            }

            /*Segundo a Tabela 1 do Documento de Apoio ao Módulo de Cálculo*/
            if (co2_c <= 120)//Até 120g/km
            {
                try {
                    resultado += Double.parseDouble(getString(R.string.P2007_1_co2));
                } catch (NumberFormatException ex) {
                }
            } else if (co2_c <= 180)//Mais de 120g/km até 180g/km
            {
                try {
                    resultado += Double.parseDouble(getString(R.string.P2007_2_co2));
                } catch (NumberFormatException ex) {
                }
            } else if (co2_c <= 250)//Mais de 180g/km até 250g/km
            {
                try {
                    resultado += Double.parseDouble(getString(R.string.P2007_3_co2));
                } catch (NumberFormatException ex) {
                }
            } else if (co2_c > 250)//Mais de 250g/km
            {
                try {
                    resultado += Double.parseDouble(getString(R.string.P2007_4_co2));
                } catch (NumberFormatException ex) {
                }
            }
            /*Segundo a Tabela 2 do Documento de Apoio ao Módulo de Cáculo*/
            if (combustivel_c != 0) {

                if (cilindrada_c <= 1250)//Até 1.250cm3
                {
                    try {
                        resultado += Double.parseDouble(getString(R.string.P2007_1_gasoleo));
                    } catch (NumberFormatException ex) {
                    }
                } else if (cilindrada_c <= 1750)//Mais de 1.250cm3 até 1750cm3
                {
                    try {
                        resultado += Double.parseDouble(getString(R.string.P2007_2_gasoleo));
                    } catch (NumberFormatException ex) {
                    }
                } else if (cilindrada_c <= 2500)//Mais de 1.700cm3 até 2.500cm3
                {
                    try {
                        resultado += Double.parseDouble(getString(R.string.P2007_3_gasoleo));
                    } catch (NumberFormatException ex) {
                    }
                } else if (cilindrada_c > 2500)//Mais de 2.500cm3
                {
                    try {
                        resultado += Double.parseDouble(getString(R.string.P2007_4_gasoleo));
                    } catch (NumberFormatException ex) {
                    }
                }

            }
            /*Segundo a Tabela 3 do Documento de Apoio ao Módulo de Cáculo*/
            switch (ano_c) {
                case 2007: {
                    try {
                        resultado *= Double.parseDouble(getString(R.string.C2007));
                    } catch (NumberFormatException ex) {
                    }
                    break;
                }
                case 2008: {
                    try {
                        resultado *= Double.parseDouble(getString(R.string.C2008));
                    } catch (NumberFormatException ex) {
                    }
                    break;
                }
                case 2009: {
                    try {
                        resultado *= Double.parseDouble(getString(R.string.C2009));
                    } catch (NumberFormatException ex) {
                    }
                    break;
                }
                case 2010: {
                    try {
                        resultado *= Double.parseDouble(getString(R.string.C2010));
                    } catch (NumberFormatException ex) {
                    }
                }
                default:
                    break;
            }


        } else {//Anterior a 2007
            /*Segundo a Tabela 4 do Documento de Apoio ao Módulo de Cáculo*/
            if (combustivel_c == 0) {//Carros a Gasolina
                if (cilindrada_c <= 1000) {//Até 1.000cm3
                    if (ano_c <= 1989) {//Antes de 1989
                        {
                            try {
                                resultado += Double.parseDouble(getString(R.string.A2007_1_1981));
                            } catch (NumberFormatException ex) {
                            }
                        }
                    } else if (ano_c <= 1995) {//De 1990 a 1995
                        {
                            try {
                                resultado += Double.parseDouble(getString(R.string.A2007_1_1990));
                            } catch (NumberFormatException ex) {
                            }
                        }
                    } else if (ano_c > 1995) {//Posterior a 1995
                        {
                            try {
                                resultado += Double.parseDouble(getString(R.string.A2007_1_1995));
                            } catch (NumberFormatException ex) {
                            }
                        }
                    }
                } else if (cilindrada_c <= 1300) {//Entre 1.000cm3 e 1.300cm3
                    if (ano_c <= 1989) {//Antes de 1989
                        {
                            try {
                                resultado += Double.parseDouble(getString(R.string.A2007_2_1981));
                            } catch (NumberFormatException ex) {
                            }
                        }
                    } else if (ano_c <= 1995) {//De 1990 a 1995
                        {
                            try {
                                resultado += Double.parseDouble(getString(R.string.A2007_2_1990));
                            } catch (NumberFormatException ex) {
                            }
                        }
                    } else if (ano_c > 1995) {//Posterior a 1995
                        {
                            try {
                                resultado += Double.parseDouble(getString(R.string.A2007_2_1995));
                            } catch (NumberFormatException ex) {
                            }
                        }
                    }
                } else if (cilindrada_c <= 1750) {//Entre 1.300cm3 e 1.750cm3
                    if (ano_c <= 1989) {//Antes de 1989
                        {
                            try {
                                resultado += Double.parseDouble(getString(R.string.A2007_3_1981));
                            } catch (NumberFormatException ex) {
                            }
                        }
                    } else if (ano_c <= 1995) {//De 1990 a 1995
                        {
                            try {
                                resultado += Double.parseDouble(getString(R.string.A2007_3_1990));
                            } catch (NumberFormatException ex) {
                            }
                        }
                    } else if (ano_c > 1995) {//Posterior a 1995
                        {
                            try {
                                resultado += Double.parseDouble(getString(R.string.A2007_3_1995));
                            } catch (NumberFormatException ex) {
                            }
                        }
                    }
                } else if (cilindrada_c <= 2600) {//Entre 1.750cm3 e 2.600cm3
                    if (ano_c <= 1989) {//Antes de 1989
                        {
                            try {
                                resultado += Double.parseDouble(getString(R.string.A2007_4_1981));
                            } catch (NumberFormatException ex) {
                            }
                        }
                    } else if (ano_c <= 1995) {//De 1990 a 1995
                        {
                            try {
                                resultado += Double.parseDouble(getString(R.string.A2007_4_1990));
                            } catch (NumberFormatException ex) {
                            }
                        }
                    } else if (ano_c > 1995) {//Posterior a 1995
                        {
                            try {
                                resultado += Double.parseDouble(getString(R.string.A2007_4_1995));
                            } catch (NumberFormatException ex) {
                            }
                        }
                    }
                } else if (cilindrada_c <= 3500) {//Entre 2.600cm3 e 3.500cm3
                    if (ano_c <= 1989) {//Antes de 1989
                        {
                            try {
                                resultado += Double.parseDouble(getString(R.string.A2007_5_1981));
                            } catch (NumberFormatException ex) {
                            }
                        }
                    } else if (ano_c <= 1995) {//De 1990 a 1995
                        {
                            try {
                                resultado += Double.parseDouble(getString(R.string.A2007_5_1990));
                            } catch (NumberFormatException ex) {
                            }
                        }
                    } else if (ano_c > 1995) {//Posterior a 1995
                        {
                            try {
                                resultado += Double.parseDouble(getString(R.string.A2007_5_1995));
                            } catch (NumberFormatException ex) {
                            }
                        }
                    }
                } else if (cilindrada_c > 3500) {//Superior a 3.500cm3
                    if (ano_c <= 1989) {//Antes de 1989
                        {
                            try {
                                resultado += Double.parseDouble(getString(R.string.A2007_6_1981));
                            } catch (NumberFormatException ex) {
                            }
                        }
                    } else if (ano_c <= 1995) {//De 1990 a 1995
                        {
                            try {
                                resultado += Double.parseDouble(getString(R.string.A2007_6_1990));
                            } catch (NumberFormatException ex) {
                            }
                        }
                    } else if (ano_c > 1995) {//Posterior a 1995
                        {
                            try {
                                resultado += Double.parseDouble(getString(R.string.A2007_6_1995));
                            } catch (NumberFormatException ex) {
                            }
                        }
                    }
                }
            } else {//Sem ser a gasolina
                /*Recorrendo também à Tabela 5 do Documento de Apoio ao Módulo de Cáculo*/
                if (cilindrada_c <= 1500) {//Até 1.500cm3
                    if (ano_c <= 1989) {//Antes de 1989
                        {
                            try {
                                resultado += Double.parseDouble(getString(R.string.A2007_1_1981));
                            } catch (NumberFormatException ex) {
                            }
                            try {
                                resultado += Double.parseDouble(getString(R.string.A2007_add_1_1981));//Valor Tabela 5
                            } catch (NumberFormatException ex) {
                            }
                        }
                    } else if (ano_c <= 1995) {//De 1990 a 1995
                        {
                            try {
                                resultado += Double.parseDouble(getString(R.string.A2007_1_1990));
                            } catch (NumberFormatException ex) {
                            }
                            try {
                                resultado += Double.parseDouble(getString(R.string.A2007_add_1_1990));//Valor Tabela 5
                            } catch (NumberFormatException ex) {
                            }
                        }
                    } else if (ano_c > 1995) {//Posterior a 1995
                        {
                            try {
                                resultado += Double.parseDouble(getString(R.string.A2007_1_1995));
                            } catch (NumberFormatException ex) {
                            }
                            try {
                                resultado += Double.parseDouble(getString(R.string.A2007_add_1_1995));//Valor Tabela 5
                            } catch (NumberFormatException ex) {
                            }
                        }
                    }
                } else if (cilindrada_c <= 2000) {//Entre 1.500cm3 e 2.000cm3
                    if (ano_c <= 1989) {//Antes de 1989
                        {
                            try {
                                resultado += Double.parseDouble(getString(R.string.A2007_2_1981));
                            } catch (NumberFormatException ex) {
                            }
                            try {
                                resultado += Double.parseDouble(getString(R.string.A2007_add_2_1981));//Valor Tabela 5
                            } catch (NumberFormatException ex) {
                            }
                        }
                    } else if (ano_c <= 1995) {//De 1990 a 1995
                        {
                            try {
                                resultado += Double.parseDouble(getString(R.string.A2007_2_1990));
                            } catch (NumberFormatException ex) {
                            }
                            try {
                                resultado += Double.parseDouble(getString(R.string.A2007_add_2_1990));
                            } catch (NumberFormatException ex) {
                            }
                        }
                    }//Valor Tabela 5
                    else if (ano_c > 1995) {//Posterior a 1995
                        {
                            try {
                                resultado += Double.parseDouble(getString(R.string.A2007_2_1995));
                            } catch (NumberFormatException ex) {
                            }
                            try {
                                resultado += Double.parseDouble(getString(R.string.A2007_add_2_1995));//Valor Tabela 5
                            } catch (NumberFormatException ex) {
                            }
                        }
                    }
                } else if (cilindrada_c <= 3000) {//Entre 2.000cm3 e 3.000cm3
                    if (ano_c <= 1989) {//Antes de 1989
                        {
                            try {
                                resultado += Double.parseDouble(getString(R.string.A2007_3_1981));
                            } catch (NumberFormatException ex) {
                            }
                            try {
                                resultado += Double.parseDouble(getString(R.string.A2007_add_3_1981));
                            } catch (NumberFormatException ex) {
                            }
                        }
                    }//Valor Tabela 5
                    else if (ano_c <= 1995) {//De 1990 a 1995
                        {
                            try {
                                resultado += Double.parseDouble(getString(R.string.A2007_3_1990));
                            } catch (NumberFormatException ex) {
                            }
                            try {
                                resultado += Double.parseDouble(getString(R.string.A2007_add_3_1990));
                            } catch (NumberFormatException ex) {
                            }
                        }
                    }//Valor Tabela 5
                    else if (ano_c > 1995) {//Posterior a 1995
                        {
                            try {
                                resultado += Double.parseDouble(getString(R.string.A2007_3_1995));
                            } catch (NumberFormatException ex) {
                            }
                            try {
                                resultado += Double.parseDouble(getString(R.string.A2007_add_3_1995));
                            } catch (NumberFormatException ex) {
                            }
                        }
                    }//Valor Tabela 5
                } else if (cilindrada_c > 3000) {//Mais de 3.000cm3
                    if (ano_c <= 1989) {//Antes de 1989
                        {
                            try {
                                resultado += Double.parseDouble(getString(R.string.A2007_4_1981));
                            } catch (NumberFormatException ex) {
                            }
                            try {
                                resultado += Double.parseDouble(getString(R.string.A2007_add_4_1981));
                            } catch (NumberFormatException ex) {
                            }
                        }
                    }//Valor Tabela 5
                    else if (ano_c <= 1995) {//De 1990 a 1995
                        {
                            try {
                                resultado += Double.parseDouble(getString(R.string.A2007_4_1990));
                            } catch (NumberFormatException ex) {
                            }
                            try {
                                resultado += Double.parseDouble(getString(R.string.A2007_add_4_1990));
                            } catch (NumberFormatException ex) {
                            }
                        }
                    }//Valor Tabela 5
                    else if (ano_c > 1995) {//Posterior a 1995
                        {
                            try {
                                resultado += Double.parseDouble(getString(R.string.A2007_4_1995));
                            } catch (NumberFormatException ex) {
                            }
                            try {
                                resultado += Double.parseDouble(getString(R.string.A2007_add_4_1995));
                            } catch (NumberFormatException ex) {
                            }
                        }
                    }//Valor Tabela 5
                }

            }


        }

    }
}
