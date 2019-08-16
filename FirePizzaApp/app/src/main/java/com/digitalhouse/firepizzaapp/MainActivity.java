package com.digitalhouse.firepizzaapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.digitalhouse.firepizzaapp.adapter.PizzaAdapter;
import com.digitalhouse.firepizzaapp.model.Pizza;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private TextView saudacaoTextView;
    private ImageView perfilImageView;
    private FirebaseStorage storage = FirebaseStorage.getInstance();
    private FirebaseUser user;
    private PizzaAdapter pizzaAdapter;
    private RecyclerView pizzaRecyclerView;
    private Button mussarelaButton;
    private Button calabresaButton;

    private static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        saudacaoTextView = findViewById(R.id.saudacao_text_view_id);
        perfilImageView = findViewById(R.id.perfil_image_view_id);
        pizzaRecyclerView = findViewById(R.id.pizza_recycler_view_id);
        mussarelaButton = findViewById(R.id.mussarela_button_id);
        calabresaButton = findViewById(R.id.calabresa_button_id);

        user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            String name = user.getDisplayName();
            saudacaoTextView.setText("Bem vindo " + name);
        }

        perfilImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tirarFoto();
            }
        });

        baixarFoto();

        pizzaAdapter = new PizzaAdapter();
        pizzaRecyclerView.setAdapter(pizzaAdapter);
        pizzaRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mussarelaButton.setOnClickListener( view -> {
            pedirPizza("Mussarela", 5.0F);
        });

        calabresaButton.setOnClickListener(view -> {
            pedirPizza("Calabresa", 6.0F);
        });

    }

    private void pedirPizza(String descricao, float preco) {
        Pizza pizza = new Pizza();
        pizza.setDescricao(descricao);
        pizza.setPreco(preco);
        pizza.setEntregue(false);
        pizza.setData(new Date());

    }

    private void baixarFoto() {

        StorageReference reference = storage.getReference("perfil/" + user.getUid());

        reference.getDownloadUrl().addOnSuccessListener(uri -> Picasso.get().load(uri).into(perfilImageView))
                .addOnFailureListener(exception -> Toast.makeText(MainActivity.this, "Erro ao baixar foto", Toast.LENGTH_SHORT).show());
    }

    private void tirarFoto() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = intent.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            perfilImageView.setImageBitmap(imageBitmap);

            StorageReference reference = storage.getReference("perfil/" + user.getUid());

            // Get the data from an ImageView as bytes
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            imageBitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
            byte[] data = baos.toByteArray();

            UploadTask uploadTask = reference.putBytes(data);
            uploadTask.addOnFailureListener(exception -> Toast.makeText(MainActivity.this, "Upload falhou", Toast.LENGTH_SHORT).show())
                    .addOnSuccessListener(taskSnapshot -> Toast.makeText(MainActivity.this, "Upload concluído", Toast.LENGTH_SHORT).show());

        }
    }

}
