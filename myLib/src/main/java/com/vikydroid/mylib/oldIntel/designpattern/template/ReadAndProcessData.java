package com.vikydroid.mylib.oldIntel.designpattern.template;

public abstract class ReadAndProcessData {

    void readProcessThenSaveData() {
        readData();
        processData();
        saveData();
    }

    abstract void readData();

    public abstract void processData();

    public void saveData() {
        System.out.println("Save data in db");
    }
}
