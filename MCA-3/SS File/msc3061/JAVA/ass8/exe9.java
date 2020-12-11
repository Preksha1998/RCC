import java.applet.*;
import java.awt.*;

/*<applet code="exe9.java" height=300 width=300>
</applet>*/
public class exe9 extends Applet{
	public void init(){
		setBackground(Color.gray);
	}
	public void paint(Graphics g){
		g.fillRect(10,50,20,400);
		g.setColor(Color.red);
		g.fillRect(30,50,90,50);
		g.setColor(Color.white);
		g.fillRect(30,100,90,50);
		g.setColor(Color.green);

		g.fillRect(30,150,90,50);
		g.setColor(Color.blue);
		g.fillOval(50,100,50,50);
		

	}
}