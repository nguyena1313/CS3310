package hw5cs3310_nguyen_041718;

class AVLNode<E extends Comparable<E>> {
    E key;
    AVLNode<E> left;
     AVLNode<E> right;
    int height;

    public AVLNode(E key) {
        this.key = key;
        height =1;
    }

    public E getData() {
        return key;
    }

    public void setData(E key) {
        this.key = key;
    }

    public AVLNode<E> getLeftChild() {
        return left;
    }

    void setLeft(AVLNode<E> leftChild) {
        this.left = leftChild;
    }

    public AVLNode<E> getRightChild() {
        return right;
    }

    void setRight(AVLNode<E> rightChild) {
        this.right= rightChild;
    }

    int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }


}