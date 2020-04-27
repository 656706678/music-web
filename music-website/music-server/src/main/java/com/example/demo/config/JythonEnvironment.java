package com.example.demo.config;

import org.python.core.PySystemState;
import org.python.util.PythonInterpreter;

import java.util.Properties;

public final class JythonEnvironment {
   private static JythonEnvironment INSTANCE=new JythonEnvironment();
   private JythonEnvironment(){}
   public static JythonEnvironment getInstance(){
       return INSTANCE;
   }
   private PySystemState getPySystemState(){
       PySystemState.initialize();
       final PySystemState py=new PySystemState();
       py.setClassLoader(getClass().getClassLoader());
       return py;
   }
    public PythonInterpreter getPythonInterpreter(){
        Properties props = new Properties();
        props.put("python.home", "path to the Lib folder");
        props.put("python.console.encoding", "UTF-8");
        props.put("python.security.respectJavaAccessibility", "false");
        props.put("python.import.site", "false");
        Properties preprops = System.getProperties();
        PythonInterpreter.initialize(preprops,props,new String[0]);
        PythonInterpreter inter = new PythonInterpreter();
        return inter;
    }
}
