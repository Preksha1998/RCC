import java.awt.*;
import java.applet.*;
import java.awt.event.*;
//<applet code="exe1" height=500 width=500></applet>
public class exe1 extends Applet implements ActionListener{
	Button plus,minus,mul,div,eq,clear;
	TextField t1;
	String msg="";
	int no1,no2,ans;
	int flag;
	public void init(){
		t1=new TextField(50);
		plus=new Button("+");
		minus=new Button("-");
		mul=new Button("*");
		div=new Button("/");
		eq=new Button("=");
		clear=new Button("C");
		add(t1);
		add(plus);
		add(minus);
		add(mul);
		add(div);
		add(eq);
		add(clear);
		plus.addActionListener(this);		
		minus.addActionListener(this);
		mul.addActionListener(this);
		div.addActionListener(this);
		eq.addActionListener(this);
		clear.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae){
		if(ae.getActionCommand()=="+"){
			no1=Integer.parseInt(t1.getText());
			msg="";
			t1.setText("");
			flag=1;
		}
		else if(ae.getActionCommand()=="-"){
			no1=Integer.parseInt(t1.getText());
			msg="";
			t1.setText("");
			flag=2;
		}
		else if(ae.getActionCommand()=="*"){
			no1=Integer.parseInt(t1.getText());
			msg="";
			t1.setText("");
			flag=3;
		}
		else if(ae.getActionCommand()=="/"){
			no1=Integer.parseInt(t1.getText());
			msg="";
			t1.setText("");
			flag=4;
		}
		else if(ae.getActionCommand()=="C"){
			t1.setText("");
		}
		else if(ae.getActionCommand()=="="){
			no2=Integer.parseInt(t1.getText());
			if(flag==1){
				ans=no1+no2;
			}
			else if(flag==2){
				ans=no1-no2;
			}
			else if(flag==3){
				ans=no1*no2;
			}
			else if(flag==4){
				ans=no1/no2;
			}
			t1.setText(ans+" ");
			msg="";
		}
		else{
			msg+=ae.getActionCommand();
			t1.setText(msg);
		}
	}
}