import java.io.*;
class PoolTable{
	static int index[];
	static int cnt;
	static int literalCnt;

	public PoolTable(){
		index = new int[25];
	}
	
	public static void updateIndex(){
		literalCnt++;
	}
	public static void processIndex(){
		index[cnt++] = literalCnt;
		//literalCnt = 0;
	}
	public static int getIndexPosition(){
		return literalCnt;
	}
	
	public static void showPool() throws IOException{
		
		BufferedWriter bw = new BufferedWriter(new FileWriter("Pool table.txt"));
		
		System.out.println("\nPool table");
		for(int i=0 ; i<cnt ; i++){
			if ( i > 0){
				index[i] = index[i] - index[i-1];
				bw.write((i+1) + "\t" + index[i]);
			}
			else{
				bw.write((i+1) + "\t" + index[i]);
			}
			System.out.println((i+1) + "\t" + index[i]);
		}
		bw.close();
	}
}