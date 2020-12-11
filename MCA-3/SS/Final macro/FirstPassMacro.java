import java.io.*;
import java.util.*;

class FirstPassMacro{
	void insert(PNTAB pt, EVNTAB []et, SSNTAB []sst, MNT []mt, KPDTAB kt, SSTAB []st, MDT []mtab){
		FileReader fr;
		BufferedReader br;
		
		StringTokenizer st_token;
		String []tokens;
		
		try{
			fr = new FileReader("program.txt");
			br = new BufferedReader(fr);
			
			tokens = new String[10];
			EVNTAB etObj = new EVNTAB();
			SSNTAB stObj = new SSNTAB();
			PNTAB ptObj = new PNTAB();
			
			String str, str1;
			int i, isMacroFound=0, PPptr=0, KPptr=0, noKp=0, EVptr=0, MNTptr=0, KPDTABptr=0, SSNTABptr=0, MDTptr=0, SSTABptr=0, EVNTABptr=0;
			int EVindex, SSindex, PNindex;
			
			while((str = br.readLine()) != null){
				str1 = null;
				mtab[MDTptr] = new MDT();
				sst[SSNTABptr] = new SSNTAB();
				st[SSTABptr] = new SSTAB();
				et[EVNTABptr] = new EVNTAB();
				
				if(str.equalsIgnoreCase("MACRO") || isMacroFound == 1){
					
					if(isMacroFound == 1){
						st_token = new StringTokenizer(str);
						i = 0;
						
						while(st_token.hasMoreTokens()){							
							tokens[i] = st_token.nextToken(" ");
							if(i > 0){
								if(tokens[i].contains("=")){
									kt.insert(tokens[i]);
									KPptr++;
									noKp++;
									if(mt[MNTptr].KPDTP == -1)
										mt[MNTptr].KPDTP = (KPptr-1);
								}
								
								pt.insert(tokens[i], PPptr);
								PPptr++;
								i++;
							}
							else{
								i++;
								mt[MNTptr] = new MNT();
							}
						}
						
						mt[MNTptr].macroName = tokens[0];
						mt[MNTptr].noPP = PPptr - noKp;
						mt[MNTptr].noKP = noKp;
						mt[MNTptr].MDTP = MDTptr;
					}
					isMacroFound++;
				}
				else if(str.contains("MEND")){
					mtab[MDTptr].insert("MEND");
					
					if(str.startsWith(".")){
						int length = str.length();
						str1 = str.substring(0, (length-5));
						
						SSindex = stObj.isSymbol(str1, sst);
						if(SSindex == -1){
							sst[SSNTABptr++].insert(str1);
						}
						
						st[SSTABptr].insert(MDTptr);
						
						if(mt[MNTptr].SSTP == -1)
							mt[MNTptr].SSTP = SSTABptr;
						
						SSTABptr++;
					}
					
					mt[MNTptr].noEV = EVptr;
					
					MNTptr++;
					MDTptr++;
					PPptr = 0;
					EVptr = 0;
					noKp = 0;
					SSNTABptr = 0;
					EVNTABptr = 0;
					isMacroFound = 0;
				}
				else if(isMacroFound > 1){
					st_token = new StringTokenizer(str);
					i = 0;
					
					while(st_token.hasMoreTokens()){
						tokens[i++] = st_token.nextToken(" ");
					}
						
					for(; i<10; i++){
						tokens[i] = null;
					}
					
					if(str.startsWith(".")){					//ANOP also covered
						SSindex = stObj.isSymbol(tokens[0], sst);
						if(SSindex == -1){
							sst[SSNTABptr++].insert(tokens[0]);
						}
						st[SSTABptr].insert(MDTptr);
						
						if(mt[MNTptr].SSTP == -1){
							mt[MNTptr].SSTP = SSTABptr;
						}
						
						str1 = tokens[1];
						if(tokens[2] != null){
							PNindex = ptObj.isParameter(tokens[2], pt, PPptr);
							
							if(PNindex == -1){
								str1 = str1 + " " + tokens[2];								
							}
							else{
								str1 = str1 + " (P," + PNindex + ")";
							}
							
							PNindex = ptObj.isParameter(tokens[3], pt, PPptr);
							
							if(PNindex != -1){
								if(tokens[4] != null)
									str1 = str1 + " ((P," + PNindex + ") ";  
								else
									str1 = str1 + " (P," + PNindex + ") ";  
							}
							else{
								EVindex = etObj.isEV(tokens[3], et);
								if(tokens[4] != null)
									str1 = str1 + " ((E," + EVindex + ") ";
								else
									str1 = str1 + " (E," + EVindex + ") ";								
							
							}
							if(tokens[4] != null){
								str1 = str1 + tokens[4];
								
								PNindex = ptObj.isParameter(tokens[5], pt, PPptr);
								
								if(PNindex != -1){
									str1 = str1 + " (P," + PNindex + "))";  
								}
								else{
									EVindex = etObj.isEV(tokens[5], et);
								str1 = str1 + " (E," + EVindex + "))";
								}
							}
						}
						
						mtab[MDTptr++].insert(str1);
						SSTABptr++;
					}
					else if(str.startsWith("&")){
						if(tokens[1].equalsIgnoreCase("SET")){		//&M SET &M + 1		OR		&M SET 0
							EVindex = etObj.isEV(tokens[0], et);
							str1 = "(E," + EVindex + ") " + tokens[1];
							
							EVindex = etObj.isEV(tokens[2], et);
							
							if(EVindex != -1){
								str1 = str1 + " ((E," + EVindex + ") " + tokens[3] + " " + tokens[4] + "))";
							}
							else{
								str1 = str1 + " " + tokens[2];
							}
						}
						else{										//&OP &REG &Y(pg=137)		OR 		&X DB 25(pg=159)
							PNindex = ptObj.isParameter(tokens[0], pt, PPptr);
							
							if(PNindex != -1){
								str1 = "(P," + PNindex + ")";
								PNindex = ptObj.isParameter(tokens[1], pt, PPptr);
								
								if(PNindex != -1){
									str1 = str1 + " (P," + PNindex + ")";
									PNindex = ptObj.isParameter(tokens[2], pt, PPptr);
									str1 = str1 + " (P," + PNindex + ")";
								}
								else{
									str1 = str1 + " " + tokens[1] + " " + tokens[2];
								}
							}
						}					
						
						mtab[MDTptr++].insert(str1);
					}
					else if(str.startsWith("AIF")){
						int length = tokens[1].length();						
						PNindex = ptObj.isParameter(tokens[1].substring(1, length), pt, PPptr);
						
						if(PNindex != -1){
							str1 = tokens[0] + " ((P," + PNindex + ") " + tokens[2];
						}
						else{
							EVindex = etObj.isEV(tokens[1].substring(1, length), et);
							str1 = tokens[0] + " ((E," + EVindex + ") " + tokens[2];
						}
							
						length = tokens[3].length();
						PNindex = ptObj.isParameter(tokens[3].substring(0, (length - 1)) , pt, PPptr);
						
						str1 = str1 + " (P," + PNindex + "))";
						
						SSindex = stObj.isSymbol(tokens[4], sst);
						
						if(mt[MNTptr].SSTP == -1)
							mt[MNTptr].SSTP = SSTABptr;
						
						if(SSindex == -1){
							SSindex = SSNTABptr + mt[MNTptr].SSTP;
							sst[SSNTABptr++].insert(tokens[4]);
						}
						else{
							SSindex += mt[MNTptr].SSTP;
						}
						
						str1 = str1 + " (S," + SSindex + ")";
						mtab[MDTptr++].insert(str1);
					}
					else if(str.startsWith("AGO")){
						SSindex = stObj.isSymbol(tokens[1], sst);
						
						if(mt[MNTptr].SSTP == -1)
							mt[MNTptr].SSTP = SSTABptr;
						
						if(SSindex == -1){
							SSindex = SSNTABptr + mt[MNTptr].SSTP;
							sst[SSNTABptr++].insert(tokens[1]);
						}
						else{
							SSindex += mt[MNTptr].SSTP;
						}
						
						str1 = tokens[0] + " (S," + SSindex + ")";
						mtab[MDTptr++].insert(str1);
					}
					else if(str.startsWith("LCL")){
						et[EVNTABptr].insert(tokens[1]);
						str1 = tokens[0] + " (E," + EVNTABptr + ")";
					
						EVptr++;
						mtab[MDTptr++].insert(str1);
						EVNTABptr++;
					}
					else{								//other statements
						PNindex = ptObj.isParameter(tokens[1] , pt, PPptr);
						if(PNindex != -1){									//MOVER &REG &A		OR		MOVER &REG ='0'
							str1 = tokens[0] + " (P," + PNindex + ")";
						}
						else{												//MOVER AREG &A
							str1 = tokens[0] + " " + tokens[1];	
						}
						
						PNindex = ptObj.isParameter(tokens[2] , pt, PPptr);
						
						if(PNindex != -1){
							str1 = str1 + " (P," + PNindex + ")";
						}
						else{
							str1 = str1 + " " + tokens[2];
						}
						
						mtab[MDTptr++].insert(str1);
					}
				}
			}
			br.close();
			fr.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}