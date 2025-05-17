import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());    // 수열의 개수
        int[] arr = new int[n];
        
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        Stack<Integer> stack = new Stack<Integer>();
        StringBuilder sb = new StringBuilder();    // 출력 결과 저장
        int next = 1;                              // 다음에 push할 숫자
        boolean isPossible = true;
        
        for(int i = 0; i < n; i++){
            int target = arr[i];
            
            // 1. top < target 또는 top이 비었을 때 push (+)
            // 2. top == target 일 때 pop(-)
            // 3. top > target 인 경우 "NO" 출력
            while (next <= target){
                stack.push(next);
                sb.append("+\n");
                next++;      
            }
            
            if(stack.peek() == target){
                stack.pop();
                sb.append("-\n");
            }
            
            else{
                isPossible = false;
                break;
            }
        }
        
        if(isPossible){
            System.out.println(sb);
        }
        else{
            System.out.println("NO");
        }  
    }
}