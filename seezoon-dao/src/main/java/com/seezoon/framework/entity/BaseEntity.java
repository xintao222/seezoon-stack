package com.seezoon.framework.entity;

import java.util.Date;

import lombok.Data;

/**
 * 数据库实体基类，框架默认字段，已实际表为准
 *
 * @author hdf
 */
@Data
public class BaseEntity<PK> {

    /**
     * 主键只支持单一主键，数值或者字符串，数据库表必须存在名为ID的主键列
     */
    private PK id;
    /**
     * 数据状态 {@link com.seezoon.framework.constants.EntityStatus}
     *
     * 保存方法自动处理
     * </pre>
     */
    private Byte status;
    /**
     * 保存方法自动处理
     */
    private String createBy;
    /**
     * 保存方法自动处理
     */
    private Date createTime;
    /**
     * 更新方法自动处理
     */
    private String updateBy;
    /**
     * 更新方法自动处理
     */
    private Date updateTime;
    private String remarks;

}