import java.util.*;
 
public class Main {
    
    static int n, l, r;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static ArrayList<Pair> list; 
 
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);    
 
        n = scan.nextInt();
        l = scan.nextInt();
        r = scan.nextInt();
        
        map= new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                map[i][j] = scan.nextInt();
            }
        }
        
        System.out.println(move());
    }
    
    public static int move() { 
        int result = 0;
        while(true) {
            boolean isMove = false;
            visited = new boolean[n][n]; 
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(!visited[i][j]) {
                        int sum = bfs(i, j); 
                        if(list.size() > 1) {
                            changePopulation(sum); 
                            isMove = true;
                        }    
                    }
                }
            }
            if(!isMove) return result;
            result++;
        }
    }
    
    public static int bfs(int x, int y) {
        Queue<Pair> q = new LinkedList<>();
        list = new ArrayList<>();
        
        q.add(new Pair(x, y));
        list.add(new Pair(x, y));
        visited[x][y] = true;
        
        int sum = map[x][y];
        while(!q.isEmpty()) {
            Pair p = q.poll();
            
            for(int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny]) {
                    int diff = Math.abs(map[p.x][p.y] - map[nx][ny]);
                    if(l <= diff && diff <= r) {
                        q.add(new Pair(nx, ny));
                        list.add(new Pair(nx, ny));
                        sum += map[nx][ny];
                        visited[nx][ny] = true;
                    }        
                }
            }
        }
        return sum;
    }
    
    public static void changePopulation(int sum) {
        int avg = sum / list.size();
        for(Pair n : list) {
            map[n.x][n.y] = avg;
        }
    }
    
    public static class Pair {
        int x; 
        int y;
        
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}