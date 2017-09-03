
1.默认：
http://10.127.127.1:9005/springcloud-provide-user/api/sysUsers

2.配置
zuul:
  routes:
    springcloud-provide-user: /users/**

http://10.127.127.1:9005/users/api/sysUsers

3.配置：path + service-id
zuul:
  routes:
    userABC:  # userABC 可以随意命名，只要是唯一
      path: /users-path/**
      service-id: springcloud-provide-user

http://10.127.127.1:9005/users-path/api/sysUsers

4.配置：path + url




5.配置：正则表达式指定路由规则




6.zuul路由的strip-prefix与order




7.zuul的各种姿势


