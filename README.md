# AgentManagementSystem
这是一个代理商管理系统
代理商管理系统主要是总公司对各个代理商进行管理，各级代理商可以使用这个系统对用户进行管理的的一个系统。
总公司可以在这个系统上进行代理商的扣费，除名，添加，修改权限等操作。
代理商可以在平台上进行关键字的申请，门户网站的管理（由总公司提供）。
关键字：关键字是代理商在总公司拿到产品后，对该产品在网络上的一种推广，举个例子：在代理商拿到公司提供的产品，眼镜后，再在系统上申请关键字“眼镜”，总公司会与搜索引擎
公司进行沟通，在用户搜索眼镜的时候，对该代理商的门户网站排名进行调整，具体费用视情况而定。
原型是用Spring+Struts2+myBatis写的，使用Springboot二次开发，基本各个功能模块都已实现，报表可以用excel和pdf进行下载。
在用户显示的页面上，大多都是采用的ajax实时刷新。对于代理商的扣款缴费，都采用事物回滚，保护资金的正常。

![Image text](https://github.com/yanzhao77/AgentManagementSystem/blob/master/AgentSystem-03-1/src/main/webapp/imgs/1.png)
      
![Image text](https://github.com/yanzhao77/AgentManagementSystem/blob/master/AgentSystem-03-1/src/main/webapp/imgs/2.png)
![Image text](https://github.com/yanzhao77/AgentManagementSystem/blob/master/AgentSystem-03-1/src/main/webapp/imgs/3.png)
![Image text](https://github.com/yanzhao77/AgentManagementSystem/blob/master/AgentSystem-03-1/src/main/webapp/imgs/4.png)
![Image text](https://github.com/yanzhao77/AgentManagementSystem/blob/master/AgentSystem-03-1/src/main/webapp/imgs/5.png)
