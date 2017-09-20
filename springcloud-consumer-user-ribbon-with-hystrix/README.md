

http://192.168.1.105:9050/hystrix.stream ,会进行ping操作,但是没有数据.
需要先请求一次http://192.168.1.105:9050/consumer/all ,
http://192.168.1.105:9050/hystrix.stream , 就会有数据了.