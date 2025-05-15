import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        // 1. 행렬 사이즈, 쿼리 수 입력 받기
            // "4 3" -> 4, 3
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int mSize = Integer.parseInt(st.nextToken());
        int query = Integer.parseInt(st.nextToken());
        
        // 2. 행렬 생성
        long A[][] = new long[mSize + 1][mSize + 1];
        
        // 3. 행렬에 값 입력
            // "1 2 3 4" -> 1, 2, 3, 4
        for(int i = 1; i <= mSize; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= mSize; j++){
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 4. 누적 합 행렬 생성
        long S[][] = new long[mSize + 1][mSize + 1];
        for(int i = 1; i <= mSize; i++){
            for(int j = 1; j <= mSize; j++){
                S[i][j] = S[i][j-1] + S[i-1][j] - S[i-1][j-1] + A[i][j];
            }
        }
        
        // 5. 범위 입력 받기
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < query; i++){
            // "2 2 3 4" -> S[2][2], S[3][4]
            st = new StringTokenizer(br.readLine());
            int startRow = Integer.parseInt(st.nextToken());
            int startCol = Integer.parseInt(st.nextToken());
            int endRow = Integer.parseInt(st.nextToken());
            int endCol = Integer.parseInt(st.nextToken());
            long result = S[endRow][endCol] 
                - S[startRow - 1][endCol] 
                - S[endRow][startCol - 1]
                + S[startRow - 1][startCol - 1];
            
            sb.append(result).append("\n");
        }
        System.out.print(sb);
    } 
}