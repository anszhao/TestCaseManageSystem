package com.xiaoju.framework.entity.request.dir;

import com.xiaoju.framework.constants.BizConstant;
import com.xiaoju.framework.entity.request.ParamValidate;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.util.StringUtils;

/**
 * 文件夹 删除
 *
 * @author 刘智
 * @date 2020/9/11
 */
@Data
@AllArgsConstructor
public class DirDeleteReq implements ParamValidate {

    private String parentId;

    private Long productLineId;

    private String delId;

    private Integer channel;

    @Override
    public void validate() {
        if (productLineId == null || productLineId <= 0) {
            throw new IllegalArgumentException("业务线id为空或者非法");
        }
        if (StringUtils.isEmpty(delId)) {
            throw new IllegalArgumentException("要删除的文件夹id不能为空");
        }
        if (BizConstant.ROOT_BIZ_ID.equals(delId)) {
            throw new IllegalArgumentException("不能删除根文件夹");
        }
        if (StringUtils.isEmpty(parentId)) {
            throw new IllegalArgumentException("父文件夹id为空");
        }
        if (channel == null) {
            throw new IllegalArgumentException("渠道为空");
        }
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Long getProductLineId() {
        return productLineId;
    }

    public void setProductLineId(Long productLineId) {
        this.productLineId = productLineId;
    }

    public String getDelId() {
        return delId;
    }

    public void setDelId(String delId) {
        this.delId = delId;
    }

    public Integer getChannel() {
        return channel;
    }

    public void setChannel(Integer channel) {
        this.channel = channel;
    }
}
