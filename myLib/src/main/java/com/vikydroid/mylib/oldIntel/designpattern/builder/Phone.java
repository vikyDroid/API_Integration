package com.vikydroid.mylib.oldIntel.designpattern.builder;

public class Phone {
    private String os;
    private int ram;
    private int battery;
    private double screenSize;

    public Phone(String os, int ram, int battery, double screenSize) {
        this.os = os;
        this.ram = ram;
        this.battery = battery;
        this.screenSize = screenSize;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "os='" + os + '\'' +
                ", ram=" + ram +
                ", battery=" + battery +
                ", screenSize=" + screenSize +
                '}';
    }

    static class Builder {
        private String os;
        private int ram;
        private int battery;
        private double screenSize;

        public Builder setOs(String os) {
            this.os = os;
            return this;
        }

        public Builder setRam(int ram) {
            this.ram = ram;
            return this;
        }

        public Builder setBattery(int battery) {
            this.battery = battery;
            return this;
        }

        public Builder setScreenSize(double screenSize) {
            this.screenSize = screenSize;
            return this;
        }

        Phone build() {
            return new Phone(os, ram, battery, screenSize);
        }
    }
}
