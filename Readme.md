## 多层级问答对话式菜单模块

### 简介

适用于聊天机器人、短信机器人、客服机器人等场景的非即时问答对话场景，通过自定义菜单层级及跳转关系实现指令式交互。

### 基本效果展示

不同层级跳转与指令解析，其中`0`为返回上一层，`00`为返回主菜单

此版本除主菜单以外最多支持9个层级，每层可设置至多99个选项，只支持一个主菜单

![1](https://raw.githubusercontent.com/leishui/ChatBotMenu/master/img/1.gif)

[**示例代码(Java)**](https://github.com/leishui/ChatBotMenu/blob/master/src/Main.java)

![4](https://raw.githubusercontent.com/leishui/ChatBotMenu/master/img/4.jpg)

### 层级设置

使用一个long类型数字代表层级，每个菜单对应一个层级，不同层级菜单通过数值运算进行跳转操作，更多有关菜单的跳转请参照源码

其中`0`号菜单代表主菜单，每两个数字代表一层

例如：

【注】这里使用`01`做演示，实际使用省略前面的`0`

**主菜单--->第一层：**

* 主菜单第一项跳转为`01`号菜单
* 主菜单第55项跳转为`55`号菜单

**第一层--->第二层：**

* 在`01`号菜单继续向后跳转到`01`号菜单中的第23项，结果为`0123`号菜单
* 在`55`号菜单继续向后跳转到`55`号菜单中的第77项，结果为`5577`号菜单

**以此类推：** 且最多支持9个层级，每层可设置1~99个选项

![1](https://raw.githubusercontent.com/leishui/ChatBotMenu/master/img/1.jpg)

各菜单之间呈现树状结构，若将每个节点放置2个子节点，就得到一个二叉树结构，若每个节点放满99个子节点，则是一个99叉树

### 原理简介

1. Java中的long类型

```
基本类型：long 二进制位数：64
包装类：java.lang.Long
最小值：Long.MIN_VALUE=-9223372036854775808
最大值：Long.MAX_VALUE=9223372036854775807
```

取其中0~999999999999999999范围的数（不包括能被10整除的数，即0除外不以0结尾）

![3](https://raw.githubusercontent.com/leishui/ChatBotMenu/master/img/3.jpg)

每两个数字为一组分成9组，即前面讲到的9层，每个数标志着一个菜单位置

2. 层级跳转

![2](https://raw.githubusercontent.com/leishui/ChatBotMenu/master/img/2.jpg)

如图所示通过基础运算进行层级跳转，若要跳到`102`号菜单中的第13个，通过`(102 X 100) + 13`计算得到`10213`号菜单，若要再返回上一层，简单通过`10213 / 100`可得。

3. 更多实现参照源码