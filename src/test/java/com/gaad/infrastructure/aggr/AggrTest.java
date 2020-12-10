package com.gaad.infrastructure.aggr;


import com.gaad.infrastructure.aggr.core.Aggr;

import java.util.ArrayList;
import java.util.List;

/**
 * @author loken
 * @date 2020/12/9
 */
public class AggrTest {


    public static void test01() {
        User user = new User();
        user.setAge(1);
        user.setName("zhangsan");
        List<Long> type = new ArrayList<>();
        type.add(1L);
        type.add(2L);
        type.add(3L);
        Aggr.main(type).connect(user).name("type").build();
    }

    /**
     *
     */
    public static void test02() {
        User user = null;
        List<User> list1 = new ArrayList<>();
        List<User> list2 = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            user = new User();
            user.setId(i);
            user.setName("main" + i);
            list1.add(user);
        }
        for (int i = 1; i < 4; i++) {
            user = new User();
            user.setId(i);
            user.setAge(i);
            list2.add(user);
        }
        List<User> type = Aggr.main(list1).id("id").connect(list2).name("type").build();
        System.out.println("11111111");

    }


    public static void main(String[] args) {
        AggrTest.test01();
    }

    public static class User {

        private Integer id;

        private String name;

        private Integer age;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }
}
