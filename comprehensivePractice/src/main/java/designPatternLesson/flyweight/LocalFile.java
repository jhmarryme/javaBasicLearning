package designPatternLesson.flyweight;

/**
 * @author jhmarryme.cn
 * @date 2019/11/8 18:36
 */
public class LocalFile {

    private String fileName;
    private String content;

    public LocalFile(String fileName, String content) {
        this.fileName = fileName;
        this.content = content;
    }

    public String getFileName() {
        return fileName;
    }

    public String getContent() {
        return content;
    }
}
