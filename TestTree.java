import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestTree {
 Service s = new ServiceImpl();
  


public static void main(String[] args) {
	TestTree t = new TestTree();
	Graph g_duplicateCheck  = new Graph(5);
	g_duplicateCheck.addEdge(g_duplicateCheck,'A','B');
	g_duplicateCheck.addEdge(g_duplicateCheck,'A','C');
	g_duplicateCheck.addEdge(g_duplicateCheck,'C','M');
//	g_duplicateCheck(g,'C','M');
	
	if(t.s.duplicateError(g_duplicateCheck))
		System.out.println("pass in duplicate Check");
	else
		System.out.println("E2");
	Graph g_cycle = new Graph(5);
	g_cycle.addEdge(g_cycle, 'A', 'B');
	g_cycle.addEdge(g_cycle, 'B', 'C');
	g_cycle.addEdge(g_cycle, 'C', 'A');
	if(t.s.cycleError(g_cycle))
		System.out.println("pass in Cycle");
	else
		System.out.println("E3");
	Graph parent = new Graph(5);
	parent.addEdge(parent, 'A', 'B');
	parent.addEdge(parent, 'B', 'C');
	parent.addEdge(parent, 'A', 'C');
	if(t.s.multipleParent(parent))
	System.out.println("pass in mulitple parent");
	else System.out.println("E5");
	Graph multipleroot = new Graph(5);
	multipleroot.addEdge(multipleroot, 'A', 'B');
	multipleroot.addEdge(multipleroot, 'B', 'D');
//	multipleroot.addEdge(multipleroot, 'M', 'N');
	if(t.s.multipleroot(multipleroot))
	System.out.println("pass in mulitple root");
	else System.out.println("E4");
}
}
