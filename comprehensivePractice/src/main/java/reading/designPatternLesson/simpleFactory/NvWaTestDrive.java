package reading.designPatternLesson.simpleFactory;


import reading.designPatternLesson.utils.XMLUtil;

/**
 * 测试简单工厂模式的应用
 */

class NvWaTestDrive{
    public static void main(String[] args) {
        //通过工具类测试
        try {
            //从xml配置文件中获取参数
            String womanType = XMLUtil.getAttribute("config.xml", "womanType");
            String rebotType = XMLUtil.getAttribute("config.xml", "rebotType");
            String manType = XMLUtil.getAttribute("config.xml", "manType");

            // 通过简单工厂创建对象
            Person woman = NvWa.makePerson(womanType.charAt(0));
            System.out.print("类名: ");
            System.out.println(woman.getClass().getName());
            woman.speak();

            Person man = NvWa.makePerson(manType.charAt(0));
            System.out.print("类名: ");
            System.out.println(man.getClass().getName());
            man.speak();

            Person rebot = NvWa.makePerson(rebotType.charAt(0));
            System.out.print("类名: ");
            System.out.println(rebot.getClass().getName());
            rebot.speak();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}