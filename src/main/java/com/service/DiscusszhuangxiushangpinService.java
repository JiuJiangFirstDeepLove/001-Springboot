package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscusszhuangxiushangpinEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscusszhuangxiushangpinVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscusszhuangxiushangpinView;


/**
 * 装修商品评论表
 *
 * @author 
 * @email 
 * @date 2023-04-21 15:06:10
 */
public interface DiscusszhuangxiushangpinService extends IService<DiscusszhuangxiushangpinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusszhuangxiushangpinVO> selectListVO(Wrapper<DiscusszhuangxiushangpinEntity> wrapper);
   	
   	DiscusszhuangxiushangpinVO selectVO(@Param("ew") Wrapper<DiscusszhuangxiushangpinEntity> wrapper);
   	
   	List<DiscusszhuangxiushangpinView> selectListView(Wrapper<DiscusszhuangxiushangpinEntity> wrapper);
   	
   	DiscusszhuangxiushangpinView selectView(@Param("ew") Wrapper<DiscusszhuangxiushangpinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusszhuangxiushangpinEntity> wrapper);
   	

}

