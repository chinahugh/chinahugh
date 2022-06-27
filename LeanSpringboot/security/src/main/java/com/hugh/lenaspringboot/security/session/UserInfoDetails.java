package com.hugh.lenaspringboot.security.session;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hugh.lenaspringboot.security.entity.Menu;
import com.hugh.lenaspringboot.security.entity.UserInfo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class UserInfoDetails implements UserDetails, Serializable {

    private UserInfo userInfo;
    private List<SimpleGrantedAuthority> authorities;

    public UserInfoDetails(UserInfo userInfo) {
        this.userInfo = userInfo;
        this.authorities = userInfo.getMenus().stream()
                .map(Menu::getMunu)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    @JsonIgnore
    public String getPassword() {
        return userInfo.getPassword();
    }

    @Override
    public String getUsername() {
        return userInfo.getUsername();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
//        Collection<GrantedAuthority> authorities=new ArrayList<>();
//        for (Role role : userInfo.getRoles()) {
//            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("ROLE_" + role.getValue());
//            authorities.add(simpleGrantedAuthority);
//        }
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public void setAuthorities(List<SimpleGrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", UserInfoDetails.class.getSimpleName() + "[", "]")
                .add("userInfo=" + userInfo)
                .toString();
    }
}
