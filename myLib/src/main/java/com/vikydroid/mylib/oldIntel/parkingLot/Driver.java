package com.vikydroid.mylib.oldIntel.parkingLot;

import com.practice.systemdesign.parkingLot.spot.Spot;
import com.practice.systemdesign.parkingLot.vehicle.SmallV;
import com.practice.systemdesign.parkingLot.vehicle.Vehicle;

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
