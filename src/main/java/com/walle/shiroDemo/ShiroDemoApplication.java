package com.walle.shiroDemo;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.ldap.DefaultLdapRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
@MapperScan(basePackages = "com.walle.shiroDemo.mapper")
public class ShiroDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShiroDemoApplication.class, args);
    }

    /**
     * Apache shiro -授权
     * crud-->crete read update delete
     * 建立在资源和程序操作上
     * 权限分配给某个角色，角色关联用户
     * 1.subject.isPermitted/hasRole --->Security Manager -->Author
     * <p>
     * subject 当前用户执行的一系列操作 ，而不是特定的用户
     */

    /**
     * shiro 简单易懂，在filter里配置就行
     * spring security 难学、复杂
     */
    public void test() {

        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(new DefaultLdapRealm());
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("fuck", "shit");
        Session session = subject.getSession();
        session.setAttribute("fuck", "shit");
    }
}
