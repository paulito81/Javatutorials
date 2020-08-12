package sort;

public class StringReverse {


    public StringReverse(){
    }

    public StringReverse(String value){
        reverse(value);
    }

    public String reverse(String s ){
        int j = s.length();
        char[] result = new char[j];
        for(int i = 0; i <s.length(); i++){
            result[--j] = s.charAt(i);
        }
        System.out.println(result);
        return new String(result);
    }
}
