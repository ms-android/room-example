

package org.ms.dev.room_example.db.opt;


import org.ms.dev.room_example.db.LocalUserDataSource;
import org.ms.dev.room_example.db.UsersDatabase;

// @author maohuawei
// @date 2019/1/7
// 数据库操作对象
// 桥接模式设计
public class Injection {

    public static UserDataSource provideUserDataSource() {
        UsersDatabase database = UsersDatabase.getInstance();
        return new LocalUserDataSource(database.userDao());
    }
}