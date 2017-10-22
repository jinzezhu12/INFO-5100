import ATM.testATM;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class solution6 {
    public static void main(String args[]){
        System.out.println("*********************************************************");
        System.out.println("          Solutions For Home Assignment # 6              ");
        System.out.println("*********************************************************");

        acceptUserOption();
    }


    private static void acceptUserOption() {
        Scanner reader = new Scanner(System.in);
        int option = -1;
        while(option !=0){
            showSolutionMenu();
            option = reader.nextInt();

            switch (option){
                case 0:
                    break;
                case 1:
                    // Creating my own indexOutOfBoundException class
                    List<Integer> list = new ArrayList<Integer>(); //prepare for producing indexOutOfBound exception
                    list.add(1);
                    list.add(2);
                    list.add(3);
                    list.add(4);
                    try{ //try to produce
                        int total = list.get(5);
                } catch (IndexOutOfBoundsException e){
                        MyIndexOutOfBound ibe = new MyIndexOutOfBound(0, list.size(), 5);
                    }
                    break;
                case 2:
                    // Modifying parse()

                    try {
                        parse(createTestFile());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    break;
                case 3:
                    // ATM Console System

                    try{
                        testATM.launchATM();
                    } catch (IOException e){
                        System.out.println("Data file issue exist, need to be fixed soon......");
                    }


                default:
                    System.out.println("Please enter a valid option ( 0 - 3 )..........");
            }
        }
    }

    private static File createTestFile() throws IOException {
         File file = new File("./test.txt");
         if(file.createNewFile()) {
             System.out.println("File is created");
         } else{
             System.out.println("File already exists");
         }
         //write content
        FileWriter writer = new FileWriter(file);
        writer.write("Test data");
        writer.close();

        return file;
    }

    private static void showSolutionMenu() {
        System.out.println("        Which solution do you want to test?              ");
        System.out.println("*********************************************************");
        System.out.println("        1. Customized IndexOutOfBound Exception          ");
        System.out.println("        2. Modifying parse()                             ");
        System.out.println("        3. Build A ATM Console System                    ");
        System.out.println("*********************************************************");
        System.out.println("        Press 0 to exit the menu.........................");
    }

    public static void parse(File file) {
        RandomAccessFile input = null;
        String line = null;

        try {
            input = new RandomAccessFile(file, "r");
            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }
            return;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
