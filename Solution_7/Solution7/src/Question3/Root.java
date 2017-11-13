package Question3;

public class Root {
    public static void main(){
        Device device = new Device();
        Sensor heat = new Sensor(device);
        Sensor pressure = new Sensor(device);

        Controller controller = new Controller(device, heat, pressure);


        controller.start();
        heat.start();
        pressure.start();

    }
}
