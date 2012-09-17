package com.geeksun.algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * @author geeksun
 * ����������
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
 * �ڵ���:��������,���ݴ���Ҫ�洢������,����ָ��ڵ�������ӽڵ������
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
	 * @param key:�ؽ���,Ҫ�ҵ�ֵ:���ҴӸ���ʼ
	 * @return �����ؽ��ֵĽڵ�
	 *  current ���ڲ鿴�Ľڵ�
	 */
	public Node find(int key) {
		Node current = root; //  from root begin search
		while (current.iData != key) {
			if (key < current.iData) //  key С�� current ��ֵʱ, current��Ϊ�˽ڵ�����ӽڵ�
				current = current.leftChild;
			else
				current = current.rightChild;
			if (current == null) //  û���ӽڵ�ʱ,���Ѿ������������û�и�ֵ
				return null;
		}
		return current;
	}

	/**
	 * @param id
	 * @param dd
	 *  ����һ���ڵ�,��һ������ parent �洢���һ������ null �Ľڵ�,Ҫ�ڷ���ǰ�����½ڵ�
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
	 *  current:Ҫɾ���Ľڵ�;parent:Ҫɾ���ڵ�ĸ��ڵ�;successor:ɾ���ڵ�ĺ�̽ڵ�
	 *  ɾ��ָ���Ľڵ�
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
		//  if no children,simply delete it,ɾ��û�����ӽڵ�Ľڵ�
		if (current.leftChild == null && current.rightChild == null) //  
		{
			if (current == root) //  if tree
				root = null; //  tree is empty
			else if (isLeftChild)
				parent.leftChild = null;
			else
				parent.rightChild = null;
		}

		//  if no right child,replace with left subtree,ɾ����һ���ӽڵ�Ľڵ�,��Ҫɾ���ڵ�ĵ��ӽڵ�����Ϊɾ���ڵ��λ��
		else if (current.rightChild == null)
			if (current == root)
				root = current.leftChild;
			else if (isLeftChild)
				parent.leftChild = current.leftChild;
			else
				parent.rightChild = current.leftChild;

		//  if no left child,replace with right subtree,���ڵ�û�����ӽڵ�ʱ
		else if (current.leftChild == null)
			if (current == root)
				root = current.rightChild;
			else if (isLeftChild)
				parent.leftChild = current.rightChild;
			else
				parent.rightChild = current.rightChild;

		//  two children,so replace with inorder success,ɾ���������ӽڵ�Ľڵ�,��������������������
		else {
			//  get successor of node to delete (current),Ѱ�Һ�̽ڵ�
			Node successor = getSuccessor(current); //  successor:�̳���,������

			//  connect parent of current to successor instead    instead:����,�滻
			if (current == root)
				root = successor;
			else if (isLeftChild)
				parent.leftChild = successor;
			//  �����̽ڵ��� delNode �����ӽڵ�
			else
				parent.rightChild = successor; //  �ø��ڵ�����ӽڵ�ָ���̽ڵ�,Ҫɾ���Ľڵ��Զ���������

			//  connect successor to current's left child
			successor.leftChild = current.leftChild; //  �ѱ�ɾ���ڵ�����ӽڵ������ת�Ƶ���̽ڵ�����ӽڵ�
		}
		return true;
	}

	/**
	 * @param delNode,Ҫɾ���Ľڵ�;successorParent:��̽ڵ�ĸ��ڵ�
	 * @return successor:�ڵ�ĺ�̽ڵ�
	 */
	private Node getSuccessor(Node delNode) {
		Node successorParent = delNode;
		Node successor = delNode;
		Node current = delNode.rightChild; //  go to right child

		while (current != null) //  ���Һ�̽ڵ�
		{
			successorParent = successor;
			successor = current;
			current = current.leftChild;
		}

		//  ɾ���ڵ�ĺ�̽ڵ㲻���������ӽڵ�ʱ
		if (successor != delNode.rightChild) {
			successorParent.leftChild = successor.rightChild; //  �Ѻ�̽ڵ�����ӽڵ���Ϊ���ڵ�����ӽڵ�
			successor.rightChild = delNode.rightChild; //   ��Ҫɾ���ڵ�����ӽڵ���Ϊ��̽ڵ�����ӽڵ� 
		}
		return successor;
	}

	public void traverse(int traverseType) {

	}

	/**
	 * @param localRoot
	 *  ǰ�����
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
	 *  �������
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
	 *  �������
	 */
	private void postOrder(Node localRoot) {
		if (localRoot != null) {
			postOrder(localRoot.leftChild);
			postOrder(localRoot.rightChild);
			System.out.println(localRoot.iData + " ");
		}
	}

	/**
	 *  ��ʾ��
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
