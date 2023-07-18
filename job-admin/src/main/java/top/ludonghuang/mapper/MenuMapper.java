package top.ludonghuang.mapper;

import top.ludonghuang.entity.Menu;

import java.util.List;

public interface MenuMapper {

	int create(Menu menu);

	int delete(Integer id);

	int update(Menu menu);

	List<Menu> query(Menu menu);

	Menu detail(Integer id);

	int count(Menu menu);
}