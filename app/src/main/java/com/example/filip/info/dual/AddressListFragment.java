package com.example.filip.info.dual;

import android.app.Activity;
import android.app.ListFragment;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.filip.info.R;

import java.util.ArrayList;

/**
 * Created by Filip on 2017-08-08.
 */

public class AddressListFragment extends ListFragment {
    private static final String TAG = "AddressListFragment";
    private ArrayList<NameAndAddress> mNameAndAddress;
    private ActivityComs mActivityComs;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mNameAndAddress = AddressBook.getInstance().getBook();

        AddressListAdapter addressListAdapter = new AddressListAdapter(mNameAndAddress);
        setListAdapter(addressListAdapter);

    }

    @SuppressWarnings("deprecation")
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            mActivityComs = (ActivityComs) activity;
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i(TAG, "in onAttach");
        Activity a;

        if (context instanceof Activity) {
            a = (Activity) context;
            mActivityComs = (ActivityComs) a;
        }


    }

    @Override
    public void onDetach() {

        super.onDetach();
        mActivityComs = null;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        try {
            mActivityComs.onListItemSelected(position);

        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }
    }

    private class AddressListAdapter extends ArrayAdapter<NameAndAddress> {

        public AddressListAdapter(ArrayList<NameAndAddress> namesAndAddresses) {
            super(getActivity(), R.layout.list_item, namesAndAddresses);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            if (convertView == null) {
                LayoutInflater inflater = getActivity().getLayoutInflater();

                convertView = inflater.inflate(R.layout.list_item, null);
            }

            NameAndAddress tmp = getItem(position);

            TextView textView = convertView.findViewById(R.id.textName);

            textView.setText(tmp.getName());
            return convertView;
        }
    }
}
