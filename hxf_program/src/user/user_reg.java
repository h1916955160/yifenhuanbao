package user;

public class user_reg {
    private int acount;
    private int passward;
    private String name;
    private String sex;
    private String addr;
    private String email;

    public  user_reg()
    {
        super();
    }
    public user_reg(int ac ,int pd ,String na, String sex, String ad, String em)
    {
        super();
        this.acount=ac;
        this.passward=pd;
        this.name=na;
        this.sex=sex;
        this.addr=ad;
        this.email=em;
    }
    public int getAcount() {
        return acount;
    }

    public void setAcount(int acount) {
        this.acount = acount;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPassward() {
        return passward;
    }

    public void setPassward(int passward) {
        this.passward = passward;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
}
