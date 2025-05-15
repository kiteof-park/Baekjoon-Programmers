import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 1. 자연수 N 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        // 2. 변수 초기화
        int count = 1;    // 자기 자신(N)은 무조건 포함됨
        int sum = 1;
        int start = 1;
        int end = 1;
        
        // 3. 1 ~ N까지의 배열 생성
        //int arr[] = new int[N]
        //for(int i = 0; i < N; i++){
        //    arr[i] = arr[i] + 1;
        //}        
        
        // 4. 투 포인터 사용
        while(end != N){
            if(sum == N){
                count++;
                end++;
                sum += end;
            }
            else if(sum > N){
                sum -= start;
                start++;
            }
            else{
                end++;
                sum += end;
            }
        }
        System.out.println(count);
    }
}