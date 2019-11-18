package designPatternLesson.flyweight;

/**
 * 相当于享元类
 * @author jhmarryme.cn
 * @date 2019/11/8 18:34
 */
public class File {

    //owner和fileName为外部状态
    private String fileName;
    private String owner;

    // resource 为内部状态
    private Resource resource;

    public File(String owner, String fileName) {
        this.fileName = fileName;
        this.owner = owner;
    }

    public String fileMeta() {// 文件存储到文件系统中需要的key
        if (this.owner == null || fileName == null || resource == null) {
            return "未知文件";
        }
        return owner + "-" + fileName + "-" + resource.getHashId();
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public String getFileName() {
        return fileName;
    }

    public String getOwner() {
        return owner;
    }

    public void display() {
        System.out.println(fileMeta() + "资源内容 : " + resource.toString());
    }
}
