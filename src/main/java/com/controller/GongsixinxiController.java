package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.GongsixinxiEntity;
import com.entity.view.GongsixinxiView;

import com.service.GongsixinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 公司信息
 * 后端接口
 * @author 
 * @email 
 * @date 2023-04-21 15:06:09
 */
@RestController
@RequestMapping("/gongsixinxi")
public class GongsixinxiController {
    @Autowired
    private GongsixinxiService gongsixinxiService;

    @Autowired
    private StoreupService storeupService;

    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,GongsixinxiEntity gongsixinxi,
		HttpServletRequest request){
        EntityWrapper<GongsixinxiEntity> ew = new EntityWrapper<GongsixinxiEntity>();

		PageUtils page = gongsixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gongsixinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,GongsixinxiEntity gongsixinxi, 
		HttpServletRequest request){
        EntityWrapper<GongsixinxiEntity> ew = new EntityWrapper<GongsixinxiEntity>();

		PageUtils page = gongsixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gongsixinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( GongsixinxiEntity gongsixinxi){
       	EntityWrapper<GongsixinxiEntity> ew = new EntityWrapper<GongsixinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( gongsixinxi, "gongsixinxi")); 
        return R.ok().put("data", gongsixinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(GongsixinxiEntity gongsixinxi){
        EntityWrapper< GongsixinxiEntity> ew = new EntityWrapper< GongsixinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( gongsixinxi, "gongsixinxi")); 
		GongsixinxiView gongsixinxiView =  gongsixinxiService.selectView(ew);
		return R.ok("查询公司信息成功").put("data", gongsixinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        GongsixinxiEntity gongsixinxi = gongsixinxiService.selectById(id);
        return R.ok().put("data", gongsixinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        GongsixinxiEntity gongsixinxi = gongsixinxiService.selectById(id);
        return R.ok().put("data", gongsixinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GongsixinxiEntity gongsixinxi, HttpServletRequest request){
    	gongsixinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(gongsixinxi);
        gongsixinxiService.insert(gongsixinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody GongsixinxiEntity gongsixinxi, HttpServletRequest request){
    	gongsixinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(gongsixinxi);
        gongsixinxiService.insert(gongsixinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody GongsixinxiEntity gongsixinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(gongsixinxi);
        gongsixinxiService.updateById(gongsixinxi);//全部更新
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        gongsixinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
