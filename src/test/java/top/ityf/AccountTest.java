package top.ityf;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import top.ityf.dao.AccountDao;
import top.ityf.dao.UserDao;
import top.ityf.domain.Account;
import top.ityf.domain.User;

import java.io.InputStream;
import java.util.List;

/**
 * ClassName:AccountTest
 * Package: top.ityf
 * Description:
 *
 * @Date: 2020/1/4 23:59
 * @Author: YanFei
 */
public class AccountTest {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession sqlSession;
    private AccountDao accountDao;

    @Before
    public void init() throws Exception {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        sqlSession = factory.openSession();
        accountDao = sqlSession.getMapper(AccountDao.class);
    }

    @After
    public void destory() throws Exception {
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }


    @Test
    public void testFindAll(){
        List<Account> accounts = accountDao.findAll();
        for(Account account:accounts){
            System.out.println("-------------");
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }

    @Test
    public void testFindOne(){
        List<Account> accounts = accountDao.findById(36);
        for (Account account:accounts){
            System.out.println(account);
        }
    }
}
