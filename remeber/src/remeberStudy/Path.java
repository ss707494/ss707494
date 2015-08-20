package remeberStudy;

/**
 * Created by Administrator on 2015/8/19.
 */
public class Path {
    public static String PATH;

    static String getpath(String name) {
        return Path.class.getResource(name).getPath();
    }

    public static void main(String[] args) {
        System.out.println(getpath("packup"));
    }
}
