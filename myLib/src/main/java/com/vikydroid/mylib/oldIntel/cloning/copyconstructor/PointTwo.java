package com.vikydroid.mylib.oldIntel.cloning.copyconstructor;

public class PointTwo extends PointOne {
    int z;

    public PointTwo(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    public PointTwo(PointOne pointOne, int z) {
        super(pointOne);
        this.z = z;
    }
}
