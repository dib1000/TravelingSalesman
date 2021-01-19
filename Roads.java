import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
public class Roads{

  public static void print2D(int mat[][]){
    for (int i = 0; i < mat.length; i++){
      for (int j = 0; j < mat[i].length; j++){
        System.out.print(mat[i][j] + " ");
      }
      System.out.println("");
    }
  }

  public static void findDistances(ArrayList<String> cities, int[][] distances, Scanner s){
    while (s.hasNextLine()){
      Scanner line = new Scanner(s.nextLine());
      while (line.hasNext()){
        String city1 = line.next();
        line.next();
        String city2 = line.next();
        line.next();
        int distance = line.nextInt();
        distances[cities.indexOf(city1)][cities.indexOf(city2)] = distance;
      }
    }
  }

  public static void main(String[] args) {
    ArrayList<String> cities = new ArrayList<String>();
    Scanner file = new Scanner(System.in);
    String copy = "";
    while (file.hasNextLine()){
      String s = file.nextLine();
      copy += s + "\n";
      Scanner line = new Scanner(s);
      for (int i = 0; i < 3 && line.hasNext(); i++){
        String city = line.next();
        System.out.println(city);
        if (!(cities.contains(city) || city.equals("to"))){
          cities.add(city);
        }
      }
    }
    int[][] distances = new int[cities.size()][cities.size()];
    Scanner c = new Scanner(copy);
    while (c.hasNextLine()){
      Scanner line = new Scanner(c.nextLine());
      while (line.hasNext()){
        String city1 = line.next();
        System.out.print(city1);
        line.next();
        String city2 = line.next();
        System.out.print(" " + city2);
        line.next();
        int distance = line.nextInt();
        System.out.println(" =" + distance);
        distances[cities.indexOf(city1)][cities.indexOf(city2)] = distance;
      }
    }
    System.out.println(cities);
    print2D(distances);
  }

}