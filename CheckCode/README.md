## 验证码
`com.yhc.servlet` servelet四位验证码，形式单一，不需要jar包，访问servlet.jsp    
`com.yhc.jcaptcha` 利用Jcaptcha组件生成验证码，与Spring组合使用，产生所种形式的验证码，访问jcaptcha.jsp   
> 需要jar包:  
`commons-collections-3.2.jar`   
`commons-logging-1.0.4.jar`  
`filters-2.0.235.jar`  
`jcaptcha-2.0-alpha-1-SNAPSHOT.jar`  
`jcaptcha-api-1.0.jar`  
`jcaptcha-integration-simple-servlet-2.0-alpha-1-SNAPSHOT.jar`    

`com.yhc.kaptcha` 利用Kaptcha组件生成各式验证码    
> 所需jar包：
`kaptcha-2.3.jar`  