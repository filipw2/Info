package com.example.filip.info.dual;

import java.io.Serializable;

/**
 * Created by Filip on 2017-08-08.
 */

public class NameAndAddress implements Serializable {
    private String mName;
    private String mAddress1;
    private String mAddress2;
    private String mZipCode;

    public NameAndAddress(String mName, String mAddress1, String mAddress2, String mZipCode) {
        this.mName = mName;
        this.mAddress1 = mAddress1;
        this.mAddress2 = mAddress2;
        this.mZipCode = mZipCode;
    }

    public String getName() {
        return mName;
    }

    public String getAddress1() {
        return mAddress1;
    }

    public String getAddress2() {
        return mAddress2;
    }

    public String getZipCode() {
        return mZipCode;
    }
}
