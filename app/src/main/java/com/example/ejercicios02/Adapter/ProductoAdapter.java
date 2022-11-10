package com.example.ejercicios02.Adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ejercicios02.Modelos.Producto;
import com.example.ejercicios02.R;

import java.util.List;

public class ProductoAdapter extends RecyclerView.Adapter<ProductoAdapter.ProductoVH>{

    private List<Producto> objects;
    private int resource;
    private Context context;

    public ProductoAdapter(List<Producto> objects, int resource, Context context) {
        this.objects = objects;
        this.resource = resource;
        this.context = context;
    }

    @NonNull
    @Override
    public ProductoVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View productoFilaView = LayoutInflater.from(context).inflate(resource, null);
        productoFilaView.setLayoutParams(new RecyclerView.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        ));

        return new ProductoVH(productoFilaView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoVH holder, int position) {
        Producto producto = objects.get(position);
        holder.lblNombre.setText(producto.getNombre());
        holder.lblPrecio.setText(String.valueOf(producto.getPrecio()));
        holder.lblCantidad.setText(String.valueOf(producto.getCantidad()));
        holder.btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                objects.remove(producto);
                notifyItemRemoved(holder.getAdapterPosition());
            }
        });


    }



    @Override
    public int getItemCount() {
        return objects.size();
    }


    public class ProductoVH extends RecyclerView.ViewHolder{

        TextView lblNombre;
        TextView lblPrecio;
        TextView lblCantidad;
        Button btnEliminar;

        public ProductoVH(@NonNull View itemView) {
            super(itemView);
            lblNombre = itemView.findViewById(R.id.lblNombreProductoCard);
            lblPrecio = itemView.findViewById(R.id.lblPrecioProductoCard);
            lblCantidad = itemView.findViewById(R.id.lblCantidadProductoCard);
            btnEliminar = itemView.findViewById(R.id.btnEliminar);
        }
    }
}