package pt.isec.a21240085.popoiuc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

import pt.isec.a21240085.popoiuc.req.AnoRequest;
import pt.isec.a21240085.popoiuc.req.CilindradaRequest;
import pt.isec.a21240085.popoiuc.req.CombustivelRequest;
import pt.isec.a21240085.popoiuc.req.EmissoesRequest;
import pt.isec.a21240085.popoiuc.req.MarcasRequest;
import pt.isec.a21240085.popoiuc.req.ModelosRequest;

import static pt.isec.a21240085.popoiuc.R.string.cm3;

public class InserirDadosActivity extends Activity {

    Spinner ano, cilindrada, combustivel, emissoes;
    Spinner marca, modelo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inserir_dados);
        ano = (Spinner) findViewById(R.id.spinnerAno);
        cilindrada = (Spinner) findViewById(R.id.spinnerCilindrada);
        combustivel = (Spinner) findViewById(R.id.spinnerCombustivel);
        emissoes = (Spinner) findViewById(R.id.spinnerCO2);
        marca = (Spinner) findViewById(R.id.SpinerMarca);
        modelo = (Spinner) findViewById(R.id.SpinerModelo);

        new MarcasRequest(){

            @Override
            protected void onMarcas(List<String> listaMarcas) {
                atualizaSppinner(listaMarcas, marca);
            }
        };

        marca.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String marcaSelecionada = "";
                try {
                    marcaSelecionada = marca.getSelectedItem().toString();
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), "Erro na seleção de dados!", Toast.LENGTH_SHORT).show();
                    return;
                }
                new ModelosRequest(marcaSelecionada){

                    @Override
                    protected void onModelo(List<String> list) {
                        atualizaSppinner(list, modelo);
                    }
                };
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(getApplicationContext(), "Nenhuma marca selecionado!", Toast.LENGTH_SHORT).show();
            }
        });

        modelo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String marcaSelecionada = "", modeloSelecionado = "";
                try {
                    marcaSelecionada = marca.getSelectedItem().toString();
                    modeloSelecionado = modelo.getSelectedItem().toString();
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), "Erro na seleção de dados!", Toast.LENGTH_SHORT).show();
                    return;
                }
                new CombustivelRequest(marcaSelecionada, modeloSelecionado){
                    @Override
                    public void onCombustivel(List<String> list) {
                        atualizaSppinner(list, combustivel);
                    }
                };
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(getApplicationContext(), "Nenhum modelo selecionado!", Toast.LENGTH_SHORT).show();
            }
        });

        combustivel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String marcaSelecionada = "", modeloSelecionado = "", combustivelSelecionado = "";
                try {
                    marcaSelecionada = marca.getSelectedItem().toString();
                    modeloSelecionado = modelo.getSelectedItem().toString();
                    combustivelSelecionado = combustivel.getSelectedItem().toString();
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), "Erro na seleção de dados!", Toast.LENGTH_SHORT).show();
                    return;
                }
                new AnoRequest(marcaSelecionada, modeloSelecionado, combustivelSelecionado){
                    @Override
                    public void onAno(List<String> list) {
                        atualizaSppinner(list, ano);
                    }
                };
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(getApplicationContext(), "Nenhum combustivel selecionado!", Toast.LENGTH_SHORT).show();
            }
        });

        ano.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String marcaSelecionada = "", modeloSelecionado = "", combustivelSelecionado = "";
                String anoSelecionado = "";
                try {
                    marcaSelecionada = marca.getSelectedItem().toString();
                    modeloSelecionado = modelo.getSelectedItem().toString();
                    combustivelSelecionado = combustivel.getSelectedItem().toString();
                    anoSelecionado = ano.getSelectedItem().toString();
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), "Erro na seleção de dados!", Toast.LENGTH_SHORT).show();
                    return;
                }
                new CilindradaRequest(marcaSelecionada, modeloSelecionado, combustivelSelecionado, anoSelecionado){
                    @Override
                    public void onCilindrada(List<String> list) {
                        atualizaSppinner(list, cilindrada);
                    }
                };
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(getApplicationContext(), "Nenhum ano selecionado!", Toast.LENGTH_SHORT).show();
            }
        });

        cilindrada.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String marcaSelecionada = "", modeloSelecionado = "", combustivelSelecionado = "";
                String anoSelecionado = "", cilindradaSelecionada = "";
                try {
                    marcaSelecionada = marca.getSelectedItem().toString();
                    modeloSelecionado = modelo.getSelectedItem().toString();
                    combustivelSelecionado = combustivel.getSelectedItem().toString();
                    anoSelecionado = ano.getSelectedItem().toString();
                    cilindradaSelecionada = cilindrada.getSelectedItem().toString();
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), "Erro na seleção de dados!", Toast.LENGTH_SHORT).show();
                    return;
                }
                new EmissoesRequest(marcaSelecionada, modeloSelecionado, combustivelSelecionado, anoSelecionado, cilindradaSelecionada){
                    @Override
                    public void onEmissoes(List<String> list) {
                        atualizaSppinner(list, emissoes);
                    }
                };
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(getApplicationContext(), "Nenhum ano selecionado!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void atualizaSppinner(List<String> listaMarcas, Spinner tipo) {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, listaMarcas);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tipo.setAdapter(adapter);
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
        int ano_c = -1, cilindrada_c = -1, emissoes_c = -1, combustivel_c = -1;
        moduloCalculo resultado;

        String text = combustivel.getSelectedItem().toString();
        if(text.equals("Gasolina"))
            combustivel_c=0;
        if(text.equals("Gasoleo"))
            combustivel_c=1;
        if(text.equals("GPL"))
            combustivel_c=2;

        try{
            ano_c = Integer.parseInt(ano.getSelectedItem().toString());
        }catch(Exception e){
            Toast.makeText(this, "Erro na inserção do campo Ano!", Toast.LENGTH_SHORT).show();
            return;
        }

        try{
            cilindrada_c = Integer.parseInt(cilindrada.getSelectedItem().toString());
        }catch(Exception e){
            Toast.makeText(this, "Erro na inserção do campo Cilindrada!", Toast.LENGTH_SHORT).show();
            return;
        }

        try{
            emissoes_c = Integer.parseInt(emissoes.getSelectedItem().toString());
        }catch(Exception e){
            Toast.makeText(this, "Erro na inserção do campo Emissão de CO2!", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            resultado = new moduloCalculo(ano_c, cilindrada_c, emissoes_c, combustivel_c, this);
        }catch(Exception e) {
            Toast.makeText(this, "Erro na passagem de valores dos campos inseridos", Toast.LENGTH_SHORT).show();
            return;
        }

        resultado.calcular();

        Intent itent = new Intent(this, CalculaIUCActivity.class);
        itent.putExtra("intResultado", resultado.getResultado());
        startActivity(itent);

    }


}
