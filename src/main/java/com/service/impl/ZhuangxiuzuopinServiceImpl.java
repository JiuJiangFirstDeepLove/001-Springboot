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


import com.dao.ZhuangxiuzuopinDao;
import com.entity.ZhuangxiuzuopinEntity;
import com.service.ZhuangxiuzuopinService;
import com.entity.vo.ZhuangxiuzuopinVO;
import com.entity.view.ZhuangxiuzuopinView;

@Service("zhuangxiuzuopinService")
public class ZhuangxiuzuopinServiceImpl extends ServiceImpl<ZhuangxiuzuopinDao, ZhuangxiuzuopinEntity> implements ZhuangxiuzuopinService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZhuangxiuzuopinEntity> page = this.selectPage(
                new Query<ZhuangxiuzuopinEntity>(params).getPage(),
                new EntityWrapper<ZhuangxiuzuopinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZhuangxiuzuopinEntity> wrapper) {
		  Page<ZhuangxiuzuopinView> page =new Query<ZhuangxiuzuopinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZhuangxiuzuopinVO> selectListVO(Wrapper<ZhuangxiuzuopinEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZhuangxiuzuopinVO selectVO(Wrapper<ZhuangxiuzuopinEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZhuangxiuzuopinView> selectListView(Wrapper<ZhuangxiuzuopinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZhuangxiuzuopinView selectView(Wrapper<ZhuangxiuzuopinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
