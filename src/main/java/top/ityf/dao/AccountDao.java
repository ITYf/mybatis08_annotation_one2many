package top.ityf.dao;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;
import top.ityf.domain.Account;

import java.util.List;

/**
 * ClassName:AccountDao
 * Package: top.ityf.dao
 * Description:
 *
 * @Date: 2020/1/4 23:57
 * @Author: YanFei
 */
public interface AccountDao {
    /**
     * 查询所有账户，并获取每个账户所属的用户信息
     * */
    @Select("select * from account")
    @Results(id = "accountMap" ,value = {
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "uid",property = "uid"),
            @Result(column = "money",property = "money"),
            @Result(column = "uid",property = "user",
                    one = @One(select = "top.ityf.dao.UserDao.findById",
                            fetchType = FetchType.EAGER))
    })
    List<Account> findAll();

    /**
     * 根据Id查询账户 ，这里的id是用户的id
     * */
    @Select("select * from account where uid=#{userId}")
    List<Account> findById(Integer id);
}
