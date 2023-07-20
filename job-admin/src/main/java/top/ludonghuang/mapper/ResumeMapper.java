package top.ludonghuang.mapper;

import top.ludonghuang.entity.Resume;

import java.util.List;

public interface ResumeMapper {

	int create(Resume resume);

	int delete(Integer id);

	int update(Resume resume);

	List<Resume> query(Resume resume);



	List<Resume> detail(Integer id);

	List<Resume> detail2(Integer id);


	int count(Resume resume);
}