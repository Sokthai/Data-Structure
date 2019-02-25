package Assignment4;

public class tester1 {
	public static void main(String[] args){
	
		BinaryTree<String> t = new BinaryTree<>();
	
		
		t.root.setElement("My root");	
		
		t.expandExternal(t.root);
		t.root.leftChild().setElement("Left Child");
		t.root.rightChild().setElement("Right Child");
		
		t.expandExternal(t.root.leftChild());
		
		t.root.leftChild().leftChild().setElement("1");
		t.root.leftChild().rightChild().setElement("2");
		
		

		
		
		t.expandExternal(t.root.rightChild());
		t.root.rightChild().leftChild().setElement("3");
		t.root.rightChild().rightChild().setElement("4");

		t.expandExternal(t.root.rightChild().rightChild());
		t.expandExternal(t.root.rightChild().rightChild().rightChild());
		t.expandExternal(t.root.rightChild().rightChild().rightChild().leftChild());
//		System.out.println(t.depth(t.root.leftChild().leftChild()));
//		System.out.println(t.depthIteration(t.root.leftChild().leftChild()));
		
		System.out.println(t.height(t.root.leftChild().leftChild()));
		System.out.println(t.depth(t.root.rightChild().rightChild().rightChild().leftChild().rightChild()));
//		t.expandExternal(t.root.leftChild().leftChild());
//		t.root.leftChild().leftChild().rightChild().setElement("right extra");
//		t.root.leftChild().leftChild().leftChild().setElement("left extra");
//		
//	
//		
//		t.removeAboveExternal(t.root.leftChild().leftChild().leftChild());
////		t.removeAboveExternal(t.root.leftChild());
//		//System.out.println(t.sibling(t.root.leftChild()));
//		
////		t.swapElements(t.root.rightChild(), t.root.rightChild().rightChild());
////		System.out.println(t.isInternal(t.root.rightChild().leftChild()));
//		t.expandExternal(t.root.rightChild().rightChild());
//		t.expandExternal(t.root.rightChild().rightChild().rightChild());
//		
//		t.removeAboveExternal(t.root.rightChild().rightChild().rightChild().rightChild());
//		
//		
//		
//		
//		//t.inOrder(t.root);
//		
//		System.out.println(t);
		
	
		//System.out.println("size is " + t.size());
		
//		System.out.print(t.parentheticRepresentation(t, t.root));
		
		
//=============================================================================================================================		
//		BinaryTree<String> b = new BinaryTree<>();
//		b.expandExternal(b.root);
//		b.root.setElement("This is root");
//		b.root.leftChild().setElement("This is left child==>>>>>>>>>>");
//		b.root.rightChild().setElement("This is right child==<<<<<<<<");
//		
//		for (String s : b){
//			System.out.println(s);
//		}
//=============================================================================================================================		
		
		//=============================================================================
		//=============================================================================
		//=============================================================================
/**
		BinaryTree<String> b = new BinaryTree<>();
		BTNode<String> root = new BTNode<>();
		b.root = root;
		b.root.setElement("-");
		b.expandExternal(b.root);
		
		b.root.leftChild().setElement("/");
		b.root.rightChild().setElement("+");
		
		b.expandExternal(b.root.leftChild());
		b.root.leftChild().leftChild().setElement("x");
		b.root.leftChild().rightChild().setElement("+");
		
		b.expandExternal(b.root.leftChild().leftChild());
		b.root.leftChild().leftChild().leftChild().setElement("+");
		b.root.leftChild().leftChild().rightChild().setElement("3");
		
		b.expandExternal(b.root.leftChild().rightChild());
		b.root.leftChild().rightChild().leftChild().setElement("-");
		b.root.leftChild().rightChild().rightChild().setElement("2");
		
		b.expandExternal(b.root.leftChild().leftChild().leftChild());
		b.root.leftChild().leftChild().leftChild().leftChild().setElement("3");
		b.root.leftChild().leftChild().leftChild().rightChild().setElement("1");
		
		b.expandExternal(b.root.leftChild().rightChild().leftChild());
		b.root.leftChild().rightChild().leftChild().leftChild().setElement("9");
		b.root.leftChild().rightChild().leftChild().rightChild().setElement("5");
		
		b.expandExternal(b.root.rightChild());
		b.root.rightChild().leftChild().setElement("x");
		b.root.rightChild().rightChild().setElement("6");
		
		b.expandExternal(b.root.rightChild().leftChild());
		b.root.rightChild().leftChild().leftChild().setElement("3");
		b.root.rightChild().leftChild().rightChild().setElement("-");
		
		b.expandExternal(b.root.rightChild().leftChild().rightChild());
		b.root.rightChild().leftChild().rightChild().leftChild().setElement("7");
		b.root.rightChild().leftChild().rightChild().rightChild().setElement("4");
		
		
		System.out.println(b);
		System.out.print(b.parentheticRepresentation(b, b.root));
		System.out.println();
		System.out.println(b.size());
**/
	}
	
	
}
