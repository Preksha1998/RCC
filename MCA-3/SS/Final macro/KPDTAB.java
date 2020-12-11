import java.util.*;

class KPDTAB{
	String [][]keyword = new String[50][2];
	static int count = 0;
	
	void insert(String str){
		StringTokenizer st = new StringTokenizer(str);
		int i=0;
		
		while(st.hasMoreTokens())
		{
			keyword[count][i++] = st.nextToken("=");
		}
		count++;
	}
	
	int isKV(String str, KPDTAB kt){
		for(int i=0; i<count; i++){
			for(int j=0; j<1; j++){
				if(kt.keyword[i][j].equalsIgnoreCase(str)){
					return i;
				}
			}
		}
		return -1;
	}
	
	void display(){
		for(int i=0; i<count; i++){
			for(int j=0; j<2; j++){
				System.out.print(keyword[i][j] + "\t");
			}
			System.out.println();
		}
	}
}