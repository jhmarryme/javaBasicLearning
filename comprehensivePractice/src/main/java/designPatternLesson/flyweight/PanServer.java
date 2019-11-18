package designPatternLesson.flyweight;

import designPatternLesson.utils.HashUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jhmarryme.cn
 * @date 2019/11/8 18:36
 */
public class PanServer {

    private static volatile PanServer instance;

    private Map<String, File> fileSystem;
    private Map<String, Resource> resourceSystem;

    private PanServer(){
        fileSystem = new HashMap<>();
        resourceSystem = new HashMap<>();
    }

    /**
     * 单例模式 -- 双重校验
     * @return
     */
    public static PanServer getInstance(){
        if (instance == null) {
            synchronized (PanServer.class){
                if (instance == null) {
                    instance = new PanServer();
                }
            }
        }
        return instance;
    }

    public String upload(String userName, LocalFile localFile){

        File file = new File(userName, localFile.getFileName());

        String hashId = HashUtil.computeHashId(localFile.getContent());
        try{
            if (resourceSystem.containsKey(hashId)){
                //存在相同的文件
                System.out.println("检测到相同文件, 为节约空间将重用文件");
                file.setResource(resourceSystem.get(hashId));
                Thread.sleep(100);
            } else{
                //新文件 -> 上传
                System.out.println("文件上传中..." + localFile.getFileName());
                Resource resource = new Resource(localFile.getContent());
                file.setResource(resource);
                resourceSystem.put(hashId, resource);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fileSystem.put(file.fileMeta(), file);
        return file.fileMeta();

    }

    public void download(String key){

        if (fileSystem.containsKey(key)) {
            fileSystem.get(key).display();
        }
    }
}
