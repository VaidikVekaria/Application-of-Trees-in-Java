package model;

import tests.SLLNode;
import tests.TreeNode;

public class TreeUtilities {

	public SLLNode<Integer> getElementsOfRanks(TreeNode<Integer> n, int i, int j) {
		
		SLLNode<Integer> toSort = rankHelper(n);
		SLLNode<Integer> sorted = sort(toSort);
		SLLNode<Integer> range = extract(sorted, i, j);
		return range;
	}
	public SLLNode<Integer> extract(SLLNode<Integer> sorted, int i, int j){
		int start = 1;
		while(start < i) {
			sorted = sorted.getNext();
			start++;
		}
		SLLNode<Integer> cut = sorted;
		while(i < j) {
			i++;
			cut = cut.getNext();
		}
		cut.setNext(null);
		return sorted;
	}
	
	public SLLNode<Integer> sort(SLLNode<Integer> n){
		SLLNode<Integer> head = n;
		SLLNode<Integer> sorted = head;
		
		while(head.getNext() != null) {
			int i = head.getElement();
			
			while(n.getNext() != null) {
				if(i > n.getNext().getElement()) {
					int j = n.getNext().getElement();
					n.getNext().setElement(i);
					head.setElement(j);
					i = j;
				}
				n = n.getNext();
			}
			
			head = head.getNext();
			n = head;
		}
		
		return sorted;
	}
	
	public SLLNode<Integer> rankHelper(TreeNode<Integer> n){
		
		SLLNode<TreeNode<Integer>> children = n.getChildren();
		SLLNode<Integer> result = new SLLNode<Integer>(null, null);
		SLLNode<Integer> head = result;
		SLLNode<Integer> toAdd = new SLLNode<Integer>(n.getElement(), null);
		
		if(children == null) {
			SLLNode<Integer> bottom = new SLLNode<Integer>(n.getElement(),null);
			return bottom;
			
		} else {
			//SLLNode<Integer> node;
			while(children != null) {
				result.setNext(rankHelper(children.getElement()));
				result = result.getNext();
				while(result.getNext() != null) {
					result = result.getNext();
				}
				children = children.getNext();
				
			}
			result.setNext(toAdd);
			result = result.getNext();
		}
		return head.getNext();
	}

	public TreeNode<String> getStats(TreeNode<Integer> n) {
		
		//TreeNode<String> Sahajanand = new TreeNode<>("Mara Bhagvan");
		TreeNode<Integer>m = sumHelper(n);
		return getStatsHelper(m);
	}
	
	public TreeNode<String> getStatsHelper(TreeNode<Integer> m){
		SLLNode<TreeNode<Integer>> children = m.getChildren();
		String output;
		TreeNode<String> t0;
		
		if(children == null) {
			output = "Number of descendants: " + String.valueOf(m.getElement()%10) + "; Sum of descendants: " + String.valueOf(m.getElement()/100000);
			t0 = new TreeNode<>(output);
			return t0;
			
		} else {
			t0 = new TreeNode<>("");
			while(children != null){
				TreeNode<String> child = getStatsHelper(children.getElement());
				t0.addChild(child);
				(child).setParent(t0);
				children = children.getNext();
			}
			output = "Number of descendants: " + String.valueOf(m.getElement()%10) + "; Sum of descendants: " + String.valueOf(m.getElement()/100000);
			t0.setElement(output);
			return t0;
		}
	}
	
	public TreeNode<Integer> sumHelper(TreeNode<Integer> n){
		SLLNode<TreeNode<Integer>> children = n.getChildren();
		int sum = n.getElement() * 100000;
		
		if(children == null) {
			n.setElement(sum + 1);
			return n;
		} else {
			while(children != null) {
				sum = sum + sumHelper(children.getElement()).getElement();
				children = children.getNext();
			}
			n.setElement(sum +1);
			return n;
		}
	}
	
	
	public static void main(String[] args) {
		/*
		TreeNode<Integer> n1 = new TreeNode<>(23);
		TreeNode<Integer> n2 = new TreeNode<>(46);
		TreeNode<Integer> n3 = new TreeNode<>(69);
		TreeNode<Integer> n4 = new TreeNode<>(92);
		TreeNode<Integer> n5 = new TreeNode<>(115);
		TreeNode<Integer> n6 = new TreeNode<>(138);
		TreeNode<Integer> n7 = new TreeNode<>(161);
		
		n2.addChild(n1); n1.setParent(n2);
		n2.addChild(n5); n5.setParent(n2);
		n2.addChild(n7); n7.setParent(n2);
		n1.addChild(n4); n4.setParent(n1);
		n1.addChild(n3); n3.setParent(n1);
		n5.addChild(n6); n6.setParent(n5);
		*/
		
		TreeNode<Integer> n1 = new TreeNode<>(23);
		TreeNode<Integer> n2 = new TreeNode<>(46);  
		TreeNode<Integer> n5 = new TreeNode<>(115); 
		TreeNode<Integer> n7 = new TreeNode<>(161);
		
		n2.addChild(n1); n1.setParent(n2);
		n2.addChild(n5); n5.setParent(n2);
		n2.addChild(n7); n7.setParent(n2); 
		
		TreeUtilities u = new TreeUtilities();
		//SLLNode<Integer> result = u.getElementsOfRanks(n2, 0, 0);
		
		//TreeNode<Integer> result = u.sumHelper(n2);
		//SLLNode<TreeNode<Integer>> children = result.getChildren().getNext().getElement().getChildren();
		
		//TreeNode<String> result = u.getStats(n2);
		//SLLNode<TreeNode<String>> children = result.getChildren(); 
		//TreeNode<String> parent = children.getElement().getParent();
		
		//SLLNode<Integer> children = u.getElementsOfRanks(n1, 1,1);
		//System.out.println(children.getElement());
		//System.out.println(children.getNext().getElement());
		//System.out.println(children.getNext().getNext().getElement());
		//System.out.println(children.getNext().getNext().getNext().getElement());
		//System.out.println(children.getNext().getNext().getNext().getNext().getElement());
		//System.out.println(children.getNext().getNext().getNext().getNext().getNext().getElement());
		//System.out.println(children.getNext().getNext().getNext().getNext().getNext().getNext().getElement());
	    //System.out.println(children.getNext().getNext().getNext().getNext().getNext().getNext().getNext().getElement());
		
	}

}
