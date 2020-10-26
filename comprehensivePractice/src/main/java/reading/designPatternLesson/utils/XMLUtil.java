package reading.designPatternLesson.utils;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.File;

/**
 * 通过工具类读取配置文件中的字符串参数
 * @author jhmarryme.cn
 * @date 2019/10/13 12:53
 */
public class XMLUtil {

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        try {
            String womanType = getAttribute("config.xml", "womanType");
            System.out.println("womanType = " + womanType);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过文件名和标签名 获取标签中的内容
     * 文件默认位置在resources下
     * @param fileName
     * @param tagName
     * @return 标签内容
     * @throws Exception
     */
    public static String getAttribute(String fileName, String tagName) throws Exception {
        //创建文档对象
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        final DocumentBuilder builder = factory.newDocumentBuilder();
        Document document;
        document = builder.parse(new File("src//main//resources//" + fileName));

        //获取结点
        NodeList type = document.getElementsByTagName(tagName);
        Node typeNode = type.item(0).getFirstChild();
        String value = typeNode.getNodeValue().trim();

        return value;
    }

    /**
     * 通过反射获取对象实例
     * @param fileName
     * @param tagName
     * @return
     * @throws Exception
     */
    public static Object getBean(String fileName, String tagName) throws Exception{
        String value = getAttribute(fileName, tagName);

        Class<?> c = Class.forName(value);
        Object o = c.newInstance();
        return o;
    }
}
