<p align="center"><font size="70"> Aggr 数据聚合</font></p>

## 介绍

 Aggr是基于cglib和google-collections实现的一款数据动态聚合工具；方便快速将两个对象进行根据指定条件对比后，将对象中的字段进行合并，从而将两个对象聚合在一个对象中，返回给前端。

## 开发

```shell
#克隆项目
git clone https://github.com/gaadev/aggr.git
#进入项目
cd aggr
#项目打包
gradle build
```

将打包后的jar包，导入到自己的项目中即可使用

## 使用

**将B对象（Entity或者List）转换为A对象中的某个字段**

```java
/**
 * 需要注意的是，当A对象为集合时，则B必须为集合；
 * 当A对象为Entity时，则B不需要与之相对应
 */
A a = Aggr.main(A).connect(B).name(customerName).build();
```

**将A集合与B集合 根据指定字段进行聚合为A集合中的对象中的指定字段**

```java
/**
 * 单个字段比较
 * AID: 为A集合对象中有的字段且必须存在，否则会找不到字段从而导致抛出异常
 * BID: 为B集合对象中有的字段且必须存在，否则会找不到字段从而导致抛出异常
 * 当比较的字段为id时，则可以缺省id()方法，默认为id字段比较，即A = Aggr.main(A).connect(B).name(customerName).build();
 */   
A = Aggr.main(A).id(AID).connect(B).id(BID).name(customerName).build();
/**
 * 多个字段比较
 * 
 * 当比较字段为id时，id字段也可以缺省，直接添加mixId，则会默认添加上id字段进行比较 。即A = Aggr.main(A).mixId(AMixID).connect(B).mixId(BMixID).name(customerName).build();
 */ 
A = Aggr.main(A).id(AID).mixId(AMixID).connect(B).id(BID).mixId(BMixID).name(customerName).build();
```

