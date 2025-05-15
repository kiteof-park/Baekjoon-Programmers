import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        // 1. N(재료의 수), M(갑옷 만드는데 필요한 수) 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        
        // 2. 재료들의 고유 번호 입력 받고 배열 생성
            // "2 7 4 1 5 3" -> 2, 7, 4, 1, 5, 3
        StringTokenizer st = new StringTokenizer(br.readLine());
        int arr[] = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        // 오름차순 정렬 
        Arrays.sort(arr);
            
        // 3. 투 포인터
        int answer = 0;
        int start = 0;
        int end = N - 1;
        
        while(start < end){
            if(arr[start] + arr[end] == M){
                answer++;
                start++;
                end--;
            }
            else if(arr[start] + arr[end] > M){
                end--;
            }
            else{    // arr[start] + arr[end] < M
                start++;
            }
        }
        
        PrintWriter pw = new PrintWriter(System.out);
        pw.println(answer);
        pw.flush();
     
        // System.out.println(answer);
    }
}