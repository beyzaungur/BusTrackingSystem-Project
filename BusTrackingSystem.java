
package bustrackingsystem;
import java.util.Scanner;

public class BusTrackingSystem {

    public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    
    System.out.println("Enter the number of stops on the route: ");
    int numStops= scan.nextInt();
    scan.nextLine();
    
    String[] stopNames =new String[numStops];
    int[] boarding = new int[numStops];
    int[] alighting = new int[numStops];
    int[] currentOccupancy= new int[numStops];
    
    for(int i =0;i< numStops;i++){
        System.out.println((i+1)+". stop information: ");
        System.out.println("Stop name: ");
        stopNames[i]=scan.nextLine();
        
        System.out.println("Number of passengers boarding at: "+stopNames[i]);
        boarding[i]=scan.nextInt();
        
        System.out.println("Number of passengers alighting at:"+stopNames[i]);
        alighting[i]=scan.nextInt();
        scan.nextLine();
    }
        System.out.println("Enter the bus seating capacity:");
        int seatingCapacity= scan.nextInt();
        
        int currentPassengers=0;
        int overCapacityCount=0;
        int totalOccupancyForAverage=0;
    
      
        for (int i =0; i<numStops; i++){
        if(alighting[i]>(currentPassengers+ boarding[i])){
            System.out.println(stopNames[i]+"cannot have more passsengers aligthing!!!");
            currentPassengers=0;        
        }else {
            currentPassengers= currentPassengers+boarding[i]- alighting[i];       
        }
        if(currentPassengers < 0){
            currentPassengers=0;
        }
        currentOccupancy[i]=currentPassengers;
        totalOccupancyForAverage+= currentPassengers;
        
        System.out.println("Passengers on the bus after "+stopNames[i]+ currentPassengers);
        
        if(currentPassengers> seatingCapacity){
            System.out.println("bus is over capacity at: "+stopNames[i]);
            overCapacityCount++;
            
        //statistics
        System.out.println("route summary report: ");
        }
      }
        for(int i =0; i<numStops;i++){
          System.out.println("Stop: "+ stopNames[i]+ "| Boarding: "+ boarding[i]
                  +"|Alighting: "+ alighting[i]+"|Current Occupancy: "+ currentOccupancy[i]);
         
        }
        int maxBoarding = boarding[0];
        String busiestStop= stopNames[0];
        
        for(int i =1;i<numStops; i++){
            if(boarding[i]>maxBoarding){
                maxBoarding=boarding[i];
                busiestStop=stopNames[i];
            }       
        }
        double averageOccupancy = totalOccupancyForAverage/ numStops ;
        int finalPassengers=currentOccupancy[numStops -1];
        
        System.out.println("Busiest Stop: "+ busiestStop +  maxBoarding + "kisi");
        System.out.println("Average Bus Occupancy:"+ averageOccupancy);
        System.out.println("Stop Over Capacity:" + overCapacityCount);
        
        if(finalPassengers != 0){
            System.out.println("warnings:"+ finalPassengers +"passengers still on the bus .");
        }else{
            System.out.println("All passengers got off.");
        }
       
        
        }
        
    }
    
    
    

