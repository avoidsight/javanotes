---
title: spring data jpa 分页及排序
date: 2019-07-18 17:45:41
tags:
    - jpa
    - spring
categories: java
---
# Jpa分页及其排序

## 分页排序相关的接口和类

### 排序类-Sortv
- 主要实现排序功能，内部使用枚举类型Direction标示其排序方式
``` java
public static enum Direction {
    ASC,
    DESC;
    //省略方法
  }
``` 
<!--more-->

- Sort的构造函数及常用构造Sort的方法

``` java
//排序方式和需要排序的字段
public Sort(Direction direction, String... properties)
//实现远离差不多，这里字段可以使用list
public Sort(Direction direction, List<String> properties)
//排序字段，默认正序
public static Sort by(String... properties) 
//Order是Sort的内部类，定义排序的方向和字段
public static Sort by(List<Order> orders)
public static Sort by(Order... orders)
//同构造函数
public static Sort by(Direction direction, String... properties) 
```
- 创建Sort的方式
``` java
//使用构造方法
Sort sort = new Sort(Sort.Direction.ASC,"id");
//使用by的方式
Sort sort1 = Sort.by(
                new Sort.Order(Sort.Direction.ASC,"id"),
                new Sort.Order(Sort.Direction.DESC,"city"));
```

### 分页接口-Pageable

- Pageable是一个提供了分页功能的接口，第几页，每页多少条记录等。

``` java 
int getPageNumber();

int getPageSize();

int getOffset();

Sort getSort();

Pageable next();

Pageable previousOrFirst();

Pageable first();

boolean hasPrevious();
```

### Pageable的实现类-PageRequest
- 提供三个构造PageRequest的方法，构造方法均不建议使用
``` java
//构建方式参考Sort
public static PageRequest of(int page, int size)
public static PageRequest of(int page, int size, Sort sort)
public static PageRequest of(int page, int size, Direction direction, String... properties)
```

### Spring提供的集成接口-PagingAndSortingRepository
- 继承自 CrudRepository 接口，提供了排序以及分页查询能力，提供了两个方法
``` java
Iterable<T> findAll(Sort sort);
Page<T> findAll(Pageable pageable);
```
- JpaRepository 接口继承了 PagingAndSortingRepository 接口，并封装了常用的 CRUD 方法，通常我们继承 JpaRepository 来进行操作。

## 分页排序的应用

- 声明一个BlogIpPageableRepository接口继承PagingAndSortingRepository

``` java
public interface BlogIpPageableRepository extends PagingAndSortingRepository<BlogIp,Integer> {
    List<BlogIp> findByCity(String city, Pageable pageable);
    List<BlogIp> findByIp(String ip, Sort sort);
}
```

### 分页

- 创建分页对象进行查询
```java
//第一页(从0开始)，每页两条数据
Pageable pageable = PageRequest.of(1,2);
List<BlogIp> page =  blogIpPageableRepository.findByCity("222",pageable);
```
- 虽然 PagingAndSortingRepository 接口中只有 findAll 方法，但是我们依然可以使用 Repository 中的衍生查询，我们只要把 Pageable 放到最后一个参数即可

### 排序
- 可使用多个Order对象对不同列进行排序
``` java
//按id倒序
List<BlogIp> list = blogIpPageableRepository.findByIp("333",new Sort(Sort.Direction.DESC,"id"));
```

### 分页和排序
- 使用PageRequest的of方法，把Sort对象封装进去
```java
List<BlogIp> list = blogIpPageableRepository.findAll(PageRequest.of(1,2,Sort.by(Sort.Direction.DESC,"id"))).getContent();
```

## JpaSpecificationExecutor
- Spring Data Jpa 支持 Criteria 查询方式，使用这种方式需要 ***继承 JpaSpecificationExecutor 接口***，该接口提供了如下一些方法
```java
Optional<T> findOne(@Nullable Specification<T> spec);
List<T> findAll(@Nullable Specification<T> spec);
Page<T> findAll(@Nullable Specification<T> spec, Pageable pageable);
List<T> findAll(@Nullable Specification<T> spec, Sort sort);
long count(@Nullable Specification<T> spec);
```
- !!!一定要加Repository标识注解，不然会注入失败
```java
public interface BlogIpSpecificationRepository extends JpaSpecificationExecutor<BlogIp>, Repository<BlogIp, Integer> {
}
```

- 通过实现 Specification 中的 toPredicate 方法来定义动态查询，通过 CriteriaBuilder 来创建查询条件

```java
List<BlogIp> list = blogIpSpecificationRepository.findAll((Specification<BlogIp>) (root, query, criteriaBuilder) -> {
            Predicate p1 = criteriaBuilder.like(root.get("city"),"上海%");
            Predicate p2 = criteriaBuilder.greaterThan(root.get("ip"),"111");
            return criteriaBuilder.and(p1,p2);
        });
```

- 这里生成的sql就是
```sql
select * from blog_ip where city like '上海%' and ip > 111;
```

## @Query查询
- repository的写法，controller或者service直接调用
```java
@Query(value = "select * from blog_ip o where o.id= :id ",nativeQuery=true)
    BlogIp findById(@Param("id") int id);
```

## 更一般化的写法
```java
public interface BlogIpRepository extends JpaRepository<BlogIp,Integer> {
  Page<BlogIp> findAll(Specification<BlogIp> specification, Pageable pageable);
}
```
```java
//or连接的两个条件
List<BlogIp> list = blogIpRepository.findAll(Specification.where((Specification<BlogIp>) (root, query, criteriaBuilder) -> {
            Predicate p1 = criteriaBuilder.like(root.get("city"),"上%");
            Predicate p2 = criteriaBuilder.lessThan(root.get("ip"),"888");
            return criteriaBuilder.and(p1,p2);
        }).or((Specification<BlogIp>) (root, query, criteriaBuilder) -> {
            Predicate p1 = criteriaBuilder.like(root.get("city"),"高%");
            Predicate p2 = criteriaBuilder.lessThan(root.get("ip"),"888");
            return criteriaBuilder.and(p1,p2);
        }),PageRequest.of(0,10,Sort.by(Sort.Direction.DESC,"id"))).getContent();
```
