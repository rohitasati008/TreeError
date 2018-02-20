import java.util.HashSet;

public class ServiceImpl implements Service {

	static   HashSet<Character> h = new HashSet<>();
	@Override
	public boolean duplicateError(Graph g) {
		// TODO Auto-generated method stub
		for(int i = 0 ; i< g.V;i++)
		{
			HashSet<Character> h = new HashSet<>();
			for(char k :g.adjListArray[i] )
			{
			boolean b = 	h.add(k);
			if(b==false)
				return false ;
			}
		}
		return true;
	}

	@Override
	public boolean cycleError(Graph g) {
		// TODO Auto-generated method stub
		h.clear();
		if(checkCycle(g,'A'))
			return true ;
		else
		return false;
	}

	private boolean checkCycle(Graph g, char c) {
		// TODO Auto-generated method stub
		h.add(c);
		boolean b = true ;
		for(char k : g.adjListArray[c-'A'])
		{
			if(h.contains(k))
				return false ;
		 b = b &&	checkCycle(g, k);
		 
		}
		return b;
	}

	@Override
	public boolean moreNOdeError(Graph g) {
		// TODO Auto-generated method stub
		for(int i = 0 ; i< g.V;i++)
		{
	 
			 if(g.adjListArray[i].size()>2)
				 return false ;
		}
	 return true;
	}

	@Override
	public boolean multipleroot(Graph g) {
		// TODO Auto-generated method stub
		h.clear();
		trverseFromRoot(g,'A');
		for(int i =0  ;i< g.V ;i++)
		{
			for(char c : g.adjListArray[i])
			{
				if(!h.contains(c))
					return false;
			}
		}
		return true;
	}

	private void trverseFromRoot(Graph g, char c) {
		// TODO Auto-generated method stub
		boolean b = true ;
		for(char k : g.adjListArray[c-'A'])
		{
	         
	         checkParentno(g, c);
			
	        }
		 h.add(c);
		}
		
	 
		
	
	

	@Override
	public boolean multipleParent(Graph g) {
		// TODO Auto-generated method stub
		h.clear();
		if(checkParentno(g,'A'))
			return true ;
		
		return false;
	}

	private static boolean checkParentno(Graph g,char v) {
		// TODO Auto-generated method stub
  boolean b = true ;
		for(char c : g.adjListArray[v-'A'])
		{
	        if(!h.contains(c))
	        {
			 b = b && checkParentno(g, c);
			
	        }
	        else return false;
		}
		 h.add(v);
		return b;
		
	}

}
