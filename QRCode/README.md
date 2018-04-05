## java生成/解析二维码的两种方法  

1.zxing `com.yhc.zxing`  
> 访问 https://github.com/zxing/  
下载zxing项目 用新建项目ZxingJar，将zxing里面的core、javase中com及子文件拷入项目ZxingJar的src下，export出jar文件，命名为:  
`zxing-zxing-3.3.0.jar`  
`CreateQRCode` 创建二维码  

2.QRCode `com.yhc.qrcode`
> 访问 http://www.swetake.com/qrcode/index-e.html 生成  
https://zh.osdn.net/projects/qrcode/ 读取  
下载所需jar包 qrcode.jar  

3.前端js生成二维码，参见项目JsQRCode  
> 在github上搜索`jquery-qrcode-1.0`,引用其中的`jquery.qrcode.min.js`  
