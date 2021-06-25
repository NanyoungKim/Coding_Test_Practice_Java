import java.util.*;
import java.io.*;

public class Map_BOJ10816_숫자카드2 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer tokens;
	
	public static void main(String[] args) throws IOException {
		
		int N = Integer.parseInt(br.readLine());
		
		HashMap<Integer,Integer> map = new HashMap<>();
		
		tokens = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			int num = Integer.parseInt(tokens.nextToken());
			if(!map.containsKey(num)) {
				map.put(num, 1);
			}
			else {
				int newValue = map.get(num) + 1;
				map.put(num, newValue);
			}
		}
		
		
		int M = Integer.parseInt(br.readLine());
		tokens = new StringTokenizer(br.readLine());
		for(int i = 0; i<M; i++) {
			int num = Integer.parseInt(tokens.nextToken());
			if(map.containsKey(num)) {
				bw.write(map.get(num) + " ");
			}
			else {
				bw.write("0 ");
			}
			
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
