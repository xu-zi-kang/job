package top.ludonghuang.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import top.ludonghuang.entity.Train;
import top.ludonghuang.mapper.TrainMapper;

import java.util.List;

@Service
public class TrainService {

    @Autowired
    private TrainMapper trainMapper;



    public int create(Train train) {
        return trainMapper.create(train);
    }



    public int delete(String ids) {
        String[] arr = ids.split(",");
        int row = 0;
        for (String s : arr) {
            if (!StringUtils.isEmpty(s)) {
                trainMapper.delete(Integer.parseInt(s));
                row++;
            }
        }
        return row;
    }



    public int delete(Integer id) {
        return trainMapper.delete(id);
    }




    public int update(Train train) {
        return trainMapper.update(train);
    }



    public PageInfo<Train> query(Train train) {
        if (train != null && train.getPage() != null) {
            PageHelper.startPage(train.getPage(), train.getLimit());
        }
        return new PageInfo<>(trainMapper.query(train));
    }




    public List<Train> detail(Integer id) {
        return trainMapper.detail(id);
    }

    public int count(Train train) {
        return trainMapper.count(train);
    }

}
