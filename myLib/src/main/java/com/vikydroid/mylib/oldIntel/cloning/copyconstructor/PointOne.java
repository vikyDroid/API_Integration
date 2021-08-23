package com.vikydroid.mylib.oldIntel.cloning.copyconstructor;

public class PointOne {
    int x, y;

    public PointOne(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public PointOne(PointOne pointOne) {
        this.x = pointOne.x;
        this.y = pointOne.y;
    }

    public PointOne copyPoint(PointOne point) throws CloneNotSupportedException
    {
        if(!(point instanceof Cloneable))
        {
            throw new CloneNotSupportedException("Invalid cloning");
        }

        //Can do multiple other things here
        return new PointOne(point.x, point.y);
    }
}
