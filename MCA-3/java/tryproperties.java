import java.util.*;
public class tryproperties{
	public static void main(String args[])
	{
		Properties properties = System.getProperties();
		properties.list(System.out);
	}
}