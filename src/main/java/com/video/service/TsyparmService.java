package com.video.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.video.domain.Tsyparm;
import com.video.mapper.TsyparmMapper;
import com.video.vo.PageResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author itsNine
 * @create 2019-06-19-10:18
 */
@Transactional
@Service
public class TsyparmService {

    @Autowired
    private TsyparmMapper tsyparmMapper;

    public void add(Tsyparm tsyparm) {
        tsyparmMapper.insert(tsyparm);
    }

    public void del(String id) {
        tsyparmMapper.deleteByPrimaryKey(id);
    }

    public void update(Tsyparm tsyparm) {
        tsyparmMapper.updateByPrimaryKeySelective(tsyparm);
    }

    public Tsyparm queryById(String id) {
        Tsyparm tsyparm = tsyparmMapper.selectByPrimaryKey(id);
        return tsyparm;
    }

    public List<Tsyparm> queryAll(){
        List<Tsyparm> tsyparms = tsyparmMapper.selectAll();
        return tsyparms;
    }

    public PageResult<Tsyparm> queryByPage(Integer page, Integer rows, String key) {
        //分页
        PageHelper.startPage(page,rows);

        //过滤
        Example example = new Example(Tsyparm.class);
        if (StringUtils.isNoneBlank(key)){
            //过滤条件
            example.createCriteria().orLike("parmnm","%"+key+"%");
        }

        List<Tsyparm> tsyparms = tsyparmMapper.selectByExample(example);

        PageInfo<Tsyparm> info = new PageInfo<>(tsyparms);
        return new PageResult<>(info.getTotal(),tsyparms);
    }
}
