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

import com.entity.ZhuangxiuzuopinEntity;
import com.entity.view.ZhuangxiuzuopinView;

import com.service.ZhuangxiuzuopinService;
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
 * 装修作品
 * 后端接口
 * @author 
 * @email 
 * @date 2023-04-21 15:06:09
 */
@RestController
@RequestMapping("/zhuangxiuzuopin")
public class ZhuangxiuzuopinController {
    @Autowired
    private ZhuangxiuzuopinService zhuangxiuzuopinService;

    @Autowired
    private StoreupService storeupService;

    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZhuangxiuzuopinEntity zhuangxiuzuopin,
		HttpServletRequest request){
        EntityWrapper<ZhuangxiuzuopinEntity> ew = new EntityWrapper<ZhuangxiuzuopinEntity>();

		PageUtils page = zhuangxiuzuopinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhuangxiuzuopin), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZhuangxiuzuopinEntity zhuangxiuzuopin, 
		HttpServletRequest request){
        EntityWrapper<ZhuangxiuzuopinEntity> ew = new EntityWrapper<ZhuangxiuzuopinEntity>();

		PageUtils page = zhuangxiuzuopinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhuangxiuzuopin), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZhuangxiuzuopinEntity zhuangxiuzuopin){
       	EntityWrapper<ZhuangxiuzuopinEntity> ew = new EntityWrapper<ZhuangxiuzuopinEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zhuangxiuzuopin, "zhuangxiuzuopin")); 
        return R.ok().put("data", zhuangxiuzuopinService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZhuangxiuzuopinEntity zhuangxiuzuopin){
        EntityWrapper< ZhuangxiuzuopinEntity> ew = new EntityWrapper< ZhuangxiuzuopinEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zhuangxiuzuopin, "zhuangxiuzuopin")); 
		ZhuangxiuzuopinView zhuangxiuzuopinView =  zhuangxiuzuopinService.selectView(ew);
		return R.ok("查询装修作品成功").put("data", zhuangxiuzuopinView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZhuangxiuzuopinEntity zhuangxiuzuopin = zhuangxiuzuopinService.selectById(id);
        return R.ok().put("data", zhuangxiuzuopin);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZhuangxiuzuopinEntity zhuangxiuzuopin = zhuangxiuzuopinService.selectById(id);
        return R.ok().put("data", zhuangxiuzuopin);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZhuangxiuzuopinEntity zhuangxiuzuopin, HttpServletRequest request){
    	zhuangxiuzuopin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zhuangxiuzuopin);
        zhuangxiuzuopinService.insert(zhuangxiuzuopin);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZhuangxiuzuopinEntity zhuangxiuzuopin, HttpServletRequest request){
    	zhuangxiuzuopin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zhuangxiuzuopin);
        zhuangxiuzuopinService.insert(zhuangxiuzuopin);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZhuangxiuzuopinEntity zhuangxiuzuopin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zhuangxiuzuopin);
        zhuangxiuzuopinService.updateById(zhuangxiuzuopin);//全部更新
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zhuangxiuzuopinService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
