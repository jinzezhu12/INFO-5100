package Question3;


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


    @Override
    public void run(){
        device.startup();

        double d_heat, d_pressure;

        while(true){
            synchronized (device){
                try {
                    device.wait();
                } catch (InterruptedException e){
                    e.printStackTrace();
                }d_heat = heat.getValue();
                d_pressure = pressure.getValue();
                System.out.println(String.format("Heat -> %.2f, Pressure -> %.2f", d_heat, d_pressure));

            }

            if (d_pressure > 100 || d_heat > 70){
                device.shutdown();
                heat.interrupt();
                pressure.interrupt();
                return;
            }
        }
    }
}
