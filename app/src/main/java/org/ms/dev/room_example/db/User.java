package org.ms.dev.room_example.db;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;


// @author maohuawei
// @date 2019/1/22
// 用户
@Entity(tableName = "user")
public class User {

    // ID
    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    private int _id;

    // 用户名
    @ColumnInfo(name = "username")
    private String username;

    // 邮箱
    @ColumnInfo(name = "email")
    private String email;

    // 密码
    @ColumnInfo(name = "password")
    private String password;

    @ColumnInfo(name = "userid")
    private String userid;

    // access_token
    @ColumnInfo(name = "access_token")
    private String access_token;

    // tokeType
    @ColumnInfo(name = "token_type")
    private String token_type;

    // 刷新TOKEN
    @ColumnInfo(name = "refresh_token")
    private String refresh_token;

    // 过期时间
    @ColumnInfo(name = "expires_in")
    private int expires_in;

    //用户来源，包括：chujian,visitor,facebook,huawei等
    @ColumnInfo(name = "user_source")
    private String user_source;

    //是否未正式账号
    @ColumnInfo(name = "need_upgrade")
    private boolean need_upgrade = false;

    // 是否绑定手机
    @ColumnInfo(name = "mobilebound")
    private boolean mobilebound = false;

    // 是否实名认证
    @ColumnInfo(name = "realname_authenticated")
    private boolean realname_authenticated = false;

    // 存入时间
    @ColumnInfo(name = "time")
    private long time;

    public User() {
        time = System.currentTimeMillis();
    }


    @NonNull
    public int get_id() {
        return _id;
    }

    public void set_id(@NonNull int _id) {
        this._id = _id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {

        this.password = password;

    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }

    public String getUser_source() {
        return user_source;
    }

    public void setUser_source(String user_source) {
        this.user_source = user_source;
    }

    public boolean isNeed_upgrade() {
        return need_upgrade;
    }

    public void setNeed_upgrade(boolean need_upgrade) {
        this.need_upgrade = need_upgrade;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }


    public boolean isMobilebound() {
        return mobilebound;
    }

    public void setMobilebound(boolean mobilebound) {
        this.mobilebound = mobilebound;
    }

    public boolean isRealname_authenticated() {
        return realname_authenticated;
    }

    public void setRealname_authenticated(boolean realname_authenticated) {
        this.realname_authenticated = realname_authenticated;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
