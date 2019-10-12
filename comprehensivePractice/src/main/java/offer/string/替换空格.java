package offer.string;

/**
 * @author jhmarryme.cn
 * @date 2019/9/6 13:27
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class 替换空格 {
    public String replaceSpace(StringBuffer str) {
        String rowStr = str.toString();
        StringBuffer res = new StringBuffer(rowStr);

        for(int i = 0; i < res.length(); i++){
            if(res.charAt(i) == ' '){
                res.deleteCharAt(i);
                res.insert(i, "%20");
            }
        }

        return res.toString();
    }
}
