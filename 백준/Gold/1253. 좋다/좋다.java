import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        // 1. N, A 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A[] = new int[N];
        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        // 2. 투 포인터 - 조건을 만족하는 숫자쌍 찾기이므로 양 끝에서 시작되는 투 포인터 사용
        Arrays.sort(A);    // 정렬
        
        int cnt = 0;
   
        for(int i = 0; i < N; i++){
            int k = A[i];    // 검사대상 k
            int start = 0;
            int end = N - 1;
            while(start < end){
                if(A[start] + A[end] == k){
                    // 조건 추가 
                    // A[i]를 만드는데, A[i] 자신 포함X(서로 다른 두 수의 합)
                    if(start != i && end != i){
                        cnt++;
                        break;
                    }
                    else if(start == i){
                        start++;
                    }
                    else{    // end == i
                        end--;
                    }
                }
                else if (A[start] + A[end] > k){
                    end--;
                }
                else{    // A[start] + A[end] < k
                    start++;
                }
            }  
        }
        PrintWriter pw = new PrintWriter(System.out);
        pw.println(cnt);
        pw.flush();
        
    }
}