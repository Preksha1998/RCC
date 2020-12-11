import java.io.*;
import java.util.*;

public class Macro{
	public static void main(String []args){
		PNTAB pt = new PNTAB();
		EVNTAB []evt = new EVNTAB[10];
		SSNTAB []sst = new SSNTAB[10];
		MNT []mt = new MNT[10];
		KPDTAB kt = new KPDTAB();
		SSTAB []st = new SSTAB[20];
		MDT []mtab = new MDT[50];
		APTAB []at = new APTAB[15];
		EVTAB []et = new EVTAB[10];
		
		int i;
		
		FirstPassMacro fpm = new FirstPassMacro();
		SecondPassMacro spm = new SecondPassMacro();
		
		fpm.insert(pt, evt, sst, mt, kt, st, mtab);

		System.out.println("\n|----- Macro Name Table -----|\n");
		System.out.println("\nName \t\t#PP \t#KP \t#EV \tMDTP \tKPDTP \tSSTP ");
		System.out.println("-------------------------------------------------------------");
		for(i=0; i<MNT.count; i++){
			mt[i].display();
		}

		System.out.println("\n|----- Keyword Parameter Default Table -----|\n");
		kt.display();
		
		System.out.println("\n|----- Sequencing Symbol Table -----|\n");
		for(i=0; i<SSTAB.count; i++){
			st[i].display();
		}
		
		System.out.println("\n|----- Macro Definition Table -----|\n");
		for(i=0; i<MDT.count; i++){
			mtab[i].display();
		}
		
		spm.insert(mt, kt, st, mtab, at, et);
		
		FileReader fr;
		BufferedReader br;
		
		try{
			fr = new FileReader("modifiedProgram.txt");
			br = new BufferedReader(fr);
			String str;
			
			System.out.println("\n|-----  Expanded Macro -----|\n");
			while((str = br.readLine()) != null){
				System.out.println(str);
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}