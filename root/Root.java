import java.util.*;
import java.io.*;

public class Root{
    public static void main(String[] args) throws Exception{
        BufferedReader queryreader = new BufferedReader(new FileReader(args[0]));
        BufferedReader dagreader = new BufferedReader(new FileReader(args[1]));
        Scanner linescanner ;

        int line = 0;
        
        while(queryreader.readLine() != null){
            
           ArrayList<Integer> adjlist[] = new ArrayList[40];
            int[] visited = new int[40];
            for(int i = 0; i < 40; i++){
                adjlist[i] = new ArrayList<Integer>();
                visited[i] = 0;
            }
           
            for(int i = 0; i < 40; i++){
               String thisline = queryreader.readLine();
               linescanner = new Scanner(thisline);
               linescanner.next();
               linescanner.next();
               linescanner.next();
               while(linescanner.hasNext()){
                   adjlist[i].add(Integer.parseInt(linescanner.next()));
               }
           }
/*
           if(line == 0){
               for(int i = 0; i < 40; i++){
                   System.out.println(adjlist[i]);
               }
         }
*/
           String[] queuestr = dagreader.readLine().split(" ");
           int[] queue = new int[40];
           for(int i = 0; i < 40; i++){
                queue[i] = Integer.parseInt(queuestr[i]);
           }
           for(int i = 0; i < 40; i++){
               if(i == 0)
                   visited[queue[0]] = 1;

               if(visited[queue[i]] != 1)
                    System.out.println("Not root! query " + line + " and element " + i );

                for(Integer edge : adjlist[queue[i]]){
                    visited[edge] = 1;
                }
            }
           line++;
       }
    }
}
