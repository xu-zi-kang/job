package top.ludonghuang.mapper;

import top.ludonghuang.entity.Experience;

import java.util.List;

public interface ExperienceMapper {

	int create(Experience experience);

	int delete(Integer id);

	int update(Experience experience);

	List<Experience> query(Experience experience);

	Experience detail(Integer id);

	int count(Experience experience);
}