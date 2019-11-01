package dao;

import user.garbage;
import user.user_reg;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    public user_reg login(user_reg user);
    public boolean register(user_reg user) throws SQLException, ClassNotFoundException;
    public  boolean update(user_reg user1,user_reg user2) throws SQLException, ClassNotFoundException;
    public List<garbage> search(String user_addr);
}
