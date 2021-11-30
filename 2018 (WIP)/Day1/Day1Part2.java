import java.util.Scanner;
import java.util.HashSet;
import java.io.File;

public class Day1Part2 {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<Integer>();
        boolean found = false;
        Integer current = 0;
        Integer currentSum = 0;
        File file;
        Scanner sc = null;
        int count = 0;
        while(!found) {
            try {
                file = new File("input.txt");
                sc = new Scanner(file);
            } catch(Exception e) { return; }
            while(sc.hasNext() && !found){
                count++;
                String line = sc.nextLine();
                char sign = line.charAt(0);
                current = Integer.parseInt(line.substring(1));
                if (sign == '-') {
                    current *= -1;
                }
                currentSum += current;
                if (set.contains(currentSum)) {
                    found = true;
                    break;
                } else {
                    set.add(currentSum);
                }
            }
        }
        sc.close();
        System.out.println(currentSum);
        System.out.println(count);
    }
}