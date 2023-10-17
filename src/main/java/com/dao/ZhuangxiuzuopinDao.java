package com.dao;

import com.entity.ZhuangxiuzuopinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZhuangxiuzuopinVO;
import com.entity.view.ZhuangxiuzuopinView;


/**
 * 装修作品
 * 
 * @author 
 * @email 
 * @date 2023-04-21 15:06:09
 */
public interface ZhuangxiuzuopinDao extends BaseMapper<ZhuangxiuzuopinEntity> {
	
	List<ZhuangxiuzuopinVO> selectListVO(@Param("ew") Wrapper<ZhuangxiuzuopinEntity> wrapper);
	
	ZhuangxiuzuopinVO selectVO(@Param("ew") Wrapper<ZhuangxiuzuopinEntity> wrapper);
	
	List<ZhuangxiuzuopinView> selectListView(@Param("ew") Wrapper<ZhuangxiuzuopinEntity> wrapper);

	List<ZhuangxiuzuopinView> selectListView(Pagination page,@Param("ew") Wrapper<ZhuangxiuzuopinEntity> wrapper);
	
	ZhuangxiuzuopinView selectView(@Param("ew") Wrapper<ZhuangxiuzuopinEntity> wrapper);
	

}
