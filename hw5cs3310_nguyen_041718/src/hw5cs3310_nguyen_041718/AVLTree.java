package hw5cs3310_nguyen_041718;

import java.util.Stack;

public class AVLTree<E extends Comparable<E>> {

    public AVLNode<E> root;


    
    /**
     * insert method to call insertNode
     * @param data
     */
    public void insert(E data) {
        root = insertNode(root, data);
    }


    /**
     * remove method to call removeNode
     * @param data
     */
    public void remove(E data) {
        if (isEmpty()) {
            return;
        }
        root = removeNode(root, data);
    }



    /**
     * checks to see if tree is empty
     * @return
     */
    public boolean isEmpty() {
        return this.root == null;
    }



    /**
     * recursive method to remove a node from tree
     * 
     * checks to see if node has no children, one child node, or two children 
     * removes accordingly depending on the situation
     * 
     * @return removed node, null if data is not in there
     * */
    private AVLNode<E> removeNode(AVLNode<E> curr, E data) {

        //returns null if curr is null
        if (curr == null) {
            return null;
        }

        AVLNode<E> left = curr.getLeftChild();
        AVLNode<E> right = curr.getRightChild();
        
        
        E currData = curr.getData();

        if (data.compareTo(currData) == 0) {

            //System.out.println("Found and deleting: " + currData);

            //leaf node
            if (left == null && right == null) {
                return null;
            }
            
            
            //right child
            else if (left == null) {
                curr = null;
                return right;
            } 
            
            //left child
            else if (right == null) {
                curr = null;
                return left;
            } 
            
            //two children
            else {
                AVLNode<E> largeLeftTree = getMax(left);

                // swap 
                curr.setData(largeLeftTree.getData());
                curr.setLeft(removeNode(curr.getLeftChild(), largeLeftTree.getData()));

            }
            
            
             
        } 
        //traverse left
        else if (data.compareTo(currData) < 0) {
            curr.setLeft(removeNode(left, data));
  
        } 
        
      //traverse to right
        else {
            curr.setRight(removeNode(right, data));
        }

        // update height 
        curr.setHeight(calculateTreeHeight(curr));

        
        // re balance tree
        return deleteBalance(curr);
    }

    /**
     * rebalances tree after delete method
     * @return deleted node
     * */
    private AVLNode<E> deleteBalance(AVLNode<E> curr) {

        int balanceValue = getBalance(curr);

        
        // left heavy 
        if (balanceValue > 1) {
        	
        	
            // left right rotate
            if (getBalance(curr.getLeftChild()) < 0) {
                curr.setLeft(leftRotation(curr.getLeftChild()));
            }

            return rightRotation(curr);
        }

        // right heavy 
        if (balanceValue < -1) {

        	
            if (getBalance(curr.getRightChild()) > 0) {
                curr.setRight(rightRotation(curr.getRightChild()));
            }

            
            return leftRotation(curr);
        }

        return curr;
    }

    /**
     * Get the maximum node is a particular sub-tree
     *
     * @param currentNode the root node of the sub-tree
     *                    we will be examining
     * */
    private AVLNode<E> getMax(AVLNode<E> currentNode) {
        while (currentNode.getRightChild() != null) {
            currentNode = currentNode.getRightChild();
        }
        return currentNode;
    }



    /**
     * returns height of node
     *
     * @return -1 if the node is null, otherwise height
     * */
    int height(AVLNode<E> currentNode) {
        if (currentNode == null) {
            return -1;
        }
        return currentNode.getHeight();
    }

    /**
     * 
     * 
     * 
     *
     * method to insert 
     *
     * @param currentNode
     * @param dataToInsert
     * */
    private AVLNode<E> insertNode(AVLNode<E> curr, E data) {

        // if curr is null 
        if (curr == null) {
            return new AVLNode<E>(data);
        }

        // data to insert is less than curr 
        // Go to the left.
        if (curr.getData() != null && data.compareTo(curr.getData()) < 0) {
            curr.setLeft(insertNode(curr.getLeftChild(), data));
            
        } 
        
        //greater than , go to the right
        else if (curr.getData() != null && data.compareTo(curr.getData()) >= 0)  {
            curr.setRight(insertNode(curr.getRightChild(), data));
        }

        curr = balanceTree(curr, data);

        // Finally, update the height calculateTreeHeight(rootNode)
        curr.setHeight(calculateTreeHeight(curr));

        return curr;
    }

    /**
     * After the insertion/removal method, check to see if tree is balanced.
     * Four conditions
     * right heavy - left rotate
     * left heavy - right rotate
     * right heavy - left right
     * left heavy - right left 
     * 
     *
     *
     * */
    private AVLNode<E> balanceTree(AVLNode<E> currentNode, E dataToInsert) {

        int balanceValue = getBalance(currentNode);

        // Right heavy - left rotation
        if (currentNode.getRightChild() != null && currentNode.right.getData() != null &&  isRightHeavy(balanceValue)
                && dataToInsert.compareTo(currentNode.getRightChild().getData()) > 0) {
            return leftRotation(currentNode);
        }

        // Left heavy - Right rotation
        if (currentNode.getLeftChild() != null && isLeftHeavy(balanceValue)
                && dataToInsert.compareTo(currentNode.getLeftChild().getData()) < 0) {
            return rightRotation(currentNode);
        }

        // Left right
        if (currentNode.getLeftChild() != null && isLeftHeavy(balanceValue) &&
                dataToInsert.compareTo(currentNode.getLeftChild().getData()) > 0) {
            currentNode.setLeft(insertNode(currentNode.getLeftChild(), dataToInsert));
            return rightRotation(currentNode);
        }

        // right-left
        if (currentNode.getLeftChild() != null && isRightHeavy(balanceValue) && 
                dataToInsert.compareTo(currentNode.getLeftChild().getData()) < 0) {
            currentNode.setRight(insertNode(currentNode.getRightChild(), dataToInsert));
            return leftRotation(currentNode);
        }

        return currentNode;
    }

    /**
     * 
     * get balance of current node
     * greater than 1 means left heavy, -2 or less means right heavy 
     * */
    private int getBalance(AVLNode<E>currentNode) {
        if (currentNode == null) {
            return 0;
        }
        return height(currentNode.getLeftChild()) - height(currentNode.getRightChild());
    }

    /**
     *check if balanced
     * @param currentNode
     * */
    private boolean isBalanced(AVLNode<E> currentNode) {
        return Math.abs(getBalance(currentNode)) < 2;
    }

    /**
     * balance check
     * @param balanceValue
     * */
    private boolean isBalanced(int balanceValue) {
        return balanceValue < 2 && balanceValue > -2;
    }

    /**
     * left heavy check 
     * */
    private boolean isLeftHeavy(int balanceValue) {
        return balanceValue > 1;
    }

    /**
     * 
     * right heavy check 
     * */
    private boolean isRightHeavy(int balanceValue) {
        return balanceValue < -1;
    }
    /**
     * 
     * calculates tree height 
     * */
    private int calculateTreeHeight(AVLNode<E> currentNode) {
        return Math.max(height(currentNode.getLeftChild()), height(currentNode.getRightChild())) + 1;
    }

    
    public int height1(AVLNode<E> root)
    {
        if (root == null)
           return 0;
        else
        {
            /* compute  height of each subtree */
            int lheight = height(root.left);
            int rheight = height(root.right);
             
            /* use the larger one */
            if (lheight > rheight)
                return(lheight+1);
            else return(rheight+1); 
        }
        
      
    }
    
    void LevelOrder()
    {
        int h = height(root);
        int i;
        for (i=1; i<=h; i++)
            printLevel(root, i);
    }
    
    void printLevel (AVLNode<E> root ,int level)
    {
        if (root == null)
            return;
        if (level == 1)
            System.out.print("Height: "+root.getHeight()+" Data: " +root.getData() + " ");
        else if (level > 1)
        {
            printLevel(root.left, level-1);
            printLevel(root.right, level-1);
        }
    }
    
    
	public void printDepth(AVLNode<E> root) {
		Stack<AVLNode<E>> s = new Stack<AVLNode<E>>();
		s.add(root);
		while (s.isEmpty() == false) {
			AVLNode<E> x = s.pop();
			if(x.right!=null) s.add(x.right);
			if(x.left!=null) s.add(x.left);			
			System.out.print(" Height: " +x.getHeight()+ " Data: " + x.getData());
		}
	}
	
	
    /**
     * 
     * right rotation 
     *
     *
     * */
    private AVLNode<E> rightRotation(AVLNode<E> currentNode) {

        AVLNode<E> newRootNode = currentNode.getLeftChild();
        AVLNode<E> rightChildOfLeft = newRootNode.getRightChild();

  
        newRootNode.setRight(currentNode);

       
        currentNode.setLeft(rightChildOfLeft);

   
        newRootNode.setHeight(calculateTreeHeight(newRootNode));
        currentNode.setHeight(calculateTreeHeight(currentNode));

        return newRootNode;
    }

    private AVLNode<E> leftRotation(AVLNode<E> currentNode) {


        AVLNode<E> newRootNode = currentNode.getRightChild();
        AVLNode<E> leftChildOfRight = newRootNode.getLeftChild();


        newRootNode.setLeft(currentNode);

        currentNode.setRight(leftChildOfRight);

        newRootNode.setHeight(calculateTreeHeight(newRootNode));
        currentNode.setHeight(calculateTreeHeight(currentNode));

        return newRootNode;
    }


    /**
     * In order traversal implementation
     * left
     * visit
     * right 
     *
     *recursive method
     *
     * @param currentNode the node that we are currently at
     * */
    public void inOrderTraversal(AVLNode<E> currentNode) {

    	AVLNode<E> leftChild = currentNode.getLeftChild();

        if (leftChild != null) {
            inOrderTraversal(leftChild);
        }

        System.out.print(currentNode + "(height: " +currentNode.height+ ")  --> ");

        AVLNode<E> rightChild = currentNode.getRightChild();

        if (rightChild != null) {
            inOrderTraversal(rightChild);
        }

    }

    /**
     * Pre order traversal implementation
     * 1. visit
     * 2. left
     * 3. right
     *
     * @param currentNode the node that we are currently at
     * */
    public void preOrderTraversal(AVLNode<E> currentNode) {

        System.out.print(currentNode + "(height: " +currentNode.height+ ") --> ");

        AVLNode<E> leftChild = currentNode.getLeftChild();

        if (leftChild != null) {
            preOrderTraversal(leftChild);
        }

        AVLNode<E> rightChild = currentNode.getRightChild();

        if (rightChild != null) {
            preOrderTraversal(rightChild);
        }
    }

    /**
     * Post order traversal
     * left
     * right 
     * visit/.
     *
     * @param currentNode the node that we are currently at
     * */
    private void postOrderTraversal(AVLNode<E> currentNode) {
    	AVLNode<E> leftChild = currentNode.getLeftChild();

        if (leftChild != null) {
            preOrderTraversal(leftChild);
        }

        AVLNode<E> rightChild = currentNode.getRightChild();

        if (rightChild != null) {
            preOrderTraversal(rightChild);
        }

        System.out.print(currentNode + " --> ");
    }
    
    
    
    public boolean search(E data) {
		if(root == null){
			return false;
		}else{
			return search(data, root);
		}
	}

	/**
	 * 
	 * @param data
	 * @param node
	 * @return
	 * 
	 * checks passed String data and if it's less than root node, then call recursively to the left
	 * if it's more than root node, then call recursively to the right
	 */
	private boolean search(E data, AVLNode<E> node) {
		// TODO Auto-generated method stub
		if(data != null) {
			
			if(data.compareTo(node.getData()) == 0) {
				System.out.println("Found");
				System.out.println("Height: " +node.getHeight());
				return true;
			}
			else{
				if(data.compareTo(node.getData()) < 0){
					if(node.left == null){
						System.out.println("Not found");
						return false;
					}
					else{
						return search(data, node.left);
					}
				}
				else if(data.compareTo(node.getData()) > 0){
					if(node.right == null){
						System.out.println("Not found");
						return false;
					}
				else{
						return search(data, node.right);
					}
				}
			}	
		}
		
		System.out.println("Not found");
		return false;		
	}

}




