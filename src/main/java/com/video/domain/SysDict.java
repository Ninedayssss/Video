package com.video.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author itsNine
 * @create 2019-06-19-14:51
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sys_dict")
public class SysDict {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;

    private Long num;
    private Long pid;
    private String name;
    private String tips;

}
