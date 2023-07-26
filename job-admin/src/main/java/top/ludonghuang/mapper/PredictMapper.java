package top.ludonghuang.mapper;


import org.apache.ibatis.annotations.Mapper;
import top.ludonghuang.entity.Predict;
import top.ludonghuang.entity.Train;


import java.util.List;

@Mapper
public interface PredictMapper  {

    public void createPredict(Predict predict);


    List<Predict> query(Predict predict);


    //删除
    int delete(Integer id);


//修改
    int update(Predict predict);


    List<Predict> detail(Integer id);


}
