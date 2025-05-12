import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());    // 숫자 개수
        String num = br.readLine();                  // 공백없이 주어진 N개의 숫자
        char[] numArr = num.toCharArray();
        int result = 0;
        
        for(int i = 0; i < cnt; i++){
            result += (numArr[i] - '0');
        }
        
        System.out.println(result);
    }
}