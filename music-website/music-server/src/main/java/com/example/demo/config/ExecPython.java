package com.example.demo.config;


import com.example.demo.config.HwProperties;
import com.example.demo.config.JythonEnvironment;
import org.python.antlr.ast.Str;
import org.python.core.Py;
import org.python.core.PyFunction;
import org.python.core.PyList;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class ExecPython {
    private static PythonInterpreter inter;
    public ExecPython(){}
    public ExecPython(String path) {
        this.inter  = JythonEnvironment.getInstance().getPythonInterpreter();
        System.out.println("推荐算法调用地址:"+path);
        this.inter.execfile(path);
    }

    public List<String> getRecommandList(String path,String userID){
        List<String> list = new ArrayList<>();
        try{
            System.out.println("推荐算法调用方法地址:"+path);
            PyFunction pyFunction=this.inter.get(path,PyFunction.class);
            PyList pylist = (PyList) pyFunction.__call__(Py.newString(userID));
            for (int i=0;i<pylist.size();i++){
                String value = pylist.get(i).toString();
                list.add(value);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return list;
    }
}
