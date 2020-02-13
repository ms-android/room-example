package org.ms.dev.room_example.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import io.reactivex.Single;

// @author maohuawei
// @date 2019/1/22
// UserDao
@Dao
public interface UserDao {
    // 查询所有的用户
    @Query("SELECT * FROM user")
    Single<List<User>> queryAllUser();

    @Query("SELECT * FROM user WHERE userid=:user_id")
    Single<User> queryUser(String user_id);


    @Query("SELECT * FROM user WHERE username = (:uname)")
    Single<User> queryUsername2User(String uname);

    // 查询所有的用户id
    @Query("SELECT * FROM user WHERE _id IN (:userIds)")
    Single<List<User>> queryAllIds(int[] userIds);

    // 查询所有的用户名
    @Query("SELECT * FROM user WHERE username IN (:name)")
    Single<List<User>> queryAllUsernames(String[] name);

    // 查询最后一条数据
    @Query("SELECT * FROM  (SELECT * FROM user ORDER BY time DESC )  LIMIT 0,1")
    Single<User> getLastUser();

    // 更新数据
    @Update
    int update(User... user);

    // 插入数据
    @Insert
    void insert(User... users);

    // 删除数据
    @Delete
    void delete(User... user);
}