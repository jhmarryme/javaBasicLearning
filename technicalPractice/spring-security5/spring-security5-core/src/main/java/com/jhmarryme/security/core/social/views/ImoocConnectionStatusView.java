package com.jhmarryme.security.core.social.views;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.AbstractView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 查看社交账号绑定状态的视图
 *      connect/status为默认值
 * @author JiaHao Wang
 * @date 2021/1/27 14:16
 */
@Component("connect/status")
public class ImoocConnectionStatusView extends AbstractView {

    @Autowired
    private ObjectMapper objectMapper;

    @SuppressWarnings("unchecked")
    @Override
    protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 从model中取出 社交账号绑定状态的数据
        Map<String, List<Connection<?>>> connectionMap = (Map<String, List<Connection<?>>>) model.get("connectionMap");

        Map<String, Boolean> result = new HashMap<>();

        connectionMap.forEach((providerId, connections) -> {
            result.put(providerId, CollectionUtils.isNotEmpty(connections));
        });

        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(objectMapper.writeValueAsString(result));
    }
}
