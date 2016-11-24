package pt.isec.a21240085.popoiuc;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

public class InserirDadosActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inserir_dados);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_inserirdados, menu);
        return true;
    }
}
