package com.delivery.project01.Service;

import com.delivery.project01.DTO.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.delivery.project01.DAO.UserDAO;

import java.util.List;

@Service
public class UserLoginServiceImpl implements UserLoginService {

        @Autowired
        private  UserDAO UserDAO;

        @Override
        public  boolean join(UserDTO DTO){
            UserDTO user = UserDAO.selectOneUser(DTO.getId());
            if(user!=null)
            {
                return false;
            }else{
                UserDAO.InsertUser(DTO);
                return true;
            }
        }
        @Override
        public List<UserDTO> getUserList(){
            return UserDAO.selectAllUser();
        }
    }

