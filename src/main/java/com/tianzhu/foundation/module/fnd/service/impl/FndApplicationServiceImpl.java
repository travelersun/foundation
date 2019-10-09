package com.tianzhu.foundation.module.fnd.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tianzhu.foundation.module.fnd.entity.FndApplication;
import com.tianzhu.foundation.module.fnd.mapper.FndApplicationMapper;
import com.tianzhu.foundation.module.fnd.service.IFndApplicationService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统注册的应用 服务实现类
 * </p>
 *
 * @author Maya
 * @since 2019-09-23
 */
@Service
public class FndApplicationServiceImpl extends ServiceImpl<FndApplicationMapper, FndApplication> implements IFndApplicationService {

}
