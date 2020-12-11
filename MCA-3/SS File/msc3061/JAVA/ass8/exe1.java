import java.applet.*;
import java.awt.*;
/*<applet code="exe1.java" height=500 width=500>
</applet>*/
public class exe1 extends Applet{
	public void init(){
		System.out.println("Applet Initialized");
	}
	public void start(){
		System.out.println("Applet Started");
	}
	public void paint(Graphics g){
		g.drawString("Hetvee",100,100);
	}
	public void stop(){
		System.out.println("Applet Stopped");
	}
	public void destroy(){
		System.out.println("Applet Destroyed");
	}
	
} 