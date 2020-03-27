package com.wh.mysports;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MoreFragment extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.pre_more, rootKey);
    }

    @Override
    public boolean onPreferenceTreeClick(Preference preference) {
        Uri uri = null;
        Intent intent = null;
        uri = Uri.parse(preference.getSummary().toString());
//        switch (preference.getKey()){
//            case "personal_github":{
//                uri = Uri.parse("https://github.com/alone-wolf");
//                break;
//            }
//            case "personal_github_page_blog":{
//                uri = Uri.parse(preference.getSummary().toString());
//                break;
//            }
//            case "myrss_repo_address":{
//                uri = Uri.parse(preference.getSummary().toString());
//                break;
//            }
//        }
        intent = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(intent);
        return super.onPreferenceTreeClick(preference);
    }
}
