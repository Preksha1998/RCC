import java.io.*;
import java.util.*;

class assembly
{
	String[] lbl=new String[100];
	String[][] finalstr=new String[100][100];
	int linecount=0;
	int lc=0;	
	String[][][] opt={{{"START","0","IS"},{"ADD","1","IS"},{"SUB","2","IS"},{"MULT","3","IS"},{"MOVER","4","IS"},{"MOVEM","5","IS"},{"COMP","6","IS"},{"BC","7","IS"},{"DIV","8","IS"},{"READ","9","IS"},{"PRINT","10","IS"},{"DC","00","DL"},{"DS","01","DL"},{"AREG","01","REG"},{"BREG","02","REG"},{"CREG","03","REG"},{"DREG","04","REG"},{"LT","01","FLAG"},{"LE","02","FLAG"},{"EQ","03","FLAG"},{"GT","04","FLAG"},{"GE","05","FLAG"},{"ANY","06","FLAG"}}};
	String symtab[][]=new String[50][2];
	String littab[][]=new String[50][2];
	int sptr=0,lptr=0;
	int pooltab[]=new int[10];
	int pptr=1;
	
	assembly()
	{
		pooltab[pptr]=1;
	}
	
	void pass1()
	{
		for(int x=0; x<linecount; x++)
		{
			for(int y=0; y<finalstr[x].length; y++)
			{
				boolean exis=false;
				if(finalstr[x][y].equals("START"))
				{
					lc=Integer.parseInt(finalstr[x][y+1]);
					x++;
				}
				else if(finalstr[x][y].substring(0,1).equals("="))
				{
					littab[lptr][0]=finalstr[x][y];
					lptr++;
				}
				else if(finalstr[x][y].equals("LTORG"))
				{		
					x++;
					while(finalstr[x][y].substring(0,1).equals("=")) // loop while you get literal (line wise)
					{
							for(int p=0; p<lptr; p++)
							{
								if(littab[p][0].equals(finalstr[x][y]))
								{
									littab[p][1]=Integer.toString(lc);
								}
							}	
						lc++;
						x++;
					}
					pptr++; // 2 = 3
					pooltab[pptr]=lptr+1;
					y--;
				}
				else if(!finalstr[x][y].equals("END"))
				{
					boolean flag=true;
					for(int i=0; i<opt[0].length; i++)
					{	
							if(opt[0][i][0].equals(finalstr[x][y])) 	// opt[0] means entire set of 23 optab
							{
								flag=false;
								continue;
							}
					}
					
					if(flag==true)
					{
						// Check if symbol exists in symtab already, if it exists then update it's address to current lc
						for(int k=0; k<sptr; k++)
						{
							if(finalstr[x][y].equals(symtab[k][0]))
							{
								exis=true;
								symtab[k][1]=Integer.toString(lc); 			
								break;
							}
						}
						
						// Insert the symbol and it's current lc if it doesn't exist in symtab already
						if(exis==false)
						{
							symtab[sptr][0]=finalstr[x][y];					
							symtab[sptr][1]=Integer.toString(lc);
							sptr++;
						}
						
					}
				}	
				if(exis==true)
				{
					exis=false;
					break;
				}
			}
			lc++;
		}
    }
	
	void printtables()
	{
		int i,j;
		
		System.out.println("\nSYMTAB:-\n");
		
		for(i=0; i<sptr; i++)
		{
			for(j=0; j<2; j++)
			{
				System.out.print(symtab[i][j] + "\t"); 		
			}
			System.out.println("\n\n");
		}
		
		System.out.println("\nLITTAB:-\n");
		
		for(i=0; i<lptr; i++)
		{
			for(j=0; j<2; j++)
			{
				System.out.print(littab[i][j] + "\t");
			}
			System.out.println("\n\n");
		}
		
		System.out.println("\nPOOLTAB:-\n");
		
		for(i=1; i<=pptr; i++)
		{
			System.out.print(pooltab[i]);
			System.out.println("\n");
		}
	}
	
	void storelines(File obj)
	{
		try{
			Scanner myReader = new Scanner(obj);
			
			while(myReader.hasNextLine())  // Loop until next line to read is available
			{
				String st=myReader.nextLine();
				if(!st.isEmpty())
				{
					lbl[linecount] = st;
					linecount++;
				}
			}
			  myReader.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
	
	void tokenize()
	{
		for(int i=0; i<linecount; i++)
		{			
			finalstr[i]=lbl[i].trim().split("[, ]+"); // Extract words from each line stored in lbl array.
		}
	}
}

class assembly_demo
{		
   public static void main(String[] args) 
   {
	   assembly a1=new assembly();
	   
	   // Get filename with path and extension
	   String fname=System.console().readLine("\nEnter File Name with Path & Extension: "); 
	   
	   File myObj = new File(fname); // Create new file object
		
		if(myObj.exists() && myObj.canRead() && myObj.canWrite())
		{
			a1.storelines(myObj); // 
			//a1.displaylines();
			a1.tokenize();
			a1.pass1();
			a1.printtables();
		}
		else
		{
			System.out.println("\nError, File Does Not Exist!");
		}
   }
}