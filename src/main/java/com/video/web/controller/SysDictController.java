package com.video.web.controller;

import com.video.domain.SysDict;
import com.video.service.SysDictService;
import com.video.vo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author itsNine
 * @create 2019-06-19-15:34
 */
@RestController
@RequestMapping("sysdict")
public class SysDictController {
    @Autowired
    private SysDictService sysDictService;

    //添加
    @PostMapping("add")
    public ResponseEntity<Void> add(@RequestBody SysDict sysDict){
        sysDictService.add(sysDict);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity<Void> del(@PathVariable("id") String id){
        sysDictService.del(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("update")
    public ResponseEntity<Void> update(@RequestBody SysDict sysDict){
        sysDictService.update(sysDict);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/query/{id}")
    public ResponseEntity<SysDict> queryById(@PathVariable("id") String id){
        return ResponseEntity.ok(sysDictService.queryById(id));
    }

    @GetMapping("/query")
    public ResponseEntity<List<SysDict>> queryAll(){
        return ResponseEntity.ok(sysDictService.queryAll());
    }

    @GetMapping("/query/page")
    public ResponseEntity<PageResult<SysDict>> querySpuByPage(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "rows", defaultValue = "5") Integer rows,
            @RequestParam(value = "key", required = false) String key
    ){
        return ResponseEntity.ok(sysDictService.queryByPage(page,rows,key));
    }
}
