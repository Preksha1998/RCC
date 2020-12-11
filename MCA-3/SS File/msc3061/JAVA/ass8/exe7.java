import java.applet.*;
import java.awt.*;

/*<applet code="exe7.java" height=500 width=500>
</applet>*/
public class exe7 extends Applet{
	public void init(){
		setBackground(Color.pink);
	}
	public void paint(Graphics g){
		g.setColor(Color.yellow);
		g.fillOval(10,20,200,200);

		g.setColor(Color.white);
		g.fillOval(40,90,50,50);

		g.setColor(Color.black);
		g.fillOval(55,105,20,20);

		g.setColor(Color.white);
		g.fillOval(130,90,50,50);

		g.setColor(Color.black);
		g.fillOval(145,105,20,20);

		
		g.drawArc(70,150,80,50,0,-180);	

	}
}