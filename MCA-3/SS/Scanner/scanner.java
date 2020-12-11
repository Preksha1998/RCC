import java.io.*;
import java.util.*;

public class scanner{
	public static void main(String args[])throws Exception{
		Scanners scanner=new Scanners();
		scanner.fillTable();
		scanner.showTable();
		scanner.fillKeywords();
		scanner.dispKeyword();
		scanner.dispBrackets();
		scanner.dispOperators();
		scanner.scanFile();
	}
}
class Scanners{
	String ruleTable[][]=new String[12][9];
	String keywords[]=new String[23];
	String brackets[]={"(",")","[","]","{","}"};
	String operator[]={"+","-","*","/","^","%","=","<",">","==","!=","<=",">="};
	void fillTable()throws Exception{
		BufferedReader br=new BufferedReader(new FileReader("state.txt"));
		String tempArr[],line=br.readLine();
		int j=0;
		while(line!=null){
			tempArr=line.split("\t");
			for(int i=0;i<tempArr.length;i++)
				ruleTable[j][i]=tempArr[i];
			j++;
			line=br.readLine();
		}
		br.close();
	}
	void fillKeywords()throws Exception{
		BufferedReader br=new BufferedReader(new FileReader("keywords.txt"));
		String line=br.readLine();
		int i=0;
		while(line!=null){
			keywords[i++]=line;
			line=br.readLine();
		}
		br.close();
	}
	void showTable(){
		System.out.println("\n\n_______State TAble____________");
		for(int i=0;i<ruleTable.length;i++){
			for(int j=0;j<ruleTable[i].length;j++)
				System.out.print(ruleTable[i][j]+"\t");
			System.out.println();
		}
	}
	void dispKeyword()
	{
		System.out.println("\n\n_______Keywords____________");
		for(int i=0;i<keywords.length;i++)
			System.out.println(keywords[i]);
	}
	void dispBrackets()
	{
		System.out.println("\n\n_______Brackets____________");
		for(int i=0;i<brackets.length;i++)
			System.out.println(brackets[i]);
	}
	void dispOperators()
	{
		System.out.println("\n\n_______Operators____________");
		for(int i=0;i<operator.length;i++)
			System.out.println(operator[i]);
	}
	boolean isKeyword(String token){
		for(int i=0;i<keywords.length;i++)
			if(keywords[i].equals(token))
				return true;
		return false;
	}
	boolean isBracket(String token){
		for(int i=0;i<brackets.length;i++)
			if(brackets[i].equals(token))
				return true;
		return false;
	}
	boolean isOperator(String token){
		for(int i=0;i<operator.length;i++)
			if(operator[i].equals(token))
				return true;
		return false;
	}
	String getNextState(String curState,char chr){
		int r=-1,c=-1;
		String newState="-",col;
		if(Character.isDigit(chr))
			col="d";
		else if(Character.isLetter(chr))
			col="l";
		else if(chr=='.' || chr=='_' || chr=='"' || chr=='\'')
			col=Character.toString(chr);
		else
			col="-";
		
		if(col!="-"){
			for(int i=0;i<ruleTable.length;i++)
				if(ruleTable[i][0].equals(curState)){
					r=i;
					break;
				}
			for(int i=0;i<ruleTable[0].length;i++)
				if(ruleTable[0][i].equals(col)){
					c=i;
					break;
				}
			newState=ruleTable[r][c];
		}
		return newState;
	}
	void scanFile()throws Exception{
		BufferedReader br=new BufferedReader(new FileReader("input.txt"));
		System.out.println("______________________________________________________________");
		System.out.println("\t\tScanning Input File");
		System.out.println("______________________________________________________________");
		String tempArr[],line=br.readLine();
		while(line!=null){
			System.out.println("----------------------------------------------------------");
			System.out.println("Scanning line : "+line);
			System.out.println("----------------------------------------------------------");
			tempArr=line.split(" ");
			for(int i=0;i<tempArr.length;i++){
				if(isBracket(tempArr[i]))
					System.out.println(tempArr[i]+"\t is Bracket");
				else if(isKeyword(tempArr[i]))
					System.out.println(tempArr[i]+"\t is Keyword");
				else if(isOperator(tempArr[i]))
					System.out.println(tempArr[i]+"\t is Operator");
				else if(tempArr[i].equals(";"))
					System.out.println(tempArr[i]+"\t is End Of Statement");
				else
				{
					char []token=tempArr[i].toCharArray();
					String curState="1";
					for(int j=0;j<token.length;j++){
						curState=getNextState(curState,token[j]);
						if(curState.equals("-"))
							break;
					}
					if(curState.equals("2"))
						System.out.println(tempArr[i] + "\t is identifier");
					else if(curState.equals("6"))
						System.out.println(tempArr[i] + "\t is integer");
					else if(curState.equals("7"))
						System.out.println(tempArr[i] + "\t is float");
					else if(curState.equals("8"))
						System.out.println(tempArr[i] + "\t is string constant");
					else if(curState.equals("10"))
						System.out.println(tempArr[i] + "\t is character constant");
					else
						System.out.println(tempArr[i] + "\t is invalid token");
				}
			}
			line=br.readLine();
		}
		br.close();
	}
}