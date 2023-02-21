package input.components.segment;

import input.components.point.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SegmentNodeDatabase
{
	protected Map<PointNode, Set<PointNode>> _adjLists;
	
	public SegmentNodeDatabase()
	{
		_adjLists = new LinkedHashMap<PointNode, Set<PointNode>>();
		
	}
	
	public SegmentNodeDatabase(Map<PointNode, Set<PointNode>> map)
	{
		_adjLists = new LinkedHashMap<PointNode, Set<PointNode>>(map);
	}

	
	public int numUndirectedEdges()
	{
		int count = 0;
		
		for( Set<PointNode> adjValueList : _adjLists.values())
		{
			count += adjValueList.size();
		}
		
		return count / 2;
	}
	
	private void addDirectedEdge(PointNode p1, PointNode p2)
	{
		// If an adjacency list doesn't exist for a point, make one.
		if(!_adjLists.containsKey(p1)) _adjLists.put(p1, new LinkedHashSet<PointNode>());
			
		// Create a copy of the adjacency list for p1.
		LinkedHashSet<PointNode> adjList = new LinkedHashSet<PointNode>(_adjLists.get(p1));
		 
		// Add the new edge to that adjacency list 
		adjList.add(p2);
		
		// Replace the old adjacency list with the new one.
		_adjLists.put(p1, adjList);
	}
		
	public void addUndirectedEdge(PointNode p1, PointNode p2)
	{
		addDirectedEdge(p1, p2);
		addDirectedEdge(p2, p1);
	}
	
	public void addAdjacencyList(PointNode p, List<PointNode> list)
	{
		LinkedHashSet<PointNode> set = new LinkedHashSet<PointNode>(list);

		for(PointNode p2 : set)
		{
			addUndirectedEdge(p, p2);
		}
		
		_adjLists.put(p, set);
	}
	
	public List<SegmentNode> asSegmentList()
	{
		List<SegmentNode> listSegNodes = new ArrayList<SegmentNode>();
		
		for (PointNode p : _adjLists.keySet())
		{
			for(PointNode p2 : _adjLists.get(p))
			{
				listSegNodes.add(new SegmentNode(p, p2));
			}
		}
		
		return listSegNodes;
	}
	
	public List<SegmentNode> asUniqueSegmentList()
	{
		List<SegmentNode> listSegNodes = new ArrayList<SegmentNode>();
		
		for (PointNode p : _adjLists.keySet())
		{
			for(PointNode p2 : _adjLists.get(p))
			{
				SegmentNode segNode = new SegmentNode(p, p2);
				if(!listSegNodes.contains(segNode)) listSegNodes.add(segNode);
			}
		}
		
		return listSegNodes;
	}
	
}