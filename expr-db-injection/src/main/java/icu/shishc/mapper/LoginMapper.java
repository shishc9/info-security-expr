package icu.shishc.mapper;

import icu.shishc.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LoginMapper {
    User findByNameAndPwd(@Param("loginName") String loginName, @Param("password") String password);

    User findByNameAndPwdWithInjection(@Param("loginName") String loginName, @Param("password") String password);
}
