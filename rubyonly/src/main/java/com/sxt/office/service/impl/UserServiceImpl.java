package com.sxt.office.service.impl;

import com.sxt.office.domain.User;
import com.sxt.office.mapper.UserMapper;
import com.sxt.office.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author rubyonly
 * @since 2020-05-25
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
