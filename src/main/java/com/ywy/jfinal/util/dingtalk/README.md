##钉钉消息推送组件
* 用法
```
仅需关注message包中各个Msg的构造方法即可
创建一个BaseMsg的子类,调用sendTo方法发送消息
```
* 代码示例
```
new TextMsg("我就是我不一样的烟火").sendTo("robot_token_123456789");
```
* 返回值
```
{"errcode":0,"errmsg":"ok"}
{"errcode":300001,"errmsg":"token is not exist"}
```