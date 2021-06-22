import java.util.*;
import java.io.*;
public class BinarySearch_BOJ10815_숫자카드 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] arrN = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		

		
		for(int i = 0; i<N; i++) {
			arrN[i] = Integer.parseInt(st.nextToken());
			//arrN[i] = sc.nextInt();
		}
		Arrays.sort(arrN);
		
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<M; i++) {
			
			int m = Integer.parseInt(st.nextToken());
			
			int first= 0;
			int last = N-1;
			boolean flag = false;
			while(first<=last) {

				int mid = (first+last)/2;
				int targetN = arrN[mid];
				 
				if(targetN==m) {
					flag = true;
					break;
				}
				
				if(targetN > m) {
					last = mid - 1;
				}
				else {
					first = mid + 1;
				}
				
			}
			if(flag) bw.write(1 + " ");
			else bw.write(0 + " ");
			
		}
	bw.flush();
	bw.close();
	br.close();
	}
}
