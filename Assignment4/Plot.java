import java.util.ArrayList;

public class Plot {
	private int x, y, depth, width;
	
	
	public Plot(int x, int y, int width, int depth) {
		this.x = x;
		this.y = y;
		this.depth = depth;
		this.width = width;
	}
	
	public Plot() {
		x = 0;
		y = 0;
		depth = 1;
		width = 1;
	}
	public Plot(Plot otherPlot) {
		this.x = otherPlot.x;
		this.y = otherPlot.y;
		this.depth = otherPlot.depth;
		this.width = otherPlot.width;
	}
	// all accessor methods for x & y coordinates, as well as depth and width 
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getDepth() {
		return depth;
	}
	public int getWidth() {
		return width;
	}
	
	// all mutator methods for x & y coordinates, as well as depth and width
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	
	public boolean overlaps(Plot plot) {
		int plotYCorner = (plot.y+plot.depth), plotXCorner = (plot.x+plot.width);
		int yCorner = (this.y+this.depth), xCorner = (x+width);
		if(xCorner <= plot.x || plotXCorner <= x) {
			return false;
		}
		if(yCorner <= plot.y || plotYCorner <= y) {
			return false;
		}
		return true;
		
	}
	public boolean encomapsses() {
		if(x+width > 10 || y+depth > 10 || x+width < 0 || y+depth < 0) {
			return true;
		}
		return false;
	}
	@Override
	public String toString() {
		return(x+","+y+","+width+","+depth);
	}
	

}


