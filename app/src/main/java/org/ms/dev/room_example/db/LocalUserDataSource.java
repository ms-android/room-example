package org.ms.dev.room_example.db;
import org.ms.dev.room_example.db.opt.UserDataSource;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleObserver;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

// @author maohuawei
// @date 2019/1/22
// 实现数据库操作
public class LocalUserDataSource implements UserDataSource {

    private static final String TAG = "LocalUserDataSource";

    private final UserDao mUserDao;

    public LocalUserDataSource(UserDao mUserDao) {
        this.mUserDao = mUserDao;
    }

    @Override
    public Single<List<User>> getUsers() {
        return mUserDao.queryAllUser();
    }

    @Override
    public Single<User> getUser(String userid) {
        return mUserDao.queryUser(userid);
    }

    @Override
    public Single<User> getLastUser() {
        return mUserDao.getLastUser();
    }

    @Override
    public Single<User> queryUsername2User(String username) {
        return mUserDao.queryUsername2User(username);
    }

    @Override
    public void insertOrUpdateUser(User user) {
        if (user == null) {

            return;
        }

        mUserDao.queryAllUser()
                .subscribeOn(Schedulers.io()).
                subscribe(new SingleObserver<List<User>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onSuccess(List<User> users) {

                    }

                    @Override
                    public void onError(Throwable e) {

                        e.printStackTrace();
                    }
                });
    }

    @Override
    public void update(User... user) {
        Single.create(new SingleOnSubscribe<Integer>() {
            @Override
            public void subscribe(SingleEmitter<Integer> emitter) throws Exception {
                emitter.onSuccess(0);
            }
        }).subscribeOn(Schedulers.io()).subscribe(new SingleObserver<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onSuccess(Integer integer) {

            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }

    @Override
    public void deleteAllUsers() {

        mUserDao.queryAllUser().subscribeOn(Schedulers.io()).subscribe(new Consumer<List<User>>() {
            @Override
            public void accept(List<User> users) throws Exception {
                for (User itemUser : users) {
                    deleteUser(itemUser);
                }

            }
        });
    }

    @Override
    public void deleteUser(User user) {
        Single.create(new SingleOnSubscribe<Integer>() {
            @Override
            public void subscribe(SingleEmitter<Integer> emitter) throws Exception {
                emitter.onSuccess(0);
            }
        }).subscribeOn(Schedulers.io()).subscribe(new SingleObserver<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onSuccess(Integer integer) {
                mUserDao.delete();
            }

            @Override
            public void onError(Throwable e) {
            }
        });
    }
}