package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZhuangxiushangpinEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZhuangxiushangpinVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZhuangxiushangpinView;


/**
 * 装修商品
 *
 * @author 
 * @email 
 * @date 2023-04-21 15:06:09
 */
public interface ZhuangxiushangpinService extends IService<ZhuangxiushangpinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZhuangxiushangpinVO> selectListVO(Wrapper<ZhuangxiushangpinEntity> wrapper);
   	
   	ZhuangxiushangpinVO selectVO(@Param("ew") Wrapper<ZhuangxiushangpinEntity> wrapper);
   	
   	List<ZhuangxiushangpinView> selectListView(Wrapper<ZhuangxiushangpinEntity> wrapper);
   	
   	ZhuangxiushangpinView selectView(@Param("ew") Wrapper<ZhuangxiushangpinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZhuangxiushangpinEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<ZhuangxiushangpinEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<ZhuangxiushangpinEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<ZhuangxiushangpinEntity> wrapper);



}

