package top.ludonghuang.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import top.ludonghuang.entity.Resume;
import top.ludonghuang.mapper.ResumeMapper;

import java.util.List;

@Service
public class ResumeService {

    @Autowired
    private ResumeMapper resumeMapper;

    public int create(Resume resume) {
        return resumeMapper.create(resume);
    }

    public int delete(String ids) {
        String[] arr = ids.split(",");
        int row = 0;
        for (String s : arr) {
            if (!StringUtils.isEmpty(s)) {
                resumeMapper.delete(Integer.parseInt(s));
                row++;
            }
        }
        return row;
    }

    public int delete(Integer id) {
        return resumeMapper.delete(id);
    }

    public int update(Resume resume) {
        return resumeMapper.update(resume);
    }

    public PageInfo<Resume> query(Resume resume) {
        if (resume != null && resume.getPage() != null) {
            PageHelper.startPage(resume.getPage(), resume.getLimit());
        }
        return new PageInfo<>(resumeMapper.query(resume));
    }

    public List<Resume> detail(Integer id) {
        return resumeMapper.detail(id);
    }

    public List<Resume> detail2(Integer id) {
        return resumeMapper.detail2(id);
    }


    public int count(Resume resume) {
        return resumeMapper.count(resume);
    }
}
