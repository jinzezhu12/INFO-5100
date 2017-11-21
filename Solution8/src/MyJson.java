import java.io.*;
import java.util.ArrayList;

public class MyJson {


    public static void main() throws IOException{
        File file = new File("./src/Question3_camino.txt");
        ArrayList<Vehicle> vehicles = readAndGetVehicles(file);
        String s = getJsonString(vehicles);
        System.out.println(s); // console  logging the JSON result
        writeToFile(s, file.getParent());
    }

    private static ArrayList<Vehicle> readAndGetVehicles(File file) throws IOException {
        ArrayList<Vehicle> cars = new ArrayList<>();
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();
        while (true) {
            line = br.readLine();
            if (line == null) {
                break;
            }
            Vehicle cur = new Vehicle(line.split("~"));
            cars.add(cur);
        }

        br.close(); //close the buffer reader
        fr.close(); //close the file reader
        return cars;
    }

    public static String getJsonString(ArrayList<Vehicle> vehicles){
        StringBuilder sb = new StringBuilder("{" + "\n");
        sb.append("\"" + vehicles.get(0).webId + "\" : [" + "\n");
        for (int i = 0; i < vehicles.size(); ++i) {
            sb.append("{" + "\n");
            sb.append(toJson(vehicles.get(i)));
            if (i < vehicles.size() - 1) sb.append("}," + "\n");
            else sb.append("}" + "\n");
        }
        sb.append("]" + "\n");
        sb.append("}" + "\n");

        return sb.toString();

    }

    private static String toJson(Vehicle c) {

        StringBuilder sb = new StringBuilder();

        sb.append("\"id\" : \"" + c.id + "\"," + "\n");
        sb.append("\"category\" : \"" + c.category + "\"," + "\n");
        sb.append("\"year\" : \"" + c.year + "\"," + "\n");
        sb.append("\"make\" : \"" + c.make + "\"," + "\n");
        sb.append("\"model\" : \"" + c.model + "\"," + "\n");
        sb.append("\"trim\" : \"" + c.trim + "\"," + "\n");
        if (c.type.isEmpty()) {
            sb.append("\"type\" : null," + "\n");
        }
        else {
            sb.append("\"type\" : \"" + c.type + "\"," + "\n");
        }
        sb.append("\"price\" : " + c.price + "," + "\n");
        sb.append("\"photo\" : \"" + c.photo + "\"," + "\n");
        return sb.toString();
    }

    public static void writeToFile(String inputToWrite, String filePath) throws IOException{
        File newFile = new File( "./outputFiles/jsonResult.txt");
        newFile.createNewFile();
        FileWriter fw = new FileWriter(newFile);
        fw.write(inputToWrite);
        fw.close();
    }
}
