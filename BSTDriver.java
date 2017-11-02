import java.util.ArrayList;
public class BSTDriver{
   public static void main(String[] args){
      ArrayList<ArrayList<NewBinarySearchTree<Integer>>> tree = new ArrayList<ArrayList<NewBinarySearchTree<Integer>>>();
      for(int h = 0; h < 9; h += 1){
         int k = (h+1) * 10;
         tree.add(new ArrayList<NewBinarySearchTree<Integer>>());
         for(int i = 0; i < 10; i++){
            tree.get(h).add(new NewBinarySearchTree<Integer>());
            for(int j = 0; j < 1000; j++){
               if(k > Math.random()*100){
                  tree.get(h).get(i).add(42);
               }else{
                  tree.get(h).get(i).add((int)((Math.random()*3000)+1));
               }
            }
         }
      }
//       for(int i = 0; i < tree.size(); i++){
//          System.out.println("\nHeight (recursive): " + tree.get(i).heightA());
//          System.out.println("Height (iterative): " + tree.get(i).heightB());
//          System.out.println("Optimal Height: " + tree.get(i).minHeight());
//          System.out.println("Fullness Ratio: " + tree.get(i).fRatio());
//       }
      ArrayList<Double> avgHeights = new ArrayList<>();
      ArrayList<Double> avgFRatios = new ArrayList<>();
      for(int h = 0; h < tree.size(); h++){
         double avgHeight = 0;
         double avgFRatio = 0;
         for(int i = 0; i < tree.get(h).size(); i++){
            avgHeight += tree.get(h).get(i).heightA();
            avgFRatio += tree.get(h).get(i).fRatio();
         }
         avgHeights.add(avgHeight/tree.get(h).size());
         avgFRatios.add(avgFRatio/tree.get(h).size());
      } 
      for(int h = 0; h < avgHeights.size() && h < avgFRatios.size(); h++){
         System.out.println("K=" + (h+1)*10 + 
            "\n\tAverage Height: " + avgHeights.get(h) +
            "\n\tAverage Fullness Ratio: " + avgFRatios.get(h));
      }
   }
}