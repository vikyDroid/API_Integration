package com.vikydroid.mylib.oldIntel.parkingLot;

import com.vikydroid.mylib.oldIntel.parkingLot.spot.Spot;
import com.vikydroid.mylib.oldIntel.parkingLot.vehicle.SmallV;
import com.vikydroid.mylib.oldIntel.parkingLot.vehicle.Vehicle;

public class Driver {
    public static void main(String[] args) {
        ParkingSpot parkingSpot = new ParkingSpot();
        Vehicle vehicle = new SmallV(1000);
        Spot spot = parkingSpot.findSpaceAndPark(vehicle);
        if (spot != null) {
            System.out.println(spot.id);
        }
        System.out.println(parkingSpot.getSpot(vehicle));
    }
}
