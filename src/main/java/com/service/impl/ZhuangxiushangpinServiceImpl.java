package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.ZhuangxiushangpinDao;
import com.entity.ZhuangxiushangpinEntity;
import com.service.ZhuangxiushangpinService;
import com.entity.vo.ZhuangxiushangpinVO;
import com.entity.view.ZhuangxiushangpinView;

@Service("zhuangxiushangpinService")
public class ZhuangxiushangpinServiceImpl extends ServiceImpl<ZhuangxiushangpinDao, ZhuangxiushangpinEntity> implements ZhuangxiushangpinService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZhuangxiushangpinEntity> page = this.selectPage(
                new Query<ZhuangxiushangpinEntity>(params).getPage(),
                new EntityWrapper<ZhuangxiushangpinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZhuangxiushangpinEntity> wrapper) {
		  Page<ZhuangxiushangpinView> page =new Query<ZhuangxiushangpinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZhuangxiushangpinVO> selectListVO(Wrapper<ZhuangxiushangpinEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZhuangxiushangpinVO selectVO(Wrapper<ZhuangxiushangpinEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZhuangxiushangpinView> selectListView(Wrapper<ZhuangxiushangpinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZhuangxiushangpinView selectView(Wrapper<ZhuangxiushangpinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<ZhuangxiushangpinEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<ZhuangxiushangpinEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<ZhuangxiushangpinEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
