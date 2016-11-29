package pt.isec.a21240085.popoiuc;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends Activity {

    Button comeco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        comeco = (Button) findViewById(R.id.buttonComecar);

        openOrCreateDatabase("",MODE_PRIVATE,null);
    }

    protected void clicar(){

    }
}
