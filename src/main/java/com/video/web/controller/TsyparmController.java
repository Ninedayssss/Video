package com.video.web.controller;

import com.video.domain.Tsyparm;
import com.video.service.TsyparmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.video.vo.PageResult;

import java.util.List;

/**
 * 系统参数Controller
 * @author itsNine
 * @create 2019-06-19-10:17
 */
@RestController
@RequestMapping("tsyparm")
public class TsyparmController {
    @Autowired
    private TsyparmService tsyparmService;

    //添加
    @PostMapping("add")
    public ResponseEntity<Void> add(@RequestBody Tsyparm tsyparm){
        tsyparmService.add(tsyparm);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity<Void> del(@PathVariable("id") String id){
        tsyparmService.del(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("update")
    public ResponseEntity<Void> update(@RequestBody Tsyparm tsyparm){
        tsyparmService.update(tsyparm);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/query/{id}")
    public ResponseEntity<Tsyparm> queryById(@PathVariable("id") String id){
        return ResponseEntity.ok(tsyparmService.queryById(id));
    }

    @GetMapping("/query")
    public ResponseEntity<List<Tsyparm>> queryAll(){
        return ResponseEntity.ok(tsyparmService.queryAll());
    }

    @GetMapping("/query/page")
    public ResponseEntity<PageResult<Tsyparm>> querySpuByPage(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "rows", defaultValue = "5") Integer rows,
            @RequestParam(value = "key", required = false) String key
    ){

        return ResponseEntity.ok(tsyparmService.queryByPage(page,rows,key));
    }


}
