package com.dao;

import com.entity.DiscusszhuangxiushangpinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscusszhuangxiushangpinVO;
import com.entity.view.DiscusszhuangxiushangpinView;


/**
 * 装修商品评论表
 * 
 * @author 
 * @email 
 * @date 2023-04-21 15:06:10
 */
public interface DiscusszhuangxiushangpinDao extends BaseMapper<DiscusszhuangxiushangpinEntity> {
	
	List<DiscusszhuangxiushangpinVO> selectListVO(@Param("ew") Wrapper<DiscusszhuangxiushangpinEntity> wrapper);
	
	DiscusszhuangxiushangpinVO selectVO(@Param("ew") Wrapper<DiscusszhuangxiushangpinEntity> wrapper);
	
	List<DiscusszhuangxiushangpinView> selectListView(@Param("ew") Wrapper<DiscusszhuangxiushangpinEntity> wrapper);

	List<DiscusszhuangxiushangpinView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusszhuangxiushangpinEntity> wrapper);
	
	DiscusszhuangxiushangpinView selectView(@Param("ew") Wrapper<DiscusszhuangxiushangpinEntity> wrapper);
	

}
