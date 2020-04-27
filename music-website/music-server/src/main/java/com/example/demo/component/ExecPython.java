package com.example.demo.component;


import com.example.demo.config.HwProperties;
import com.example.demo.config.JythonEnvironment;
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

@Service
@Component
public class ExecPython {

    @Autowired
    private HwProperties hwProperties;

    private static PythonInterpreter inter;
    public ExecPython() {
        this.inter  = JythonEnvironment.getInstance().getPythonInterpreter();
        String pathPython = hwProperties.getPythonPath();
        System.out.println("推荐算法调用地址:"+pathPython);
        this.inter.execfile(pathPython);
    }

    public List<String> getRecommandList(String userID){
        List<String> list = new ArrayList<>();
        try{
            String pathMethod=hwProperties.getPythonMethod();
            System.out.println("推荐算法调用方法地址:"+pathMethod);
            PyFunction pyFunction=this.inter.get(pathMethod,PyFunction.class);
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
