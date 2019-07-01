package br.com.digitalhouse.fragmentsviewpager.adapters;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

public class FragmentsAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> listaFragments;

    public FragmentsAdapter(FragmentManager fm, List<Fragment> listaFragments) {
        super(fm);
        this.listaFragments = listaFragments;
    }

    @Override
    public Fragment getItem(int position) {
        return listaFragments.get(position);
    }

    @Override
    public int getCount() {
        return listaFragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        Fragment fragment = listaFragments.get(position);
        Bundle bundle = fragment.getArguments();

        String titulo = bundle.getString("TITULO");

        return titulo;
    }
}
