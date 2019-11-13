package user;

public class Message_port {
    private int Message_port_id;
    private int User_id;
    private int Post_id;
    private int B_id;
    private String Message_content;
    private String Message_time;

    public String getMessage_time() {
        return Message_time;
    }

    public void setMessage_time(String message_time) {
        Message_time = message_time;
    }

    public String getMessage_content() {
        return Message_content;
    }

    public void setMessage_content(String message_content) {
        Message_content = message_content;
    }

    public int getPost_id() {
        return Post_id;
    }

    public void setPost_id(int post_id) {
        Post_id = post_id;
    }

    public int getUser_id() {
        return User_id;
    }

    public void setUser_id(int user_id) {
        User_id = user_id;
    }

    public int getMessage_port_id() {
        return Message_port_id;
    }

    public void setMessage_port_id(int message_port_id) {
        Message_port_id = message_port_id;
    }

    public int getB_id() {
        return B_id;
    }

    public void setB_id(int b_id) {
        B_id = b_id;
    }
}
