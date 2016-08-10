/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OopBasics;

/**
 *
 * @author Plankton
 */
public class CircleTest {

    public static void main(String ar[]) {
        Circle c1 = new Circle();
        System.out.println("The circle has radius of " + c1.getRadius()
                + " units and area of " + c1.getArea() + " square units.");
        Circle c2 = new Circle(2.0);
        System.out.println("The circle has radius of " + c2.getRadius()
                + " units and area of " + c2.getArea() + " square units.");
    }
}
