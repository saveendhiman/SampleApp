package com.sampleapp.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

/**
 * Created by saveen_dhiman on 05-November-16.
 * contains methods related to fragment transactions
 */
public class FragmentUtils {

    // replace fragment in a container
    public void replaceFragment(int container, FragmentManager manager, Fragment fragment) {
        manager.beginTransaction().replace(container, fragment).commitAllowingStateLoss();
    }
}
