package reading.designPatternLesson.flyweight;

/**
 *
 * 享元模式的应用
 *
 * 一般网盘对于相同的文件只保留一份，譬如有一个场景：当我们上传一部别人上传过的电影，会发现很快就上传完成了，
 * 实际上不是真的上传，而是引用别人曾经上传过的那部电影，这样一可以提高我们的用户体验，二可以节约存储空间避免资源浪费
 * @author jhmarryme.cn
 * @date 2019/11/8 18:53
 */
public class PanServerTestDrive {

    public static void main(String[] args) {

        String content = "设计模式.pdf";
        LocalFile file1 = new LocalFile("HeadFirst设计模式", content);
        LocalFile file2 = new LocalFile("设计模式", content);

        PanServer server = PanServer.getInstance();

        String jh = server.upload("jh", file1);
        String wjh = server.upload("wjh", file2);
        System.out.println(jh);
        System.out.println(wjh);

        server.download(wjh);
        server.download(jh);
    }
}
