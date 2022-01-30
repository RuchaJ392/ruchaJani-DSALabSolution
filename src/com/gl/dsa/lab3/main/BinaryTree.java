package com.gl.dsa.lab3.main;
import java.io.*;
import java.util.ArrayList;

public class BinaryTree
{
	
//Binary tree node
static class Node
{
	Node left;
	Node right;
	int data;
};


static Node newNode(int data)
{
	Node temp = new Node();

	temp.data = data;
	temp.left = null;
	temp.right = null;

	return temp;
}

//Function to find and return the
//longest path
public static ArrayList<Integer> longestPath(Node root)
{
	
	
	if(root == null)
	{
		ArrayList<Integer> output = new ArrayList<>();
		return output;
	}
	

	ArrayList<Integer> right = longestPath(root.right);

	ArrayList<Integer> left = longestPath(root.left);
	
	
	if(right.size() < left.size())
	{
		left.add(root.data);
	}
	else
	{
		right.add(root.data);
	}
	
	// Return the appropriate ArrayList
	return (left.size() >
			right.size() ? left :right);
}


public static void main(String[] args)
{
	Node root = newNode(100);
	root.left = newNode(20);
	root.right = newNode(130);
	root.left.left = newNode(10);
	root.left.right = newNode(50);
	root.left.left.left = newNode(5);
	root.right.right=newNode(140);
	root.right.left=newNode(110);
	ArrayList<Integer> output = longestPath(root);
	int n = output.size();
	
	System.out.print(output.get(n - 1));
	for(int i = n - 2; i >= 0; i--)
	{
		System.out.print(" -> " + output.get(i));
	}
}
}

