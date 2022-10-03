package org.iesch.a02_registro_de_superheroes;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;

import org.iesch.a02_registro_de_superheroes.databinding.ActivityDetailBinding;

import org.iesch.a02_registro_de_superheroes.model.SuperHero;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDetailBinding binding = ActivityDetailBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        Bundle extras = getIntent().getExtras();

        SuperHero superHero = extras.getParcelable("superHero");
        Bitmap photo = extras.getParcelable("photoSuperHero");

        binding.tvHeroName.setText(superHero.getName());
        binding.tvAlterEgo.setText(superHero.getAlterEgo());
        binding.tvBio.setText(superHero.getBio());
        binding.ratingBar.setRating(superHero.getPower());
        binding.imageView.setImageBitmap(photo);



    }
}