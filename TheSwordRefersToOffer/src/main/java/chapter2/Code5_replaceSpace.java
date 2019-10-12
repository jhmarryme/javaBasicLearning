package chapter2;

/**
 * @author jhmarryme.cn
 * @date 2019/8/30 15:53
 */
public class Code5_replaceSpace {

    public String replaceSpace(StringBuffer str) {
        int n = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == ' '){
                n++;
            }
        }

        int p1 = str.length() - 1;
        str.setLength(str.length() + n*2);
        int p2 = str.length() - 1;

        while(p1 >= 0 && p2 > p1){
            if(str.charAt(p1) != ' '){
                str.setCharAt(p2--, str.charAt(p1));
            } else{
                str.setCharAt(p2--, '0');
                str.setCharAt(p2--, '2');
                str.setCharAt(p2--, '%');
            }
            p1--;
        }

        return str.toString();
    }
}
