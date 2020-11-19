/*

3.Write an application that defines a Circle class with two constructors .The first form accepts a
double value that represents the radius of the circle .This constructor assumes that the circle is
centered at origin .The second form accepts three double values .The first two arguments defines
the coordinates of the center and the third argument defines the radius .Create 10 objects of the
Circle type and save them in the array. Randomly select a radius between 1 and 10 cm for each circle
created .After all circles have been created display each circle and total area of all circles.

*/

class circle
{	
	double area;
	public static int totalarea=0;
	
	circle(double radius)
	{
		area=3.14*radius*radius;
		System.out.println("Area = " + Math.round(area));
		totalarea+=area;
	}
	
	circle(double x,double y,double radius)
	{
		
		
		area=(3.14*radius*radius);
		System.out.println("Area for Origin(" + Math.round(x) + "," + Math.round(y) + ") = " + Math.round(area));
		totalarea+=area;
	}
}

class a2_p3
{
	public static void main(String[] args)
	{
		circle[] cir=new circle[10];
		
		for(int i=0; i<5; i++)
		cir[i]=new circle(((Math.random()*10)+1));
	
		System.out.println();
	
		for(int i=5; i<10; i++)
		cir[i]=new circle(((Math.random()*10)+1),((Math.random()*10)+1),((Math.random()*10)+1));
	
		System.out.println();
	
		System.out.println("Total Area is: " + cir[0].totalarea);
	}
}

/*
Output:-

D:\MCA-III\java Assignment2>java a2_p3
Area = 167
Area = 134
Area = 325
Area = 74
Area = 25

Area for Origin(8,5) = 38
Area for Origin(4,4) = 86
Area for Origin(9,4) = 176
Area for Origin(6,4) = 31
Area for Origin(6,5) = 76

Total Area is: 1127

*/