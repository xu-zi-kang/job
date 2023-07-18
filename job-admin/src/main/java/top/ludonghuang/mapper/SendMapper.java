package top.ludonghuang.mapper;

import top.ludonghuang.entity.Send;

import java.util.List;

public interface SendMapper {

	int create(Send send);

	int delete(Integer id);

	int update(Send send);

	List<Send> query(Send send);

	Send detail(Integer id);

	int count(Send send);
}