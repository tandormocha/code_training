package com.kouyy.training.dowith.javaCompiler;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**
 * @author kouyouyang
 * @date 2020-03-29 22:12
 */
public class ScriptEngineDemo {
    //获得脚本引擎对象
    ScriptEngineManager sem = new ScriptEngineManager();
    ScriptEngine engine = sem.getEngineByName("javascript");

}
