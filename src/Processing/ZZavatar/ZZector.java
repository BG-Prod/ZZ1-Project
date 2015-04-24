import processing.core.*;

class ZZector extends PVector {
    protected PVector origin;
    
    public ZZector() {
      this(0, 0, 0);
    }

    public ZZector(float x, float y) {
      this(x, y, 0);
    }
    
    public ZZector(float x, float y, float z) {
      super(x, y, z);
      origin = new PVector(x, y, z);
    }
    
    public ZZector(PVector v) {
      this(v.x, v.y, v.z);
    }
    
    public void reset() {
      this.set(origin.array());
    }
    
    public void rotate(float theta, float phi) {
		/***************************************************************
		 * 
    	 *	Rotation de vector selon 2 angles
		 * 
		 ***************************************************************/
    	
    	rotate(theta, phi, 0);
    }
    
    public void rotate(float theta, float phi, float epsilon) {
		/***************************************************************
		 * 
    	 *	Rotation de vector selon 3 angles
		 * 
		 ***************************************************************/
    	
    	float tmp;
    	
        //Rotation selon theta (axe x)
    	tmp = x;
        x = x*PApplet.cos(theta) - y*PApplet.sin(theta);
        y = tmp*PApplet.sin(theta) + y*PApplet.cos(theta);
        
        //Rotation selon phi (axe z)
        tmp = x;
        x = x*PApplet.cos(phi) - z*PApplet.sin(phi);
        z = tmp*PApplet.sin(phi) + z*PApplet.cos(phi);
        
        //Rotation selon epsilon (axe y)
        tmp = y; 
		y = y*PApplet.cos(epsilon) - z*PApplet.sin(epsilon);
        z = tmp*PApplet.sin(epsilon) + z*PApplet.cos(epsilon);
    }

    public void rotateAround(PVector center, float theta, float phi, float epsilon) {
		/***************************************************************
		 * 
		 *  rotation autour d'un point dans un espace 3D
		 * 
		 ***************************************************************/
		
		this.sub(center);
		rotate(theta, phi, epsilon);
		this.add(center);
    }
    
    public void rotateAround(PVector center, float theta, float phi) {
		/***************************************************************
		 * 
		 *  rotation autour d'un point dans un espace 3D
		 * 
		 ***************************************************************/
		
		this.sub(center);
		rotate(theta, phi);
		this.add(center);
    }
    
    public void rotateAround(PVector center, float theta) {
      /***************************************************************
       * 
       *  rotation autour d'un point dans un espace 3D
       * 
       ***************************************************************/
      
      rotateAround(center, theta, 0);
    }
}