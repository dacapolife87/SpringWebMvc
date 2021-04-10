package me.hjjang.webmvc.web.frontcontroller.v3;

import me.hjjang.webmvc.web.frontcontroller.ModelView;

import java.util.Map;

public interface ControllerV3 {

    ModelView process(Map<String, String> paramMap);
}
