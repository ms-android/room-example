
package org.ms.dev.room_example.db.opt;


import org.ms.dev.room_example.db.User;

import java.util.List;

import io.reactivex.Single;

// @author maohuawei
// @date 2019/1/22
// 数据库操作接口
public interface UserDataSource {

    // 获取所有的用户
    Single<List<User>> getUsers();

    Single<User> getUser(String userid);

    // 查询最后一个用户
    Single<User> getLastUser();

    Single<User> queryUsername2User(String username);

    // 插入或者更新用户
    void insertOrUpdateUser(User user);


    void update(User... user);

    // 删除所有的用户
    void deleteAllUsers();

    //删除某个用户
    void deleteUser(User user);
}