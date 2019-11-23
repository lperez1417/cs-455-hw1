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
      int stripesW = 300;
      int stripesH = 120;
      Color white = new Color(255, 255, 255);
      Color[] colors = new Color[3];
      colors[0] = new Color(152, 203, 74);//green
      colors[1] = new Color(84, 129, 230);//blue
      colors[2] = new Color(241, 95, 116);//pink
      int inc = 0;
      int q,r;
      FrameBuffer stripes = new FrameBuffer(stripesW, stripesH);
      for (int k = 0; k <= 9; ++k)
      {
        if (inc == colors.length)
          inc = 0;
        for (int i = 0; i <= 30; ++i)
        {
          q = 0;
          for (int j = 119; j >= 0; --j)
          {
            r = q + i + (30*k);
            if (r == 300)
              break;
            stripes.setPixelFB(r, j, colors[inc]);
            q++;
          }
        }
        inc++;
      }
      FrameBuffer.Viewport copy = stripes.new Viewport(180, 0, 120, 120);
      FrameBuffer.Viewport stripesFull = stripes.new Viewport(0, 0, copy);
      square = frame.new Viewport(610, 420, stripes);
      
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
