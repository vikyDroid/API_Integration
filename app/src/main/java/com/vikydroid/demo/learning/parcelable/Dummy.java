package com.vikydroid.demo.learning.parcelable;

import android.os.Parcel;
import android.os.Parcelable;

public class Dummy implements Parcelable {

    String name;
    int age;
    String address;

    protected Dummy(Parcel in) {
        name = in.readString();
        age = in.readInt();
        address = in.readString();
    }

    public static final Creator<Dummy> CREATOR = new Creator<Dummy>() {
        @Override
        public Dummy createFromParcel(Parcel in) {
            return new Dummy(in);
        }

        @Override
        public Dummy[] newArray(int size) {
            return new Dummy[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(age);
        dest.writeString(address);
    }
}
