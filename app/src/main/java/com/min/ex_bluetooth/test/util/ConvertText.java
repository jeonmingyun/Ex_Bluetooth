package com.min.ex_bluetooth.test.util;

import java.nio.charset.StandardCharsets;

public class ConvertText {
    public static String byteArrayToString(byte[] bytes) {
        return new String(bytes);
    }

    public static byte[] stringToByteArray(String str) {
        return str.getBytes(StandardCharsets.UTF_8);
    }
}
