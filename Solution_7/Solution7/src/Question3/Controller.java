package Question3;

import java.awt.*;

public class Controller extends Thread {

    private Device device;
    private Sensor heat;
    private Sensor pressure;

    //initialization
    public Controller(Device device, Sensor sensor1, Sensor sensor2){
            this.heat = sensor1;
            this.pressure = sensor2;
            this.device = device;
    }


    public void run(){
        device.startup();

        synchronized (device){
            while(heat.getValue() <= 70 && pressure.getValue() <= 100){
                System.out.println(String.format("heat -> %.2f, pressure -> %.2f", heat.getValue(), pressure.getValue()));
            }
            try{
                device.wait();
            } catch (InterruptedException e){
                System.out.println("Something went wrong while the device is waiting......");
            }
        }
        heat.stop();
        pressure.stop();
        device.shutdown();
    }
}
