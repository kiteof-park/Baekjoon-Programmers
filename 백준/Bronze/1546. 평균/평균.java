import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        // 1. 과목 개수 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        
        // 2. 각 과목의 시험 성적 입력
            // "10 20 30" 입력 -> [10, 20, 30]으로 변환
        StringTokenizer st = new StringTokenizer(br.readLine());
        int scores[] = new int[cnt];
        
        for(int i = 0; i < cnt; i++){
            scores[i] = Integer.parseInt(st.nextToken());            
        }
        
        // 3. 입력받은 점수들 중 최대값 선정
        int max = 0;
        for(int i = 0; i < cnt; i++){
            max = scores[i] > max ? scores[i] : max;
        }
        
        // 4. 최대값을 기준으로 점수 조작 후 점수 합산
        double sum = 0.0;
        for(int i = 0; i < cnt; i++){
            sum += (double)scores[i]/max*100;
        }
        
        // 5. 다시 평균 구하기
        double avg = sum/(double)cnt;
        
        // 결과 출력
        System.out.println(avg);
        
    }
}