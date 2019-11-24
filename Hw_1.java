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
     /*if ( 0 == args.length )
      {
         System.err.println("Usage: java Hw_1 <PPM-file-name>");
         System.exit(-1);
      }

      // This framebuffer holds the image that will be embedded
      // within a viewport of our larger framebuffer.
      //FrameBuffer fbEmbedded = new FrameBuffer( args[0] );

      /******************************************/

      // Your code goes here.
      // Create a framebuffer. Fill it with the checkerboard pattern.
      FrameBuffer frame = new FrameBuffer(1000,600);
      Color checker1 = new Color(255,189,96);
      Color checker2 = new Color(192,56,14);
      boolean alternate = true;
      FrameBuffer.Viewport vp = frame.new Viewport();
      for (int i = 0; i < 1000; i += 100)
      {
        for (int j = 0; j < 600; j += 100)
        {
          vp = frame.new Viewport(i, j, 100, 100);
          if (alternate == true)
            vp.clearVP(checker1);
          else
            vp.clearVP(checker2);
          alternate = !alternate;
        }
        alternate = !alternate;
      }
      // Create a viewport to hold the given PPM file. Put the PPM file in the viewport.
      FrameBuffer trooper = new FrameBuffer("RebelTrooper.ppm");
      vp = frame.new Viewport(75, 125, trooper);
      
      // Create another viewport and fill it with a flipped copy of the PPM file.
      FrameBuffer.Viewport vpTrooper = trooper.new Viewport(0, 0, trooper);
      int ppmH =  vpTrooper.getHeight();
      int ppmW = vpTrooper.getWidth();
      FrameBuffer flipped = new FrameBuffer(ppmW, ppmH);
      for (int i = 0; i < ppmH ; ++i)
      {
        for (int j = 0; j < ppmW ; ++j)
        {
          flipped.setPixelFB(j, i, trooper.getPixelFB(ppmW - 1 - j,i));
        }
      }
      vp = frame.new Viewport(75 + ppmW, 125, flipped);
      
      // Create another viewport and fill it with the striped pattern.
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
      vp = frame.new Viewport(610, 420, stripes);
      
      // Create another viewport that covers the selected region of the framebuffer.
      vp = frame.new Viewport(500, 200, 200, 300);
      FrameBuffer fbCopy = vp.convertVP2FB();
      
      // Create another viewport to hold a copy of the selected region.
      vp = frame.new Viewport(725, 25, 250, 350);
      
      // Give this viewport a grayish background color.
      Color gray = new Color(192, 192, 192);
      vp.clearVP(gray);
      
      // Create another viewport inside the last one.
      vp = frame.new Viewport(750, 50, fbCopy);
      
      // Copy the selected region's viewport into this last viewport.
      

      FrameBuffer fb = frame;


      /******************************************/
      // Save the resulting image in a file.
      String savedFileName = "Hw_1.ppm";
      fb.dumpFB2File( savedFileName );
      System.err.println("Saved " + savedFileName);
   }
   
}



