package pt.isec.a21240085.popoiuc;

import android.app.Activity;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class DadosSemOptimizacaoActivity extends Activity {

    EditText ano,cilindrada,co2;
    Spinner combustivel;
    private String[] arraySpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_sem_optimizacao);
        ano = (EditText)findViewById(R.id.editTextAno);
        cilindrada = (EditText)findViewById(R.id.editTextCilindrada);
        co2 = (EditText) findViewById(R.id.editTextCO2);
        combustivel= (Spinner) findViewById(R.id.spinnerCombustivel_o);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Combustivel, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        combustivel.setAdapter(adapter);
    }
    protected void calcular(View v){

        int ano_c=0,cilindrada_c=0,co2_c=0,combustivel_c=-1;
        moduloCalculo calculos;

        String text = combustivel.getSelectedItem().toString();
        if(text.equals("Gasolina"))
            combustivel_c=0;
        if(text.equals("Gásoleo"))
            combustivel_c=1;
        if(text.equals("GPL"))
            combustivel_c=2;

        if(combustivel_c==-1){
            Toast.makeText(this, "Erro na passagem de valores - Combustivel", Toast.LENGTH_SHORT).show();
            return;
        }
        try {
            ano_c = Integer.parseInt(ano.toString());
        } catch(NumberFormatException nfe) {
            Toast.makeText(this, "Erro na passagem de valores - Ano", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            cilindrada_c = Integer.parseInt(cilindrada.toString());
        } catch(NumberFormatException nfe) {
            Toast.makeText(this, "Erro na passagem de valores - Cilindrada", Toast.LENGTH_SHORT).show();
            return;
        }
        try {
            co2_c = Integer.parseInt(co2.toString());
        } catch(NumberFormatException nfe) {
            Toast.makeText(this, "Erro na passagem de valores - Co2", Toast.LENGTH_SHORT).show();
            return;
        }
        calculos= new moduloCalculo(ano_c,cilindrada_c,co2_c,combustivel_c,this);
        calculos.calcular();
        Toast.makeText(this, "Resultado: "+calculos.devolve_resultado(), Toast.LENGTH_SHORT).show();
        return;
    }
}
