package com.min.ex_bluetooth;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final String TAG = getClass().getSimpleName();
    private final static int REQUEST_ENABLE_BT = 1;
    // Get permission
    String[] permission_list = {
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
    };

    TextView textStatus;
    Button btnParied, btnSearch, btnSend;
    ListView listView;

    BluetoothAdapter bluetoothAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityCompat.requestPermissions(MainActivity.this, permission_list, REQUEST_ENABLE_BT);

        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (bluetoothAdapter == null) {
            Toast.makeText(this, "기기가 블루투스를 지원하지 않습니다.", Toast.LENGTH_SHORT).show();
        } else {
            // Enable bluetooth
            if (!bluetoothAdapter.isEnabled()) {
                Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
            }
        }


        // variables
        textStatus = (TextView) findViewById(R.id.text_status);
        btnParied = (Button) findViewById(R.id.btn_paired);
        btnSearch = (Button) findViewById(R.id.btn_search);
        btnSend = (Button) findViewById(R.id.btn_send);
        listView = (ListView) findViewById(R.id.listview);

        btnParied.setOnClickListener(this);
        btnSearch.setOnClickListener(this);
        btnSend.setOnClickListener(this);

//        // Show paired devices
//        btArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
//        deviceAddressArray = new ArrayList<>();
//        listView.setAdapter(btArrayAdapter);
//
//        listView.setOnItemClickListener(new myOnItemClickListener());
    }

    @Override
    public void onClick(View v) {
        if (v == btnParied) {
            Log.e("dddddd", "btnParied");
        } else if (v == btnSearch) {
            Log.e("dddddd", "btnSearch");
        } else if (v == btnSend) {
            Log.e("dddddd", "btnSend");
        }
    }

//    public void onClickButtonPaired(View view) {
//        btArrayAdapter.clear();
//        if (deviceAddressArray != null && !deviceAddressArray.isEmpty()) {
//            deviceAddressArray.clear();
//        }
//        pairedDevices = btAdapter.getBondedDevices();
//        if (pairedDevices.size() > 0) {
//            // There are paired devices. Get the name and address of each paired device.
//            for (BluetoothDevice device : pairedDevices) {
//                String deviceName = device.getName();
//                String deviceHardwareAddress = device.getAddress(); // MAC address
//                btArrayAdapter.add(deviceName);
//                deviceAddressArray.add(deviceHardwareAddress);
//            }
//        }
//    }

}