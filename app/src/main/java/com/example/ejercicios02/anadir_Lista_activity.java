package com.example.ejercicios02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ejercicios02.Modelos.Producto;
import com.example.ejercicios02.databinding.ActivityAnadirListaBinding;

public class anadir_Lista_activity extends AppCompatActivity {

     EditText txtNombre;
     EditText txtCantidad;
     EditText txtPrecio;
     Button btnCrear;

     private ActivityAnadirListaBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anadir_lista);

        binding = ActivityAnadirListaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());//si quieres hacer el pintarElementos() obligatoriamente tienes que ponerlo y si tiene binding tambien

        binding.btnCrearProducto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Producto producto = crearProducto();
                if (producto != null){
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("PRODUCTO",producto);
                    Intent intent = new Intent();
                    intent.putExtras(bundle);
                    setResult(RESULT_OK,intent);
                    finish();
                }else{
                    Toast.makeText(anadir_Lista_activity.this, "FALTAN DATOS", Toast.LENGTH_SHORT).show();;
                }
            }
        });
    }

    private Producto crearProducto() {
        if (binding.txtCantidadCrearProducto.getText().toString().isEmpty() &&
                binding.txtPrecioCrearProducto.getText().toString().isEmpty() &&
                binding.txtNombreCrearProducto.getText().toString().isEmpty()){
            return null;
        }
        return new Producto(binding.txtNombreCrearProducto.getText().toString(),
                Float.parseFloat(binding.txtPrecioCrearProducto.getText().toString()),
                Integer.parseInt(binding.txtCantidadCrearProducto.getText().toString()));
    }
}