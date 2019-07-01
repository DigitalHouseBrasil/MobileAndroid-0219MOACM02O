package br.com.digitalhouse.fragmentsviewpager;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.fragmentsviewpager.adapters.FragmentsAdapter;
import br.com.digitalhouse.fragmentsviewpager.fragments.PrimeiroFragment;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.view_pager);

        List<Fragment> listaFragments = new ArrayList<>();

        listaFragments.add(PrimeiroFragment.newInstance("Primeiro"));
        listaFragments.add(PrimeiroFragment.newInstance("Segundo"));
        listaFragments.add(PrimeiroFragment.newInstance("Terceiro"));
        listaFragments.add(PrimeiroFragment.newInstance("Quarto"));

        FragmentsAdapter fragmentsAdapter = new FragmentsAdapter(getSupportFragmentManager(), listaFragments);
        viewPager.setAdapter(fragmentsAdapter);

        tabLayout = findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);
    }
}
