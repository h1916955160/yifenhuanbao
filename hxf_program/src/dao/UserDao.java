package dao;

import user.Message_port;
import user.garbage;
import user.invitation;
import user.user_reg;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface UserDao {
    public user_reg login(user_reg user);
    public boolean register(user_reg user) throws SQLException, ClassNotFoundException;
    public  boolean update(user_reg user1,user_reg user2) throws SQLException, ClassNotFoundException;
    public List<garbage> search(String user_addr);
    public ArrayList<invitation> post_invitation(int user_id,int post_id);
    public  ArrayList<Message_port> port_Message(int t_id,int u_id);
    public  ArrayList<Message_port> port_Message1(int t_id,int u_id,int m_id);

}
