package com.video.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author itsNine
 * @create 2019-06-19-10:09
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tsyparm")
public class Tsyparm {

    @Id
    @KeySql(useGeneratedKeys = true)
    private String id;
    private String parmnm;
    private String parmvalue;

}
