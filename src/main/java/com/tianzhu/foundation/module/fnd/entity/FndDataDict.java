package com.tianzhu.foundation.module.fnd.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 * 数据字典
 * </p>
 *
 * @author Maya
 * @since 2019-09-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("FND_DATA_DICT")
public class FndDataDict implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("FND_DATA_DICT_ID")
    private Long fndDataDictId;

    /**
     * 主标识
     */
    @TableField("PRIMARY_KEY")
    private String primaryKey;

    /**
     * 主要数据
     */
    @TableField("PRIMARY_VALUE")
    private String primaryValue;

    /**
     * 次标识
     */
    @TableField("SECONDARY_KEY")
    private String secondaryKey;

    /**
     * 次要数据
     */
    @TableField("SECONDARY_VALUE")
    private String secondaryValue;

    /**
     * 禁用标识
     */
    @TableField("DISABLE")
    private String disable;

    /**
     * 排序号
     */
    @TableField("ORDER_RANK")
    private Integer orderRank;

    /**
     * 父标识
     */
    @TableField("PARANT_DATA_DICT_ID")
    private Long parantDataDictId;

    /**
     * 文件路径数据
     */
    @TableField("FILE_PATH_VALUE")
    private String filePathValue;

    /**
     * 图片路径数据
     */
    @TableField("IMAGE_PATH_VALUE")
    private String imagePathValue;

    /**
     * 富文本属性值
     */
    @TableField("RICH_TEXT_VALUE")
    private String richTextValue;

    @TableField("CREATION_DATE")
    private Date creationDate;

    @TableField("CREATED_BY")
    private String createdBy;

    @TableField("LAST_UPDATE_DATE")
    private Date lastUpdateDate;

    @TableField("LAST_UPDATED_BY")
    private String lastUpdatedBy;


}
