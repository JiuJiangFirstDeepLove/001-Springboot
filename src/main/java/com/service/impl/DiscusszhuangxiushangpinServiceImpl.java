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


import com.dao.DiscusszhuangxiushangpinDao;
import com.entity.DiscusszhuangxiushangpinEntity;
import com.service.DiscusszhuangxiushangpinService;
import com.entity.vo.DiscusszhuangxiushangpinVO;
import com.entity.view.DiscusszhuangxiushangpinView;

@Service("discusszhuangxiushangpinService")
public class DiscusszhuangxiushangpinServiceImpl extends ServiceImpl<DiscusszhuangxiushangpinDao, DiscusszhuangxiushangpinEntity> implements DiscusszhuangxiushangpinService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusszhuangxiushangpinEntity> page = this.selectPage(
                new Query<DiscusszhuangxiushangpinEntity>(params).getPage(),
                new EntityWrapper<DiscusszhuangxiushangpinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusszhuangxiushangpinEntity> wrapper) {
		  Page<DiscusszhuangxiushangpinView> page =new Query<DiscusszhuangxiushangpinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscusszhuangxiushangpinVO> selectListVO(Wrapper<DiscusszhuangxiushangpinEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscusszhuangxiushangpinVO selectVO(Wrapper<DiscusszhuangxiushangpinEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscusszhuangxiushangpinView> selectListView(Wrapper<DiscusszhuangxiushangpinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusszhuangxiushangpinView selectView(Wrapper<DiscusszhuangxiushangpinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
