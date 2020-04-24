package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HwProperties {

    @Value("${python.path}")
    private String pythonPath;
    @Value("${python.method}")
    private String pythonMethod;

    public String getPythonPath() {
        return pythonPath;
    }

    public void setPythonPath(String pythonPath) {
        this.pythonPath = pythonPath;
    }

    public String getPythonMethod() {
        return pythonMethod;
    }

    public void setPythonMethod(String pythonMethod) {
        this.pythonMethod = pythonMethod;
    }
}
