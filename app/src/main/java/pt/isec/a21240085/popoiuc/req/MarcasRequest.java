package pt.isec.a21240085.popoiuc.req;

import android.content.Context;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static android.R.attr.key;
import static android.R.id.list;

/**
 * Created by Carolina on 13/12/2016.
 */

public abstract class MarcasRequest {

    protected MarcasRequest(){
        DatabaseReference database = FirebaseDatabase.getInstance().getReference();

        database.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<String> list = new ArrayList<>();
                Iterator<DataSnapshot> it = dataSnapshot.getChildren().iterator();
                while(it.hasNext()){
                    String res = it.next().getKey();
                    list.add(res);
                }
                onMarcas(list);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        database.push();
    }
    protected abstract  void onMarcas(List<String> list);

}
