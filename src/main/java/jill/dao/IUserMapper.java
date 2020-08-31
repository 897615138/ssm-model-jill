package jill.dao;

import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import jill.entity.UserInfo;

@Repository

public interface IUserMapper extends BaseMapper<UserInfo> {
}
