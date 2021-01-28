package com.kouyy.training.dowith.javaCompiler;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author kouyouyang
 * @date 2020-03-29 21:36
 */
public class Jcdemo {

    /**
     * 动态编译
     *
     * @param sourceFile
     * @return
     */
    public static int compileFile(String sourceFile) {

        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        int result = compiler.run(null, null, null, sourceFile);
        System.out.println(result == 0 ? "编译成功" : "编译失败");
        return result;
    }

    /**
     * 通过反射运行编译好的类
     *
     * @param dir
     * @param classFile
     * @throws Exception
     */
    public static void runJavaClassByReflect(String dir, String classFile) throws Exception {
        try {
            URL[] urls = new URL[]{new URL("file:/" + dir)};
            //类加载器
            URLClassLoader loader = new URLClassLoader(urls);
            Class c = loader.loadClass(classFile);
            //调用加载类的main方法
            c.getMethod("main", String[].class).invoke(null, (Object) new String[]{});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
