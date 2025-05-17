import java.util.*;
import java.io.*;

public class Main{
    static int[] minCount = new int[4];
    static int[] myCount = new int[4];
    
    public static void main(String[] args) throws IOException{
        // 1. S(문자열 길이), P(부분 문자열 길이)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        
        // 2. DNA 문자열 -> 문자배열
        String str = br.readLine();
        char[] dna = str.toCharArray();
        
        // 3. A,C,G,T 최소 개수
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++){
            minCount[i] = Integer.parseInt(st.nextToken());
        }
        
        // 4. 슬라이딩 윈도우
            // (1) 문자배열을 윈도우 사이즈로 제한
            // (2) 조건 검사
            // (3) 다음 윈도우로 이동
        int cnt = 0;
        
        for(int i = 0; i < P; i++){
            add(dna[i]);
        }
        if(isValid()){
            cnt++;
        }
        
        for(int i = P; i < S; i++){
            add(dna[i]);
            remove(dna[i - P]);
            if(isValid()){
                cnt++;
            }
        }
        
        System.out.println(cnt);
    }
    
    static void add(char c){
        switch(c){
            case 'A' : myCount[0]++; break;
            case 'C' : myCount[1]++; break;
            case 'G' : myCount[2]++; break;
            case 'T' : myCount[3]++; break;
        }
    }
    
    static boolean isValid(){
        for(int i = 0; i < 4; i++){
            if(myCount[i] < minCount[i]){
                return false;
            }
        }
        return true;
    }
    
    static void remove(char c){
        switch(c){
            case 'A' : myCount[0]--; break;
            case 'C' : myCount[1]--; break;
            case 'G' : myCount[2]--; break;
            case 'T' : myCount[3]--; break;
        }
    }
    
}