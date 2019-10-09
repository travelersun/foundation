package com.tianzhu.foundation.module.fnd.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 * 系统注册的应用
 * </p>
 *
 * @author Maya
 * @since 2019-09-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("FND_APPLICATION")
public class FndApplication implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("APPLICATION_ID")
    private Long applicationId;

    /**
     * 应用简称
     */
    @TableField("APPLICATION_SHORT_NAME")
    private String applicationShortName;

    /**
     * 应用描述
     */
    @TableField("APPLICATION_DESCRIPTION")
    private String applicationDescription;

    /**
     * 基础路径
     */
    @TableField("BASEPATH")
    private String basepath;

    /**
     * 应用所属产品代码
     */
    @TableField("PRODUCT_CODE")
    private String productCode;

    @TableField("CREATION_DATE")
    private Date creationDate;

    @TableField("CREATED_BY")
    private String createdBy;

    @TableField("LAST_UPDATE_DATE")
    private Date lastUpdateDate;

    @TableField("LAST_UPDATED_BY")
    private String lastUpdatedBy;


}
