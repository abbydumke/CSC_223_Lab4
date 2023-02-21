package input.components.point;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class PointNodeDatabase 
{

	protected Set <PointNode> _points;

	public PointNodeDatabase(){ _points = new LinkedHashSet<PointNode>(); }
	
	public PointNodeDatabase(List<PointNode> list) { _points = new LinkedHashSet<PointNode>(list); }
	
	public void put(PointNode node)
	{
		_points.add(node);
	}
	
	public boolean contains(PointNode node)
	{
		return _points.contains(node);
	}
	
	public boolean contains(double x, double y)
	{
		return _points.contains(new PointNode(x, y));
	}
	
	public String getName(PointNode node)
	{
		return node.getName();
	}
	
	public String getName(double x, double y)
	{
		for(PointNode point: _points)
		{
			if(point.equals(new PointNode(x, y))) return point.getName();
		}
		
		return null;
	}
	
	public PointNode getPoint(PointNode node)
	{
		for(PointNode point: _points)
		{
			if(point.equals(node)) return point;
		}
		
		return null;
	}
	
	public PointNode getPoint(double x, double y)
	{
		for(PointNode point: _points)
		{
			if(point.equals(new PointNode(x, y))) return point;
		}
		
		return null;
	}
}
