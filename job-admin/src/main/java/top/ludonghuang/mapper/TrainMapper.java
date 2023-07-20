package top.ludonghuang.mapper;

import top.ludonghuang.entity.Train;

import java.util.List;

public interface TrainMapper {

	int create(Train train);

	int delete(Integer id);

	int update(Train train);

	List<Train> query(Train train);

	List<Train> detail(Integer id);

	int count(Train train);

}