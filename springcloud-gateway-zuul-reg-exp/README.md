# 正则表达式指定路由规则

```java
@SpringBootApplication
@EnableZuulProxy
public class Application {

	@Bean
	public PatternServiceRouteMapper serviceRouteMapper() {
		return new PatternServiceRouteMapper("(?<name>^.+)-(?<version>v.+$)", "${version}/${name}");
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
```

请求的应用名称为:springcloud-provide-users-v1

请求的url:   http://localhost:9006/v1/springcloud-provide-users/api/sysUsers