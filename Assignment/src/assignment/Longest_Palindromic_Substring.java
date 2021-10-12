package assignment;

public class Longest_Palindromic_Substring {
public static void main(String[] args) {
	int max=0;
    String string="";
    String s="babad";
    for(int begin=0;begin<s.length();begin++){
       for(int end=s.length()-1;end>=begin;end--){
           int l=begin,r=end;
           int size=0;
           while(l<=r&&s.charAt(l)==s.charAt(r)){
               size++;
               l++;
               r--;
           }
           if(r<=l){
               if(max<size){
               max=size;
               string=s.substring(begin,end+1);
               }
               break;
           }
       }
    }
    System.out.println(string);
}
}
