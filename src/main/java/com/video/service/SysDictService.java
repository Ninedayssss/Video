package com.video.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.video.domain.SysDict;
import com.video.domain.Tsyparm;
import com.video.mapper.SysDictMapper;
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
 * @create 2019-06-19-15:34
 */
@Transactional
@Service
public class SysDictService {
    @Autowired
    private SysDictMapper sysDictMapper;

    public void add(SysDict sysDict) {
        sysDictMapper.insert(sysDict);
    }

    public void del(String id) {
        sysDictMapper.deleteByPrimaryKey(id);
    }

    public void update(SysDict sysDict) {
        sysDictMapper.updateByPrimaryKeySelective(sysDict);
    }

    public SysDict queryById(String id) {
        SysDict sysDict = sysDictMapper.selectByPrimaryKey(id);
        return sysDict;
    }

    public List<SysDict> queryAll(){
        List<SysDict> sysDicts = sysDictMapper.selectAll();
        return sysDicts;
    }

    public PageResult<SysDict> queryByPage(Integer page, Integer rows, String key) {
        //分页
        PageHelper.startPage(page,rows);

        //过滤
        Example example = new Example(Tsyparm.class);
        if (StringUtils.isNoneBlank(key)){
            //过滤条件
            example.createCriteria().orLike("parmnm","%"+key+"%");
        }

        List<SysDict> list = sysDictMapper.selectByExample(example);

        PageInfo<SysDict> info = new PageInfo<>(list);
        return new PageResult<>(info.getTotal(),list);
    }
}
