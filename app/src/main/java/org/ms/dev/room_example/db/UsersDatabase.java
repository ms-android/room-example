package org.ms.dev.room_example.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;


// @author maohuawei
// @date 2019/1/22
// 数据库实例化
@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class UsersDatabase extends RoomDatabase {
    public abstract UserDao userDao();

    private static volatile UsersDatabase INSTANCE;

    public static UsersDatabase getInstance() {
        if (INSTANCE == null) {
            synchronized (UsersDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(DataBaseInitProvider.application,
                            UsersDatabase.class, "app-user.db")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}