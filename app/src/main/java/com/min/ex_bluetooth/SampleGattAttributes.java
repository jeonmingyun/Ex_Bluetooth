package com.min.ex_bluetooth;

import java.util.HashMap;

public class SampleGattAttributes {
    private static HashMap<String, String> attributes = new HashMap();
    public static String HEART_RATE_MEASUREMENT = "00002a37-0000-1000-8000-00805f9b34fb";
    //BluetoothGattDescriptor 고정
    public static String CLIENT_CHARACTERISTIC_CONFIG = "00002902-0000-1000-8000-00805f9b34fb";

    /*사용자 ble UUID*/
    public static String SERVICE_STRING = "6e400001-b5a3-f393-e0a9-e50e24dcca9e"; // service
    public static String CHARACTERISTIC_COMMAND_STRING  = "6e400002-b5a3-f393-e0a9-e50e24dcca9e"; // read characteristic
    public static String CHARACTERISTIC_RESPONSE_STRING  = "6e400003-b5a3-f393-e0a9-e50e24dcca9e"; // write characteristic

    static {
        // Sample Services.
        attributes.put("0000180d-0000-1000-8000-00805f9b34fb", "Heart Rate Service");
        attributes.put("0000180a-0000-1000-8000-00805f9b34fb", "Device Information Service");
        // Sample Characteristics.
        attributes.put(HEART_RATE_MEASUREMENT, "Heart Rate Measurement");
        attributes.put("00002a29-0000-1000-8000-00805f9b34fb", "Manufacturer Name String");
    }
    public static String  lookup(String uuid, String defaultName) {
        String name = attributes.get(uuid);
        return name == null ? defaultName : name;
    }
}