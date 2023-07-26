package top.ludonghuang.service;


import com.github.pagehelper.PageInfo;
import top.ludonghuang.entity.Predict;
import top.ludonghuang.entity.Train;

import java.util.List;

public interface PredictService {



    public void createPredict(Predict predict);



   // public Page<Predict> getPage(int currentPage, int pageSize);


    public PageInfo<Predict> query(Predict predict);


//删除
    public int delete(String ids);



    public int update(Predict predict);

    public List<Predict> detail(Integer id);

}
