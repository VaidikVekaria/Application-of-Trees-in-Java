package tests;
import model.TreeUtilities;

import static org.junit.Assert.*;
import org.junit.Test;
import model.TreeUtilities;



@SuppressWarnings("unused")
public class StarterTests {
	he exceptions (library methods which you are allowed to use if needed):
	 * 		- String class (equals, format, length, charAt)
	
	
	@Test 
	public void test_getElementsOfRanks_1() {
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
		
		/*
		 * Hint: Visualize the tree constructed from the above nodes.
		 */
		
		TreeUtilities u = new TreeUtilities();
		
		/*
		 * Input:
		 * 	+ The root node `n` of some general tree (see the TreeNode class) storing integers.
		 * 	+ An integer `i` denoting some lower bound.
		 * 	+ An integer `j` denoting some upper bound.
		 * Assumptions:
		 * 	1. Input `n` is not null.
		 *  2. The organization of nodes in the input tree rooted at `n` is arbitrary: 
		 *  	no ordering among child node elements can be assumed.
		 * 	3. Input `i` is larger than or equal to 1.
		 * 	4. Input `j` is less than or equal to the size of the tree rooted at `n`.
		 * 	5. i <= j
		 * Output:
		 * 	Return the head node (see the SLLNode class) of a sorted list enumerating
		 * 		from the (i)th smallest value to the (j)th smallest value in the input tree rooted at `n`.    
		 */
		SLLNode<Integer> output = u.getElementsOfRanks(n2, 1, 1);
		assertTrue(output.getElement() == 23);
		assertNull(output.getNext());
		
		output = u.getElementsOfRanks(n2, 4, 4);
		assertTrue(output.getElement() == 92);
		assertNull(output.getNext());
		
		output = u.getElementsOfRanks(n2, 7, 7);
		assertTrue(output.getElement() == 161);
		assertNull(output.getNext());
	}
	
	@Test 
	public void test_getElementsOfRanks_2() {
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
		
		TreeUtilities u = new TreeUtilities();
		
		SLLNode<Integer> output = u.getElementsOfRanks(n2, 1, 2);
		assertTrue(output.getElement() == 23);
		assertTrue(output.getNext().getElement() == 46);
		assertNull(output.getNext().getNext());
		
		output = u.getElementsOfRanks(n2, 4, 5);
		assertTrue(output.getElement() == 92);
		assertTrue(output.getNext().getElement() == 115);
		assertNull(output.getNext().getNext());
		
		output = u.getElementsOfRanks(n2, 6, 7);
		assertTrue(output.getElement() == 138);
		assertTrue(output.getNext().getElement() == 161);
		assertNull(output.getNext().getNext());
	}
	
	@Test 
	public void test_getElementsOfRanks_3() {
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
		
		TreeUtilities u = new TreeUtilities();
		
		SLLNode<Integer> output = u.getElementsOfRanks(n2, 1, 3);
		assertTrue(output.getElement() == 23);
		assertTrue(output.getNext().getElement() == 46);
		assertTrue(output.getNext().getNext().getElement() == 69);
		assertNull(output.getNext().getNext().getNext());
		
		output = u.getElementsOfRanks(n2, 3, 5);
		assertTrue(output.getElement() == 69);
		assertTrue(output.getNext().getElement() == 92);
		assertTrue(output.getNext().getNext().getElement() == 115);
		assertNull(output.getNext().getNext().getNext());
		
		output = u.getElementsOfRanks(n2, 5, 7);
		assertTrue(output.getElement() == 115);
		assertTrue(output.getNext().getElement() == 138);
		assertTrue(output.getNext().getNext().getElement() == 161);
		assertNull(output.getNext().getNext().getNext());
	}
	
	@Test 
	public void test_getElementsOfRanks_4() {
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
		
		TreeUtilities u = new TreeUtilities();
		
		SLLNode<Integer> output = u.getElementsOfRanks(n2, 1, 7);
		assertTrue(output.getElement() == 23);
		assertTrue(output.getNext().getElement() == 46);
		assertTrue(output.getNext().getNext().getElement() == 69);
		assertTrue(output.getNext().getNext().getNext().getElement() == 92);
		assertTrue(output.getNext().getNext().getNext().getNext().getElement() == 115);
		assertTrue(output.getNext().getNext().getNext().getNext().getNext().getElement() == 138);
		assertTrue(output.getNext().getNext().getNext().getNext().getNext().getNext().getElement() == 161);
		assertNull(output.getNext().getNext().getNext().getNext().getNext().getNext().getNext());
	}
	
	/*
	 * Jackie's suggestions: 
	 * 	+ Try more test cases with trees of different shapes.
	 * 	+ Try more test cases with different combinations of lower and upper bounds. 
	 */
	
	/*
	 * Tests related to getStats
	 */
	
	@Test 
	public void test_getStats_1() {
		TreeNode<Integer> n1 = new TreeNode<>(23);
		TreeNode<Integer> n2 = new TreeNode<>(46);  
		TreeNode<Integer> n5 = new TreeNode<>(115); 
		TreeNode<Integer> n7 = new TreeNode<>(161);
		
		n2.addChild(n1); n1.setParent(n2);
		n2.addChild(n5); n5.setParent(n2);
		n2.addChild(n7); n7.setParent(n2); 
		
		
		TreeUtilities u = new TreeUtilities();
		
		
		TreeNode<String> output = u.getStats(n2);
		assertNull(output.getParent());
		assertEquals("Number of descendants: 4; Sum of descendants: 345", output.getElement());
		
		SLLNode<TreeNode<String>> levelOne = output.getChildren();
		TreeNode<String> levelOneChild0 = levelOne.getElement();
		TreeNode<String> levelOneChild1 = levelOne.getNext().getElement();
		TreeNode<String> levelOneChild2 = levelOne.getNext().getNext().getElement();
		assertNull(levelOne.getNext().getNext().getNext());
		
		/* child 0 */
		assertTrue(output == levelOneChild0.getParent());
		assertEquals("Number of descendants: 1; Sum of descendants: 23", levelOneChild0.getElement());
		/* child 1 */
		assertTrue(output == levelOneChild1.getParent());
		assertEquals("Number of descendants: 1; Sum of descendants: 115", levelOneChild1.getElement());
		/* child 2 */
		assertTrue(output == levelOneChild2.getParent());
		assertEquals("Number of descendants: 1; Sum of descendants: 161", levelOneChild2.getElement());
		
		/*
		 * Hint: Visualize the tree constructed from the above nodes storing strings.
		 * 			How does this string tree correspond to the input integer tree?
		 */
	}
	
	@Test 
	public void test_getStats_2() {
		TreeNode<Integer> n1 = new TreeNode<>(23);   
		
		TreeUtilities u = new TreeUtilities(); 
		
		TreeNode<String> output = u.getStats(n1);
		assertNull(output.getParent());
		assertNull(output.getChildren());
		assertEquals("Number of descendants: 1; Sum of descendants: 23", output.getElement());
	}
	
	@Test 
	public void test_getStats_3() {
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
		
		/*
		 * Hint: Visualize the tree constructed from the above nodes storing integers.
		 */
		
		TreeUtilities u = new TreeUtilities();
		
		/*
		 * See Section 2.3 (page 7) of the instructions PDF.
		 */
		 
		TreeNode<String> output = u.getStats(n2);
		assertNull(output.getParent());
		assertEquals("Number of descendants: 7; Sum of descendants: 644", output.getElement());
		
		SLLNode<TreeNode<String>> levelOne = output.getChildren();
		TreeNode<String> levelOneChild0 = levelOne.getElement();
		TreeNode<String> levelOneChild1 = levelOne.getNext().getElement();
		TreeNode<String> levelOneChild2 = levelOne.getNext().getNext().getElement();
		assertNull(levelOne.getNext().getNext().getNext());
		
		/* child 0 */
		assertTrue(output == levelOneChild0.getParent());
		assertEquals("Number of descendants: 3; Sum of descendants: 184", levelOneChild0.getElement());
		/* child 1 */
		assertTrue(output == levelOneChild1.getParent());
		assertEquals("Number of descendants: 2; Sum of descendants: 253", levelOneChild1.getElement());
		/* child 2 */
		assertTrue(output == levelOneChild2.getParent());
		assertEquals("Number of descendants: 1; Sum of descendants: 161", levelOneChild2.getElement());
		
		SLLNode<TreeNode<String>> levelTwo = levelOneChild0.getChildren();
		TreeNode<String> levelTwoChild0 = levelTwo.getElement();
		TreeNode<String> levelTwoChild1 = levelTwo.getNext().getElement();
		assertNull(levelTwo.getNext().getNext());
		
		levelTwo = levelOneChild1.getChildren();
		TreeNode<String> levelTwoChild2 = levelTwo.getElement();
		assertNull(levelTwo.getNext());
		
		/* child 0 */
		assertTrue(levelOneChild0 == levelTwoChild0.getParent());
		assertEquals("Number of descendants: 1; Sum of descendants: 92", levelTwoChild0.getElement());
		/* child 1 */
		assertTrue(levelOneChild0 == levelTwoChild1.getParent());
		assertEquals("Number of descendants: 1; Sum of descendants: 69", levelTwoChild1.getElement());
		/* child 2 */
		assertTrue(levelOneChild1 == levelTwoChild2.getParent());
		assertEquals("Number of descendants: 1; Sum of descendants: 138", levelTwoChild2.getElement());
		
	}
	
}
