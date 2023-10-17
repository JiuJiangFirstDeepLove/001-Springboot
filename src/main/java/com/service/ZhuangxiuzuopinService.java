package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZhuangxiuzuopinEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZhuangxiuzuopinVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZhuangxiuzuopinView;


/**
 * 装修作品
 *
 * @author 
 * @email 
 * @date 2023-04-21 15:06:09
 */
public interface ZhuangxiuzuopinService extends IService<ZhuangxiuzuopinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZhuangxiuzuopinVO> selectListVO(Wrapper<ZhuangxiuzuopinEntity> wrapper);
   	
   	ZhuangxiuzuopinVO selectVO(@Param("ew") Wrapper<ZhuangxiuzuopinEntity> wrapper);
   	
   	List<ZhuangxiuzuopinView> selectListView(Wrapper<ZhuangxiuzuopinEntity> wrapper);
   	
   	ZhuangxiuzuopinView selectView(@Param("ew") Wrapper<ZhuangxiuzuopinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZhuangxiuzuopinEntity> wrapper);
   	

}

