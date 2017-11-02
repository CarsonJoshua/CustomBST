import support.BSTNode;
import ch04.queues.LinkedQueue;
import ch07.trees.BinarySearchTree;
public class NewBinarySearchTree<T> extends BinarySearchTree<T>{
   public NewBinarySearchTree(){
      super();
   }
   public int heightA(){
      return heightA(root);
   }
   private int heightA(BSTNode<T> node){
      if(node.getLeft() == null && node.getRight() == null) return 1;
      if(node.getLeft() == null) return heightA(node.getRight()) + 1;
      if(node.getRight() == null) return heightA(node.getLeft()) + 1;
      return greater(heightA(node.getRight()), heightA(node.getLeft())) + 1;
   }
   private static int greater(int a, int b){
      if(a > b)return a;
      return b;
   }
   public int heightB(){
      LinkedQueue<BSTNode<T>> q = new LinkedQueue<BSTNode<T>>();
      int height = 0;
      if(root!=null)q.enqueue(root);
      while(!q.isEmpty()){
         height++;
         LinkedQueue<BSTNode<T>> newq = new LinkedQueue<BSTNode<T>>();
         while(!q.isEmpty()){
            BSTNode<T> parent = q.dequeue();
            if(parent.getRight() != null)
               newq.enqueue(parent.getRight());
            if(parent.getLeft() != null)
               newq.enqueue(parent.getLeft());
         }
         q = newq;
      }      
      return height;
   }
   public double fRatio(){
      return (double)minHeight()/heightA();
   }
   public int minHeight(){
      int height = 0;
      int capacity = 0;
      while(size() > capacity){
         capacity += Math.pow(2, height);
         height++;
      }
      return height;
   }
}