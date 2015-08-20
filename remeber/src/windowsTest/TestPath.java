package windowsTest;


/**
 * Created by Administrator on 2015/8/19.
 */
public class TestPath {
    public static void main(String[] args) {
        String path=
                TestPath.class.getResource("../remeberStudy/config.xml").getPath();
        System.out.println(path);
    }
}
