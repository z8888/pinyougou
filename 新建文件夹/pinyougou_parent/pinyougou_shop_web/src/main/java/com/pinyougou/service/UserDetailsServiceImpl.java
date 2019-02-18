package com.pinyougou.service;

import com.pinyougou.pojo.TbSeller;
import com.pinyougou.sellergoods.service.SellerService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class UserDetailsServiceImpl implements UserDetailsService {
    // 使用set注入
    private SellerService sellerService;

    public void setSellerService(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 从数据库查是否存在这个账户
        TbSeller serviceOne = sellerService.findOne(username);

        List<GrantedAuthority> grantedAuthortity=new ArrayList<>();
        // 添加用户
        grantedAuthortity.add(new SimpleGrantedAuthority("ROLE_SELLER"));
        if(serviceOne!=null){
            // 如果不为空就返回
            if(serviceOne.getStatus().equals("1")){
            return new User(username,serviceOne.getPassword(),grantedAuthortity);
            }
        }
        return null;
    }
}
