package com.min.ex_bluetooth;

import java.nio.charset.StandardCharsets;

public class ConvertByte {
    public static String byteArrayToString(byte[] bytes) {
        return new String(bytes);
    }

    public static byte[] stringToByteArray(String str) {
        return str.getBytes(StandardCharsets.UTF_8);
    }

    public static int byteToInt(byte data) {
        return data & 0xff;
    }

    public static byte intToByte(int num) {
        return (byte) num;
    }

}
