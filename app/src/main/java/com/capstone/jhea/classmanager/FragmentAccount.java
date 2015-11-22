package com.capstone.jhea.classmanager;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Che Balane on 11/22/2015.
 */
public class FragmentAccount extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View accountSettings = inflater.inflate(R.layout.fragment_settings, container, false);

        return accountSettings;
    }
}
