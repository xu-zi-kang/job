package top.ludonghuang.service.serviceImpl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import top.ludonghuang.entity.Predict;
import top.ludonghuang.entity.Profession;
import top.ludonghuang.entity.Train;
import top.ludonghuang.mapper.PredictMapper;
import top.ludonghuang.service.PredictService;

import java.util.List;


/**
 * @Description:
 * @Auther: yol$
 * @Data: 2023/7/25
 */
@Service
public class PredictServiceImpl implements PredictService {

    @Autowired
    private PredictMapper predictMapper;


    @Override
    public void createPredict(Predict predict) {
        predictMapper.createPredict(predict);
    }


//    @Override
//    public Page<Predict> getPage(int currentPage, int pageSize) {
//        Page<Predict> page = new Page<>();
//        predictMapper.selectPage(page,null);
//        return page;
//    }


    @Override
    public PageInfo<Predict> query(Predict predict) {
        if (predict != null && predict.getPage() != null) {
            PageHelper.startPage(predict.getPage(), predict.getLimit());
        }
        return new PageInfo<>(predictMapper.query(predict));
    }


    //删除
    public int delete(String ids) {
        String[] arr = ids.split(",");
        int row = 0;
        for (String s : arr) {
            if (!StringUtils.isEmpty(s)) {
                predictMapper.delete(Integer.parseInt(s));
                row++;
            }
        }
        return row;
    }


    public int update(Predict predict) {
        return predictMapper.update(predict);
    }


//按id查
    public List<Predict> detail(Integer id) {
        return predictMapper.detail(id);
    }





}
