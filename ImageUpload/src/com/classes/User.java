package com.classes;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {
    @Id
String userName;
String password;
@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
List<ImageDetails> list;

public List<ImageDetails> getList() {
    return list;
}

public void setList(List<ImageDetails> list) {
    this.list = list;
}

public String getUserName() {
    return userName;
}

public void setUserName(String userName) {
    this.userName = userName;
}

public String getPassword() {
    return password;
}

public void setPassword(String password) {
    this.password = password;
}


}
