package edu.utec.app_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv1;
    private ListView lv1;

    // creamos un vector para colocar los elementos que vamos a cargar en nuestra lista
    private String nombres[] = {"Samuel", "Valentina", "Santiago", "Alejandro", "Valeria", "Benjamin",
                                    "Gerardo", "Carlos", "David", "Sofia"};  //elementos que se cargaran cuando inicie la app
    private String edades[] = {"18","25","32","17","24","20","27","15","19","23"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Agrego la relacion entre la parte grafica y la parte logica
        tv1 = (TextView) findViewById(R.id.tv1);
        lv1 = (ListView) findViewById(R.id.lv1);

        // Utilizo el metodo ArrayAdapter para agregar los valor en la lista
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_item_rodrigo, nombres); //utilizamos el que creamos
        lv1.setAdapter(adapter);

        // creo el metodo para que muestre los valores luego de darle click a la opcion seleccionada
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(
                    AdapterView<?> adapterView,
                    View view,
                    int i,
                    long l
            ) {

                tv1.setText("La edad de " + lv1.getItemAtPosition(i) + " es " + edades[i] + " años");
            }
        });
    }
}