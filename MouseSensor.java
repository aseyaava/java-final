package aywon;


import java.awt.*;
import java.awt.event.*;
class MouseSensor extends MouseAdapter
{
public void mousePressed(MouseEvent m)
{
System.out.println("Mouse is being pressed at X= "+m.getX()+", Y= "+m.getY());
}
/*public void mouseMoved(MouseEvent m){
System.out.print("X= "+m.getX()+", Y= "+m.getY());
System.out.println("  moved");
}*/

public void mouseDragged(MouseEvent m){
if(m.getX()<500&&m.getY()<500&&m.getX()>0&&m.getY()>0)
{System.out.print("X= "+m.getX()+", Y= "+m.getY());
System.out.println("  dragged");}

}

//mouseMoved - getX(), getY()
//mouseDragged
}
