package org.iesch.a02_registro_de_superheroes;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;

import android.provider.MediaStore;
import android.widget.Toast;


import org.iesch.a02_registro_de_superheroes.databinding.ActivityMainBinding;
import org.iesch.a02_registro_de_superheroes.model.SuperHero;



public class MainActivity extends AppCompatActivity {

    private Bitmap photo;
    private ActivityMainBinding binding;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        binding.btnSave.setOnClickListener(view ->  {
            String etHeroName = binding.etHeroName.getText().toString();
            String etAlterEgo = binding.etAlterEgo.getText().toString();
            String etBio = binding.etBio.getText().toString();
            Float RatingBar = binding.RatingBar.getRating();


            abrirDetalActivity(etHeroName, etAlterEgo, etBio, RatingBar);
        });

        binding.imageHero.setOnClickListener(view ->  {
            abrirCamara();
        });



    }

    private void abrirCamara() {

         Intent camaraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
         startActivityForResult(camaraIntent, 1000);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK && requestCode == 1000){
            photo = data.getExtras().getParcelable("data");
            binding.imageHero.setImageBitmap(photo);
            if (photo != null){
                photo = data.getExtras().getParcelable("data");
                binding.imageHero.setImageBitmap(photo);
            } else {
                Toast.makeText(this, "Invalid", Toast.LENGTH_SHORT).show();;
            }
        }
    }

    private void abrirDetalActivity(String etHeroName, String etAlterEgo, String etBio, float RatingBar) {

        SuperHero superHero = new SuperHero(etHeroName, etAlterEgo, etBio, RatingBar);


        Intent irDetalle = new Intent(this, DetailActivity.class);

        irDetalle.putExtra("superHero", superHero);
        if (photo != null) irDetalle.putExtra("photoSuperHero", photo);

        startActivity(irDetalle);

    }




}