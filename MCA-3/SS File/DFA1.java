import java.util.*;
import java.io.*;
class DFA1{
    static String table[][];
    public static void main(String args[]) throws Exception{
        Scanner sc=new Scanner(System.in);
        System.out.println("Regular Expression : aa+(c|d)*b(bd)*");
        System.out.println("Enter Expression : ");
        String expr=sc.nextLine();
        getRules();
        eval(expr);
    }
    static void eval(String expr){
        String curr_state=table[1][0],next,curr_char;
        for(int i=0;i<expr.length();i++){
            curr_char=expr.charAt(i)+"";
            next=getnext(curr_state,curr_char);
            if(next == null || next.equals("-")){
                System.out.println("Invalid Expression");
            }
            curr_state=next;
        }
        if(curr_state.equals("D")){
            System.out.println("Valid Expression");
        }
        else{
            System.out.println("Invalid Expression");
        }
    }
    static String getnext(String curr_state,String curr_char){
        int row=0,col=0;
        for(int i=0;i<table.length;i++){
            if(curr_state.equals(table[i][0])){
                row=i;
                break;
            }
        }
        for(int i=0;i<table[0].length;i++){
            if(curr_char.equals(table[0][i])){
                col=i;
                break;
            }
        }
        return table[row][col];
    }
    static void getRules() throws Exception{
        table=new String[6][5];
        BufferedReader br=new BufferedReader(new FileReader("states.txt"));
        String line;
        int i=0,j;
        String token[];
        while((line=br.readLine())!=null){
            token=line.split("\t");
            for(j=0;j<token.length;j++){
                table[i][j]=token[j];
            }
            i++;
        }
        System.out.println("State Table : ");
        for(i=0;i<table.length;i++){
            for(j=0;j<table[i].length;j++){
                System.out.print(table[i][j]+"\t");
            }
            System.out.println("");
        }
    }
}