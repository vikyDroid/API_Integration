package com.vikydroid.mylib.oldIntel.designpattern.template;

public class Test {
    public static void main(String[] args) {
        ReadAndProcessDataFromExcel excel = new ReadAndProcessDataFromExcel();
        excel.readProcessThenSaveData();

        ReadAndProcessDataFromWord word = new ReadAndProcessDataFromWord();
        word.readProcessThenSaveData();
    }
}
