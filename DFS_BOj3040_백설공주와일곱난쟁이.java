import java.util.*;
public class DFS_BOj3040_백설공주와일곱난쟁이 {

	static int[] numArr, visited;
	static ArrayList<Integer> ansList = new ArrayList<Integer>(); 
	
	public static boolean DFS(int start, int toPick, int sum) {
		if(toPick==0 && sum==100) {
			for(int i = 0; i<ansList.size(); i++) {
				System.out.println(ansList.get(i));
			}
			return true;
		}
		
		for(int i = start; i<9; i++) {
			if(visited[i] == 0) {
				visited[i] = 1;
				ansList.add(numArr[i]);
				if(DFS(i, toPick-1, sum + numArr[i])==false) {
					ansList.remove(ansList.size()-1);
					visited[i] = 0;
				}
				else break;
			}
		}
		return false;
	}
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		numArr = new int[9];
		visited = new int[9];
		
		for(int i = 0; i<9; i++) {
			numArr[i] = sc.nextInt();
		}
		
		DFS(0,7,0);	
	}
}
