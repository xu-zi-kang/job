package top.ludonghuang.mapper;

import top.ludonghuang.entity.Dict;

import java.util.List;

public interface DictMapper {

	int create(Dict dict);

	int delete(Integer id);

	int update(Dict dict);

	List<Dict> query(Dict dict);

	Dict detail(Integer id);

	int count(Dict dict);
}