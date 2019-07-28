package com.linkenzone.craft253.util;

import java.io.File;

public class PathUtils {

    /**
     * 获取项目路径
     *
     * @return
     */
    public static String getProjectPath(){
        File file = new File("");
        return file.getAbsolutePath() + "/";
    }
}
