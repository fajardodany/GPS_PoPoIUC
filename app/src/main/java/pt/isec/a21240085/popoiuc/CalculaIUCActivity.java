package pt.isec.a21240085.popoiuc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class CalculaIUCActivity extends Activity {

    TextView resultadoFinal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcula_iuc);
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);
        Intent i = getIntent();
        double calculo = i.getDoubleExtra("intResultado",5.0);
        resultadoFinal = (TextView) findViewById(R.id.textViewResultadoIUC);
        resultadoFinal.setText(df.format(calculo)+"€");
    }

    protected void onRecomecar(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
