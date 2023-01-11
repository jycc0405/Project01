package com.delivery.project01.Service;

import com.delivery.project01.DTO.UserDTO;

import java.util.List;

public interface UserLoginService {
        public boolean join(UserDTO user);
        public List<UserDTO> getUserList();
}
