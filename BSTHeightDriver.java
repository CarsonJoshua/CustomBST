public class BSTHeightDriver{
   public static void main(String[] args){
      NewBinarySearchTree<Character> example = new NewBinarySearchTree<Character>();
      example.add('P'); example.add('F'); example.add('S'); example.add('B'); 
      example.add('H'); example.add('R'); example.add('Y'); example.add('G'); 
      example.add('T'); example.add('Z'); example.add('W');  
      System.out.println(example.heightB());
   }
}