package pt.isec.a21240085.popoiuc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static android.R.attr.text;

public class InserirDadosActivity extends Activity {

    Spinner ano, cilindrada, combustivel, emissoes;
    AutoCompleteTextView marca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inserir_dados);
        ano = (Spinner) findViewById(R.id.spinnerAno);
        cilindrada = (Spinner) findViewById(R.id.spinnerCilindrada);
        combustivel = (Spinner) findViewById(R.id.spinnerCombustivel);
        emissoes = (Spinner) findViewById(R.id.spinnerCO2);
        marca = (AutoCompleteTextView) findViewById(R.id.autoCompleteMarcaModelo);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Combustivel, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        combustivel.setAdapter(adapter);

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        List<String> lista = new ArrayList<>();
        int AnoComeço = 1980;
        for(int i = AnoComeço; i <= year; i++){
            lista.add(""+i);
        }
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, lista);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ano.setAdapter(adapter2);

        combustivel.setOnItemSelectedListener(selectedItemListener);
        ano.setOnItemSelectedListener(selectedItemListener);

    }

    AdapterView.OnItemSelectedListener selectedItemListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
            int int_ano = -1;
            try{
                int_ano = Integer.parseInt(ano.getSelectedItem().toString());
            }catch(Exception e){
                Toast.makeText(getApplicationContext(), "Erro na inserção do campo Ano", Toast.LENGTH_SHORT).show();
                return;
            }
            int int_comb = -1;
            String text = combustivel.getSelectedItem().toString();
            if(text.equals("Gasolina"))
                int_comb=0;
            if(text.equals("Gásoleo"))
                int_comb=1;
            if(text.equals("GPL"))
                int_comb=2;

            if(int_comb==-1){
                Toast.makeText(getApplicationContext(), "Erro na inserção do campo Combustível", Toast.LENGTH_SHORT).show();
                return;
            }

            atualizaSpinners(int_ano, int_comb);

        }

        @Override
        public void onNothingSelected(AdapterView<?> parentView) {
            Toast.makeText(getApplicationContext(), "Não existe nada selecionado", Toast.LENGTH_SHORT).show();
        }

    };

    public void calcular(View v){
        int ano_c = -1,cilindrada_c = -1,emissoes_c = -1,combustivel_c = -1;
        moduloCalculo resultado;

        String text = combustivel.getSelectedItem().toString();
        if(text.equals("Gasolina"))
            combustivel_c=0;
        if(text.equals("Gásoleo"))
            combustivel_c=1;
        if(text.equals("GPL"))
            combustivel_c=2;

        if(combustivel_c==-1){
            Toast.makeText(this, "Erro na inserção do campo Combustível", Toast.LENGTH_SHORT).show();
            return;
        }

        try{
            ano_c = Integer.parseInt(ano.getSelectedItem().toString());
        }catch(Exception e){
            Toast.makeText(this, "Erro na inserção do campo Ano", Toast.LENGTH_SHORT).show();
            return;
        }

        if(marca.getText().toString().isEmpty()){
            Toast.makeText(this, "Erro na inserção do campo Marca/Modelo", Toast.LENGTH_SHORT).show();
            return;
        }

        String cilText = "";
        try{
            cilText = cilindrada.getSelectedItem().toString();
        }catch(Exception e){
            Toast.makeText(this, "Erro na inserção do campo Cilindrada", Toast.LENGTH_SHORT).show();
            return;
        }
        if(ano_c >= 2007){
            if(cilText.equals("Até 1250 cm3"))
                cilindrada_c=2500;
            else if(cilText.equals("Mais de 1250 cm3 a 1750 cm3"))
                cilindrada_c=1251;
            else if(cilText.equals("Mais de 1750 cm3 a 2500 cm3"))
                cilindrada_c=1751;
            else if(cilText.equals("Mais de 2500 cm3"))
                cilindrada_c=2501;
        }else if(ano_c < 2007){
            if(combustivel_c == 0){
                if(cilText.equals("Até 1000 cm3"))
                    cilindrada_c=999;
                else if(cilText.equals("Mais de 1000 cm3 a 1300 cm3"))
                    cilindrada_c=1001;
                else if(cilText.equals("Mais de 1300 cm3 a 1750 cm3"))
                    cilindrada_c=1301;
                else if(cilText.equals("Mais de 1750 cm3 a 2600 cm3"))
                    cilindrada_c=1751;
                else if(cilText.equals("Mais de 2600 cm3 a 3500 cm3"))
                    cilindrada_c=2601;
                else if(cilText.equals("Mais de 3500 cm3"))
                    cilindrada_c=3501;
            }else{
                if(cilText.equals("Até 1500 cm3"))
                    cilindrada_c=1499;
                else if(cilText.equals("Mais de 1500 cm3 a 2000 cm3"))
                    cilindrada_c=1501;
                else if(cilText.equals("Mais de 2000 cm3 a 3000 cm3"))
                    cilindrada_c=2001;
                else if(cilText.equals("Mais de 3000 cm3"))
                    cilindrada_c=3001;
            }
        }

        String emissText = "";
        try {
            emissText = emissoes.getSelectedItem().toString();
        }catch(Exception e){
            Toast.makeText(this, "Erro na inserção do campo Emissões de CO2", Toast.LENGTH_SHORT).show();
            return;
        }
        if(emissText.equals("Até 120 g/km"))
            emissoes_c=119;
        else if(emissText.equals("Mais de 120 g/km a 180 g/km"))
            emissoes_c=121;
        else if(emissText.equals("Mais de 180 g/km a 250 g/km"))
            emissoes_c=181;
        else if(emissText.equals("Mais de 250 g/km"))
            emissoes_c=251;

        try {
            resultado = new moduloCalculo(ano_c, cilindrada_c, emissoes_c, combustivel_c, this);
        } catch(Exception e) {
            Toast.makeText(this, "Erro na passagem de valores dos campos inseridos", Toast.LENGTH_SHORT).show();
            return;
        }

        resultado.calcular();

        Intent itent = new Intent(this, CalculaIUCActivity.class);
        itent.putExtra("intResultado", resultado.getResultado());
        startActivity(itent);
    }

    protected void atualizaSpinners(int ano, int combustivel){
        //--------------Apartir do ano e do tipo de combustivel preenche o s campos-----------------
        ArrayAdapter<CharSequence> adapterCilindrada = null;
        if(ano >= 2007)
            adapterCilindrada = ArrayAdapter.createFromResource(this,
                    R.array.TodasCilindradasGasolinaM2007, android.R.layout.simple_spinner_item);
        else if(ano<2007)
            if(combustivel == 0){
                adapterCilindrada = ArrayAdapter.createFromResource(this,
                        R.array.TodasCilindradasGasolinam2007, android.R.layout.simple_spinner_item);
            }else {
                adapterCilindrada = ArrayAdapter.createFromResource(this,
                        R.array.TodasCilindradasGasoleom2007, android.R.layout.simple_spinner_item);
            }
        adapterCilindrada.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cilindrada.setAdapter(adapterCilindrada);

        ArrayAdapter<CharSequence> adapterEmissoes = ArrayAdapter.createFromResource(this,
                R.array.TodasEmissões, android.R.layout.simple_spinner_item);
        adapterEmissoes.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        emissoes.setAdapter(adapterEmissoes);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_inserirdados, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(getApplicationContext(), "Inserção Sem Otimização", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, DadosSemOptimizacaoActivity.class);
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }

    protected void onCalcular(View v){
        calcular(v);
    }


}
