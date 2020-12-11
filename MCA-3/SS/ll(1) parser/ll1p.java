
import java.io.*;
import java.util.*;

class ll1p{
	public static void main(String args[])throws Exception{
		LL1Parser obj=new LL1Parser();
		obj.initTable();
		obj.showTable();
		obj.getExpression();
		obj.parseExpression();
	} 
}
class LL1Parser{
	String expression;
	String ruleArray[][]=new String[6][5];
	
	void getExpression(){
		Scanner sc=new Scanner(System.in);
		System.out.print("\n____________________________________________\nEnter Expression : ");
		expression=sc.next();
		System.out.println("\n____________________________________________");
		expression=expression+"|";
	}
	
	void initTable()throws Exception{
		BufferedReader br=new BufferedReader(new FileReader("ruleTable.txt"));
		String arr[],line=br.readLine();
		int i=0;
		while(line!=null){
			arr=line.split("\t");
			for(int j=0;j<arr.length;j++)
				ruleArray[i][j]=arr[j];
			i++;
			line=br.readLine();
		}
		br.close();
	}
	
	void showTable(){
		System.out.println("\n______________RULE TABLE___________________ ");
		for(int i=0;i<ruleArray.length;i++){
			for(int j=0;j<ruleArray[i].length;j++)
				System.out.print( ruleArray[i][j]+"\t" );
			System.out.print("\n");
		}
	}

	void parseExpression(){
		int SSM=0;
		String csf="",newRule;
		if(expression.charAt(SSM)=='a')
		{
			newRule=getNextRule(ruleArray[1][0],expression.charAt(0)+"");
			csf=newRule+csf;
			System.out.println("\nCSF \t\t Symbol \t Prediction \n________________________________________________\n");
			
			while(SSM<expression.length()){
				System.out.println(csf+" \t\t "+expression.charAt(SSM) +" \t\t "+newRule);
				newRule=getNextRule(csf.charAt(0)+"",expression.charAt(SSM)+"");
				
				if(newRule==null){
					System.out.println("!!! INVALID EXPRESSION !!!");
					return;
				}
				
				csf=new StringBuilder(csf).deleteCharAt(0).toString();
				csf=newRule+csf;
				
				if((csf.charAt(0)+"").equals(expression.charAt(SSM)+"")){
					csf=new StringBuilder(csf).deleteCharAt(0).toString();
					SSM++;					
				}
				
				if(newRule.equals("e"))
					csf=new StringBuilder(csf).deleteCharAt(0).toString();
				
				if(csf.equals("")){
					System.out.println("\n_______________________\n EXPRESSION IS VALID \n_______________________");
					return;
				}			
			}
			System.out.println("!!! INVALID EXPRESSION !!!");
		}
		else{
			System.out.println("!!! INVALID EXPRESSION !!!");
		}
	}
	String getNextRule(String r,String c){
		boolean row=false,col=false;
		int i,j;
		for(i=1;i<ruleArray.length;i++){
			if(ruleArray[i][0].equals(r)){	
				row=true;
				break;
			}
		}
		for(j=1;j<ruleArray[0].length;j++){
			if(ruleArray[0][j].equals(c)){	
				col=true;
				break;
			}
		}
		if(row && col)
			return ruleArray[i][j];
		else
			return null;
	}
}