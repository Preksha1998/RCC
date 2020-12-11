import java.awt.*;
import java.awt.event.*;
import java.applet.*;
//<applet code="exe5" height=500 width=500></applet>
public class exe5 extends Applet implements ActionListener{
	List l1;
	TextField t1;
	Button b1,b2,b3,b4;
	public void init(){
		l1=new List();
		t1=new TextField(20);
		b1=new Button("ADD");
		b2=new Button("CLEAR");
		b3=new Button("REMOVE");
		b4=new Button("SELECTED ITEM");
		l1.add("Apple");
		l1.add("Banana");
		add(t1);
		add(l1);
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource()==b1){
			l1.add(t1.getText());
		}
		if(ae.getSource()==b2){
			l1.clear();
		}
		if(ae.getSource()==b3){
			l1.remove(l1.getSelectedItem());
		}
		if(ae.getSource()==b4){
			t1.setText(l1.getSelectedItem());
		}
	}
}