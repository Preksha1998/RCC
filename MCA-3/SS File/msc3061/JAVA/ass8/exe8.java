import java.applet.*;
import java.awt.*;

/*<applet code="exe8.java" height=1000 width=1000>
</applet>*/
public class exe8 extends Applet{
	public void init(){
		setBackground(Color.pink);
	}
	public void paint(Graphics g){
		g.drawRoundRect(50,100,400,250,30,30);	
		g.drawRoundRect(50,400,250,250,30,30);	

	}
}