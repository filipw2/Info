package com.example.filip.info.dual;

import java.util.ArrayList;

/**
 * Created by Filip on 2017-08-08.
 */

public class AddressBook {
    private static final AddressBook ourInstance = new AddressBook();

    private ArrayList<NameAndAddress> mNameAndAddress;

    private AddressBook() {
        mNameAndAddress = new ArrayList<>();

        NameAndAddress tmp = new NameAndAddress("Adam", "Kraków", "ALeja", "31-580");
        mNameAndAddress.add(tmp);

        tmp = new NameAndAddress("Dawid", "Katowice", "some", "33-333");

        mNameAndAddress.add(tmp);
    }

    public static AddressBook getInstance() {
        return ourInstance;
    }

    public ArrayList<NameAndAddress> getBook() {
        return mNameAndAddress;
    }

    public void insertAddress(String name, String city, String street, String code) {
        NameAndAddress tmp = new NameAndAddress(name, city, street, code);
        mNameAndAddress.add(tmp);

    }
}
