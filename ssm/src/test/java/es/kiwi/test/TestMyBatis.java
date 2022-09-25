package es.kiwi.test;

import es.kiwi.mapper.AccountDAO;
import es.kiwi.model.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMyBatis {

    @Test
    public void run1() throws Exception {
        InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");

        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = factory.openSession(true);
        AccountDAO accountDAO = sqlSession.getMapper(AccountDAO.class);

        List<Account> accounts = accountDAO.findAll();
        accounts.forEach(System.out::println);

        sqlSession.close();
        in.close();
    }

    @Test
    public void run2() throws Exception {
        InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");

        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = factory.openSession(true);
        AccountDAO accountDAO = sqlSession.getMapper(AccountDAO.class);

        Account account = new Account();
        account.setName("Ryan");
        account.setMoney(6000f);
        accountDAO.saveAccount(account);

        sqlSession.close();
        in.close();
    }
}
