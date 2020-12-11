import java.util.*;

class PNTAB{
	String []parameter = new String[15];
	void insert(String str, int PPIndex){	
		if(str.contains("=")){
			StringTokenizer st = new StringTokenizer(str);
			int i=0;
			
			while(st.hasMoreTokens() && i<1){
				parameter[PPIndex] = st.nextToken("=");
				i++;
			}
		}
		else{
			parameter[PPIndex] = str;
		}
	}
	
	int isParameter(String str, PNTAB pt, int PPIndex){
		for(int i=0; i<PPIndex; i++){
			if(pt.parameter[i].equalsIgnoreCase(str)){
				return i;
			}
		}
		return -1;
	}
	
	/*void display()
	{
		for(int i=0; i<parameter.length; i++)
		{
			System.out.println(parameter[i]);
		}
	}*/
}