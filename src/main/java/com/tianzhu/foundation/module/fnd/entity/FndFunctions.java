package com.tianzhu.foundation.module.fnd.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 功能基本表
 * </p>
 *
 * @author Maya
 * @since 2019-08-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("FND_FUNCTIONS")
public class FndFunctions implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("FUNCTION_ID")
    private Long functionId;

    /**
     * 功能名称
     */
    @TableField("FUNCTION_NAME")
    private String functionName;

    /**
     * 功能代码
     */
    @TableField("FUNCTION_CODE")
    private String functionCode;

    @TableField("APPLICATION_ID")
    private Long applicationId;

    /**
     * 功能描述
     */
    @TableField("DESCRIPTION")
    private String description;

    /**
     * Map Direction
     */
    @TableField("DIRECTION")
    private String direction;

    /**
     * 功能参数
     */
    @TableField("PARAMETERS")
    private String parameters;

    /**
     * 功能类型
     */
    @TableField("`TYPE`")
    private String type;

    /**
     * Web主机名
     */
    @TableField("WEB_HOST_NAME")
    private String webHostName;

    /**
     * Web代理主机名
     */
    @TableField("WEB_AGENT_NAME")
    private String webAgentName;

    /**
     * 功能的URL调用路径
     */
    @TableField("WEB_HTML_CALL")
    private String webHtmlCall;

    /**
     * 是否加密web参数
     */
    @TableField("WEB_ENCRYPT_PARAMETERS")
    private String webEncryptParameters;

    /**
     * 是否需要安全验证是否登陆
     */
    @TableField("WEB_SECURED")
    private String webSecured;

    /**
     * 功能图标
     */
    @TableField("WEB_ICON")
    private String webIcon;

    @TableField("OBJECT_ID")
    private String objectId;

    /**
     * What aspect of the current context this function'sbehavior depends on
     */
    @TableField("CONTEXT_DEPENDENCE")
    private String contextDependence;

    /**
     * 引用路径
     */
    @TableField("PATH")
    private String path;

    @TableField("COMPONENT")
    private String component;

    @TableField("HIDDEN")
    private Integer hidden;

    /**
     * Native Method Name
     */
    @TableField("METHOD_NAME")
    private String methodName;

    /**
     * Compatability Flag
     */
    @TableField("COMPATIBILITY")
    private String compatibility;

    /**
     * 关联功能名称
     */
    @TableField("ASSOC_FUNCTION_NAME")
    private String assocFunctionName;

    @TableField("CLASS_ID")
    private String classId;

    /**
     * Flag used for schema validation
     */
    @TableField("SCHEMA_VALIDATION_FLAG")
    private String schemaValidationFlag;

    @TableField("CREATION_DATE")
    private Date creationDate;

    @TableField("CREATED_BY")
    private String createdBy;

    @TableField("LAST_UPDATE_DATE")
    private Date lastUpdateDate;

    @TableField("LAST_UPDATED_BY")
    private String lastUpdatedBy;

    /**
     * 协议头部
     */
    @TableField("`SCHEMA`")
    private String schema;

    /**
     * 协议端口
     */
    @TableField("`PORT`")
    private Integer port;

    @TableField("META")
    private String meta;

    @TableField("REDIRECT")
    private String redirect;


}
