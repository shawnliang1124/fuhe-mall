## 项目更新日志  

### 9月7日  
### 完成功能  
1.初始化了项目架构，实现了注册中心eureka ,微信服务 , 会员服务初始化,且将两个服务注册到注册中心上去。    

### 遇到的问题  
1.为了统一项目的管理，考虑到每个人的环境不一样的问题，请修改本机的hosts文件，将：
C:\Windows\System32\drivers\etc中增加以下这一行:   
  <b style="text-align:center">127.0.0.1 fuhe-mall.cn</b>


2.直接使用feign客户端的时候，会出现"405 not Suport"的错误，出错原因和分析见博文所示：
https://www.jianshu.com/p/36088be4a2bc  