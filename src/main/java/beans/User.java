package beans;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class User {
    private String name;
    private Integer age;
    private InetAddress ip;

    public User(String name, Integer age) throws UnknownHostException {
        this.name = name;
        this.age = age;
        this.ip = InetAddress.getLocalHost();
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public InetAddress getIp() {
        return ip;
    }
}
