package com.vikydroid.mylib.oldIntel.parkingLot;


import com.vikydroid.mylib.oldIntel.parkingLot.spot.LargeS;
import com.vikydroid.mylib.oldIntel.parkingLot.spot.MediumS;
import com.vikydroid.mylib.oldIntel.parkingLot.spot.SmallS;
import com.vikydroid.mylib.oldIntel.parkingLot.spot.Spot;
import com.vikydroid.mylib.oldIntel.parkingLot.spot.XLargeS;
import com.vikydroid.mylib.oldIntel.parkingLot.vehicle.LargeV;
import com.vikydroid.mylib.oldIntel.parkingLot.vehicle.MediumV;
import com.vikydroid.mylib.oldIntel.parkingLot.vehicle.SmallV;
import com.vikydroid.mylib.oldIntel.parkingLot.vehicle.Vehicle;
import com.vikydroid.mylib.oldIntel.parkingLot.vehicle.XLargeV;

import java.util.HashMap;
import java.util.Stack;

public class ParkingSpot {
    Stack<SmallS> s = new Stack<>();
    Stack<MediumS> m = new Stack<>();
    Stack<LargeS> l = new Stack<>();
    Stack<XLargeS> xl = new Stack<>();

    HashMap<Vehicle, Spot> map;


    ParkingSpot() {
        map = new HashMap<>();
        for (int i = 0; i <= 10; i++) {
            s.add(new SmallS(i));
        }
        for (int i = 0; i <= 10; i++) {
            m.add(new MediumS(i));
        }
        for (int i = 0; i <= 10; i++) {
            l.add(new LargeS(i));
        }
        for (int i = 0; i <= 10; i++) {
            xl.add(new XLargeS(i));
        }
    }

    public Spot findSpaceAndPark(Vehicle vehicle) {
        Spot spot = findSpot(vehicle);
        map.put(vehicle, spot);
        return spot;
    }

    public Spot getSpot(Vehicle vehicle) {
        return map.get(vehicle);
    }

    private Spot findSpot(Vehicle vehicle) {
        if (vehicle instanceof SmallV) {
            return s.pop();
        } else if (vehicle instanceof MediumV) {
            return m.pop();
        } else if (vehicle instanceof LargeV) {
            return l.pop();
        } else if (vehicle instanceof XLargeV) {
            return xl.pop();
        }
        return null;
    }
}
