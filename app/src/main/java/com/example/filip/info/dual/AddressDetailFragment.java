package com.example.filip.info.dual;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.filip.info.R;

import java.util.ArrayList;

/**
 * Created by Filip on 2017-08-08.
 */

public class AddressDetailFragment extends Fragment {

    private ArrayList<NameAndAddress> mNameAndAddresses;
    private NameAndAddress mNameAndAddress;

    public static AddressDetailFragment getInstance(int position) {
        Bundle args = new Bundle();
        args.putInt("Position", position);
        AddressDetailFragment frag = new AddressDetailFragment();
        frag.setArguments(args);
        return frag;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mNameAndAddresses = AddressBook.getInstance().getBook();

        int position = getArguments().getInt("Position");
        mNameAndAddress = mNameAndAddresses.get(position);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.detail_fragment, container, false);

        TextView textViewN = view.findViewById(R.id.textNameD);
        TextView textViewA1 = view.findViewById(R.id.textAddr1);
        TextView textViewA2 = view.findViewById(R.id.textAddr2);
        TextView textViewZ = view.findViewById(R.id.textZipC);

        textViewN.setText(mNameAndAddress.getName());
        textViewA1.setText(mNameAndAddress.getAddress1());
        textViewA2.setText(mNameAndAddress.getAddress2());
        textViewZ.setText(mNameAndAddress.getZipCode());

        return view;
    }
}
