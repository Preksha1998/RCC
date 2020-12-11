import java.awt.*;
import java.awt.event.*;
import java.applet.*;
//<applet code="exe3" height=500 width=500></applet>
public class exe3 extends Applet implements ActionListener{

	TextField t1,t2;
	Button b1;
	String uname="hetu",pass="hetu",msg="";
	public void init(){
		t1=new TextField(20);
		t2=new TextField(20);
		b1=new Button("LOGIN");
		t2.setEchoChar('*');
		add(t1);
		add(t2);
		add(b1);
		b1.addActionListener(this);
		
	}
	public void paint(Graphics g){
		g.drawString(msg,100,100);
	}	
	public void actionPerformed(ActionEvent ae){
		if((uname.equals(t1.getText())) && (pass.equals(t2.getText()))){
			msg="LOGIN SUCEESSFUL";
		}
		else{
			msg="LOGIN UNSUCEESSFUL";
		}
	repaint();
	}
}