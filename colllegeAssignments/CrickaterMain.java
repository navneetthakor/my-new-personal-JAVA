// package colllegeAssignments;

// class for the format

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

class Format{
    private String formatName;
    private int runs;
    private int wickets;
    private int catches;
    private double ratings;
    private int rank;

    Format(String fname){
        formatName = fname;
    }

    protected void updateData(String str,int data, int n, Crickter[] arr){
        switch(str){
            case "runs":
                runs += data;
                break;
            case "wickets":
                wickets += data; 
                break;
            case "catches":
                catches += data;
                break;
            default:
                System.out.println("Wrong input");
                return;
        }

        // updating ratings 
        ratings = (runs + wickets + catches)*(0.33);

        // updating ranking
        ArrayList<Double> al = new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            if(!al.contains(arr[i].formats[n].ratings))
                al.add(arr[i].formats[n].ratings);
        }

        Collections.sort(al,Collections.reverseOrder());
        
        for(int i=0; i<arr.length; i++){
            arr[i].formats[n].rank = al.indexOf(arr[i].formats[n].ratings) + 1;
        }
    }

    protected int getfdata(String str){
        switch(str){
            case "runs":
                return runs;
            case "wickets":
                return wickets;
            case "catches":
                return catches;
            case "rank":
                return rank;
            default:
                System.out.println("Wrong input");
            }
            return -1;
    }

    protected double getRatings(){
        return ratings;
    }

}

class Crickter{
    private String name;
    private int id;
     Format[] formats = new Format[3];

    Crickter(String dname, int did){
        name = dname;
        id = did;
        formats[0] = new Format("odi");
        formats[1] = new Format("t20");
        formats[2] = new Format("test");
    }

    void addDAta(String formatName, String varName, int data, Crickter[] arr){
        // to determin array index in formats array 
        int n = findFotmat(formatName);
        if(n == -1)
            return;

        // adding data 
        formats[n].updateData(varName,data,n,arr);

    }

    int getData(String formatName, String value){
        // to determin array index in formats array 
        int n = findFotmat(formatName);
        if(n == -1)
            return -1;

        // returning the desired value 
        return formats[n].getfdata(value);
    }

    private static int findFotmat(String formatName){
        switch(formatName){
            case "odi":
                return 0;
            case "t20":
                return 1;
            case "test":
                return 2;
            default:
                System.out.println("Wrong format");
            }
            return -1;
    }

}


public class CrickaterMain {
    public static void main(String args[]){
        int size;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements : ");
        size = sc.nextInt();
        Crickter[] c = new Crickter[size];
        
        // initializing the array 
        for(int i=0; i<size; i++){
            c[i] = new Crickter("nk", i);
        }

        // to generate random numbers
        Random rndm = new Random();
        int max = 5000;

        for(int i=0; i<size; i++){
            // for odi 
            c[i].addDAta("odi", "runs", (rndm.nextInt(5000)), c);
            c[i].addDAta("odi", "wickets", (rndm.nextInt(5000)), c);
            c[i].addDAta("odi", "catches", (rndm.nextInt(5000)), c);

            // for t20
            c[i].addDAta("t20", "runs", (rndm.nextInt(5000)), c);
            c[i].addDAta("t20", "wickets", (rndm.nextInt(5000)), c);
            c[i].addDAta("t20", "catches", (rndm.nextInt(5000)), c);
            
            // for test
            c[i].addDAta("test", "runs", (rndm.nextInt(5000)), c);
            c[i].addDAta("test", "wickets", (rndm.nextInt(5000)), c);
            c[i].addDAta("test", "catches", (rndm.nextInt(5000)), c);
            
        }

        // printing rankings
        for(int i=0; i<size; i++){
            System.out.println("For c : " + i);
            System.out.println("odi : " + c[i].getData("odi", "rank"));
            System.out.println("t20 : " + c[i].getData("t20", "rank"));
            System.out.println("test : " + c[i].getData("test", "rank"));
        }
    }
    
}
