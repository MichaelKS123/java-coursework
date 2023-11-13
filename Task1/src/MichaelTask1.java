
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MichaelTask1 {

    public static void main(String[] args) {

        int abcCounter[][] = new int[26][2];
        String dataFile = System.getProperty("user.dir") + File.separator + "play.txt";
        //read file into stream, try-with-resources
	try (BufferedReader br = new BufferedReader(new FileReader(dataFile))) {

            int unique;
            while ((unique = br.read()) != -1) {
		if(unique>=97 && unique <= 122){
                    abcCounter[unique-97][0]++;
                }
                else if(unique>=65 && unique <= 90){
                    abcCounter[unique-65][0]++;
                }
            }

	} catch (IOException e) {
            e.printStackTrace();
	}
        String totalCountTxt = "Total amount of letters = "+ count(abcCounter);
        sort(abcCounter);
        String amount = getamount(abcCounter);
        System.out.println(totalCountTxt+amount);
        writeToFile(totalCountTxt+amount);
        
    }
    
    static int count(int arr[][]){
        int totalCount=0;
        for(int i = 0;i<26;i++){
            
            arr[i][1] = i+97;
            totalCount+=arr[i][0];
        }
        return totalCount;
    }
    
    static void sort(int arr[][]) 
    { 
        int n = arr.length; 
        for (int i = 0; i < n-1; i++){
            for (int j = 0; j < n-i-1; j++){
                if (arr[j][0] > arr[j+1][0]) 
                { 
                    // swap arr[j+1] and arr[i] 
                    int[] temp = arr[j]; 
                    arr[j] = arr[j+1]; 
                    arr[j+1] = temp; 
                } 
            }
        }
    } 
    
    static String getamount(int arr[][]) {
        String output = "";
        for(int i = 25;i>=0;i--){
            char unique=(char)(arr[i][1]);
            String outputAmountLine = unique + " --> " + arr[i][0];
            output  = output + "\n"+ outputAmountLine;
        }
        return output;
    }
    
    
    public static void writeToFile(String content)
    {
        String outputFile = System.getProperty("user.dir") + File.separator + "results.txt";  
        try (FileWriter fileWriter = new FileWriter(outputFile);
                PrintWriter printWriter = new PrintWriter(fileWriter)){
            printWriter.print(content);
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    

}
