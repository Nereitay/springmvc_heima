package es.kiwi.mapper;

import es.kiwi.model.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AccountDAO {

    @Select("select * from account")
    List<Account> findAll();

    @Insert("insert into account (name, money) values ( #{name}, #{money})")
    void saveAccount(Account account);
}
