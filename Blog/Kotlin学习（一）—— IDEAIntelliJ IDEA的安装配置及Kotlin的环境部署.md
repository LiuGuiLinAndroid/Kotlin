# Kotlin学习（一）——IDEAIntelliJ IDEA的安装配置及Kotlin的环境部署

## 一.概括

从这篇博客开始，我们就正式的开始学习Kotlin了，首先我们来了解下他的几个重点

- Kotlin 是一个基于 JVM 的新的编程语言，由 JetBrains 开发。
- Kotlin可以编译成Java字节码，也可以编译成JavaScript，方便在没有JVM的设备上运行。
- JetBrains，作为目前广受欢迎的Java IDE IntelliJ 的提供商，在 Apache 许可下已经开源其Kotlin 编程语言。
- Kotlin已正式成为Android官方支持开发语言

JetBrains 的另一个代表作：IDEA，我相信大家都不陌生，所以我们在前期学习的时候依旧会以IDEA作为编译器，后期讲到Android这一块的时候，再用Android Studio

那我们首先先安装一下IntelliJ IDEA

![这里写图片描述](http://img.blog.csdn.net/20171117113214550?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY3ODcxMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

点击直接下载就好了

- [IntelliJ IDEA下载地址](http://www.jetbrains.com/idea/download/index.html#section=windows)

## 二.安装
安装的话，一路Next下去就好了，然后启动

![这里写图片描述](http://img.blog.csdn.net/20171117130028942?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY3ODcxMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

这里是提示你是否有配置好的setting.jar，我们作为一次全新的安装，就选下面的没有就好了

![这里写图片描述](http://img.blog.csdn.net/20171117130200966?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY3ODcxMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

这是认证，想要破解的话自行搜索就好了，推荐使用注册码

![这里写图片描述](http://img.blog.csdn.net/20171117130354436?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY3ODcxMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

这里是选择的主题，白的黑的随便你

![这里写图片描述](http://img.blog.csdn.net/20171117130504674?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY3ODcxMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

OK，到这里安装步骤算是完成了

## 三.创建Kotlin项目
我们成功安装完了之后，就可以创建项目了

![这里写图片描述](http://img.blog.csdn.net/20171117132857932?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY3ODcxMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

点击Create New Project

![这里写图片描述](http://img.blog.csdn.net/20171117133008197?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY3ODcxMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

然后我们选中Kotlin一栏，这里就有两种类型了，一种JVM还有一种JS，我们选择JVM，然后Next

![这里写图片描述](http://img.blog.csdn.net/20171117133158442?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY3ODcxMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

这里就要说明一下了，首先，name就是工程的名字，然后location的话，随便你放哪，紧接着SDK，这里你一开始安装的时候会提示没有，所以你需要指定你的JDK安装地址，也就是JAVA_HOME给他就好了，Library的话是默认自带的KotlinJavaRuntime，然后点击Finish就好了

![这里写图片描述](http://img.blog.csdn.net/20171117133854875?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY3ODcxMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

到这里算是成功创建了，我们从下节课开始就会开始学习了

## 四.IDEA配置

其实IDEA的配置和Android Studio基本上一样，所以大家可以直接看我的这篇博客

- [Android Studio重构之路，我们重新来了解一下Google官方的Android开发工具](http://blog.csdn.net/qq_26787115/article/details/51774003)

#### 如果有兴趣的话，可以加入我的Kotlin学习小组

![这里写图片描述](http://img.blog.csdn.net/20171117134155479?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcXFfMjY3ODcxMTU=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

#### **我的公众号，期待你的关注**

![weixin](http://img.blog.csdn.net/20160108203741937)