import java.util.*;
public class Roads{
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
        line.next();
        String city2 = line.next();
        line.next();
        int distance = line.nextInt();
        distances[cities.indexOf(city1)][cities.indexOf(city2)] = distance;
        distances[cities.indexOf(city2)][cities.indexOf(city1)] = distance;
      }
    }
  }
  public static boolean check(List<Integer> input, ArrayList<String> output) {
    String tmp = input.toString();
    if (output.contains(tmp)){
      return true;
    }
    else {
      output.add(tmp);
      return false;
    }
  }
  public static int findSmallestDistance(ArrayList<String> cities, int[][] distances){
    ArrayList<Integer> indeces=new ArrayList<Integer>();
    ArrayList<String> usedCombos = new ArrayList<>();
    for (int i=0; i<cities.size(); i++){
      indeces.add(i);
    }
    int mindistance=Integer.MAX_VALUE;
    while (check(indeces, usedCombos)){
      Collections.shuffle(indeces);
    }
    usedCombos.add(indeces.toString());
    int totaldistance=0;
    for (int i=0; i<indeces.size()-1; i++){
      totaldistance+=distances[i][i+1];
    }
    if (totaldistance<mindistance) mindistance=totaldistance;
    return mindistance;
  }

}
