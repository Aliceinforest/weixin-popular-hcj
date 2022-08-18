package weixin.popular.example;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.beans.factory.annotation.Value;
import weixin.popular.support.TokenManager;

public class TokenManagerListener implements ServletContextListener {
    @Value("${app.id}")
    String appId;

    @Value("${app.secret}")
    String appSecret;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //WEB容器 初始化时调用
        TokenManager.init(appId, appSecret);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //WEB容器  关闭时调用
        TokenManager.destroyed();
    }
}
