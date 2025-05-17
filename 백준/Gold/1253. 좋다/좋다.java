import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        // 1. N, A 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        // 2. 투 포인터
        Arrays.sort(A);
        int cnt = 0;    // 정답 변수
        
        for(int i = 0; i < N; i++){
            int target = A[i];
            int start = 0;
            int end = N - 1;
            
            while(start < end){
                if(start == i){
                    start++;
                    continue;
                }
                if(end == i){
                    end--;
                    continue;
                }
                
                long sum = A[start] + A[end];
                
                if(sum == target){
                    cnt++;
                    break;
                }
                else if(sum > target){
                    end--;
                }
                else {    // sum < target
                    start++;
                }
            }
        }
        System.out.println(cnt);
    }
}