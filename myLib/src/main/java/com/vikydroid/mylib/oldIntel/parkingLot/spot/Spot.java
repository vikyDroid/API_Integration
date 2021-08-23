package com.vikydroid.mylib.oldIntel.parkingLot.spot;

public abstract class Spot {
    public long id;

    Spot(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }
}
