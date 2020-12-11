import java.applet.*;
import java.awt.*;
//<applet code="exe3.java" height=500 width=500></applet>
public class exe3 extends Applet{
	Color c;
	Font f;
	public void init(){
		f=new Font("ARIAL",Font.BOLD,25);
		setFont(f);
		c=new Color(100,100,100);
	}
	public void paint(Graphics g){
		g.drawString("FONT CLASS",50,50);
		g.drawString("IS ISALIC()::"+f.isItalic(),50,80);
		g.drawString("IS ISBOLD()::"+f.isBold(),50,110);
		g.drawString("IS ISPLAIN()::"+f.isPlain(),50,140);

		g.drawString("COLOR CLASS",50,200);
		g.drawString("GETRED()::"+c.getRed(),50,230);
		g.drawString("GETBLUE()::"+c.getBlue(),50,270);
		g.drawString("GETGREEN()::"+c.getGreen(),50,310);
		g.drawString("GETRGB()::"+c.getRGB(),50,350);
	}

}