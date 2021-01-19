import java.util.*;
public class Roads{
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
    int numCities = cities.size();
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
    int[] totalDists = addTotalDists(numCities, distances);
    int answer =  findSmallestDistance(totalDists);
    System.out.println("SHORTEST DISTANCE: " + answer);
  }

  public static int[] addTotalDists(int numCities, int[][] distances){
    ArrayList<String> usedCombos = new ArrayList<>();
    ArrayList<Integer> indeces=new ArrayList<Integer>();
    for (int i=0; i<numCities; i++){
      indeces.add(i);
    }
    int[] totalDists = new int[permute(numCities)];
      for(int i = 0; i < permute(numCities);){
        int in = 0;
        totalDists[i] =0;
        for(int j = 0; j < numCities-1;j++){
          totalDists[i] = totalDists[i]+ distances[indeces.get(in)][indeces.get(in+1)];
          in++;
        }
        Collections.shuffle(indeces);
        while (check(indeces, usedCombos)){
          Collections.shuffle(indeces);
        }
        i++;
      }
      return totalDists;
  }

  public static int findSmallestDistance(int[] distances){
    int mindistance=Integer.MAX_VALUE;
    for (int i =0;i<distances.length;i++ ) {
      if(distances[i] < mindistance){
        mindistance = distances[i];
      }
    }
    return mindistance;
  }

  public static int permute(int a){
    int permutations = 1;
    for (int i =a; a>0; a--){
      permutations = permutations * a;
    }
    return permutations;
  }
}
