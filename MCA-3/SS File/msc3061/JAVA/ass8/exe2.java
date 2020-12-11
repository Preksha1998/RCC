import java.applet.*;
import java.awt.*;
import java.net.*;
/*<applet code="exe2.java" height=500 width=500>
</applet>*/
public class exe2 extends Applet{
	public void init(){
		setBackground(Color.pink);
	}
	public void paint(Graphics g){
		String msg;
		URL url=getCodeBase();
		msg="CODEBASE::"+url.toString();
		g.drawString(msg,100,100);

		url=getDocumentBase();
		msg="DOCUMENT BASE::"+url.toString();
		g.drawString(msg,100,200);
	}
}