package com.lemon.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by lemoon on 20/2/2 上午9:38
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    public void insertUser() {
        userDao.insert();
        //otherDao.other();XXX
        System.out.println("插入完成");
        int i = 10 / 0;
    }
}
