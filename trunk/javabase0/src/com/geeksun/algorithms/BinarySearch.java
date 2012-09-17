package com.geeksun.algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * @author geeksun
 * 二叉搜索树
 */
public class BinarySearch {

	public static void main(String[] args) throws IOException {
		int value;
		Tree binaryTree = new Tree();

		binaryTree.insert(10, 1.8);
		binaryTree.insert(12, 3.3);
		binaryTree.insert(13, 4.8);

		while (true) {
			System.out
					.println("Enter first letter or show:insert,find,delete or traverse");
			char choice = getChar();

			switch (choice) {
			case 's':
				binaryTree.displayTree();
				break;
			case 'i':
				System.out.println("Enter value to insert: ");
				value = getInt();
				binaryTree.insert(value, value + 0.9);
				break;
			case 'f':
				System.out.println("Enter value to find: ");
				value = getInt();
				Node found = binaryTree.find(value);
				if (found != null) {
					System.out.println("Found: ");
					found.displayNode();
					System.out.println("\n");
				} else
					System.out.println("Could not find");
				System.out.println(value + '\n');
				break;
			case 'd':
				System.out.println("Enter value to delete: ");
				value = getInt();
				boolean didDelete = binaryTree.delete(value);
				if (didDelete)
					System.out.println("Deleted " + value + '\n');
				else
					System.out.println("Could not delete " + value + '\n');
				break;
			case 't':
				System.out.println("Enter tyupe 1,2,3: ");
				value = getInt();
				binaryTree.traverse(value);
				break;
			default:
				System.out.println("Invalid entry");
			}
		}
	}

	public static String getString() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}

	public static char getChar() throws IOException {
		String s = getString();
		return s.charAt(0);
	}

	public static int getInt() throws IOException {
		String s = getString();
		return Integer.parseInt(s);
	}
}

/**
 * @author Administrator
 * 节点类:包含数据,数据代表要存储的内容,还有指向节点的两个子节点的引用
 */
class Node {
	public int iData; //  data item(key)
	public double dData; //  data imtm
	public Node leftChild;
	public Node rightChild;

	public void displayNode() { //  display ourself
		System.out.println("{" + iData + "," + dData + "}");
	}

}

class Tree {
	private Node root; //  first node of tree

	public Tree() {
		root = null;
	}

	/**
	 * @param key:关健字,要找的值:查找从根开始
	 * @return 包含关健字的节点
	 *  current 正在查看的节点
	 */
	public Node find(int key) {
		Node current = root; //  from root begin search
		while (current.iData != key) {
			if (key < current.iData) //  key 小于 current 的值时, current设为此节点的左子节点
				current = current.leftChild;
			else
				current = current.rightChild;
			if (current == null) //  没有子节点时,即已经查遍整棵树都没有该值
				return null;
		}
		return current;
	}

	/**
	 * @param id
	 * @param dd
	 *  插入一个节点,用一个变量 parent 存储最后一个不是 null 的节点,要在返回前插入新节点
	 */
	public void insert(int id, double dd) {
		Node newNode = new Node();
		newNode.iData = id; //  insert data
		newNode.dData = dd;
		if (root == null) //  no node in root
			root = newNode;
		else {
			Node current = root; //  start at root 
			Node parent;
			while (true) {
				parent = current;
				if (id < current.iData) //  go left
				{
					current = current.leftChild; //  insert on left
					if (current == null) //  if end of the line
					{
						parent.leftChild = newNode;
						return;
					}
				} else {
					current = current.rightChild;
					if (current == null) {
						parent.rightChild = newNode; //  insert on right
						return;
					}
				}
			}
		}
	}

	/**
	 * @param key
	 *  current:要删除的节点;parent:要删除节点的父节点;successor:删除节点的后继节点
	 *  删除指定的节点
	 */
	public boolean delete(int key) //  delete node with given key	
	{
		Node current = root;
		Node parent = root;
		boolean isLeftChild = true; //  search for node

		while (current.iData != key) {
			parent = current;
			if (key < current.iData) //  go left
			{
				isLeftChild = true;
				current = current.leftChild;
			} else {
				isLeftChild = false;
				current = current.rightChild;
			}
			if (current == null)
				return false;
		}

		//  found node to delete
		//  if no children,simply delete it,删除没有子子节点的节点
		if (current.leftChild == null && current.rightChild == null) //  
		{
			if (current == root) //  if tree
				root = null; //  tree is empty
			else if (isLeftChild)
				parent.leftChild = null;
			else
				parent.rightChild = null;
		}

		//  if no right child,replace with left subtree,删除有一个子节点的节点,把要删除节点的的子节点上移为删除节点的位置
		else if (current.rightChild == null)
			if (current == root)
				root = current.leftChild;
			else if (isLeftChild)
				parent.leftChild = current.leftChild;
			else
				parent.rightChild = current.leftChild;

		//  if no left child,replace with right subtree,当节点没有左子节点时
		else if (current.leftChild == null)
			if (current == root)
				root = current.rightChild;
			else if (isLeftChild)
				parent.leftChild = current.rightChild;
			else
				parent.rightChild = current.rightChild;

		//  two children,so replace with inorder success,删除有两个子节点的节点,用它的中序后继来代替它
		else {
			//  get successor of node to delete (current),寻找后继节点
			Node successor = getSuccessor(current); //  successor:继承者,接任者

			//  connect parent of current to successor instead    instead:代替,替换
			if (current == root)
				root = successor;
			else if (isLeftChild)
				parent.leftChild = successor;
			//  如果后继节点是 delNode 的右子节点
			else
				parent.rightChild = successor; //  让父节点的右子节点指向后继节点,要删除的节点自动不被引用

			//  connect successor to current's left child
			successor.leftChild = current.leftChild; //  把被删除节点的左子节点的引用转移到后继节点的左子节点
		}
		return true;
	}

	/**
	 * @param delNode,要删除的节点;successorParent:后继节点的父节点
	 * @return successor:节点的后继节点
	 */
	private Node getSuccessor(Node delNode) {
		Node successorParent = delNode;
		Node successor = delNode;
		Node current = delNode.rightChild; //  go to right child

		while (current != null) //  查找后继节点
		{
			successorParent = successor;
			successor = current;
			current = current.leftChild;
		}

		//  删除节点的后继节点不是它的右子节点时
		if (successor != delNode.rightChild) {
			successorParent.leftChild = successor.rightChild; //  把后继节点的右子节点设为父节点的左子节点
			successor.rightChild = delNode.rightChild; //   把要删除节点的右子节点设为后继节点的右子节点 
		}
		return successor;
	}

	public void traverse(int traverseType) {

	}

	/**
	 * @param localRoot
	 *  前序遍历
	 */
	private void preOrder(Node localRoot) {
		if (localRoot != null) {
			System.out.println(localRoot.iData + " ");
			preOrder(localRoot.leftChild);
			preOrder(localRoot.rightChild);
		}
	}

	/**
	 * @param localRoot
	 *  中序遍历
	 */
	private void inOrder(Node localRoot) {
		if (localRoot != null) {
			inOrder(localRoot.leftChild);
			System.out.println(localRoot.iData + " ");
			inOrder(localRoot.rightChild);
		}
	}

	/**
	 * @param localRoot
	 *  后序遍历
	 */
	private void postOrder(Node localRoot) {
		if (localRoot != null) {
			postOrder(localRoot.leftChild);
			postOrder(localRoot.rightChild);
			System.out.println(localRoot.iData + " ");
		}
	}

	/**
	 *  显示树
	 */
	public void displayTree() {
		Stack globalStack = new Stack();
		globalStack.push(root);
		int nBlanks = 32;
		boolean isRowEmpty = false;
		System.out.println("********************************");
		while (isRowEmpty == false) {
			Stack localStack = new Stack();
			isRowEmpty = true;

			for (int i = 0; i < nBlanks; i++)
				System.out.println(' ');

			while (globalStack.isEmpty() == false) {
				Node temp = (Node) globalStack.pop();
				if (temp != null) {
					System.out.println(temp.iData);
					localStack.push(temp.leftChild);
					localStack.push(temp.rightChild);

					if (temp.leftChild != null || temp.rightChild != null)
						isRowEmpty = false;
				} else {
					System.out.println("--");
					localStack.push(null);
					localStack.push(null);
				}
				for (int j = 0; j < nBlanks * 2 - 2; j++) {
					System.out.println(' ');
				}
				nBlanks /= 2;
				while (localStack.isEmpty() == false)
					globalStack.push(localStack.pop());
			}
			System.out.println("***********************************");
		}
	}

}
