package top.ityf.domain;

import java.io.Serializable;

/**
 * ClassName:Account
 * Package: top.ityf.domain
 * Description:
 *
 * @Date: 2020/1/4 23:55
 * @Author: YanFei
 */
public class Account implements Serializable {
    private Integer id;
    private Integer uid;
    private Integer money;

    //多对一(mybatis中称为一对一)的映射，一个账户只能属于一个用户
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", uid=" + uid +
                ", money=" + money +
                '}';
    }
}
