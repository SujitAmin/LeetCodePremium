import java.util.PriorityQueue;
import java.util.TreeMap;

public class HighFive {
    public static void main(String[] args){
        int[][] arr = new int[100][100];
        highFive(arr);

    }
    public static int[][] highFive(int[][] items) {
        TreeMap<Integer, PriorityQueue<Integer>> treeMap = new TreeMap<>();
        for(int[] studentToScores : items){
            if(treeMap.containsKey(studentToScores[0])){
                PriorityQueue<Integer> maxHeap = treeMap.get(studentToScores[0]);
                maxHeap.offer(studentToScores[1]);
                if(maxHeap.size() > 5){
                    maxHeap.poll();
                }
                treeMap.put(studentToScores[0], maxHeap);
            }
        }
        int[][] result = new int[treeMap.size()][2];
        for(int id : treeMap.keySet()){
            result[id - 1][0] = id;
            int sum = 0;
            PriorityQueue<Integer> maxHeap = treeMap.get(id);
            while(!maxHeap.isEmpty()){
                sum += maxHeap.poll();
            }
            result[id - 1][1] = sum/5;
        }
        return result;
    }
}

