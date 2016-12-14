package pt.isec.a21240085.popoiuc.req;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Carolina on 14/12/2016.
 */

public abstract class AnoRequest {
    protected AnoRequest(String marca, String modelo, String combustivel){
        DatabaseReference database = FirebaseDatabase.getInstance().getReference();

        database.child(marca).child(modelo).child(combustivel).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<String> list = new ArrayList<>();
                Iterator<DataSnapshot> it = dataSnapshot.getChildren().iterator();
                while(it.hasNext()){
                    String res = it.next().getKey();
                    list.add(res);
                }
                onAno(list);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        database.push();
    }
    protected abstract  void onAno(List<String> list);
}
