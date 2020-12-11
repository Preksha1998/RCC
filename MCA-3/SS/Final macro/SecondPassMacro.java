import java.io.*;
import java.util.*;

class SecondPassMacro
{
	void insert(MNT []mt, KPDTAB kt, SSTAB []st, MDT []mtab, APTAB []at, EVTAB []et)
	{
		FileReader fr;
		BufferedReader br;
		
		FileWriter fw;
		BufferedWriter bw;
		
		StringTokenizer st_token;
		String []tokens;
		
		try
		{
			fr = new FileReader("progam.txt");
			br = new BufferedReader(fr);
			
			fw = new FileWriter("modifiedProgram.txt");
			bw = new BufferedWriter(fw);
			
			tokens = new String[10];
			MNT m_t = new MNT();
			KPDTAB k_t = new KPDTAB();
			
			String str, str1;
			boolean isMacroFound=false, isEnd=false;
			int MNT_index, MDT_index, i, j, APTAB_ptr=0, EVTAB_ptr=0, APTAB_index, EVTAB_index;
			
			while((str = br.readLine()) != null && !isEnd)
			{
				//System.out.println(str);
				if(str.equalsIgnoreCase("MACRO"))
				{
					isMacroFound = true;
				}
				else if(isMacroFound)
				{
					if(str.contains("MEND"))
					{
						isMacroFound = false;
					}
				}
				else if(str.equalsIgnoreCase("END"))
				{
					isEnd = true;
					bw.write(str);
				}
				else
				{
					i = 0;
					et[EVTAB_ptr] = new EVTAB();
					st_token = new StringTokenizer(str);
					
					while(st_token.hasMoreTokens())
					{
						tokens[i++] = st_token.nextToken(" ");
					}
						
					for(; i<10; i++)
					{
						tokens[i] = null;
					}
					
					if(tokens[0] == null)
					{
						//do nothing
					}
					else
					{
						MNT_index = m_t.isMNT(tokens[0], mt);
						if(MNT_index == -1)
						{
							bw.write(str + "\n");						
						}
						else
						{
							for(j=0; j<mt[MNT_index].noPP; j++)
							{
								at[APTAB_ptr] = new APTAB();
								at[APTAB_ptr++].insert(tokens[j+1]);
								//System.out.println(tokens[j+1]);
							}
							
							j++;
							int l = mt[MNT_index].KPDTP;
							
							for(i=0; i<mt[MNT_index].noKP; i++)
							{
								at[APTAB_ptr] = new APTAB();
								
								if(tokens[j] == null)
								{
									at[APTAB_ptr++].insert(kt.keyword[l][1]);
									//System.out.println(kt.keyword[l][1]);
								}
								else
								{
									int k = j;
									String tmp = kt.keyword[l][0];
									
									while(tokens[k] != null)
									{
										if(tmp.equalsIgnoreCase("&" + tokens[k].substring(0, tokens[k].indexOf("="))))
										{
											tmp = tokens[k].substring((tokens[k].indexOf("=")+1), tokens[k].length());
											// OPTION	tmp = tokens[k].substring((tokens[k].indexOf("=")+1));
											break;
										}
										k++;
									}
									
									at[APTAB_ptr++].insert(tmp);
									//System.out.println(tmp);
								}
								l++;
							}
							
							MDT_index = mt[MNT_index].MDTP;
							while(!mtab[MDT_index].macroLine.equalsIgnoreCase("MEND"))
							{
								i = 0;
								st_token = new StringTokenizer(mtab[MDT_index].macroLine);
					
								while(st_token.hasMoreTokens())
								{
									tokens[i++] = st_token.nextToken(" ");
								}
									
								for(; i<6; i++)
								{
									tokens[i] = null;
								}
								
								if(tokens[0].equalsIgnoreCase("LCL"))
								{
									EVTAB_index = Integer.parseInt(tokens[1].substring(3, 4));
									et[EVTAB_index] = new EVTAB();
								}
								else if(tokens[0].equalsIgnoreCase("AIF"))
								{
									int compInt1, compInt2;
									
									if(tokens[1].startsWith("((P,"))
									{
										APTAB_index = Integer.parseInt(tokens[1].substring(4, 5));
										compInt1 = Integer.parseInt(at[APTAB_index].actualParameter);
										
										APTAB_index = Integer.parseInt(tokens[3].substring(3, 4));
										compInt2 = Integer.parseInt(at[APTAB_index].actualParameter);
									}
									else
									{
										EVTAB_index = Integer.parseInt(tokens[1].substring(4, 5));
										compInt1 = et[EVTAB_index].initialValue;
										
										APTAB_index = Integer.parseInt(tokens[3].substring(3, 4));
										compInt2 = Integer.parseInt(at[APTAB_index].actualParameter);
									}
										
									if(tokens[2].equalsIgnoreCase("EQ"))
									{
										if(compInt1 == compInt2)
										{
											MDT_index = st[Integer.parseInt(tokens[4].substring(3, 4))].symbolIndex - 1;
										}
									}
									else if(tokens[2].equalsIgnoreCase("NE"))
									{
										if(compInt1 != compInt2)
										{
											MDT_index = st[Integer.parseInt(tokens[4].substring(3, 4))].symbolIndex - 1;
										}
									}
								}
								else if(tokens[0].equalsIgnoreCase("AGO"))
								{
									MDT_index = st[Integer.parseInt(tokens[1].substring(3, 4))].symbolIndex - 1;
								}
								else if(tokens[0].equalsIgnoreCase("ANOP"))
								{
									//do nothing
								}
								else if(tokens[1].equalsIgnoreCase("SET"))
								{
									EVTAB_index = Integer.parseInt(tokens[0].substring(3, 4));
									if(tokens[3] != null)								//(E,0) SET ((E,0) + 1))
									{
										int temp = et[EVTAB_index].initialValue + Integer.parseInt(tokens[4].substring(0,1));
										et[EVTAB_index].insert(temp);
									}
									else
									{
										et[EVTAB_index].insert(Integer.parseInt(tokens[2]));
									}
								}
								else if(mtab[MDT_index].macroLine.startsWith("(P,"))	//&OP &REG &Y     -->     (P,2) (P,4) (P,1)     -->     MULT AREG B
								{
									APTAB_index = Integer.parseInt(tokens[0].substring(3, 4));
									str1 = at[APTAB_index].actualParameter + " ";
									
									APTAB_index = Integer.parseInt(tokens[1].substring(3, 4));
									str1 += at[APTAB_index].actualParameter + " ";
									
									APTAB_index = Integer.parseInt(tokens[2].substring(3, 4));
									str1 += at[APTAB_index].actualParameter;
									
									bw.write(str1 + "\n");
								}
								else
								{
									str1 = tokens[0] + " ";
									
									if(tokens[1].startsWith("(P,"))
									{
										APTAB_index = Integer.parseInt(tokens[1].substring(3, 4));
										str1 += at[APTAB_index].actualParameter + " ";
									}
									else
									{
										str1 += tokens[1] + " ";
									}
									
									if(tokens[2].startsWith("(P,"))
									{
										APTAB_index = Integer.parseInt(tokens[2].substring(3, 4));
										str1 += at[APTAB_index].actualParameter + " ";
									}
									else if(tokens[2].startsWith("((P,"))
									{
										APTAB_index = Integer.parseInt(tokens[2].substring(4, 5));
										str1 += at[APTAB_index].actualParameter + " ";
									}
									else
									{
										str1 += tokens[2] + " ";
									}
									
									if(tokens[3] != null)
									{
										EVTAB_index = Integer.parseInt(tokens[4].substring(3, 4));
										str1 += tokens[3] + " " + et[EVTAB_index].initialValue;
									}
									
									bw.write(str1 + "\n");
								}

								MDT_index++;
							}
							APTAB_ptr = 0;
							EVTAB_ptr = 0;
						}
					}
				}
			}
			
			bw.close();
			fw.close();
			br.close();
			fr.close();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}