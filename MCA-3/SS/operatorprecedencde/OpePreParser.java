import java.io.*;
import java.util.*;
class TreeNode{
	String value;
	TreeNode leftChild,rightChild;
	TreeNode(){
		value="";
		leftChild=null;
		rightChild=null;
	}
	TreeNode(String val){
		value=val;
		leftChild=null;
		rightChild=null;
	}
	TreeNode(String val,TreeNode lchild,TreeNode rchild){
		value=val;
		leftChild=lchild;
		rightChild=rchild;
	}
	void postOrder(){
		if(leftChild!=null)
			leftChild.postOrder();
		if(rightChild!=null)
			rightChild.postOrder();
		System.out.print(value);
	}
}
class Stack{
	String operator;
	TreeNode operand;
	static int TOS =-1;
	void push(String operator,TreeNode operand){
		this.operand=operand;
		this.operator=operator;
	}
}
class OpePreParser{
	static String precedenceTable[][];
	static TreeNode rootNode;
	
	public static void main(String args[]) throws Exception{
		fillTable();
		showPrecTable();
		Scanner scanner=new Scanner(System.in);
		System.out.println("________________________________");
		System.out.print("Enter Expression : ");
		String expression=scanner.next();
		System.out.println("________________________________");
		expression="|"+expression+"|";
		
		int ssm=0,row=0,col=0;
		Stack stack[]=new Stack[10];
		String operator=expression.charAt(ssm++)+"";
		System.out.println("OP: "+operator);
		String operand=expression.charAt(ssm)+"";
		
		TreeNode node=new TreeNode(operand);
		stack[++Stack.TOS]=new Stack();
		stack[Stack.TOS].push(operator,node);

		String str;
		boolean error=false;
		
		while(expression.charAt(ssm)!='|'){
			ssm++;
			row=getRow(stack[Stack.TOS].operator);
			col=getColumn(expression.charAt(ssm)+"");
			if(row != -1 && col != -1)
				str=precedenceTable[row][col];
			else{
				System.out.println("________________________________");
				System.out.println("!!! INVALID EXPRESSION !!!");
				System.out.println("________________________________");
				error=true;
				break;
			}			
			if(str.equals("<")){
				operator=expression.charAt(ssm++)+"";
				operand=expression.charAt(ssm)+"";
				node=new TreeNode(operand);
				stack[++Stack.TOS]=new Stack();
				stack[Stack.TOS].push(operator,node);
			}
			else if(str.equals(">")){
				pop(stack);
				ssm--;
			}
		}
		if(!error){
			rootNode=stack[Stack.TOS].operand;
			System.out.println("________________________________");
			System.out.print(">>Post Order Expression : ");
			rootNode.postOrder();
			System.out.println("\n________________________________");
		}
	}
	static void pop(Stack stack[]){
		TreeNode node1=stack[Stack.TOS].operand;
		String op1=stack[Stack.TOS--].operator;
		TreeNode node2=stack[Stack.TOS].operand;
		String op2=stack[Stack.TOS--].operator;
		TreeNode node=new TreeNode(op1,node2,node1);
		stack[++Stack.TOS].push(op2,node);
	}
	static void fillTable() throws Exception{
		BufferedReader bufRead=new BufferedReader(new FileReader("OpePreTable.txt"));
		precedenceTable=new String[6][6];
		String arr[],line=bufRead.readLine();
		int i=0;
		while(line!=null && i<6){
			arr=line.split("\t");
			for(int j=0;j<arr.length;j++)
				precedenceTable[i][j]=arr[j];
			i++;
			line=bufRead.readLine();
		}
		bufRead.close();
	}
	static void showPrecTable(){
		System.out.println("\n_______________________Precedence Table_______________________________");
		for(int i=0;i<precedenceTable.length;i++){
			for(int j=0;j<precedenceTable[i].length;j++)
				System.out.print("\t"+precedenceTable[i][j]);
			System.out.println("");
		}			
	}
	static int getRow(String str){
		for(int i=0;i<precedenceTable.length;i++)
			if(precedenceTable[i][0].equals(str))
				return i;
		return -1;
	}
	static int getColumn(String str){
		for(int i=0;i<precedenceTable[0].length;i++)
			if(precedenceTable[0][i].equals(str))
				return i;
		return -1;
	}
}