package com.sxt.office.common;

import com.sxt.office.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author tanghua
 * @Date: 2020/5/25 14:43
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActiverUser {

    private User user;

    private List<String> roles;

    private List<String> permissions;
}
