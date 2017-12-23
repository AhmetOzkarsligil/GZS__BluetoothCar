package com.hakan_ahmet.deneme;

import android.support.v7.app.AppCompatActivity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Set;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    private final String DEVICE_ADDRESS = "98:D3:36:00:A5:7C"; //MAC Addresimiz (Bluetootun)
    private final UUID PORT_UUID = UUID.fromString("00001101-0000-1000-8000-00805f9b34fb");

    private BluetoothDevice device;
    private BluetoothSocket socket;
    private OutputStream outputStream;

    Button nos_btn, zero_btn,  forward_btn, forward_left_btn, forward_right_btn, reverse_btn, reverse_left_btn, reverse_right_btn, bluetooth_connect_btn;

    String command; //modüle iletilen bilgiler command değişkeni ile ifade edilecek

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //declaration of button variables
        forward_btn = (Button) findViewById(R.id.forward_btn);
        forward_left_btn = (Button) findViewById(R.id.forward_left_btn);
        forward_right_btn = (Button) findViewById(R.id.forward_right_btn);
        reverse_btn = (Button) findViewById(R.id.reverse_btn);
        reverse_right_btn = (Button) findViewById(R.id.reverse_right_btn);
        reverse_left_btn = (Button) findViewById(R.id.reverse_left_btn);
        zero_btn = (Button) findViewById(R.id.zero_btn);
        nos_btn = (Button) findViewById(R.id.nos_btn);
        bluetooth_connect_btn = (Button) findViewById(R.id.bluetooth_connect_btn);


        //ileri butonu (bastığımız süre boyunca ilerleyecek)
        forward_btn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_DOWN) //Basılı tutulan zaman
                {
                    command = "1";

                    try
                    {
                        outputStream.write(command.getBytes()); //1 değerini bluetootha iletir
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                }
                else if(event.getAction() == MotionEvent.ACTION_UP) //butona basma bırakıldığı zaman çalışacak olan event
                {
                    command = "10";
                    try
                    {
                        outputStream.write(command.getBytes());
                    }
                    catch(IOException e)
                    {
                        e.printStackTrace();
                    }

                }

                return false;
            }

        });

        //geri butonu (bastığımız süre boyunca geri gidecek)
        reverse_btn.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                if(event.getAction() == MotionEvent.ACTION_DOWN)
                {
                    command = "2";

                    try
                    {
                        outputStream.write(command.getBytes());
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                }
                else if(event.getAction() == MotionEvent.ACTION_UP)
                {
                    command = "10";
                    try
                    {
                        outputStream.write(command.getBytes());
                    }
                    catch(IOException e)
                    {

                    }

                }
                return false;
            }
        });

        //ileri-sola dönüş
        forward_left_btn.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                if(event.getAction() == MotionEvent.ACTION_DOWN)
                {
                    command = "3";

                    try
                    {
                        outputStream.write(command.getBytes());
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                }
                else if(event.getAction() == MotionEvent.ACTION_UP)
                {
                    command = "10";
                    try
                    {
                        outputStream.write(command.getBytes());
                    }
                    catch(IOException e)
                    {

                    }

                }
                return false;
            }
        });

        //ileri-saga donus
        forward_right_btn.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                if(event.getAction() == MotionEvent.ACTION_DOWN)
                {
                    command = "4";

                    try
                    {
                        outputStream.write(command.getBytes());
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                }
                else if(event.getAction() == MotionEvent.ACTION_UP)
                {
                    command = "10";
                    try
                    {
                        outputStream.write(command.getBytes());
                    }
                    catch(IOException e)
                    {
                        e.printStackTrace();
                    }

                }
                return false;
            }
        });

        //geri-sola donus
        reverse_left_btn.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                if(event.getAction() == MotionEvent.ACTION_DOWN)
                {
                    command = "5";

                    try
                    {
                        outputStream.write(command.getBytes());
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                }
                else if(event.getAction() == MotionEvent.ACTION_UP)
                {
                    command = "10";
                    try
                    {
                        outputStream.write(command.getBytes());
                    }
                    catch(IOException e)
                    {
                        e.printStackTrace();
                    }

                }
                return false;
            }
        });

        //geri-saga donus
        reverse_right_btn.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                if(event.getAction() == MotionEvent.ACTION_DOWN)
                {
                    command = "6";

                    try
                    {
                        outputStream.write(command.getBytes());
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                }
                else if(event.getAction() == MotionEvent.ACTION_UP)
                {
                    command = "10";
                    try
                    {
                        outputStream.write(command.getBytes());
                    }
                    catch(IOException e)
                    {
                        e.printStackTrace();
                    }

                }
                return false;
            }
        });
        //360°Dön butonuna basında etrafinda dönup duracak (bastığımız süre boyunca donecek)
        zero_btn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_DOWN) //Basılı tutulan zaman
                {
                    command = "7";

                    try
                    {
                        outputStream.write(command.getBytes()); //1 değerini bluetootha iletir
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                }
                else if(event.getAction() == MotionEvent.ACTION_UP) //butona basma bırakıldığı zaman çalışacak olan event
                {
                    command = "10";
                    try
                    {
                        outputStream.write(command.getBytes());
                    }
                    catch(IOException e)
                    {
                        e.printStackTrace();
                    }

                }

                return false;
            }

        });
        //Nos butonuna basıldıgında hız artımı saglanacak (bastığımız süre boyunca donecek)
        nos_btn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_DOWN) //Basılı tutulan zaman
                {
                    command = "8";

                    try
                    {
                        outputStream.write(command.getBytes()); //8 değerini bluetootha iletir
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                }
                else if(event.getAction() == MotionEvent.ACTION_UP) //butona basma bırakıldığı zaman çalışacak olan event
                {
                    command = "9";
                    try
                    {
                        outputStream.write(command.getBytes());
                    }
                    catch(IOException e)
                    {
                        e.printStackTrace();
                    }

                }

                return false;
            }

        });
        //Bulunan cihazı bluetooth ile bağlama
        bluetooth_connect_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(BTinit())
                {
                    BTconnect();
                }

            }
        });

    }

    //Bluetooth modülünü başlatma
    public boolean BTinit()
    {
        boolean found = false;

        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        if(bluetoothAdapter == null) //cihazın bluetoothu destekleyip, desteklemediğine bakar
        {
            Toast.makeText(getApplicationContext(), "Cihaz bluetooth'u desteklemiyor", Toast.LENGTH_SHORT).show();
        }

        if(!bluetoothAdapter.isEnabled()) //Bluetooth etkin mi kontrol edilir, değilse kullanıcıdan etkinleştirme için iziin ister
        {
            Intent enableAdapter = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableAdapter,0);

            try
            {
                Thread.sleep(1000);
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
        }

        Set<BluetoothDevice> bondedDevices = bluetoothAdapter.getBondedDevices();

        if(bondedDevices.isEmpty()) //eslestirilmiş cihazları kontrol eder
        {
            Toast.makeText(getApplicationContext(), "Lütfen önce cihazı eşleştirin", Toast.LENGTH_SHORT).show();
        }
        else
        {
            for(BluetoothDevice iterator : bondedDevices)
            {
                if(iterator.getAddress().equals(DEVICE_ADDRESS))
                {
                    device = iterator;
                    found = true;
                    break;
                }
            }
        }

        return found;
    }

    public boolean BTconnect()
    {
        boolean connected = true;

        try
        {
            socket = device.createRfcommSocketToServiceRecord(PORT_UUID); //Giden bağlantıyı işlemek için bir soket oluşturulur
            socket.connect();

            Toast.makeText(getApplicationContext(),
                    "Bluetooth cihazına bağlantı başarılı", Toast.LENGTH_LONG).show();
        }
        catch(IOException e)
        {
            e.printStackTrace();
            connected = false;
        }

        if(connected)
        {
            try
            {
                outputStream = socket.getOutputStream(); //Soketin çıktısı alınır
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }

        return connected;
    }

    @Override
    protected void onStart()
    {
        super.onStart();
    }

}

