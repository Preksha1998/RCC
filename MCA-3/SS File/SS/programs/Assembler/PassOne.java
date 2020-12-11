import java.io.*;
class PassOne{
	
	public static void main(String [] args) throws FileNotFoundException , IOException{
		
		/*BufferedReader br = new BufferedReader( new FileReader("Mnemonic.txt"));
		
		String line;
		int i = 0;
		while ((line = br.readLine()) != null)
		{
			String [] tokens = line.split("\t");
			
			for(i = 0; i<tokens.length ;i++)
			{
				System.out.print(tokens[i] +"\t");
			}
			System.out.println();
			
			int idx = Integer.parseInt(tokens[0]);
			String mnemonic = tokens[1];
			String code = tokens[2];
			String add = tokens[3];
			String mc = tokens[4];
			int len = Integer.parseInt(tokens[5]);
			//mTab[i] = new MnemonicTable(idx,mnemonic.toString(),code.toString(),add.toString(),mc.toString(),len);
			mTab[i++] = new MnemonicTable(0,"START","0000","AD",0);
		}*/	
		
		MnemonicTable [] mTab ={
			new MnemonicTable(0,"START","0000","AD",0),
			new MnemonicTable(1,"ADD","0001","IS",1),
			new MnemonicTable(2,"SUB","0002","IS",1),
			new MnemonicTable(3,"MULT","0003","IS",1),
			new MnemonicTable(4,"DIV","0004","IS",1),
			new MnemonicTable(5,"MOVER","0005","IS",1),
			new MnemonicTable(6,"MOVEM","0006","IS",1),
			new MnemonicTable(7,"COMP","0007","IS",1),
			new MnemonicTable(8,"BC","0008","IS",1),
			new MnemonicTable(9,"READ","0009","IS",0),
			new MnemonicTable(10,"PRINT","0010","AD",0),
			new MnemonicTable(11,"EQU","0011","AD",0),
			new MnemonicTable(12,"ORIGIN","0012","AD",0),
			new MnemonicTable(13,"LTORG","0013","AD",0),
			new MnemonicTable(14,"STOP","0014","AD",0),
			new MnemonicTable(15,"END","0014","AD",0),
			new MnemonicTable(16,"DS","0015","DL",0),
			new MnemonicTable(17,"DC","0016","DL",0)
		};
		
		Register rTab[] = {
			new Register(1,"AREG","501"),
			new Register(2,"BREG","502"),
			new Register(3,"CREG","503"),
			new Register(4,"DREG","504")
		};
		
		SymbolTable sTab[] = new SymbolTable[20];
		LiteralTable lTab[] = new LiteralTable[20];
		PoolTable pTab = new PoolTable();
		Error err[] = new Error[20];
		
		BufferedReader br = new BufferedReader(new FileReader("code.txt"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("Output.txt"));
			
		int locConter = 0,lineNo = 0;
		String token [] = null;
		String line,iCode;
		
		while((line = br.readLine()) != null){
			lineNo++;
			token = line.split(" ");
			
			if(lineNo == 1){	// first line of the assembly program (one time execute)
				if(token[0].equals("START")){
					iCode = MnemonicTable.getCode(mTab,"START");
					bw.write(iCode);
					
					if(token.length == 1) // if origin is defined
					bw.write("C," + locConter + ")");
				
					else if(token.length == 2){  // if origin is not defined
						int sCounter = Integer.parseInt(token[1]);
						locConter = sCounter;
						bw.write(" (C," + sCounter + ")");
					}
					else
						Error.addError(err,lineNo,"Invalid origin defined.",true);
				}
				else
					Error.addError(err,lineNo,"START directive not found",true);
			} // end of first line
			
			else if(token[0].equals("START")){	// condition check for more than one time START occurrence
				Error.addError(err,lineNo,"START directive found more than one",true);
			}
			else if(token[0].equals("END")){
				iCode = MnemonicTable.getCode(mTab,"END");
				bw.newLine();
				bw.write(iCode);
			}
			else{
				boolean mFlag=false,dFlag=false,eFlag=false;
				mFlag = MnemonicTable.isExist(mTab,token[0]);
				
				if(mFlag == false){
					if(line.contains("DS") || line.contains("DC") || line.contains("EQU")){
						dFlag = true;
					}	
				}

				if(mFlag || dFlag){
					if(dFlag){
						bw.newLine();
						
						eFlag = Register.isExist(rTab,token[0]);
						
						if(eFlag){
							Error.addError(err,lineNo,"Register name can not be use as identifier.",true);
						}
						else{
							if((SymbolTable.isExist(sTab,token[0])) && (SymbolTable.getAddress(sTab,token[0]) == 0)){
								SymbolTable.updateSymbol(sTab,token[0],locConter);
							}
											
							else if((SymbolTable.isExist(sTab,token[0])) && (SymbolTable.getAddress(sTab,token[0]) !=0)){
								Error.addError(err,lineNo,token[0] + " is already defined.",true);
							}
							else
								SymbolTable.addSymbol(sTab,token[0],locConter,true);
							
							if(token[1].equals("DS")){
								iCode = MnemonicTable.getCode(mTab,"DS");
								bw.write(iCode);
								
								if(token.length == 3){
									int bSize = Integer.parseInt(token[2]);
									
									if( bSize !=0 ){
										locConter += bSize;
										bw.write(" (C," + bSize + ")");
									}
									else
										Error.addError(err,lineNo,"Invalid size of byte specified.",true);
								}
								else
									Error.addError(err,lineNo,"Invalid number of arguments specified.",true);
							} // end of DS statemnt
							
							else if(token[1].equals("DC")){
								iCode = MnemonicTable.getCode(mTab,"DC");
								bw.write(iCode);
								
								locConter += 1;
								bw.write(" (C," + token[2].substring(1,token[2].length()-1) + ") ");
							} // end of DC statemnt
							
							else if(token[1].equals("EQU")){
								
								if(token.length == 3){
									eFlag = Register.isExist(rTab,token[2]);
									
									if(eFlag)
										Error.addError(err,lineNo,"Register name can not be use in EQU.",true);
									
									eFlag = SymbolTable.isExist(sTab,token[2]);
									if(!eFlag){
										Error.addError(err,lineNo,"identifier " + token[2] + " is not defined",true);
									}
									else{
										SymbolTable.addSymbol(sTab,token[0],SymbolTable.getAddress(sTab,token[2]),true);
									}						
								}
								else
									Error.addError(err,lineNo, "Invalid number of argumnets in EQU statemnt.",true);
							} // end of EQU statemnt
						}
					} // end of dFlag
					
					else if(mFlag){
						locConter++;
						bw.newLine();
						
						// condtion for assembly directive
						if(Converter.isAssemblyDirective(mTab,token[0])){
							
							if(token[0].equals("LTORG")){
								iCode = MnemonicTable.getCode(mTab,"LTORG");
								bw.write(iCode);
								PoolTable.processIndex();
								locConter = LiteralTable.updateLiteral(lTab,PoolTable.getIndexPosition(),locConter);
							}
						} //  end of assemblyDirective condition
						
						// condtion for imperative statment
						else if (Converter.isImperative(mTab,token[0])){
							if(token[0].equals("BC")){
								eFlag = Converter.isBranchCondition(token[1]);
									
								if(!eFlag)
									Error.addError(err,lineNo,"Invalid branch condition.",true);
								
								if(token.length == 3){
									iCode = MnemonicTable.getCode(mTab,"BC") + " " +Converter.getBranchCode(token[1]);
									bw.write(iCode);
								}
								else
									Error.addError(err,lineNo,"few argumnets in branch condition.",true);
								
								continue;
							} // end of BC statemnt
							bw.write("(IS," + MnemonicTable.getIndex(mTab,token[0]) + ") ");
							
							if(token.length == 2){
								eFlag = Register.isExist(rTab,token[0]);
								
								if(eFlag)
									Error.addError(err,lineNo,"Register name can not be use as identifier",true);
								eFlag = SymbolTable.isExist(sTab,token[1]);
								
								if(!eFlag){
									SymbolTable.addSymbol(sTab,token[1],0,false);
									bw.write(" (S," + SymbolTable.getIndex(sTab,token[1] + ")")); 
								}
								else{
									bw.write(" (S," + SymbolTable.getIndex(sTab,token[1]) + ")");
								}
							}
							else if(token.length == 3){
								if(Register.isExist(rTab,token[1])){
									bw.write(" (R," + Register.getIndex(rTab,token[1]) + ")");
								}
								else{
									Error.addError(err,lineNo,"First operand should be register",true);
								}
								
								if(SymbolTable.isExist(sTab,token[2])){
									bw.write(" (S," + SymbolTable.getIndex(sTab,token[2]) + ")");
								}
								else{
									
									if(token[2].endsWith("'")){
										LiteralTable.addLiteral(lTab,token[2]);
										PoolTable.updateIndex();
										bw.write(" (L," + LiteralTable.getIndex(lTab,token[2]) + ")");
										continue;
									}
									
									eFlag = SymbolTable.isExist(sTab,token[2]);
									if(!eFlag){
										SymbolTable.addSymbol(sTab,token[2],0,false);
										bw.write(" (S,"+ SymbolTable.getIndex(sTab,token[2]) + ")");
										Error.addError(err,lineNo,"Undeclared identifier " + token[2],token[2],false);
									}
									else{
										bw.write(" (S," + SymbolTable.getIndex(sTab,token[2]) + ")");
									}
								}
							}
							else{
								Error.addError(err,lineNo,"few number arguments provided",true);
							}
						} //  end of imperative condition
					} // end of mflag
				}	// end of mFlag || dFlag			
				
				else if(token.length == 4){
					bw.newLine();
					
					if(SymbolTable.isExist(sTab,token[0])){
						boolean isD = SymbolTable.isDefined(sTab,token[0]);
						
						if(isD){
							SymbolTable.updateSymbol(sTab,token[0],locConter);
						}
						else{
							Error.addError(err,lineNo,"identifier already defined." + token[0] ,true);
						}
					}
					else{
						SymbolTable.addSymbol(sTab,token[0],locConter,true);
					}
					
					if(!MnemonicTable.isExist(mTab,token[1])){
						Error.addError(err,lineNo,"First operand must be imperative statemnt",true);
					}
					else{
						bw.write("(IS," + MnemonicTable.getIndex(mTab,token[1]) + ")");
					}
					
					if(Register.isExist(rTab,token[2])){
						bw.write(" (R," + Register.getIndex(rTab,token[2]) + ")" );
					}
					else{
						Error.addError(err,lineNo,"second operand must be register.",true);
					}
					
					if(SymbolTable.isExist(sTab,token[3])){
						bw.write(" (S,"+ SymbolTable.getIndex(sTab,token[3]) + ")");
					}
					else{
						if(token[3].endsWith("'")){
							LiteralTable.addLiteral(lTab,token[3]);
							PoolTable.updateIndex();
							bw.write(" (L" + LiteralTable.getIndex(lTab,token[3]) + ")");
							continue;
						}
						
						eFlag = SymbolTable.isExist(sTab,token[3]);
						
						if(!eFlag){
							SymbolTable.addSymbol(sTab,token[3],0,false);
							bw.write(" (S," + SymbolTable.getIndex(sTab,token[3]) + ")");
							Error.addError(err,lineNo,"Undeclared identifier"+token[3],token[3],false);
						}
						else{
							bw.write(" (S" + SymbolTable.getIndex(sTab,token[3]) + ")");
						}
					}
					
				}
			} // end of else case
			
			int tError = Error.getTotalError();
			
			for(int i=0 ; i < tError ;i++){
				boolean cFlag = false;
				
				if(err[i].eFlag == false){
					for(SymbolTable obj : sTab){
						if(obj!= null && obj.sName.equals(err[i].token) && obj.sAddress != 0)
							cFlag = true;
					}
					
					if(cFlag == false)
						err[i].eFlag = true;
				}			
			}
			
			//PoolTable.processIndex();
			//locConter =  LiteralTable.updateLiteral(lTab,PoolTable.getIndexPosition(),locConter);
		}
		br.close();
		bw.close();
		SymbolTable.showSymbol(sTab);
		LiteralTable.showLiteral(lTab);
		PoolTable.showPool();
		Error.showError(err);
	}
}	