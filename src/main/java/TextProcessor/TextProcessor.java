package TextProcessor;

import java.util.Scanner;

/**
 * Created by Huaoao on 2018/9/22 17:14
 */
public class TextProcessor {
    /**
     * 字符串拼接
     * @param text
     * @param width
     * @return
     */
    public String process(String text,int width){
        StringBuffer stringBuffer = new StringBuffer();//拼接字符串
        int len = text.length();                       //字符串的长度
        int i = 0;                                     //记录字符串中字符的位置
        int k = 0;                                     //记录每行文本的开始位置
        int n = 1;                                     //记录每节的行号
        int start = 0;                                 //记录每节的开始位置
        int end = 0;                                   //记录每节的结束位置
        int j = 0;                                     //记录每节字符的位置
        while (i < len){  //当前字符位置没有超过字符串长度，则进行遍历
            k = i;
            while (i >= k && i < k + width && i < len){  //拼接每行文本里的节
                start = i;
                end = i;
                if (start <k+width && end <k+width){  //判断当前节的首字母位置和尾字母位置是否超出当前行
                    if (text.charAt(end)!=' '){       //拼接字母为文本字符的节
                        while (end < len  && text.charAt(end)!=' '){  //记录每节末尾字符的位置
                            end++;
                            i++;
                        }
                        if (end <= k+width){          //判断末尾字符位置是否超出当前行
                            for (j = start;j <end+1;j++){
                                if (j < end){
                                    stringBuffer.append(text.charAt(j));
                                }else {
                                    stringBuffer.append('('+String.valueOf(n)+");");
                                }
                            }
                        }else {
                            for (j = start;j <end+1;j++){
                                if (j < end){
                                    stringBuffer.append(text.charAt(j));
                                }else {
                                    stringBuffer.append('('+String.valueOf(n)+","+String.valueOf(n+1)+");");
                                }
                            }
                            i = end;
                        }
                        start = end;
                    }else if (text.charAt(end)==' '){   //拼接字符为空白字符的节
                        while (text.charAt(end) == ' '){
                            end++;
                            i++;
                        }
                        if (end <= k + width){           //判断末尾字符位置是否超出当前行
                            for (j = start;j <end+1;j++){
                                if (j < end){
                                    stringBuffer.append(text.charAt(j));
                                }else {
                                    stringBuffer.append('('+String.valueOf(n)+");");
                                }
                            }
                        }else {
                            for (j = start;j <end+1;j++){
                                if (j < end){
                                    stringBuffer.append(text.charAt(j));
                                }else {
                                    stringBuffer.append('('+String.valueOf(n)+","+String.valueOf(n+1)+");");
                                }
                            }
                            i = end;
                        }
                        start = end;
                    }
                }
            }
            n++;
        }
        return stringBuffer.toString();
    }

    /**
     * 判断是否为异常字符
     * @param ch
     * @return
     */
    public static boolean isLetter(char ch){
        if ((ch >= 'A' && ch <= 'Z')||(ch >= 'a'&&ch <= 'z')||ch == ' '){
            return true;
        }else {
            return false;
        }
    }
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        String text = in.nextLine();
        //String text = "The main theme of education in engineering school is learning to teach yourself";
        //String text = "So   many whitespaces";
        int lenText = text.length();
        for (int i = 0;i < lenText;i++){
            if (!isLetter(text.charAt(i))){
                throw new Exception("ERROR:Invalid character");
            }
        }
        //int width = 30;
        int width = Integer.parseInt(in.nextLine());
        if (width < 10||width > 80){
            throw new Exception("ERROR:Width out of range!");
        }
        TextProcessor textProcessor = new TextProcessor();
        String result = textProcessor.process(text,width);
        System.out.println(result);
    }
}
