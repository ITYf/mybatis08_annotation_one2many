package top.ityf.dao;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import top.ityf.domain.User;

import java.util.List;

/**
 * ClassName:UserDao
 * Package: top.ityf.dao
 * Description: 在 mybatis 中针对CRUD一共有四个注解
 *
 * @Select @Insert @Update @Delete
 * @Date: 2020/1/4 14:27
 * @Author: YanFei
 */
@CacheNamespace(blocking = true)
public interface UserDao {
    /**
     * 查询所有用户
     */
    @Select("select * from user")
    @Results(id = "userMap", value = {
            @Result(id = true, column = "id", property = "userId"),
            @Result(column = "username", property = "userName"),
            @Result(column = "address", property = "userAddress"),
            @Result(column = "sex", property = "userSex"),
            @Result(column = "birthday", property = "userBirthday"),
            @Result(column = "id",property = "accounts",
                    many = @Many(select = "top.ityf.dao.AccountDao.findById",
                            fetchType = FetchType.LAZY))
    })
    List<User> findAll();

    /**
     * 根据id查询用户信息
     */
    @Select("select * from user where id=#{id}")
    //当value值只有一个时，可以省略value和花括号
    @ResultMap(value = {"userMap"})
    User findById(Integer id);

    /**
     * 根据用户名称模糊查询
     */
    @Select("select * from user where username like #{username} ")
    @ResultMap("userMap")
    List<User> findUserByName(String name);

}
