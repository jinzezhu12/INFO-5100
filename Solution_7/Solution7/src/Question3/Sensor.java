package Question3;

public class Sensor extends Thread {
    private final Device device;
    private double value;

    public Sensor(Device device){
        this.device = device;
    }

    public double getValue() {
        return value;
    }

    public void updateValue(){

        this.value += 0.001;
    }

    @Override
    public void run(){

        while(true){
        synchronized (device){
            double prevValue = value;
            updateValue();
            if(value != prevValue)
                device.notify();
            }
        }
     } //end of overridden run()

}
