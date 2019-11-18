package designPatternLesson.flyweight;

import designPatternLesson.utils.HashUtil;

/**
 * 享元类的内部状态
 * @author jhmarryme.cn
 * @date 2019/11/8 18:32
 */
public class Resource {
    private String hashId;
    private String content;
    private int byteSize;

    public Resource(String content) {
        this.content = content;
        hashId = HashUtil.computeHashId(content);
        byteSize = content.length();
    }

    public String getHashId() {
        return hashId;
    }

    public String getContent() {
        return content;
    }

    public int getByteSize() {
        return byteSize;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "hashId='" + hashId + '\'' +
                ", content='" + content + '\'' +
                ", byteSize=" + byteSize +
                '}';
    }
}
