import java.applet.*;
import java.awt.*;

/*<applet code="exe5.java" height=500 width=500>
</applet>*/
public class exe5 extends Applet{
	public void init(){
		setBackground(Color.pink);
	}
	public void paint(Graphics g){
		g.setColor(Color.red);
		g.drawString("H",100,200);

		g.setColor(Color.green);
		g.drawString("E",110,200);

		g.setColor(Color.yellow);
		g.drawString("L",120,200);

		g.setColor(Color.black);
		g.drawString("L",130,200);

		g.setColor(Color.white);
		g.drawString("O",140,200);

		g.setColor(Color.cyan);
		g.drawString("W",180,200);

		g.setColor(Color.red);
		g.drawString("O",190,200);

		g.setColor(Color.gray);
		g.drawString("R",200,200);

		g.setColor(Color.black);
		g.drawString("L",210,200);

		g.setColor(Color.blue);
		g.drawString("D",220,200);
	}
}