import java.awt.*;

public class Light extends Component
{
  private Polygon p1, p2;
  private int prevWidth=0, prevHeight=0;
  
  public Light ()
  {
  }
  
  public void paint ( Graphics g )
  {
    if( getWidth () != prevWidth || getHeight () != prevHeight )
    {
      p1 = null;
      prevWidth = getWidth();
      prevHeight = getHeight();
    }
    if( p1 == null )
    {
      int h = getHeight();
      int w = getWidth();
      p1 = new Polygon ();
      
      p1.addPoint ( w/4, h/5 );
      p1.addPoint ( w/3+30, h/2 );
      p1.addPoint ( w/6, h*2/3 );
      
      p2 = new Polygon ();
      
      p2.addPoint ( w/2, h/8 );
      p2.addPoint ( w-w/6, h/2 );
      p2.addPoint ( w/3-30, h/2 );
      
    }
    g.setColor (Color.white);
    g.fillRect (0,0,getWidth (),getHeight ());
    g.setColor (Color.green);
    g.drawLine (0,0,prevWidth,prevHeight);
    g.drawLine (0,prevHeight,prevWidth,0);
    g.setColor (Color.blue);
    g.fillPolygon( p1 );
    g.setColor (Color.orange);
    g.fillPolygon ( p2 );
  }
  
  public static void main ( String[] args )
  {
    java.awt.Frame f = new java.awt.Frame ();
    f.addWindowListener (new java.awt.event.WindowAdapter ()
    {
      public void windowClosing (java.awt.event.WindowEvent evt)
      {
        System.exit (0);
      }
    });
    f.add ( new Light () );
    f.pack ();
    f.setVisible (true);
    f.repaint();
  }
  
  public Dimension getPreferredSize ()
  {
    final Dimension dim = new Dimension (200,200);
    return dim;
  }
  public Dimension getMinimumSize ()
  {
    final Dimension dim = new Dimension (20,20);
    return dim;
  }
  
}
