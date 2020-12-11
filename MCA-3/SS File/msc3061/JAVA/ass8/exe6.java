import java.applet.*;
import java.awt.*;

/*<applet code="exe6.java" height=500 width=500>
</applet>*/
public class exe6 extends Applet{
	public void init(){
		setBackground(Color.pink);
	}
	public void paint(Graphics g){
		Dimension d=this.getSize();
		drawCenteredString("This is centered",d.width,d.height,g);

	}
	public void drawCenteredString(String s,int w,int h,Graphics g){
		FontMetrics fm=g.getFontMetrics();
		int x=(w-fm.stringWidth(s))/2;
		int y=(fm.getAscent()+(h-(fm.getAscent()+fm.getDescent()))/2);
		g.drawString(s,x,y);
	}
}