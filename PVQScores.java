import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class PVQScores {
	public static void main(String[] args) throws FileNotFoundException{
		PVQScores obj = new PVQScores();
		obj.run();
		
	}
	public void run(){
		String csvFile = "/Users/bhavana/Desktop/BTP/PVQ_part.csv";
		BufferedReader br = null;
		String line = "";
		String csvSplitBy = ",";
		int[] values = new int[40];
		try{
			br = new BufferedReader(new FileReader(csvFile));
			while((line= br.readLine())!=null){
				String[] user = line.split(csvSplitBy);
				for(int i=0;i<40;i++){
					values[i] = Integer.parseInt(user[i+10]);
				}
				calculateScores(values);	
			}
		}catch( FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			if(br!=null){
				try{
					br.close();
					
				}catch(IOException e){
					e.printStackTrace();
				}
			}
		}
	}
	
	public void calculateScores(int arr[]){
		String file = "/Users/bhavana/Desktop/BTP/Scores.txt";
		double[] array = new double[10];
		array[0] = (arr[6]+arr[15]+arr[27]+arr[35])/4;
		array[1] = (arr[8]+arr[19]+arr[24]+arr[37])/4;
		array[2] = (arr[11]+arr[17]+arr[26]+arr[32])/4;
		array[3] = (arr[2]+arr[7]+arr[18]+arr[22]+arr[28]+arr[39])/6;
		array[4] =  (arr[0]+arr[10]+arr[21]+arr[33])/4;
		array[5] = (arr[5]+arr[14]+arr[29])/3;
		array[6] = (arr[9]+arr[25]+arr[36])/3;
		array[7] = (arr[3]+arr[12]+arr[23]+arr[31])/4;
		array[8] = (arr[1]+arr[16]+arr[38])/3;
		array[9] = (arr[4]+arr[13]+arr[20]+arr[30]+arr[34])/5;
		try{
		FileOutputStream fos = new FileOutputStream(file);
		DataOutputStream dos = new DataOutputStream(fos);
		for(int i=0;i<array.length;i++){
			System.out.println(array[i]);
			dos.writeDouble(array[i]);
		}
		System.out.println("---------------------------");
		dos.writeChars("\n");
		dos.close();
		}catch(IOException e){
			System.out.println("IOException: " + e);
		}
	}
}
