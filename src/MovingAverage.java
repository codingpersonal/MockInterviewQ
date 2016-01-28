import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MovingAverage {
	public void printMovingAvg(BufferedReader reader, int window_size){
		String[] arr = null;
		try {
			arr = reader.readLine().split(" ");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		int[] intarr=new int[arr.length];

		for(int i=0;i<arr.length;i++) {
			intarr[i]=Integer.parseInt(arr[i]);
		}
		
		if(intarr.length < window_size) {
			System.out.println("There should be atleast window size elements.");
			return;
		}
		
		int start = 0; 
		int end = window_size - 1;
		int sum = intarr[0] + intarr[1] + intarr[2];
		System.out.println("Average:"+sum/window_size+"\n");
		end++;
		
		while(end <= intarr.length-1) {
			sum = sum - intarr[start++] + intarr[end++];
			System.out.println("Average:"+sum/window_size);
			System.out.println("\n");
		}
		
		
	}

	public static void main(String[] args) {
		MovingAverage m = new MovingAverage();
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		m.printMovingAvg(reader, 3);
	}

}
