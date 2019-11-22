/*


*/

import framebuffer.FrameBuffer;

import java.awt.Color;

/**


*/
public class Hw_1
{
   public static void main(String[] args)
   {
      // Check for a file name on the command line.
     /* if ( 0 == args.length )
      {
         System.err.println("Usage: java Hw_1 <PPM-file-name>");
         System.exit(-1);
      }

      // This framebuffer holds the image that will be embedded
      // within a viewport of our larger framebuffer.
      FrameBuffer fbEmbedded = new FrameBuffer( args[0] );

      /******************************************/

      // Your code goes here.
      // Create a framebuffer. Fill it with the checkerboard pattern.
      FrameBuffer frame = new FrameBuffer(1000,600);
      Color checker1 = new Color(255,189,96);
      Color checker2 = new Color(192,56,14);
      boolean alternate = true;
      FrameBuffer.Viewport square = frame.new Viewport();
      for (int i = 0; i < 1000; i += 100)
      {
        for (int j = 0; j < 600; j += 100)
        {
          square = frame.new Viewport(i, j, 100, 100);
          if (alternate == true)
            square.clearVP(checker1);
          else
            square.clearVP(checker2);
          alternate = !alternate;
        }
        alternate = !alternate;
      }
      // Create a viewport to hold the given PPM file. Put the PPM file in the viewport.
      square = frame.new Viewport(75, 125, "RebelTrooper.ppm");
      // Create another viewport and fill it with a flipped copy of the PPM file.
      FrameBuffer flip = new FrameBuffer("RebelTrooper.ppm");
      FrameBuffer.Viewport vpFlip = flip.new Viewport(0, 0, flip);
      int ppmH =  vpFlip.getHeight();
      int ppmW = vpFlip.getWidth();
      for (int i = 0; i < ppmH ; ++i)
      {
        for (int j = 0; j < ppmW ; ++j)
        {
          flip.setPixelFB(j, i, flip.getPixelFB(ppmW - 1 - j,i));
        }
      }
      square = frame.new Viewport(75 + ppmW, 125, flip);
      // Create another viewport and fill it with the striped pattern.
      int stripesW = 300;
      int stripesH = 120;
      Color[] colors = new Color[3];
      colors[0] = new Color(240, 95, 116);//pink
      colors[1] = new Color(152, 203, 74);//green
      colors[2] = new Color(84, 129, 230);//blue
      int inc = 0;
      FrameBuffer stripes = new FrameBuffer(stripesW, stripesH);
      for (int i = 0; i < stripesW; ++i)
      {
        for (int j = 0; j < stripesH; ++j )
        {
          
      
      // Create another viewport that covers the selected region of the framebuffer.
      
      // Create another viewport to hold a copy of the selected region.
      
      // Give this viewport a grayish background color.
      
      // Create another viewport inside the last one.
      
      // Copy the selected region's viewport into this last viewport.
      

      FrameBuffer fb = frame;


      /******************************************/
      // Save the resulting image in a file.
      String savedFileName = "Hw_1.ppm";
      fb.dumpFB2File( savedFileName );
      System.err.println("Saved " + savedFileName);
   }
}
