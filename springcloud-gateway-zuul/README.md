
1.默认：
```
spring:
  application:
    name: springcloud-gateway-zuul

server:
  port: 9040

eureka:
  client:
    service-url:
      defaultZone: http://localhost:9001/eureka
  instance:
    prefer-ip-address: true
```

请求url --> http://10.127.127.1:9005/springcloud-provide-user/api/sysUsers

2.配置
```
zuul:
  routes:
    springcloud-provide-user: /users/**
```

请求url --> http://10.127.127.1:9005/users/api/sysUsers

3.配置：path + service-id
```
zuul:
  routes:
    userABC:  # userABC 可以随意命名，只要是唯一
      path: /users-path/**
      service-id: springcloud-provide-user
```

请求url --> http://10.127.127.1:9005/users-path/api/sysUsers

4.配置：path + url
```
zuul:
  routes:
    userABC:
      path: /users-path/**
      url: http://localhost:8087
```

http://10.127.127.1:9005/users-path/api/sysUsers


5.配置：正则表达式指定路由规则




6.zuul路由的strip-prefix与order

zuul:
  prefix: /userApi

http://10.20.37.106:9005/userApi/springcloud-provide-user/api/sysUsers



7.zuul的各种姿势


8.zuul配置外部服务的负载均衡??
zuul配置了2个微服务，每个微服务有3个实例，对这些2个微服务进行负载均衡。







