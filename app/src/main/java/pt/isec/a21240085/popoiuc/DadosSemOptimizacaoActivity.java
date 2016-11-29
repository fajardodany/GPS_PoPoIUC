package pt.isec.a21240085.popoiuc;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class DadosSemOptimizacaoActivity extends Activity {

    EditText ano,cilindrada,co2;
    Spinner combustivel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_sem_optimizacao);
        ano = (EditText)findViewById(R.id.editTextAno);
        cilindrada = (EditText)findViewById(R.id.editTextCilindrada);
        co2 = (EditText) findViewById(R.id.editTextCO2);
        combustivel= (Spinner) findViewById(R.id.spinnerCombustivel_o);
    }
    protected void calcular(View v){
        int ano_c=0,cilindrada_c=0,co2_c=0;
        double resultado=0;
        try {
            ano_c = Integer.parseInt(ano.getText().toString());
        } catch(NumberFormatException nfe) {
            Toast.makeText(this, "Erro na passagem de valores", Toast.LENGTH_SHORT).show();
        }

        try {
            cilindrada_c = Integer.parseInt(cilindrada.getText().toString());
        } catch(NumberFormatException nfe) {
            Toast.makeText(this, "Erro na passagem de valores", Toast.LENGTH_SHORT).show();
        }
        try {
            co2_c = Integer.parseInt(co2.getText().toString());
        } catch(NumberFormatException nfe) {
            Toast.makeText(this, "Erro na passagem de valores", Toast.LENGTH_SHORT).show();
        }
        if(ano_c<1989){

        }


    }
}
