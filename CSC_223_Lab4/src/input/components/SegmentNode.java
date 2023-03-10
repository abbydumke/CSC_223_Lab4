
import input.components.point.PointNode;

/**
 * A utility class only for representing ONE segment
 */
public class SegmentNode
{
	
	protected PointNode _point1;
	protected PointNode _point2;
	
	public PointNode getPoint1() { return _point1; }
	public PointNode getPoint2() { return _point2; }
	
	public SegmentNode(PointNode pt1, PointNode pt2)
	{
		_point1 = pt1;
		_point2 = pt2;
	}

	@Override
	public boolean equals(Object obj)
	{
		if(obj == null) return false;
		
		if(!(obj instanceof SegmentNode)) return false;
		
		SegmentNode that = (SegmentNode)obj;
		
		if(_point1.equals(that.getPoint1()) && _point2.equals(that.getPoint2())) return true;
		
		if(_point1.equals(that.getPoint2()) && _point2.equals(that.getPoint1())) return true;
			
		return false;
	}

	
	@Override
	public String toString()
	{
		return _point1.toString() + " " + _point2.toString() + "\n";
	}
}

