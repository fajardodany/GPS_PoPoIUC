package pt.isec.a21240085.popoiuc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

    Button comeco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        comeco = (Button) findViewById(R.id.buttonComecar);
    }

    protected void onclicar(View v){
        Intent intent = new Intent(this, InserirDadosActivity.class);
        startActivity(intent);

    }
}
