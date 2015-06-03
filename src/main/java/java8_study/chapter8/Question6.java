package java8_study.chapter8;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.Arrays;
import java.util.Comparator;

public class Question6 {
	public static void main(String[] args){
		
		Point2D[] points = new Point2D[5];
		points[0] = new Point(3,4);
		points[1] = new Point(3,3);
		points[2] = new Point(1,6);
		points[3] = new Point(4,3);
		points[4] = new Point(3,3);
		Arrays.sort(points, Comparator.comparing(Point2D::getX).thenComparing(Point2D::getY));
		for(int i=0; i < points.length; i++){
			System.out.println("x=" + Double.toString(points[i].getX()) + ",y=" + Double.toString(points[i].getY()) );
		}
		
		
		Rectangle2D[] recs = new Rectangle2D[5];
		recs[0] = new Rectangle(3,4,1,2);
		recs[1] = new Rectangle(3,3,2,1);
		recs[2] = new Rectangle(1,6,1,2);
		recs[3] = new Rectangle(4,3,1,2);
		recs[4] = new Rectangle(3,3,1,2);
		Arrays.sort(recs,
				Comparator.comparing(Rectangle2D::getX).thenComparing(Rectangle2D::getY).thenComparing(Rectangle2D::getHeight).thenComparing(Rectangle2D::getWidth));
		for(int i=0; i < recs.length; i++){
			System.out.println(
					"x=" + Double.toString(recs[i].getX()) + 
					",y=" + Double.toString(recs[i].getY()) +
					",h=" + Double.toString(recs[i].getHeight()) +
					",w=" + Double.toString(recs[i].getWidth())
					);
		}
		

    }
	
}
