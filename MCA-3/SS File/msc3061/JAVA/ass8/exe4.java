import java.applet.*;
import java.awt.*;

/*<applet code="exe4.java" height=500 width=500>
</applet>*/
public class exe4 extends Applet{
	public void init(){
		setBackground(Color.pink);
	}
	public void paint(Graphics g){
		g.setColor(Color.red);
		g.drawString("HELLO WORLD",100,200);

		g.setColor(Color.green);
		g.drawString("HELLO WORLD",100,230);

		g.setColor(Color.yellow);
		g.drawString("HELLO WORLD",100,260);

		g.setColor(Color.black);
		g.drawString("HELLO WORLD",100,290);

		g.setColor(Color.white);
		g.drawString("HELLO WORLD",100,320);

		g.setColor(Color.cyan);
		g.drawString("HELLO WORLD",100,350);
	}
}